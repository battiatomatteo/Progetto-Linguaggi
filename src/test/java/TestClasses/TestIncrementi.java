package TestClasses;

import progetto.utils.FormattedLogs;
import progetto.utils.OutputColor;

public class TestIncrementi extends GenericTest{
    public final static int TEST_INCREMENT_IN_ASSIGNMENT = 1;
    public final static int TEST_INCREMENT_COMMAND = 2;
    public final static int TEST_INCREMENT_SIMPLE = 3;


    private static final String test1 =
            """
            int x;
            int y;
            x=10;
            y = x++ + 5;
            print x;
            print y;
            y = ++x + 9;
            print x;
            print y;
            y = x-- + 7;
            print x;
            print y;
            y = --x + 3;
            print x;
            print y;
            print "corretto"
            """;



    private static final String test2 =
            """
           int x;
           int y;
           x=5;
           x++;
           print x;
           ++x;
           print x;
           x--;
           print x;
           --x;
           print x;
           print "corretto"
           """;

    private static final String test3 =
           """
           int a;
           int b;
           b = 2;
           a = b++;
           print a;
           print b
           """;
    @Override
    public void printTests() {
        super.printTests();
        FormattedLogs.println(OutputColor.BRIGHT_GREEN, "1 - test incremento e decrementi nelle espressioni");
        FormattedLogs.println(OutputColor.BRIGHT_GREEN, "2 - test incremento e decrementi come comandi");
        FormattedLogs.println(OutputColor.BRIGHT_GREEN, "3 - test incremento e assegnazione semplice");
    }

    @Override
    public  String getTests(int i){
        return switch (i){
            case TEST_INCREMENT_IN_ASSIGNMENT -> test1;
            case TEST_INCREMENT_COMMAND -> test2;
            case TEST_INCREMENT_SIMPLE -> test3;
            default -> null;
        };
    }
}
