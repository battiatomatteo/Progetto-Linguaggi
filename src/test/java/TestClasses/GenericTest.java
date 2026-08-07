package TestClasses;

import progetto.utils.FormattedLogs;

public abstract class GenericTest {

    public void printTests(){
        System.out.println();
        FormattedLogs.println(FormattedLogs.CYAN,"Test disponibili per la tipologia");
        FormattedLogs.println(FormattedLogs.RED,"0 - Chiudi");
    }
    public abstract String getTests(int i);
}
