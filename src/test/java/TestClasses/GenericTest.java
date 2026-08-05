package TestClasses;

public abstract class GenericTest {

    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";

    public void printTests(){
        System.out.println();
        System.out.println(CYAN + "Test disponibili per la tipologia" + RESET);
        System.out.println(RED + "0 - Chiudi" + RESET);
    }
    public abstract String getTests(int i);
}
