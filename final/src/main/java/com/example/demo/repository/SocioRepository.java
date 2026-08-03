package com.example.demo.repository;

import com.example.demo.model.Socio;
import com.example.demo.model.SocioPremium;
import com.example.demo.model.SocioRegular;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SocioRepository {

    // HashMap con la clave 'id' del socio
    private final Map<Integer, Socio> mapaSocios = new HashMap<>();

    public SocioRepository() {
        // Datos iniciales de prueba
        SocioRegular socio1 = new SocioRegular(101, "Juan Perez");
        SocioPremium socio2 = new SocioPremium(102, "Maria Lopez");

        mapaSocios.put(socio1.getId(), socio1);
        mapaSocios.put(socio2.getId(), socio2);
    }

    public Socio save(Socio socio) {
        mapaSocios.put(socio.getId(), socio);
        return socio;
    }

    public Socio findById(int id) {
        return mapaSocios.get(id);
    }

    public List<Socio> findAll() {
        return new ArrayList<>(mapaSocios.values());
    }
}
