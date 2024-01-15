package org.example.data_structures.base_structures;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * <h3>Формат входа:</h3>
 * Строка s[1 . . . n], состоящая из заглавных и прописных букв латинского алфавита,
 * цифр, знаков препинания и скобок из множества []{}().
 * <p> </p>
 * <h3>Формат выхода:</h3>
 * <p>Если скобки в s расставлены правильно, выведите строку “Success".</p>
 * <p>В противном случае выведите индекс (используя индексацию с единицы) первой закрывающей скобки,
 * для которой нет соответствующей открывающей.</p>
 * <p>Если такой нет, выведите индекс первой открывающей скобки, для которой нет
 * соответствующей закрывающей</p>
 */
public class BracketsBalancing {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        final String sourceLine = SCANNER.nextLine();
        final LinkedList<Bracket> stack = new LinkedList<>();
        final String[] tokens = sourceLine
                .replaceAll(" ", "")
                .split("");

        for (int i = 0; i < tokens.length; i++) {
            final String token = tokens[i];
            // Построим объект из символа
            // Объект инкапсулирует данные о символе, типе скобки, индексе символа в строке
            final Bracket bracket = Bracket.getBracket(token, i);
            // Если объект получилось построить - значит скобка, значит обрабатываем. Если построить не вышло - значит не скобка, игнорируем
            if (bracket != null) {
                // Если скобка открывающая - кладем на вершину стека
                if (Direction.OPEN.equals(bracket.direction)) {
                    stack.push(bracket);
                }
                // Если скобка закрывающая
                if (Direction.CLOSE.equals(bracket.direction)) {
                    // Забираем с вершины стека открывающую скобку (если есть) и перекладываем в переменную
                    Bracket openBracket = stack.poll();
                    // Если на стеке нет никакой открывающей скобки или если скобка на вершине стека не парная к текущей
                    // то анализ закончен, ошибка найдена
                    if (openBracket == null || !openBracket.isPair(bracket)) {
                        // Очищаем стек, в пустой стек кладем текущий объект.
                        // В нем данные об индексе символа, на которым мы нашли ошибку
                        stack.clear();
                        stack.push(bracket);
                        break;
                    }

                    // Если ошибок нет, то с вершины стека просто удаляется значение
                    // А из переменной данные удалятся на следующей итерации цикла
                }
            }
        }
        // Если все символы в строке закончились и стек пустой - значит для каждой закрывающей скобки на стеке была найдена открывающая
        // Если стек не пустой, значит либо осталась открывающая скобка, либо было найдено несоответствие, на стеке только ошибочная закрывающая скобка (объект)
        System.out.println(stack.isEmpty() ? "Success" : Objects.toString(stack.pop().index + 1));

    }

    /**
     * Объект абстрагирующий необходимые для рассчета данные об 1-ой скобке
     */
    static class Bracket {
        /**
         * Множество открывающих скобок
         */
        private static final String[] open = {"{", "[", "("};
        /**
         * Множество закрывающих скобок
         */
        private static final String[] close = {"}", "]", ")"};
        /**
         * Представление скобки в типе String
         */
        final String value;
        /**
         * Индекс скобки в анализируемой строке
         */
        final int index;
        /**
         * Тип скобки (фигурная, круглая, прямоугольная), задается индексом в массиве open или close
         * Скобки с одинаковым индексом - одного типа
         */
        final int type;
        /**
         * Направление скобки (Открывающая или закрывающая)
         */
        final Direction direction;

        private Bracket(String value, int index, Direction direction) {
            this.value = value;
            this.index = index;
            this.direction = direction;
            this.type = getType(direction, value);
        }

        private static int getType(Direction direction, String value) {
            return direction.equals(Direction.OPEN) ? getIndex(open, value) : getIndex(close, value);
        }

        private static int getIndex(Object[] arr, Object value) {
            return IntStream.rangeClosed(0, arr.length).filter(i -> arr[i].equals(value)).findFirst().orElse(-1);
        }

        public static Bracket getBracket(String bracket, int findIndex) {
            Bracket result = null;
            for (int i = 0; i < open.length; i++) {
                if (open[i].equals(bracket)) {
                    result = new Bracket(open[i], findIndex, Direction.OPEN);
                }
                if (close[i].equals(bracket)) {
                    result = new Bracket(close[i], findIndex, Direction.CLOSE);
                }

            }
            return result;
        }

        public boolean isPair(Bracket bracket) {
            final boolean equalsDirection = this.direction.equals(bracket.direction);
            final boolean equalsType = this.type == bracket.type;

            return !equalsDirection && equalsType;
        }

    }

    enum Direction {
        OPEN, CLOSE;
    }


}
