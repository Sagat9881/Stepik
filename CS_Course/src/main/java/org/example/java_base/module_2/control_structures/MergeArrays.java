package org.example.java_base.module_2.control_structures;

/**
 * 2.4 - Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел
 * в один отсортированный в том же порядке массив.
 * Массивы могут быть любой длины, в том числе нулевой.
 */
public class MergeArrays {
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int len_1 = a1.length, len_2 = a2.length;
        int a = 0, b = 0, len = len_1 + len_2;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (b < len_2 && a < len_1) {
                if (a1[a] > a2[b]) result[i] = a2[b++];
                else result[i] = a1[a++];
            } else if (b < len_2) {
                result[i] = a2[b++];
            } else {
                result[i] = a1[a++];
            }
        }
        return result;
    }
}