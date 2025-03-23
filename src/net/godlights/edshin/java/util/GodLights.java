package net.godlights.edshin.java.util;

import org.w3c.dom.Comment;

import java.lang.annotation.Annotation;

public class GodLights {
    private static boolean linkMode = false;

    public int memo = 0;

    public GodLights(String memo) {
        if(memo.equals("linkMode")) {
            linkMode = !linkMode;
        } else {
            this.memo = memo.hashCode();
        }
    }

    public static GodLights TODO(String memo) {
        return new GodLights(memo);
    }


    @Override
    public String toString() {
        if(linkMode) {
            return "https://god-lights.github.io";
        } else {
            return "GodLights";
        }
    }
}
