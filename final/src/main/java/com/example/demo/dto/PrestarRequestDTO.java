package com.example.demo.dto;

public class PrestarRequestDTO {
    private String codigoMaterial;
    private int idSocio;

    public PrestarRequestDTO() {
    }

    public PrestarRequestDTO(String codigoMaterial, int idSocio) {
        this.codigoMaterial = codigoMaterial;
        this.idSocio = idSocio;
    }

    public String getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(String codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }
}
