package TestMenu;

import TestClasses.*;

import java.util.HashMap;
import java.util.Map;

public class TestMenu {
    private final Map<Integer, TestMenuEntry> menu;
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";

    public TestMenu() {
        menu = new HashMap<Integer, TestMenuEntry>();
        setUpMenu();
    }
    public void printMenu(){
        System.out.println(CYAN + "\nScegliere il numero corrispondente alla tipologia di test da eseguire: " + RESET);

        System.out.println(GREEN + "╔════════════════════════════════════════════════╗" + RESET);
        System.out.println(GREEN + "║                 MENU PRINCIPALE                ║" + RESET);
        System.out.println(GREEN + "╠════════════════════════════════════════════════╣" + RESET);
        System.out.println(GREEN + "║ " + RED +  "0 - Chiudi programma di test" + RESET + GREEN + "                   ║" + RESET);
        for (Map.Entry<Integer, TestMenuEntry> entry : menu.entrySet()) {
            System.out.println(GREEN + "║ " + entry.getKey() + " - " + entry.getValue().getDisplayName() + "    ║" + RESET);
        }
        System.out.println(GREEN + "╚════════════════════════════════════════════════╝" + RESET);
    }

    public TestMenuEntry getTestMenuEntry(int id){
        return menu.get(id);
    }

    private void setUpMenu() {
        addEntry( 1,new TestCast(),"Casting semplici                       ");
        addEntry( 2,new TestCastArray(),"Casting su array                       ");
        addEntry( 3,new TestAssegnamenti(),"Assegnamenti alle variabili            ");
        addEntry( 4,new TestArray(),"Assegnamenti e manipolazione array     ");
        addEntry( 5,new TestIncrementi(),"Operatori di incremento                ");
        addEntry( 6,new TestInput(),"input da tastiera                      ");
        addEntry( 7,new TestControlloCondizionato(),"costrutti for-else e switch            ");
        addEntry( 8,new TestNonDeterminismo(),"Operatore non deterministico           ");
        addEntry( 9,new TestOperatoreT(),"Operatore ternario                     ");
        addEntry(10,new TestCompleti(),"Test strutturati su piu' funzionalita'");
        addEntry(11,new TestAutoCode(),"Test di Auto code                     ");
    }

    private void addEntry( int index, GenericTest classObj, String displayName){
        menu.put(index,new TestMenuEntry(classObj,displayName));
    }
}
