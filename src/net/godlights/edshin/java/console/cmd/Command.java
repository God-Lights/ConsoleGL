package net.godlights.edshin.java.console.cmd;

import net.godlights.edshin.java.console.ANSIColor;
import net.godlights.edshin.java.console.Console;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Command {
    private String name = null;
    private static final Map<String, Consumer<String[]>> map = new HashMap<>(Map.of());

    public Command(String name) {
        this.name = name;
    }

    public void registerCmd(CmdExecutor executor) {
        map.put(name, executor::onCmd);
    }

    public static Map<String,Consumer<String[]>> getCmdMap() {
        return map;
    }
}