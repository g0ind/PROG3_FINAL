package com.example.demo.strategy;

public interface MultaStrategy {
    /**
     * Calcula el monto base de la multa en función de los días de atraso.
     * @param diasAtraso Cantidad de días de demora en la devolución.
     * @return Monto base de la multa calculada.
     */
    double calcular(int diasAtraso);
}
