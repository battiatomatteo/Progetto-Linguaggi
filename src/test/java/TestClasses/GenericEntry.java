package TestClasses;

import progetto.utils.FormattedLogs;
import progetto.utils.OutputColor;

public abstract class GenericEntry {
    private final boolean showTest;
    private final boolean runTest;

    protected GenericEntry() {
        this.showTest = true;
        this.runTest = true;
    }
    protected GenericEntry(boolean showTest, boolean runTest) {
        this.showTest = showTest;
        this.runTest = runTest;
    }

    public boolean isShowTest() {
        return showTest;
    }

    public boolean isRunTest() {
        return runTest;
    }

    public void printTests(){
        System.out.println();
        FormattedLogs.println(OutputColor.CYAN,"Test disponibili per la tipologia");
        FormattedLogs.println(OutputColor.RED,"0 - Chiudi");
    }
    public abstract String getTests(int i);
}
