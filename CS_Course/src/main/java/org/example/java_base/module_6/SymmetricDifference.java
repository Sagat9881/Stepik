package org.example.java_base.module_6;

import java.util.HashSet;
import java.util.Set;

/**
 * 6.2 - Реализуйте метод, вычисляющий симметрическую разность двух множеств.
 */
public class SymmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> words1 = new HashSet<T>(set1);
        words1.removeAll(set2);
        Set<T> words2 = new HashSet<T>(set2);
        words2.removeAll(set1);
        words1.addAll(words2);
        return words1;
    }
}