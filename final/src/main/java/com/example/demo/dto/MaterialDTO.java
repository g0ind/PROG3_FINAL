package com.example.demo.dto;

public class MaterialDTO {
    private String codigo;
    private String titulo;
    private boolean disponible;
    private String tipo;          // "Libro" o "Revista"
    private String detalleExtra;  // Autor o número de edición

    public MaterialDTO() {
    }

    public MaterialDTO(String codigo, String titulo, boolean disponible, String tipo, String detalleExtra) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponible = disponible;
        this.tipo = tipo;
        this.detalleExtra = detalleExtra;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalleExtra() {
        return detalleExtra;
    }

    public void setDetalleExtra(String detalleExtra) {
        this.detalleExtra = detalleExtra;
    }
}
