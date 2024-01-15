package org.example.algorithms.greedy_algorithm;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * По данному числу 1 ≤ n ≤ 10^9 найдите максимальное число k, для которого
 * n можно представить как сумму k различных натуральных слагаемых.
 * Выведите в первой строке число k, во второй — k слагаемых.
 */
public class VariousSumComponents {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int sourceNumber = SCANNER.nextInt();
        final Set<Integer> result = new HashSet<>();

        // "1" - минимальное натуральное число.
        // Надежный шаг - включать в решение (k) минимальные доступные цели числа (т.к. нужно вывести наибольшее "k")
        int sumComponent = 1;

        for (int i = sumComponent; sourceNumber > 0; i++) {

            // Если остаток больше текущего слагаемого (i),
            // то мы гарантировано можем вычесть из остатка i+1, а значит i - минимальное доступное натуральное число
            // (т.к. числа натуральные, а 1 - минимум, на который одно число может быть больше или меньше другого)
            if (sourceNumber - i > i) {
                sourceNumber -= i;
                result.add(i);
            }
            // Если остаток меньше слагаемого и при этом не равен нулю, то слагаемое увеличивается на 1
            // А остаток, соответственно, на 1 уменьшается. Что гарантированно приводит к нулевому остатку

            // Если остаток равен нулю, мы достигли последнего возможного минимального натурального числа
            if (sourceNumber - i == 0) {
                result.add(i);
                break;
            }


        }
        System.out.println(result.size());
        System.out.println(result.stream().map(Object::toString).collect(Collectors.joining(", ")));

    }
}
