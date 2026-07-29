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
import java.util.Scanner;

public class Test {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String TEST_SEPARATOR = "\n------------------------------------------\n";

    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String BRIGHT_RED = "\u001B[91m";

    public static void main(String[] args) {

        System.out.println(CYAN + "\nBenvenuto \nAttraverso l'utilizzo del menu riportato potrà interagire col nostro programma , \ncol primo menu principale potrà scegliere" +
                " quale tipologia di test osservare e provare , \nin seguito verrà mostrato un sottomenu nel quale le verranno proposti diversi test \ninerenti al tipo scelto precedentemente " +
                ", sarà possibile visionare il codice del test prima \ndel suo risultato , sarà inoltre possibile ripetere più test , grazie e buon proseguimento ;) ." + RESET);
        // creo il menu'
        TestMenu menu = new TestMenu();

        while(testTopicSelection(menu));
    }

    private static boolean testTopicSelection(TestMenu menu){
        menu.printMenu();
        System.out.print(YELLOW + "► Scelta: " + RESET);

        int categoria = getConsoleChoice();

        //uscita terminale
        if (categoria == 0) {
            return false;
        }
        // casting fallito (non e' stato inserito un numero)
        if (categoria == -1) {
            System.out.println(RED + "Si prega di inserire un numero e non una stringa" + RESET);
            return true;
        }

        TestMenuEntry testMenuEntry = menu.getTestMenuEntry(categoria);
        // il numero inserito non e' nell'elenco
        if (testMenuEntry == null) {
            System.out.println(RED + "Scelta non valida." + RESET);
        }
        //continuo a eseguire test sulla tipologia scelta
        else while(testSelection(testMenuEntry.getTestObj()));
        return true;
    }

    private static boolean testSelection(GenericTest classObj){
        classObj.printTests();
        System.out.print(CYAN + "► Selezionare il test: " + RESET);

        int numeroTest = getConsoleChoice();

        //torno alla selezione delle tipologie
        if (numeroTest == 0) {
            return false;
        }
        // casting fallito (non e' stato inserito un numero)
        if (numeroTest == -1) {
            System.out.println(RED + "Si prega di inserire un numero e non una stringa" + RESET);
            return true;
        }
        String test = classObj.getTests(numeroTest);
        // il numero inserito non e' nell'elenco
        if (test == null)
            System.out.println(RED + "Test non trovato." + RESET);
        //eseguo il test scelto
        else runTest(test);

        return true;
    }

    private static void runTest(String test){
        System.out.println(GREEN + TEST_SEPARATOR + "Test da eseguire: " + test  + RESET );
        System.out.println(GREEN + TEST_SEPARATOR + "output del programma " + RESET);
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
        } catch (RuntimeException re) {
            System.out.println(RED + "Typing error(s) found." + RESET);
            System.out.println(re.getMessage());
            re.printStackTrace();
        }
        System.out.println(TEST_SEPARATOR);
    }

    private static int getConsoleChoice() {
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
