package org.example.java_base.module_4;

/**
 * 4.1 - Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.
 */
public class GetCallerClassAndMethodName {
    public static String getCallerClassAndMethodName() {
        StackTraceElement ste[] = new Exception().getStackTrace();
        if (ste.length < 3)
            return null;
        else {
            return ste[2].getClassName() + "#" + ste[2].getMethodName();
        }
    }
}