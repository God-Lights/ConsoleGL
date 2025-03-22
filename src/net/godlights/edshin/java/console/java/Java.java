package net.godlights.edshin.java.console.java;

import main.MainRun;
import net.godlights.edshin.java.console.Console;

public class Java {
    public static void ReloadConsole() {
        Console.print("Reload console...");
        try {
            // Simulate the reloading process, for example, restarting a new instance of the application
            String javaBin = System.getProperty("java.home") + "/bin/java";
            String classpath = System.getProperty("java.class.path");
            String className = MainRun.class.getName();

            ProcessBuilder processBuilder = new ProcessBuilder(javaBin, "-cp", classpath, className);
            processBuilder.inheritIO();  // To inherit IO streams of the current process
            processBuilder.start();

            System.exit(0);  // Exit the current application
        } catch (Exception e) {
            Console.error(e);
        }
    }
}
