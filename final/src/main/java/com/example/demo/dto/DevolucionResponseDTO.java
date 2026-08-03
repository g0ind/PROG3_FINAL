package com.example.demo.dto;

public class DevolucionResponseDTO {
    private String codigoMaterial;
    private int idSocio;
    private int diasAtraso;
    private double multaBase;
    private double descuentoAplicado;
    private double multaFinal;
    private String mensaje;

    public DevolucionResponseDTO() {
    }

    public DevolucionResponseDTO(String codigoMaterial, int idSocio, int diasAtraso, double multaBase, double descuentoAplicado, double multaFinal, String mensaje) {
        this.codigoMaterial = codigoMaterial;
        this.idSocio = idSocio;
        this.diasAtraso = diasAtraso;
        this.multaBase = multaBase;
        this.descuentoAplicado = descuentoAplicado;
        this.multaFinal = multaFinal;
        this.mensaje = mensaje;
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

    public double getMultaBase() {
        return multaBase;
    }

    public void setMultaBase(double multaBase) {
        this.multaBase = multaBase;
    }

    public double getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(double descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public double getMultaFinal() {
        return multaFinal;
    }

    public void setMultaFinal(double multaFinal) {
        this.multaFinal = multaFinal;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
