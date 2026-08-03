package com.example.demo.controller;

import com.example.demo.service.BibliotecaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    private final BibliotecaService bibliotecaService;

    public SocioController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    // Endpoint: POST /api/socios/depurar-duplicados
    @PostMapping("/depurar-duplicados")
    public ResponseEntity<List<String>> depurarDuplicados(@RequestBody List<String> dnis) {
        List<String> dnisUnicos = bibliotecaService.depurarDuplicados(dnis);
        return ResponseEntity.ok(dnisUnicos);
    }
}
