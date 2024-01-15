package org.example.java_base.module_2.control_structures;

import java.math.BigInteger;

/**
 * 2.4 - Реализуйте метод, вычисляющий факториал заданного натурального числа.
 */
public class Factorial {
    public static BigInteger factorial(int value) {
        BigInteger fct = BigInteger.valueOf(value);
        int b = value;
        if (value <= 1) {
            return fct = BigInteger.ONE;
        } else {
            for (int i = 0; i <= b; i++) {
                while (value > 1) {
                    fct = fct.multiply(BigInteger.valueOf((value - 1)));
                    value -= 1;
                }
            }
            return fct;

        }
    }
}