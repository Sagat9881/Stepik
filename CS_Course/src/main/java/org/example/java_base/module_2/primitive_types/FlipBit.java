package org.example.java_base.module_2.primitive_types;

/**
 * 2.1 -
 * Реализуйте метод flipBit, изменяющий значение одного бита заданного целого числа на противоположное.
 */
public class FlipBit {
    public static int flipBit(int value, int bitIndex) {
        return (value ^ ((int) Math.pow(2, (bitIndex - 1))));
    }
}
