package org.example.algorithms.huffman_code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <h3>Восстановите строку по её коду и беспрефиксному коду символов.</h3>
 * <p>
 * В первой строке входного файла заданы два целых числа k и l через пробел —
 * количество различных букв, встречающихся в строке, и размер получившейся закодированной строки, соответственно.
 * В следующих k строках записаны коды букв в формате "letter: code". Ни один код не является префиксом другого.
 * Буквы могут быть перечислены в любом порядке.<p/>
 *<p> В качестве букв могут встречаться лишь строчные буквы латинского алфавита;
 * каждая из этих букв встречается в строке хотя бы один раз.
 * Наконец, в последней строке записана закодированная строка. Исходная строка и коды всех букв непусты.
 * Заданный код таков, что закодированная строка имеет минимальный возможный размер.<p/>
 *<p> В первой строке выходного файла выведите строку s.
 * Она должна состоять из строчных букв латинского алфавита.
 * Гарантируется, что длина правильного ответа не превосходит 10^4 символов..<p/>
 */
public class HuffmanDecoding {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int wordsCount = SCANNER.nextInt();
        int codeStringLengths = SCANNER.nextInt();

        final Map<String, String> wordsMap = getWordsMap(wordsCount);

        final String codeString = SCANNER.nextLine();

        final HuffmanTable huffmanTable = new HuffmanTable(wordsMap);

        System.out.println(huffmanTable.fromHuffmanCode(codeString));
    }


    private static Map<String, String> getWordsMap(int wordsCount) {
        Map<String, String> wordsMap = new HashMap<>();
        int pulledSegment = 0;

        while (pulledSegment < wordsCount) {
            String segmentString = SCANNER.nextLine();
            if (segmentString != null && !segmentString.isEmpty()) {
                String[] split = segmentString.split(": ");
                wordsMap.put(split[1], split[0]);
                pulledSegment++;
            }
        }
        return wordsMap;
    }

    static class HuffmanTable {
        final Map<String, String> huffmanMap;

        HuffmanTable(Map<String, String> huffmanMap) {

            this.huffmanMap = huffmanMap;
        }

        @Override
        public String toString() {
            return huffmanMap.entrySet()
                    .stream()
                    .map(e -> e.getKey() + ": " + e.getValue())
                    .collect(Collectors.joining("\n"));
        }


        public String fromHuffmanCode(String codeString) {
            StringBuilder accum = new StringBuilder();
            StringBuilder resultAccum = new StringBuilder();
            String[] tokens = codeString.split("");

            for (String token : tokens) {
                accum.append(token);
                String value = this.huffmanMap.get(accum.toString());
                if (value != null) {
                    accum.delete(0, accum.length());
                    resultAccum.append(value);
                }
            }
            return resultAccum.toString();
        }


    }


}
