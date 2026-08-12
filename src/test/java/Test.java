import TestMenu.TestMenu;
import TestMenu.TestMenuEntry;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import progetto.Interprete;
import progetto.LinguaggioLexer;
import progetto.LinguaggioParser;
import progetto.TypedImpTS;
import TestClasses.*;
import progetto.exception.InterpreterExitException;
import progetto.utils.FormattedLogs;

import java.util.Scanner;

public class Test {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String TEST_SEPARATOR = "------------------------------------------";

    public static void main(String[] args) {

        FormattedLogs.println(FormattedLogs.CYAN,"\nBenvenuto \nAttraverso l'utilizzo del menu riportato potrà interagire col nostro programma , \ncol primo menu principale potrà scegliere" +
                " quale tipologia di test osservare e provare , \nin seguito verrà mostrato un sotto menu nel quale le verranno proposti diversi test \ninerenti al tipo scelto precedentemente " +
                ", sarà possibile visionare il codice del test prima \ndel suo risultato , sarà inoltre possibile ripetere più test , grazie e buon proseguimento ;) .");
        // creo il menu'
        TestMenu menu = new TestMenu();

        while(testTopicSelection(menu));
    }

    private static boolean testTopicSelection(TestMenu menu){
        menu.printMenu();
        FormattedLogs.print(FormattedLogs.YELLOW,"► Scelta: ");

        int categoria = getConsoleChoice();

        //uscita terminale
        if (categoria == 0) {
            return false;
        }
        // casting fallito (non e' stato inserito un numero)
        if (categoria == -1) {
            FormattedLogs.println(FormattedLogs.RED,"Si prega di inserire un numero e non una stringa");
            return true;
        }

        TestMenuEntry testMenuEntry = menu.getTestMenuEntry(categoria);
        // il numero inserito non e' nell'elenco
        if (testMenuEntry == null) {
            FormattedLogs.println(FormattedLogs.RED,"Scelta non valida.");
        }
        //continuo a eseguire test sulla tipologia scelta
        else while(testSelection(testMenuEntry.getTestObj()));
        return true;
    }

    private static boolean testSelection(GenericTest classObj){
        classObj.printTests();
        FormattedLogs.print(FormattedLogs.YELLOW,"► Selezionare il test: ");

        int numeroTest = getConsoleChoice();

        //torno alla selezione delle tipologie
        if (numeroTest == 0) {
            return false;
        }
        // casting fallito (non e' stato inserito un numero)
        if (numeroTest == -1) {
            FormattedLogs.println(FormattedLogs.RED,"Si prega di inserire un numero e non una stringa");
            return true;
        }
        String test = classObj.getTests(numeroTest);
        // il numero inserito non e' nell'elenco
        if (test == null)
            FormattedLogs.println(FormattedLogs.RED,"Test non trovato.");
        //eseguo il test scelto
        else {
            mostraTest(classObj,test);
            runTest(test);
        }

        return true;
    }

    private static void mostraTest(GenericTest classObj, String test){
        //if(!(classObj instanceof TestAutoCode)){
            FormattedLogs.println(FormattedLogs.CYAN, "\nTest da eseguire: " );
            FormattedLogs.println(FormattedLogs.GREEN,test);
       // }
        FormattedLogs.println(FormattedLogs.GREEN,TEST_SEPARATOR);
        FormattedLogs.println(FormattedLogs.CYAN, "Output del programma ");
    }

    private static void runTest(String test){

        CharStream cs = CharStreams.fromString(test);
        LinguaggioLexer lexer = new LinguaggioLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LinguaggioParser parser = new LinguaggioParser(tokens);
        ParseTree tree = parser.main();
        TypedImpTS typeSystem = new TypedImpTS();
        try {
            typeSystem.visit(tree);
            Interprete interpreter = new Interprete();
            interpreter.visit(tree);
        }catch (InterpreterExitException e){}
        catch (RuntimeException re) {
            FormattedLogs.println(FormattedLogs.RED,"Typing error(s) found.");
            FormattedLogs.println(FormattedLogs.RED,re.getMessage());
            //re.printStackTrace();
        }
        System.out.println(TEST_SEPARATOR);
    }

    private static int getConsoleChoice() {
        String input = scanner.nextLine().strip();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
