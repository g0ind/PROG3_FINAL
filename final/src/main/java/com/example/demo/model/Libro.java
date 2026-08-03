package com.example.demo.model;

public class Libro extends Material {
    private String autor;

    public Libro() {
        super();
    }

    public Libro(String codigo, String titulo, boolean disponible, String autor) {
        super(codigo, titulo, disponible);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
