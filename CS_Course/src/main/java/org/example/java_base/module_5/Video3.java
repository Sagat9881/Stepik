package org.example.java_base.module_5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Video3 {
    public static void Example3() {
        Path path = Paths.get("C://JavaTestFile//Test1");             // Создание объекта типа Path и привязка к файлу
      /*  File fromPath = path.toFile();                                   // Конвертация файла типа Path в тип File
        Path fromFile = fromPath.toPath();                                 // Обратная первой конвертация
       *//*
        path.isAbsolute();                                                 // Аналоги синтаксических конструкций в классе File
        path.getFileName();
        path.getParent();
*/
        System.out.println(path.getNameCount());                           // ПОолучение индекса объекта относительно пути.
        System.out.println(path.getName(1));                               // Получение компонента пути по его индексу.
        System.out.println(path.resolveSibling("Test.txt"));               // ???
        System.out.println(path.startsWith("C://JavaTestFile"));           // Является ли  один путь префиксом другого.
        System.out.println(Paths.get("C://").relativize(path));       //Вычисление относитльнго пути между двумя элементами ФАЙЛОВОЙ системы.


        class Video31 {

        }




    }
}
