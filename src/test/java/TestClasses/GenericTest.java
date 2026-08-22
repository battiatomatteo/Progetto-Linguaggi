package TestClasses;

import progetto.utils.FormattedLogs;
import progetto.utils.OutputColor;

public abstract class GenericTest {

    public void printTests(){
        System.out.println();
        FormattedLogs.println(OutputColor.CYAN,"Test disponibili per la tipologia");
        FormattedLogs.println(OutputColor.RED,"0 - Chiudi");
    }
    public abstract String getTests(int i);
}
