package TestClasses;

import progetto.utils.FormattedLogs;

public class TestOperatoreT extends GenericTest{
    public final static int TEST_IF_STATEMENT = 1;
    public final static int TEST_TO_DO = 2;
    public final static int TEST_TO_DO_2 = 3;

    private static final String test1 =
            """
            int x;
            int y;
            int z;
            int[] arr;
            bool v;
            int[] a;
            int[] b;
            a = [1,2,3];
            b = [3,7];
            v = true;
            y = 5;
            x = v ? 3 : 1;
            z = (false or (x < 10 and y > 0)) ? a[0] + 5 : b[1] - 3;
            arr = (z == 4) ? a : b;
            print x;
            print y;
            print z;
            print arr
            """;

    private static final String test2 =
            """
            int x;
            int y;
            bool a;
            bool b;
            x = 10;
            y = 20;
            a = true;
            b = false;
            print (a and b) ? x : y;
            print (a or b) ? x + 5 : y + 5
            """;

    private static final String test3 =
            """
            int x;
            int y;
            int z;
            int[] a;
            int[] b;
            int[] result;
            bool condition;

            a = [1,2,3];
            b = [10,20,30];

            x = 5;
            y = 10;

            condition = x < y;

            z = condition
                    ? ((x + y > 10) ? 100 : 200)
                    : ((x - y < 0) ? 300 : 400);

            result = (z > 150)
                    ? a
                    : b;

            print x;
            print y;
            print z;
            print result
            """;

    @Override
    public void printTests() {
        super.printTests();
        FormattedLogs.println(FormattedLogs.BRIGHT_GREEN, "1 - test operatore ternario semplice");
        FormattedLogs.println(FormattedLogs.BRIGHT_GREEN, "2 - test operatore ternario true / fals");
        FormattedLogs.println(FormattedLogs.BRIGHT_GREEN, "3 - test operatore ternario completo");
    }

    @Override
    public String getTests(int i){
        return switch (i){
            case TEST_IF_STATEMENT -> test1;
            case TEST_TO_DO-> test2;
            case TEST_TO_DO_2-> test3;
            default -> null;
        };
    }
}
