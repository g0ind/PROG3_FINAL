package com.example.demo.service;

import com.example.demo.dto.DevolucionRequestDTO;
import com.example.demo.dto.DevolucionResponseDTO;
import com.example.demo.dto.MaterialDTO;
import com.example.demo.dto.PrestarRequestDTO;
import com.example.demo.model.Libro;
import com.example.demo.model.Material;
import com.example.demo.model.Revista;
import com.example.demo.model.Socio;
import com.example.demo.repository.MaterialRepository;
import com.example.demo.repository.SocioRepository;
import com.example.demo.strategy.MultaCampania;
import com.example.demo.strategy.MultaFinDeSemana;
import com.example.demo.strategy.MultaNormal;
import com.example.demo.strategy.MultaStrategy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BibliotecaService {

    private final MaterialRepository materialRepository;
    private final SocioRepository socioRepository;

    public BibliotecaService(MaterialRepository materialRepository, SocioRepository socioRepository) {
        this.materialRepository = materialRepository;
        this.socioRepository = socioRepository;
    }

    // 1. Prestar material bibliográfico
    public String prestarMaterial(PrestarRequestDTO request) {
        Material material = materialRepository.findByCodigo(request.getCodigoMaterial());
        if (material == null) {
            throw new RuntimeException("El material con código " + request.getCodigoMaterial() + " no existe.");
        }

        if (!material.isDisponible()) {
            throw new RuntimeException("El material '" + material.getTitulo() + "' ya se encuentra prestado.");
        }

        Socio socio = socioRepository.findById(request.getIdSocio());
        if (socio == null) {
            throw new RuntimeException("El socio con ID " + request.getIdSocio() + " no existe.");
        }

        // Marcar material como prestado (no disponible)
        material.setDisponible(false);
        materialRepository.save(material);

        return "Prestamo realizado con exito del material '" + material.getTitulo() + "' al socio " + socio.getNombre() + ".";
    }

    // 2. Devolver material y calcular multa con Strategy y beneficio de Socio
    public DevolucionResponseDTO devolverMaterial(DevolucionRequestDTO request) {
        Material material = materialRepository.findByCodigo(request.getCodigoMaterial());
        if (material == null) {
            throw new RuntimeException("El material con código " + request.getCodigoMaterial() + " no existe.");
        }

        Socio socio = socioRepository.findById(request.getIdSocio());
        if (socio == null) {
            throw new RuntimeException("El socio con ID " + request.getIdSocio() + " no existe.");
        }

        // Marcar material de nuevo como disponible
        material.setDisponible(true);
        materialRepository.save(material);

        // Seleccionar la estrategia de multa correspondiente
        MultaStrategy estrategia;
        String tipo = request.getTipoEstrategia() != null ? request.getTipoEstrategia().toUpperCase() : "NORMAL";

        switch (tipo) {
            case "CAMPANIA":
                estrategia = new MultaCampania();
                break;
            case "FIN_DE_SEMANA":
                estrategia = new MultaFinDeSemana();
                break;
            default:
                estrategia = new MultaNormal();
                break;
        }

        // Cálculo de multa base según días de atraso
        double multaBase = estrategia.calcular(request.getDiasAtraso());

        // Aplicar beneficio del socio (Regular -> 100%, Premium -> 50% desc)
        double multaFinal = socio.aplicarBeneficio(multaBase);
        double descuento = multaBase - multaFinal;

        String mensaje = "Devolucion registrada. Material '" + material.getTitulo() + "' devuelto por " + socio.getNombre() + ".";

        return new DevolucionResponseDTO(
                material.getCodigo(),
                socio.getId(),
                request.getDiasAtraso(),
                multaBase,
                descuento,
                multaFinal,
                mensaje
        );
    }

    // 3. Obtener lista de materiales disponibles convertidos a MaterialDTO
    public List<MaterialDTO> obtenerMaterialesDisponibles() {
        List<Material> disponibles = materialRepository.findDisponibles();
        List<MaterialDTO> dtos = new ArrayList<>();

        for (Material m : disponibles) {
            String tipo = "Material";
            String detalleExtra = "";

            if (m instanceof Libro) {
                tipo = "Libro";
                detalleExtra = "Autor: " + ((Libro) m).getAutor();
            } else if (m instanceof Revista) {
                tipo = "Revista";
                detalleExtra = "Edicion Nro: " + ((Revista) m).getNumeroEdicion();
            }

            dtos.add(new MaterialDTO(m.getCodigo(), m.getTitulo(), m.isDisponible(), tipo, detalleExtra));
        }

        return dtos;
    }

    // 4. Depurar duplicados de lista de DNIs usando HashSet en 1 sola pasada
    public List<String> depurarDuplicados(List<String> dnis) {
        if (dnis == null) {
            return new ArrayList<>();
        }
        // HashSet elimina elementos duplicados automáticamente en 1 sola pasada O(N)
        Set<String> unicosSet = new HashSet<>(dnis);
        return new ArrayList<>(unicosSet);
    }
}
