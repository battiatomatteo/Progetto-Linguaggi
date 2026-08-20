package TestClasses;

import progetto.utils.FormattedLogs;

public class TestNonDeterminismo extends GenericTest{
    public static final int TEST_NON_DETERMINISMO = 1;
    public static final int TEST_NON_DETERMINISMO_DUE = 2;
    public static final int TEST_NON_DETERMINISMO_TRE = 3;

    public static final String test1 =
            """
            int x;
            int y;
            << x = 5 @ x = 4 @ x = 3 >>;
            << y = 3 @ y = 2 @ y = 1 >>;
            print (string) x;
            print y
            """;

    public static final String test2 =
            """
            int x;
            int y;
            int z;

            << x = 1 @ x = 2 @ x = 3 >>;
            << y = 10 @ y = 20 @ y = 30 >>;

            << z = x + y @ z = x * y @ z = y - x >>;

            print x;
            print y;
            print z
            """;

    public static final String test3 =
            """
            int x;
            int y;
            int z;
            int[] a;
            int[] b;
            int[] result;

            a = [1,2,3];
            b = [10,20,30];

            x = 5;
            y = 10;

            << x = x + 1 @ x = x * 2 @ x = y - x >>;

            << z = x + y
             @ z = x * y
             @ z = y - x >>;

            << result = a @ result = b >>;

            print x;
            print y;
            print z;
            print result
            """;


    @Override
    public void printTests() {
        super.printTests();
        FormattedLogs.println(FormattedLogs.BRIGHT_GREEN, "1 - test operatore non deterministico semplice");
        FormattedLogs.println(FormattedLogs.BRIGHT_GREEN, "2 - test operatore non deterministico a più operatori");
        FormattedLogs.println(FormattedLogs.BRIGHT_GREEN, "3 - test operatore non deterministico complesso");
    }

    @Override
    public String getTests(int i){
        return switch (i){
            case TEST_NON_DETERMINISMO -> test1;
            case TEST_NON_DETERMINISMO_DUE -> test2;
            case TEST_NON_DETERMINISMO_TRE -> test3;
            default -> null;
        };
    }
}
