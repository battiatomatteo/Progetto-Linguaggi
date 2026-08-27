package TestMenu;

import TestClasses.*;
import progetto.utils.FormattedLogs;
import progetto.utils.OutputColor;

import java.util.HashMap;
import java.util.Map;

public class TestMenu {
    private final Map<Integer, TestMenuEntry> menu;

    public TestMenu() {
        menu = new HashMap<Integer, TestMenuEntry>();
        setUpMenu();
    }
    // mettete in giallo tutti i warning dei codici
    /* Test da mettere apposto:
    - operatore ternario
    - test 10
     */
    public void printMenu(){
        FormattedLogs.println(OutputColor.GREEN,"\nScegliere il numero corrispondente alla tipologia di test da eseguire: ");
        FormattedLogs.println(OutputColor.GREEN,"╔════════════════════════════════════════════════╗");
        FormattedLogs.println(OutputColor.GREEN,"║                 MENU PRINCIPALE                ║");
        FormattedLogs.println(OutputColor.GREEN,"╠════════════════════════════════════════════════╣");
        FormattedLogs.printFramed("║  ",padRightString(  "0 - Chiudi programma di test",44), OutputColor.GREEN,OutputColor.RED);
        for (Map.Entry<Integer, TestMenuEntry> entry : menu.entrySet()) {
            FormattedLogs.println(OutputColor.GREEN,"║ " + String.format("%2d", entry.getKey()) + " - " + entry.getValue().getDisplayName() + "    ║");
        }
        FormattedLogs.println(OutputColor.GREEN,"╚════════════════════════════════════════════════╝");
    }

    public TestMenuEntry getTestMenuEntry(int id){
        return menu.get(id);
    }

    private void setUpMenu() {
        addEntry( 1,new TestCast(),"Casting semplici");
        addEntry( 2,new TestCastArray(),"Casting su array");
        addEntry( 3,new TestAssegnamenti(),"Assegnamenti alle variabili");
        addEntry( 4,new TestArray(),"Assegnamenti e manipolazione array");
        addEntry( 5,new TestIncrementi(),"Operatori di incremento");
        addEntry( 6,new TestInput(),"input da tastiera");
        addEntry( 7,new TestControlloCondizionato(),"costrutti for-else e switch");
        addEntry( 8,new TestNonDeterminismo(),"Operatore non deterministico");
        addEntry( 9,new TestOperatoreT(),"Operatore ternario");
        addEntry(10,new TestCompleti(),"Test strutturati su piu' funzionalita'");
        addEntry(11,new TestAutoCode(),"Test di Auto code");
        addEntry(12,new ImpostazioniMenu(), "Impostazioni menu");
    }

    private void addEntry( int index, GenericEntry classObj, String displayName){
        menu.put(index,new TestMenuEntry(classObj,padRightString(displayName,38)));
    }

    private String padRightString(String string, int length){
        return String.format("%1$-" + length + "s", string);
    }
}
