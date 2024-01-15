package org.example.java_base.module_6;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 6.3 - Напишите метод ternaryOperator, который из них построит новую функцию,
 * возвращающую значение функции ifTrue, если предикат выполнен, и значение ifFalse иначе.
 */
public class TernaryOperator {
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return (T x) -> {
            if (condition.test(x))
                return ifTrue.apply(x);
            else
                return ifFalse.apply(x);
        };
    }
}