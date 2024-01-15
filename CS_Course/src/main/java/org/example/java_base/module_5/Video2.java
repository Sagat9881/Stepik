package org.example.java_base.module_5

import java.io.File;
import java.util.Vector;

public class Video2 {
    public static void ExampleReadTest() {

        File notFile = new File("C:JavaTestFile//Test2.txt");

        File javaDir = new File("C://JavaTestFile");

        String sourceDirName = "C://JavaTestFile";
        String sourceFileName = "Test1.txt";
        File testFile = new File(sourceDirName, sourceFileName);

        System.out.println(notFile.exists());            //Проверка существования файла

        System.out.println(testFile.exists());           //Проверка существования файла

        System.out.println(testFile.isFile());           //Проверка Файл  ли это.
        System.out.println(notFile.isFile());
        System.out.println(testFile.isDirectory());      // Или директория
        System.out.println(notFile.isDirectory());

        System.out.println(testFile.length());           // Размер текущего файла
        System.out.println(testFile.lastModified());     // Время последней модификаии в млс с 1970 года

        System.out.println(notFile.length());            // При отсутствии файла эти методы вернут "0", вметсо исключения
        System.out.println(notFile.lastModified());


        System.out.println(javaDir.isDirectory());        //Директория
        System.out.println(javaDir.list());               // Вернет строковый массив  String []
        System.out.println(javaDir.listFiles());          // Вернет массив файлов     File []


    }

}

class Video21 {
    public static void ExampleCreate() {
        File test3 = new File("C://JavaTestFiles");
       /* try {
            boolean success = test3.createNewFile();      // создание файлов в системе.
            System.out.println(success);
        }catch (IOException e){
            System.out.println("ошибочка вышла");
        }*/

        File testDir = new File("C://JavaTestFile//testDir1//testDir2");
        File renDir = new File("C://JavaTestFile//testDir1//testDirElse");
        boolean dirsucc = testDir.mkdir();

        dirsucc = testDir.mkdirs();    // создание новой директории/директорий.

        dirsucc = testDir.renameTo(renDir); // переименование уже существующих директорий.


    }
}
