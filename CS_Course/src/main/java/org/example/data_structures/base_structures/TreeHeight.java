package org.example.data_structures.base_structures;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <h3>Формат входа:
 * <p>Первая строка содержит натуральное число "n".
 * <p>Вторая строка содержит "n" целых чисел ["parent[0]" , . . . , "parent[n−1]"].
 * Для каждого "0 ≤ i ≤ n−1", "parenti" — родитель вершины "i"; если parent[i] = −1, то "i" является корнем.
 * <p>Гарантируется, что корень ровно один. <p>Гарантируется, что данная последовательность задаёт дерево.<p/>
 * <p>
 * <h3>Формат выхода: Высота дерева.
 * <h3>Ограничения:  "1 ≤ n ≤ 105".
 */
public class TreeHeight {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int expectedPeaksCount = SCANNER.nextInt();
        Integer[] peaks = getPeaks(expectedPeaksCount);

        Tree tree = Tree.buildTree(peaks);

        System.out.println(tree.getHeight());
    }

    static class Tree {
        final Node head;

        private Tree(Map<Integer, Node> valueToNode, Map<Integer, Integer> valueToParentValue) {
            valueToNode.forEach((value, node) -> {
                Integer parentValue = valueToParentValue.get(value);
                Node parentNode = valueToNode.get(parentValue);
                node.parent = parentNode;

                if (parentNode != null) parentNode.childs.put(value, node);
            });

            this.head = valueToNode.keySet()
                    .stream()
                    .filter(value -> -1 == valueToParentValue.get(value))
                    .map(valueToNode::get)
                    .findFirst()
                    .orElseThrow(RuntimeException::new);

        }

        public int getHeight(Node current) {
            int height = 1;
            final Collection<Node> childs = current.childs.values();

            for (Node child : childs) {
                height = Math.max(height, 1 + getHeight(child));
            }

            return height;
        }

        public int getHeight() {
            return getHeight(this.head);
        }

        public static Tree buildTree(Integer[] peaks) {
            final Map<Integer, Integer> valueToParentValue = IntStream.range(0, peaks.length)
                    .mapToObj(i -> toMap(i, peaks[i]))
                    .reduce(TreeHeight::putAll)
                    .orElse(new HashMap<>());

            final Map<Integer, Node> valueToNode = valueToParentValue.keySet()
                    .stream()
                    .collect(Collectors.toMap(Function.identity(), Node::new));

            return new Tree(valueToNode, valueToParentValue);
        }
    }

    static class Node {
        Node parent;
        int floor;
        Map<Integer, Node> childs = new HashMap<>();
        int value;

        public Node(int value) {
            this.value = value;
            this.floor = 1;
        }

    }

    private static Map<Integer, Integer> putAll(Map<Integer, Integer> m1, Map<Integer, Integer> m2) {
        m1.putAll(m2);
        return m1;
    }

    private static <K, V> Map<K, V> toMap(K key, V value) {
        Map<K, V> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

    private static Integer[] getPeaks(int expectedStuffCount) {
        Integer[] result = new Integer[expectedStuffCount];
        int pulledSegment = 0;
        while (pulledSegment < expectedStuffCount) {
            result[pulledSegment] = SCANNER.nextInt();
            pulledSegment++;
        }
        return result;
    }


}
