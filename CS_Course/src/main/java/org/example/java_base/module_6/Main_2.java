package org.example.java_base.module_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 6.4 - Напишите программу, читающую из System.in текст в кодировке UTF-8,
 * подсчитывающую в нем частоту появления слов, и в конце выводящую 10 наиболее часто встречающихся слов
 */
public class Main_2 {


    public static void main(String[] args) {
        String str;
        Charset charset = Charset.forName("UTF-8");
        Reader reader = new InputStreamReader(System.in, charset);
        BufferedReader bufferedReader = new BufferedReader(reader);

        Stream<String> stream = bufferedReader.lines();
        Map<String, Long> collect =
                stream.map(line -> line.split("[^\\pL\\pM\\p{Nd}\\p{Nl}\\p{Pc}[\\p{InEnclosedAlphanumerics}&&\\p{So}]]"))
                        .flatMap(Arrays::stream)
                        .map(String::toLowerCase)

                        .collect(Collectors.groupingBy(o -> o, Collectors.counting()));


        collect.entrySet().stream().sorted((e1, e2) -> {
                    int comp = e2.getValue().compareTo(e1.getValue());
                    if (comp == 0) {
                        return -e2.getKey().compareTo(e1.getKey());
                    }
                    return comp;
                })
                .limit(11)
                .forEach(x -> System.out.println(x.getKey()));


    }


}
