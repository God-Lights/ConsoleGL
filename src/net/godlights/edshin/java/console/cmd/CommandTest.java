package net.godlights.edshin.java.console.cmd;

import net.godlights.edshin.java.console.Console;

public class CommandTest implements CmdExecutor{
    @Override
    public boolean onCmd(String[] args) {
        Console.print("hello world");
        return false;
    }
}
