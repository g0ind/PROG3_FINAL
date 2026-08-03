package com.example.demo.controller;

import com.example.demo.dto.DevolucionRequestDTO;
import com.example.demo.dto.DevolucionResponseDTO;
import com.example.demo.dto.PrestarRequestDTO;
import com.example.demo.service.BibliotecaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final BibliotecaService bibliotecaService;

    public PrestamoController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    // Endpoint: POST /api/prestamos/prestar
    @PostMapping("/prestar")
    public ResponseEntity<String> prestar(@RequestBody PrestarRequestDTO request) {
        String resultado = bibliotecaService.prestarMaterial(request);
        return ResponseEntity.ok(resultado);
    }

    // Endpoint: POST /api/prestamos/devolver
    @PostMapping("/devolver")
    public ResponseEntity<DevolucionResponseDTO> devolver(@RequestBody DevolucionRequestDTO request) {
        DevolucionResponseDTO respuesta = bibliotecaService.devolverMaterial(request);
        return ResponseEntity.ok(respuesta);
    }
}
