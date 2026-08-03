package com.example.demo.dto;

public class DevolucionRequestDTO {
    private String codigoMaterial;
    private int idSocio;
    private int diasAtraso;
    private String tipoEstrategia; // "NORMAL", "CAMPANIA", "FIN_DE_SEMANA"

    public DevolucionRequestDTO() {
    }

    public DevolucionRequestDTO(String codigoMaterial, int idSocio, int diasAtraso, String tipoEstrategia) {
        this.codigoMaterial = codigoMaterial;
        this.idSocio = idSocio;
        this.diasAtraso = diasAtraso;
        this.tipoEstrategia = tipoEstrategia;
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

    public int getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public String getTipoEstrategia() {
        return tipoEstrategia;
    }

    public void setTipoEstrategia(String tipoEstrategia) {
        this.tipoEstrategia = tipoEstrategia;
    }
}
