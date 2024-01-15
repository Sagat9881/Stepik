package org.example.java_base.module_6;

import java.util.stream.IntStream;

/**
 * 6.4 - Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:
 * <p>
 * Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
 * Первый элемент последовательности устанавливается равным этому числу.
 * Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid(R2n), где mid — это функция, выделяющая второй,
 * третий и четвертый разряд переданного числа. Например, mid(123456)=345.
 */
public class PseudoRandomStream {
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> (int) ((n * n) / 10 % 1000));
    }

    private static IntStream mid(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}