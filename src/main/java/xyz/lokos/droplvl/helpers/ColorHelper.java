package xyz.lokos.droplvl.helpers;

public class ColorHelper {

    private static final char COLOR_CHAR = '\u00A7';

    public static String colored(String text) {
        return String.format("%s", text).replace('&', COLOR_CHAR);
    }
}
