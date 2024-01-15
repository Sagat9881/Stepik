package org.example.algorithms.greedy_algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * По данным n отрезкам необходимо найти множество точек минимального размера,
 * для которого каждый из отрезков содержит хотя бы одну из точек.
 * <p>
 * В первой строке дано число 1 ≤ n ≤ 100 отрезков.
 * Каждая из последующих n строк содержит по два числа 0 ≤ l ≤ r ≤ 10^9,
 * задающих начало и конец отрезка.
 * <p>
 * Выведите оптимальное число точек и сами точки.
 * Если таких множеств точек несколько, выведите любое из них.
 * <p>
 * Оптимальным считается наибольшее, из возможных, значение
 */
public class DotСoverage {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        final List<Segment> segmentList = getSegments(SCANNER.nextInt());

        final ArrayList<Integer> dots = new ArrayList<>();
        final Segment finalSegment = segmentList.stream()
                .sorted(Comparator.comparingInt(s -> s.x2))
                .reduce((s1, s2) -> {
                    // "s1" пересекается с "s2" ->
                    // есть точки лежащие сразу на 2-ух отрезках ->
                    // можно пропустить "s2", т.к. "s1.x2" лежит сразу на 2-ух отрезков и является оптимальной точкой для обоих
                    if (s1.x2 >= s2.x1) {
                        return s1;
                    } else {
                        // "s1" НЕ пересекается с "s2" ->
                        // нет общих точек между отрезками ->
                        // больше нет никаких неучтенных пересечений "s1"
                        // с другими отрезками, т.к. список отрезков отсортирован по полю "s.x2"->
                        // добавляем "s1.x2" к результату
                        dots.add(s1.x2);
                        return s2;
                    }
                }).orElse(new Segment(" "));

        // Если последний отрезок пересекается с предпоследним,
        // то результатом работы редуцирования будет предпоследний отрезок ->
        // в этом случае, оптимальной точкой, лежащей на последнем и предпоследнем отрезках одновременно,
        // будет конец предпоследнего отрезка.

        // Если последний отрезок с предпоследним не пересекается,
        // то в результате работы редуцирования точка конца предпоследнего отрезка добавится в результирующее множество точек ->
        // в этом случае останется добавить только оптимальную точку, лежащую на последнем, ни с кем не пересекающемся отрезке
        // т.е. конец последнего отрезка
        dots.add(finalSegment.x2);

        final String resultDotsString = dots.stream().map(Object::toString).collect(Collectors.joining(" "));
        final int dotsCount = dots.size();

        System.out.println(dotsCount);
        System.out.println(resultDotsString);
    }

    private static List<Segment> getSegments(int expectedSegmentCount) {
        final ArrayList<Segment> segments = new ArrayList<>(expectedSegmentCount);
        int pulledSegment = 0;

        while (pulledSegment < expectedSegmentCount) {
            String segmentString = SCANNER.nextLine();
            if (segmentString != null && !segmentString.isEmpty()) {
                Segment segment = new Segment(segmentString);
                segments.add(segment);
                pulledSegment++;
            }
        }
        return segments;
    }

    static class Segment {
        int x1;
        int x2;

        public Segment(String segmentString) {
            final String regex = "^\\d+\\s\\d+$";
            if (Pattern.matches(regex, segmentString)) {
                final String[] s = segmentString.split(" ");
                this.x1 = Integer.parseInt(s[0]);
                this.x2 = Integer.parseInt(s[1]);
            }
        }
    }
}
