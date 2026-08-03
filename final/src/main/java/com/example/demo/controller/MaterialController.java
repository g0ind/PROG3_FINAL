package com.example.demo.controller;

import com.example.demo.dto.MaterialDTO;
import com.example.demo.service.BibliotecaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/materiales")
public class MaterialController {

    private final BibliotecaService bibliotecaService;

    public MaterialController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    // Endpoint: GET /api/materiales/disponibles
    @GetMapping("/disponibles")
    public ResponseEntity<List<MaterialDTO>> obtenerDisponibles() {
        List<MaterialDTO> disponibles = bibliotecaService.obtenerMaterialesDisponibles();
        return ResponseEntity.ok(disponibles);
    }
}
