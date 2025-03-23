package main;

import net.godlights.edshin.java.console.ANSIColor;
import net.godlights.edshin.java.console.Console;
import net.godlights.edshin.java.console.cmd.CmdExecutor;
import net.godlights.edshin.java.console.cmd.Command;
import net.godlights.edshin.java.console.cmd.CommandTest;
import net.godlights.edshin.java.console.cmd.lang.Translator;
import net.godlights.edshin.java.console.java.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;

public class MainRun {
    static String cd = "";
    public static void main(String[] args) {
        Map<String, Consumer<String[]>> map = new HashMap<>(Map.of());
        map.put("hello", (arg) -> {
            Console.print(Console.translator.translate("welcome.message"));
        });
        map.put("bye", (arg) -> {
            Console.print(Console.translator.translate("bye.message"));
        });
        map.put("test", (arg) -> {
            if(arg[0].equals("rainbow")) {
                Console.print(Console.translator.translate("rainbow.text"));
            } else {
                Console.error(new Exception("Command Error/Code 488"));
            }
        });
        map.put("reload", (arg) -> {
            if(arg[0].equals("confirm")) {
                Java.ReloadConsole();
            } else {
                Console.error(new Exception("Command Error/Code 488"));
            }
        });
        map.put("info",(arg) -> {
            switch (arg[0]) {
                case "os" ->
                        Console.print("OS: " + System.getProperty("os.name") + "\nver: " + System.getProperty("os.version"));
                case "java" ->
                        Console.print("Java Version: " + System.getProperty("java.version") + "\nJVM: " + System.getProperty("java.vm.name") + " " + System.getProperty("java.vm.version") + "\nJRE: " + System.getProperty("java.runtime.name"));
                case null, default ->
                        Console.error(new Exception("Command Error/Code 488"));
            }
        });
        map.put("cd", (arg) -> {
            if(arg[0].equals("name")) {
                changeCd(arg[1]);
            } else {
                Console.error(new Exception("Command Error/Code 488"));
            }
        });
        map.put("lang",(arg) -> {
            if(arg[0].equals("check")) {
                Console.print(Console.translator);
            } else if(arg[0].equals("change")) {
                if(arg[1] != null) {
                    Console.langChange(arg[1]);
                }
            } else {
                Console.error(new Exception("Command Error/Code 488"));
            }
        });
        map.put("cmd", (arg) -> {
            if(!map.containsKey(arg[0])) {
                try {
                    Console.getCmd(arg[0]).registerCmd(new CommandTest());
                } catch(Exception e) {
                    Console.error(e);
                }
            } else {
                Console.error(new Exception("It was already contained"));
            }
        });
        while(true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String text = "";
            System.out.print(cd+"> ");
            try {
                text = bufferedReader.readLine();
            } catch(IOException e) {
                Console.print(ANSIColor.RED+e.getMessage());
            }
            String[] cmdLarn = text.split(" ");
            String[] cmdi = text.split("");
            String cmdName = cmdLarn[0];
            String[] arg = Arrays.copyOfRange(cmdLarn, 1, cmdLarn.length);
            if(map.containsKey(cmdName)) {
                try {
                    map.get(cmdName).accept(arg);
                } catch(Exception e) {
                    Console.print(ANSIColor.RED+e.getMessage());
                }
            } else if(Command.getCmdMap().containsKey(cmdName)) {
                try {
                    Command.getCmdMap().get(cmdName).accept(arg);
                } catch(Exception e) {
                    Console.error(e);
                }
            } else if(!cmdLarn[0].equals("exit") && !cmdLarn[0].equals("stop")){
                Console.error(new Exception("Command wasn't found/Code 433"));
            }
            Console.print(Arrays.toString(arg));
            if(cmdLarn[0].equals("exit") || cmdLarn[0].equals("stop")) {
                Console.print("End console.");
                break;
            }
        }
    }
    public void onEnable() {
        Console.getCmd("tee").registerCmd(new CommandTest());
    }
    public static void changeCd(String name) {
        if(!Objects.equals(name, "reset") && name != null) {
            cd = name+" ";
        } else if(name.equals("reset")) {
            cd = "";
        } else {
            Console.error(new Exception("Argument is null"));
        }
    }
}