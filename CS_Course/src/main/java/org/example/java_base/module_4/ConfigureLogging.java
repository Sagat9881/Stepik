package org.example.java_base.module_4;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
 * 4.3 - вам нужно реализовать метод, настраивающий параметры логирования.
 */
public class ConfigureLogging {
    private static void configureLogging() {
        Logger classA = Logger.getLogger("org.stepic.java.logging.ClassA");
        Logger classB = Logger.getLogger("org.stepic.java.logging.ClassB");
        Logger classJ = Logger.getLogger("org.stepic.java");
        classA.setLevel(Level.ALL);
        classB.setLevel(Level.WARNING);
        classJ.setLevel(Level.ALL);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new XMLFormatter());

        classJ.addHandler(consoleHandler);
        classJ.setUseParentHandlers(false);
    }
}