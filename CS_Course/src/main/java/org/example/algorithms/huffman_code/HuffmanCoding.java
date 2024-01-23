package org.example.algorithms.huffman_code;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *  <p>По данной непустой строке "s" длины не более 10^4, состоящей из строчных букв латинского алфавита,
 * постройте оптимальный беспрефиксный код.<p/>
 * <h3>Формат вывода:
 * <p> В первой строке выведите количество различных букв "k",
 * встречающихся в строке, и размер получившейся закодированной строки.
 * <p>В следующих "k" строках запишите коды букв в формате "letter: code".
 * <p>В последней строке выведите закодированную строку.
 */
public class HuffmanCoding {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        final String sourceString = SCANNER.nextLine();

        PriorityQueue<Node> frequencyQueue = getFrequencyQueue(sourceString);

        Node node1 = frequencyQueue.poll();
        Node node2 = frequencyQueue.poll();

        while (node2 != null) {
            long nodeFrequency = node1.frequency + node2.frequency;
            Node node = new Node(nodeFrequency);
            node.left = node2;
            node.right = node1;
            frequencyQueue.add(node);

            node1 = frequencyQueue.poll();
            node2 = frequencyQueue.poll();
        }

        HuffmanTree tree = new HuffmanTree(node1);
        System.out.println(tree.toHuffmanCode(sourceString));
    }

    private static PriorityQueue<Node> getFrequencyQueue(String sourceString) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingLong(Node::getFrequency));
        Arrays.stream(sourceString.split(""))
                .collect(Collectors.toMap(Function.identity(), s -> 1L, Long::sum))
                .entrySet()
                .stream()
                .map(Node::new)
                .forEach(queue::add);
        return queue;
    }


    static class HuffmanTree {
        final Node root;
        Node current;

        HuffmanTree(Node root) {
            this.root = root;
            this.current = root;
        }

        public String toHuffmanCode(String source) {
            Map<String, String> huffmanMap = this.toHuffmanMap();
            int lettersCount = huffmanMap.keySet().size();
            StringBuilder accum = new StringBuilder();
            String[] tokens = source.split("");

            for (String token : tokens) {
                accum.append(huffmanMap.get(token));
            }

            return lettersCount + " " + accum.length() + "\n" + this + "\n" + accum;
        }

        @Override
        public String toString() {
            return this.toHuffmanMap().entrySet()
                    .stream()
                    .map(e -> e.getKey() + ": " + e.getValue())
                    .collect(Collectors.joining("\n"));
        }

        public Map<String, String> toHuffmanMap() {
            StringBuilder accum = new StringBuilder();
            Map<String, String> container = new HashMap<>();

            return this.toHuffmanMap(accum, this.root, container);
        }

        private Map<String, String> toHuffmanMap(StringBuilder accum, Node node, Map<String, String> container) {
            Node right = node.right;
            Node left = node.left;
            if (right != null) {
                accum.append("0");
                container.putAll(toHuffmanMap(accum, right, container));
            }

            if (left != null) {
                accum.append("1");
                container.putAll(toHuffmanMap(accum, left, container));
            }
            if (node.value != null) {
                String accumCode = accum.toString();
                final String code = accumCode.isEmpty() ? "0" : accumCode;
                container.put(node.value, code);
            }

            if (accum.length() > 0) {
                accum.delete(accum.length() - 1, accum.length());
            }

            return container;
        }
    }

    static class Node {
        final String value;
        final long frequency;

        Node left;
        Node right;

        Node(Map.Entry<String, Long> frequencyMapEntry) {
            this.value = frequencyMapEntry.getKey();
            this.frequency = frequencyMapEntry.getValue();
        }

        public Node(String value, long frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        public Node(long frequency) {
            this.value = null;
            this.frequency = frequency;
        }

        public long getFrequency() {
            return frequency;
        }
    }


}
