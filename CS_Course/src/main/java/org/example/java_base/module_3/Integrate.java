package org.example.java_base.module_3;

import java.util.function.DoubleUnaryOperator;

/**
 * 3.5 - Реализуйте метод, выполняющий численное интегрирование заданной функции на заданном интервале
 * по формуле левых прямоугольников.
 */
public class Integrate {
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double h = 0.00001;
        int n = (int) ((b - a) / h);
        double summ = 0;
        for (int i = 0; i < n; i++) {
            double result = h * f.applyAsDouble(a);
            a += h;
            summ += result;
        }
        return summ;

    }
}