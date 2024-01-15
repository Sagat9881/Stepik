package org.example.java_base.module_2.type_conversion;

/**
 * 2.2 - Реализуйте метод, проверяющий, является ли заданное число
 * по абсолютной величине степенью двойки.
 */
public class IsPowerOfTwo {
    public static boolean isPowerOfTwo(int value) {
        Integer x = value;
        if (Integer.bitCount(Math.abs(x)) == 1) {
            return true;
        } else {
            return false;
        }
    }
}