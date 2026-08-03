package com.example.demo.strategy;

public class MultaCampania implements MultaStrategy {

    @Override
    public double calcular(int diasAtraso) {
        if (diasAtraso <= 0) {
            return 0.0;
        }
        // MultaCampania: $60 por día de atraso
        return diasAtraso * 60.0;
    }
}
