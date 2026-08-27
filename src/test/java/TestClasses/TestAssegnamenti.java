package TestClasses;

import progetto.utils.FormattedLogs;
import progetto.utils.OutputColor;

public class TestAssegnamenti extends GenericEntry{
    public final static int TEST_FAST_ASSIGN = 1;

    private static final String test1 =
            """
            int x;
            int y;
            x = 20;
            y = 2;
            print x;
            print y;
            x+= y + 1;
            print x;
            x-= y + 1;
            print x;
            x*= y + 1;
            print x;
            x/= y + 1;
            print x
            """;

    @Override
    public void printTests() {
        super.printTests();
        FormattedLogs.println(OutputColor.BRIGHT_GREEN, "1 - Assegnamenti composti");
    }

    @Override
    public  String getTests(int i){
        return switch (i){
            case TEST_FAST_ASSIGN -> test1;
            default -> null;
        };
    }
}
