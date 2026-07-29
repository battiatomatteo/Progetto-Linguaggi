package TestClasses;

import progetto.Interprete;

import java.util.Scanner;

public class TestAutoCode extends GenericTest{

    public static final int TEST_INPUT = 1;
    public static final String BRIGHT_GREEN   = "\u001B[92m";
    public static final String RESET  = "\u001B[0m";

    private String testAutoCode(){
        Scanner sc = new Scanner(System.in);
        StringBuilder codice = new StringBuilder();

        System.out.println("Inserisci il codice da eseguire (scrivi END per terminare):");

        while (true) {
            String riga = sc.nextLine();
            if (riga.equals("END")) break;
            codice.append(riga).append("\n");
        }

        return  codice.toString();
    }

    @Override
    public void printTests() {
        super.printTests();
        System.out.println(BRIGHT_GREEN + "1 - test input codice personale " + RESET);
    }

    @Override
    public  String getTests(int i){
        return switch (i){
            case TEST_INPUT -> testAutoCode();
            default -> null;
        };
    }
}
