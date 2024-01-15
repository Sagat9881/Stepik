package org.example.algorithms.huffman_code;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * По данной непустой строке "s" длины не более 10^4, состоящей из строчных букв латинского алфавита,
 * постройте оптимальный беспрефиксный код. В первой строке выведите количество различных букв "k",
 * встречающихся в строке, и размер получившейся закодированной строки.
 * В следующих "k" строках запишите коды букв в формате "letter: code".
 * В последней строке выведите закодированную строку.
 */
public class HuffmanCoding {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        final String sourceString = SCANNER.nextLine();

        PriorityQueue<Letter> frequencyQueue = getFrequencyQueue(sourceString);

        Letter leaf1 = frequencyQueue.poll();
        Letter leaf2 = frequencyQueue.poll();

        while (leaf2 != null) {

        }


    }

    private static PriorityQueue<Letter> getFrequencyQueue(String sourceString) {
        PriorityQueue<Letter> queue = new PriorityQueue<>(Comparator.comparingLong(Letter::getFrequency));
        Arrays.stream(sourceString.split(""))
                .collect(Collectors.toMap(Function.identity(), s -> 1L, Long::sum))
                .entrySet()
                .stream()
                .map(Letter::new)
                .forEach(queue::add);
        return queue;
    }



    static class Letter {
        public Letter(String value, long frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        final String value;

        long frequency;

        Letter(Map.Entry<String, Long> frequencyMap) {
            this.value = frequencyMap.getKey();
            this.frequency = frequencyMap.getValue();
        }

        public long getFrequency() {
            return frequency;
        }
    }


}
