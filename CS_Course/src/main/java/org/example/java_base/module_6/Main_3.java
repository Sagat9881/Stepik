package org.example.java_base.module_6;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 6.2 - Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами,
 * затем удалит из них все числа, стоящие на четных позициях,
 * и затем выведет получившуюся последовательность в обратном порядке в System.out.
 */
public class Main_3 {
    public static void main(String[] args) throws IOException {
        Integer ielem;
        int i = 0;
        ArrayDeque ad = new ArrayDeque();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            ielem = sc.nextInt();
            if (i % 2 != 0)
                ad.add(ielem);
            i++;
        }
        Iterator<Integer> di = ad.descendingIterator();
        while (di.hasNext()) {
            ielem = di.next();
            System.out.print(ielem.toString() + " ");
        }
        System.out.flush();
    }
}
