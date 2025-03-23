package net.godlights.edshin.java.console.cmd;

import net.godlights.edshin.java.console.Console;
import net.godlights.edshin.java.util.GodLights;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.LinkOption;

public class CommandTest implements CmdExecutor{
    @Override
    public boolean onCmd(String[] args) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(args[0]));
                Console.print(args[0] + " 페이지를 열었습니다.");
            } catch (IOException | URISyntaxException e) {
                Console.error(e);
            }
        } else {
            Console.error(new Exception("This Desktop doesn't support Desktop class."));
        }
        return false;
    }
}
