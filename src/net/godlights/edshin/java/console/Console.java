package net.godlights.edshin.java.console;

import net.godlights.edshin.java.console.cmd.Command;
import net.godlights.edshin.java.console.cmd.lang.Translator;
import net.godlights.edshin.java.console.java.Java;

import java.util.Locale;

public class Console {

    public static Translator translator = new Translator(Locale.getDefault().getLanguage());
    public static void print(Object o) {
        System.out.println(o.toString()+ANSIColor.RESET);
        Java.outLog("Print: "+o);
    }
    public static void error(Exception e) {
        System.out.println(ANSIColor.RED+e.getMessage()+ANSIColor.RESET);
        Java.outLog("Error: "+e.getMessage());
    }
    public static void console(Object o) {
        System.out.print(o.toString()+ANSIColor.RESET);
    }

    public static void langChange(String lang) {
        translator = new Translator(lang);
    }

    public static Command getCmd(String name) {
        return new Command(name);
    }
}
