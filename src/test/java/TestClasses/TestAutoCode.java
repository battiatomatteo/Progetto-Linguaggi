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

        FormattedLogs.println(FormattedLogs.YELLOW,"\n" +
                        "Inserisci il codice da eseguire :\n" +
                        "- La sintassi del codice deve essere la stessa degli altri test \n" +
                        "- Scrivi END per terminare \n" +
                        "- Per eliminare una riga usare (può essere fatto in ogni punto del codice) \n" +
                        "  REMOVE Numero di riga -> riga di codice da sostituire \n");

        while (true) {
            String riga = sc.nextLine().trim();
            // REMOVE NUM -> .....codice.....
            if (riga.equals("END")) break;
            if (riga.startsWith(REMOVE_COM)){
                int inizioComando = riga.indexOf(NEW_LINE_COM);
                if(inizioComando == -1){
                    FormattedLogs.println(FormattedLogs.RED,"Manca la riga da sostituire" );
                    continue;
                }
                try{
                    //FormattedLogs.println(FormattedLogs.PURPLE, "riga scritta <<" + riga +">>");
                    String numeroRiga = riga.substring(REMOVE_COM.length(),inizioComando);
                    //FormattedLogs.println(FormattedLogs.PURPLE, "numero riga <<" + numeroRiga +">>");
                    int indice = Integer.parseInt(numeroRiga);
                    if(indice < 1 || indice > codiceIntero.size()){
                        FormattedLogs.println(FormattedLogs.RED,"Il numero di riga deve essere un numero valido");
                        continue;
                    }
                    String nuovaRiga = riga.substring(inizioComando + NEW_LINE_COM.length());
                    //FormattedLogs.println(FormattedLogs.PURPLE, "da sostituire <<" + nuovaRiga +">>");
                    codiceIntero.set(indice - 1,nuovaRiga);
                    continue;
                }
                catch (Exception e){
                    FormattedLogs.println(FormattedLogs.RED,"Comando REMOVE usato incorrettamente" +
                            "il formato e' REMOVE Numero di riga -> riga di codice da sostituire" );
                }
            }
            codiceIntero.add(riga);
        }
        for (String riga : codiceIntero) {
            codice.append(riga).append("\n");
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
