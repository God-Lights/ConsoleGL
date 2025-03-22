package net.godlights.edshin.java.console.cmd.lang;

import net.godlights.edshin.java.console.ANSIColor;

import java.util.Objects;

public class Translator {

    private static String lang = "";
    public Translator(String lang) {
        Translator.lang = lang;
    }

    @Override
    public String toString() {
        return lang;
    }

    public String translate(String code) {
        String os = System.getProperty("os.name");
        String userName = System.getProperty("user.name");
        if (lang.equals("ko")) {
            switch (code) {
                case "welcome.message":
                    return "안녕하세요 " + userName + "님!";
                case "bye.message":
                    return "잘가요 " + userName + "님!";
                case "os.message":
                    return "당신의 OS는 " + os + "입니다.";
                case "yourFace.othe":
                    return "ㄴl얼굴";
                case "rainbow.text":
                    return ANSIColor.RED + "우" + ANSIColor.YELLOW + "와" + ANSIColor.GREEN + "아" + ANSIColor.CYAN + "아" + ANSIColor.BLUE + "아" + ANSIColor.PURPLE + "아";
                case "madeBy.text":
                    return ANSIColor.CYAN + "GodLights" + ANSIColor.RESET + "(이)가 만들었습니다.";
                case "cmdExit.text":
                    return "커맨드를 종료합니다/Code006";
                case "cmdStop.text":
                    return "종료합니다/Code007";
            }
        } else if (lang.equals("en")) {
            switch (code) {
                case "welcome.message":
                    return "Hello " + userName + "!";
                case "bye.message":
                    return "Bye! " + userName + ".";
                case "os.message":
                    return "Your OS is " + os + ".";
                case "rainbow.text":
                    return ANSIColor.RED + "W" + ANSIColor.YELLOW + "H" + ANSIColor.GREEN + "E" + ANSIColor.CYAN + "E" + ANSIColor.BLUE + "E" + ANSIColor.PURPLE + "E" + ANSIColor.RESET + "!";
                case "madeBy.text":
                    return "Made By " + ANSIColor.CYAN + "GodLights.";
                case "cmdExit.text":
                    return "End the Console./Code006";
                case "cmdStop.text":
                    return "Exit./Code007";
            }
        }
        return ""; // default case if no match found
    }
}
