package com.example.demo.strategy;

public class MultaFinDeSemana implements MultaStrategy {

    @Override
    public double calcular(int diasAtraso) {
        if (diasAtraso <= 0) {
            return 0.0;
        }
        // MultaFinDeSemana: $100 por día + $200 adicionales al total
        return (diasAtraso * 100.0) + 200.0;
    }
}
