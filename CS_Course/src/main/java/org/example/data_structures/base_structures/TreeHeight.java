package org.example.data_structures.base_structures;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <h3>Формат входа:</h3><p>Первая строка содержит натуральное число "n".</p>
 * <p>Вторая строка содержит "n" целых чисел ["parent[0]" , . . . , "parent[n−1]"].</p>
 * Для каждого "0 ≤ i ≤ n−1", "parenti" — родитель вершины "i"; если parent[i] = −1, то "i" является корнем.
 * <p>Гарантируется, что корень ровно один.</p> <p>Гарантируется, что данная последовательность задаёт дерево.</p>
 * <p></p>
 * <h3>Формат выхода: </h3>
 * <p>Высота дерева.</p>
 * <p></p>
 * <h3>Ограничения: </h3> "1 ≤ n ≤ 105".
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
            final Collection<Node> values = current.childs.values();
            final Set<Integer> leafChild = values.stream().filter(node -> node.childs.isEmpty())
                    .map(node -> node.value)
                    .collect(Collectors.toSet());

            int height = leafChild.size() == values.size() ? 2 : 1;

            for (Collection<Node> value : partition(values, 10)) {
                int i = value.stream()
                        .filter(node -> !leafChild.contains(node.value))
                        .mapToInt(node -> this.getHeight(node) + 1)
                        .max()
                        .orElse(height);
                height = Math.max(height, i);
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

    private static <T> List<List<T>> partition(Collection<T> list, int delim) {
        ArrayList<List<T>> result = new ArrayList<>();
        List<T> wrap = new ArrayList<>(list);
        int start = 0;
        int end = delim;
        while (end + delim >= list.size()) {
            List<T> subList = wrap.subList(start, end);
            result.add(subList);
            start = end;
            end += delim;
        }
        int minus = (end + delim) - list.size();
        end += (delim - minus);
        result.add(wrap.subList(start, end));
        return result;
    }
}
