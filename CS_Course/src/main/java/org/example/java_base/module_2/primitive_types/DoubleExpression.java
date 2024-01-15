package org.example.java_base.module_2.primitive_types;

/**
 *  2.1 - работа с погрешностями
 * Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
 * Допустимая погрешность – 0.0001 (1E-4)
 */
public class DoubleExpression {
    public static boolean doubleExpression(double a, double b, double c) {
        a = a * 10000;
        b = b * 10000;
        c = c * 10000;
        int x = (int) a;
        int y = (int) b;
        int z = (int) c;
        boolean q = (z == x + y);
        return q;
    }
}
