package org.example.algorithms.greedy_algorithm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Первая строка содержит количество предметов "1 ≤ n ≤ 10^3" и вместимость рюкзака "0 ≤ W ≤ 2⋅10^6".
 * Каждая из следующих "n" строк задаёт стоимость "0 ≤ c ≤ 2⋅10^6" и объём "0 < w ≤ 2⋅10^6" предмета ("n", "W", "c", "w" — целые числа).
 * <p>
 * Выведите максимальную стоимость частей предметов
 * (от каждого предмета можно отделить любую часть, стоимость и объём при этом пропорционально уменьшатся),
 * помещающихся в данный рюкзак, с точностью не менее трёх знаков после запятой.
 */
public class BagFilling {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        final String[] bagAndStuff = SCANNER.nextLine().split(" ");
        final List<Stuff> stuffList = getStuff(Integer.parseInt(bagAndStuff[0]));

        // Надежный шаг - заполнять рюкзак сначала наиболее дорогими за кг вещами
        stuffList.sort(Comparator.<Stuff>comparingDouble(s -> s.price).reversed());

        int freeSpace = Integer.parseInt(bagAndStuff[1]);
        double result = 0;

        for (Stuff stuff : stuffList) {
            if (stuff.weight > freeSpace) {
                result += (stuff.weight - (stuff.weight - freeSpace)) * stuff.price;
                break;
            }
            result += stuff.cost;
            freeSpace -= stuff.weight;
        }
        // Приводим к 3-ем знакам после запятой
        final BigDecimal resultBagCost = BigDecimal.valueOf(result).setScale(3, RoundingMode.HALF_UP);

        System.out.println(resultBagCost);
    }

    private static List<Stuff> getStuff(int expectedStuffCount) {
        final ArrayList<Stuff> stuff = new ArrayList<>(expectedStuffCount);
        int pulledSegment = 0;
        while (pulledSegment < expectedStuffCount) {
            String stuffString = SCANNER.nextLine();
            if (stuffString != null && !stuffString.isEmpty()) {
                String[] stuffDefiniton = stuffString.split(" ");
                stuff.add(
                        new Stuff(
                                Double.parseDouble(stuffDefiniton[0]),
                                Double.parseDouble(stuffDefiniton[1])));
                pulledSegment++;
            }
        }
        return stuff;
    }

    static class Stuff {
        double cost;
        double weight;
        double price;

        public Stuff(double cost, double weight) {
            this.cost = cost;
            this.weight = weight;
            this.price = cost / weight;
        }
    }
}
