package com.example.demo.model;

public class Revista extends Material {
    private int numeroEdicion;

    public Revista() {
        super();
    }

    public Revista(String codigo, String titulo, boolean disponible, int numeroEdicion) {
        super(codigo, titulo, disponible);
        this.numeroEdicion = numeroEdicion;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }
}
