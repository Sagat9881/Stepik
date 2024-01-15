package org.example.java_base.module_2.primitive_types;

/**
 * 2.1 - Високосные года.
 * Реализуйте метод, вычисляющий количество високосных лет с начала нашей эры (первого года) до заданного года включительно.
 */
public class LeapYearCount {
    public static int leapYearCount(int leapyear) {
        leapyear = (leapyear / 4 + leapyear / 400) - leapyear / 100;
        return (leapyear);
    }
}