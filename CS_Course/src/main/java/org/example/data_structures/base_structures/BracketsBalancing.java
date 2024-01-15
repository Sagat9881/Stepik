package org.example.data_structures.base_structures;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 2.1 Скобки в коде
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
            final Bracket bracket = Bracket.getBracket(token, i);
            if (bracket != null) {
                if (Direction.OPEN.equals(bracket.direction)) {
                    stack.push(bracket);
                }

                if (Direction.CLOSE.equals(bracket.direction)) {
                    Bracket openBracket = stack.poll();
                    if (openBracket == null || !openBracket.isPair(bracket)) {
                        stack.clear();
                        stack.push(bracket);
                        break;
                    }
                }
            }
        }

        System.out.println(stack.isEmpty() ? "Success" : Objects.toString(stack.pop().index + 1));

    }

    static class Bracket {
        private static final String[] open = {"{", "[", "("};
        private static final String[] close = {"}", "]", ")"};
        final String value;

        final int index;
        final int type;
        final Direction direction;

        public Bracket(String value, int index, Direction direction) {
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
