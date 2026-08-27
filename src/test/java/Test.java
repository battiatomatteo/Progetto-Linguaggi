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
import progetto.utils.OutputColor;

import java.util.Scanner;

public class Test {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String TEST_SEPARATOR = "------------------------------------------";

    public static void main(String[] args) {

        FormattedLogs.println(OutputColor.CYAN, "\nBenvenuto " +
                "\nAttraverso l'utilizzo del menu riportato potrà interagire col nostro programma , " +
                "\ncol primo menu principale potrà scegliere quale tipologia di test osservare e provare , " +
                "\nin seguito verrà mostrato un sotto menu nel quale le verranno proposti diversi test " +
                "\ninerenti al tipo scelto precedentemente , sarà possibile visionare il codice del test prima " +
                "\ndel suo risultato , sarà inoltre possibile ripetere più test , grazie e buon proseguimento ;) .");
        // creo il menu'
        TestMenu menu = new TestMenu();

        while(testTopicSelection(menu));
    }

    private static boolean testTopicSelection(TestMenu menu){
        menu.printMenu();
        FormattedLogs.print(OutputColor.YELLOW,"► Scelta: ");

        int categoria = getConsoleChoice();

        //uscita terminale
        if (categoria == 0) {
            return false;
        }
        // casting fallito (non e' stato inserito un numero)
        if (categoria == -1) {
            FormattedLogs.println(OutputColor.RED,"Si prega di inserire un numero e non una stringa");
            return true;
        }

        TestMenuEntry testMenuEntry = menu.getTestMenuEntry(categoria);
        // il numero inserito non e' nell'elenco
        if (testMenuEntry == null) {
            FormattedLogs.println(OutputColor.RED,"Scelta non valida.");
        }
        //continuo a eseguire test sulla tipologia scelta
        else while(testSelection(testMenuEntry.getTestObj()));
        return true;
    }

    private static boolean testSelection(GenericEntry classObj){
        classObj.printTests();
        FormattedLogs.print(OutputColor.YELLOW,"► Selezionare il test: ");

        int numeroTest = getConsoleChoice();

        //torno alla selezione delle tipologie
        if (numeroTest == 0) {
            return false;
        }
        // casting fallito (non e' stato inserito un numero)
        if (numeroTest == -1) {
            FormattedLogs.println(OutputColor.RED,"Si prega di inserire un numero e non una stringa");
            return true;
        }
        String test = classObj.getTests(numeroTest);
        // il numero inserito non e' nell'elenco
        if (test == null)
            FormattedLogs.println(OutputColor.RED,"Test non trovato.");
            //eseguo il test scelto
        else {
            if(classObj.isShowTest()){
                FormattedLogs.println(OutputColor.CYAN, "\nTest da eseguire: " );
                FormattedLogs.println(OutputColor.GREEN,test);
            }
            if(classObj.isRunTest()){
                FormattedLogs.println(OutputColor.GREEN,TEST_SEPARATOR);
                FormattedLogs.println(OutputColor.CYAN, "Output del programma ");
                runTest(test);
            }

        }
        return true;
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
        }catch (InterpreterExitException _){}
        catch (RuntimeException re) {
            FormattedLogs.println(OutputColor.RED,"Typing error(s) found.");
            FormattedLogs.println(OutputColor.RED,re.getMessage());
            //re.printStackTrace();
        }
        FormattedLogs.println(OutputColor.GREEN,TEST_SEPARATOR);
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
