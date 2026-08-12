package TestClasses;

import progetto.utils.FormattedLogs;

import java.util.ArrayList;
import java.util.Scanner;

public class TestAutoCode extends GenericTest{

    public static final int TEST_INPUT = 1;
    public final String REMOVE_COM = "REMOVE ";
    public final String NEW_LINE_COM = " -> ";

    private String testAutoCode(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> codiceIntero = new ArrayList<>();
        StringBuilder codice = new StringBuilder();

        System.out.println("Inserisci il codice da eseguire (scrivi END per terminare):");

        while (true) {
            String riga = sc.nextLine().trim();
            // REMOVE NUM -> .....codice.....
            if (riga.equals("END")) break;
            if (riga.startsWith(REMOVE_COM)){
                FormattedLogs.println(FormattedLogs.PURPLE, "riga scritta <<" + riga +">>");
                String numeroRiga = riga.substring(REMOVE_COM.length(),riga.indexOf(NEW_LINE_COM));
                FormattedLogs.println(FormattedLogs.PURPLE, "numero riga <<" + numeroRiga +">>");
                try{
                    int indice = Integer.parseInt(numeroRiga);
                    String nuovaRiga = riga.substring(riga.indexOf(NEW_LINE_COM) + NEW_LINE_COM.length());
                    FormattedLogs.println(FormattedLogs.PURPLE, "da sostituire <<" + nuovaRiga +">>");
                    codiceIntero.remove(indice );
                    codiceIntero.add(indice - 1,nuovaRiga);
                    continue;
                }
                catch (Exception e){
                    FormattedLogs.println(FormattedLogs.RED,"Comando REMOVE usato incorrettamente" );
                }
            }
            codiceIntero.add(riga);
        }
        //FormattedLogs.println(FormattedLogs.PURPLE, "codice intero <<" + codiceIntero +">>");
        //Arrays.toString(codiceIntero.toArray());
        for (int i = 0; i < codiceIntero.toArray().length ; i++) {
            codice.append(codiceIntero.get(i)).append("\n");
        }


        return  codice.toString();
    }

    @Override
    public void printTests() {
        super.printTests();
        FormattedLogs.println(FormattedLogs.BRIGHT_GREEN, "1 - test input codice personale ");
    }

    @Override
    public  String getTests(int i){
        return switch (i){
            case TEST_INPUT -> testAutoCode();
            default -> null;
        };
    }
}
