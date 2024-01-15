package org.example.java_base.module_2.control_structures;

/**
 * 2.4 - Напишите метод, который будет группировать строчки по ролям,
 * пронумеровывать их и возвращать результат в виде готового текста
 */
public class PrintTextPerRole {
    static private String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder answ = new StringBuilder();
        String sRole, sText;
        StringBuilder bRole, bText;
        int sizeRoles = roles.length;
        int sizeTexts = textLines.length;
        int i, j;
        for (i = 0; i < sizeRoles; i++) {
            bRole = new StringBuilder(roles[i]);
            bRole.append(":");
            sRole = bRole.toString();
            bRole.append('\n');
            answ.append(bRole.toString());
            for (j = 0; j < sizeTexts; j++) {
                if (textLines[j].length() >= sRole.length()) {
                    sText = textLines[j].substring(0, sRole.length());
                    if (sText.compareTo(sRole) == 0) {
                        bText = new StringBuilder(textLines[j]);
                        bText.replace(0, sRole.length(), String.valueOf(j + 1) + ")");
                        bText.append('\n');
                        answ.append(bText.toString());
                    }
                }
            }
            answ.append('\n');
        }
        return answ.toString();
    }

}