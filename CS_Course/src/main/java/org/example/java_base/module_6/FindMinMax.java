package org.example.java_base.module_6;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

/**
 * 6.4 - Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.
 */
public class FindMinMax {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        T s_min = null;
        T s_max = null;
        T[] streamArray;


        streamArray = (T[]) stream.sorted(order).toArray();

        if (streamArray.length == 1) {
            s_min = streamArray[0];
            s_max = streamArray[0];
            minMaxConsumer.accept(s_min, s_max);
        } else if (streamArray.length > 1) {
            s_min = streamArray[0];
            s_max = streamArray[streamArray.length - 1];
            minMaxConsumer.accept(s_min, s_max);
        } else
            minMaxConsumer.accept(s_min, s_max);
    }
}