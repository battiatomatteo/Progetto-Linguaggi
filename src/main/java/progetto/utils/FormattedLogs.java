package progetto.utils;

public class FormattedLogs {
    public static final String RESET  = "\u001B[0m";
    public static final String RED    = "\u001B[31m";
    public static final String GREEN  = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN   = "\u001B[36m";
    public static final String BRIGHT_RED   = "\u001B[91m";
    public static final String BRIGHT_GREEN = "\u001B[92m";

    public static void println(String color, String message){
        System.out.println(color + message  + RESET);
    }
    public static void print(String color, String message){
        System.out.print(color + message  + RESET);
    }
    public static String colorString(String color, String message){
        return color + message + RESET;
    }

    public static void printFramed(String frame,String message, String frameColor,String messageColor){
        System.out.println(
                colorString(frameColor, frame) +
                colorString(messageColor,message) +
                colorString(frameColor, reverse(frame))
        );
    }
    private static String reverse (String txt){
        return new StringBuilder(txt).reverse().toString();
    }
}
