package org.example.java_base.module_2.primitive_types;

public class Mainbool {
    public static void main(String[] args) {
        Mainbool mainbool = new Mainbool();
        System.out.println(mainbool.boolmethod(true, false, true, false));
    }

    static boolean boolmethod(boolean a, boolean b, boolean c, boolean d) {
        boolean[] myArr = {a, b, c, d};
        int x = 0;
        for (int i = 0; i <= (myArr.length - 1); i++) {
            if (myArr[i]) {
                x += 1;
            }
        }
        return x == 2;

    }
}
