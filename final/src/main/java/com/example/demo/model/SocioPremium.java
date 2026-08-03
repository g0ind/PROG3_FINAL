package com.example.demo.model;

public class SocioPremium extends Socio {

    public SocioPremium() {
        super();
    }

    public SocioPremium(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public double aplicarBeneficio(double monto) {
        // Socio Premium tiene un 50% de descuento sobre las multas.
        return monto * 0.5;
    }
}
