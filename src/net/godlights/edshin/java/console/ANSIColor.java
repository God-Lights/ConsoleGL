package net.godlights.edshin.java.console;

public enum ANSIColor {
    BLACK(30),
    RED(31),
    GREEN(32),
    YELLOW(33),
    BLUE(34),
    PURPLE(35),
    CYAN(36),
    WHITE(37),
    RESET(0);



    private String code = null;
    private ANSIColor(int num) {
        this.code = "\u001B["+num+"m";
    }

    @Override
    public String toString() {
        return code;
    }
}
