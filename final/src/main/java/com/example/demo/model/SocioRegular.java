package com.example.demo.model;

public class SocioRegular extends Socio {

    public SocioRegular() {
        super();
    }

    public SocioRegular(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public double aplicarBeneficio(double monto) {
        // Socio Regular paga el 100% de la multa sin descuento.
        return monto;
    }
}
