package TestClasses;

public class TestOperatoreT extends GenericTest{
    public final static int TEST_IF_STATEMENT = 1;
    public final static int TEST_TO_DO = 2;
    public final static int TEST_TO_DO_2 = 3;
    public static final String BRIGHT_GREEN   = "\u001B[92m";
    public static final String RESET  = "\u001B[0m";

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
            """;

    private static final String test3 =
            """
            """;

    @Override
    public void printTests() {
        super.printTests();
        System.out.println(BRIGHT_GREEN + "1 - test operatore ternario " + RESET);
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
