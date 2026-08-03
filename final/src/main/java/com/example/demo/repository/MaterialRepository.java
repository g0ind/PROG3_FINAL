package com.example.demo.repository;

import com.example.demo.model.Libro;
import com.example.demo.model.Material;
import com.example.demo.model.Revista;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MaterialRepository {

    // Almacenamiento en memoria usando HashMap con la clave 'codigo'
    private final Map<String, Material> mapaMateriales = new HashMap<>();

    public MaterialRepository() {
        // Datos iniciales de prueba para trabajar en Postman
        Libro libro1 = new Libro("LIB-001", "Cien Anos de Soledad", true, "Gabriel Garcia Marquez");
        Libro libro2 = new Libro("LIB-002", "El Aleph", true, "Jorge Luis Borges");
        Revista revista1 = new Revista("REV-001", "National Geographic", true, 150);
        Revista revista2 = new Revista("REV-002", "Ciencia Hoy", true, 42);

        mapaMateriales.put(libro1.getCodigo(), libro1);
        mapaMateriales.put(libro2.getCodigo(), libro2);
        mapaMateriales.put(revista1.getCodigo(), revista1);
        mapaMateriales.put(revista2.getCodigo(), revista2);
    }

    public Material save(Material material) {
        mapaMateriales.put(material.getCodigo(), material);
        return material;
    }

    public Material findByCodigo(String codigo) {
        return mapaMateriales.get(codigo);
    }

    public List<Material> findAll() {
        return new ArrayList<>(mapaMateriales.values());
    }

    public List<Material> findDisponibles() {
        List<Material> disponibles = new ArrayList<>();
        for (Material m : mapaMateriales.values()) {
            if (m.isDisponible()) {
                disponibles.add(m);
            }
        }
        return disponibles;
    }
}
