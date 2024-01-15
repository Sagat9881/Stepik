package org.example.java_base.module_5;

import java.io.File;

public class Video1 {


    public static void main(String[] args) {
        File javaExecutabel = new File("C://JavaTestFile//Test1.txt");
        String sourceDirName = "C:JavaTestFile";
        String sourceFileName = "Test1.txt";
        File testFile = new File(sourceDirName, sourceFileName);
        System.out.println(testFile.getPath());
        System.out.println(testFile.getName());
        System.out.println(testFile.getParent());
        try {
            System.out.println(testFile.getCanonicalPath());

            System.out.println(javaExecutabel.getCanonicalPath());
        } catch (Exception e) {
            System.out.println("Не вышло1");
        }
        try {
            System.out.println(testFile.getCanonicalPath().equals(javaExecutabel.getCanonicalPath()));
        } catch (Exception e) {
            System.out.println("Не получилось");
        }
    }
}



