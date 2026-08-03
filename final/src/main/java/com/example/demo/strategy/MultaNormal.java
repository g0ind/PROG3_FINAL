package com.example.demo.strategy;

public class MultaNormal implements MultaStrategy {

    @Override
    public double calcular(int diasAtraso) {
        if (diasAtraso <= 0) {
            return 0.0;
        }
        // MultaNormal: $100 por día de atraso
        return diasAtraso * 100.0;
    }
}
