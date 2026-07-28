package TestClasses;

public class TestAssegnamenti extends GenericTest{
    public final static int TEST_FAST_ASSIGN = 1;
    public final static int TEST_TO_DO = 2;
    public final static int TEST_TO_DO_2 = 3;
    public static final String BRIGHT_GREEN   = "\u001B[92m";
    public static final String RESET  = "\u001B[0m";

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

    private static final String test2 =
            """
            """;

    private static final String test3 =
            """
            """;

    @Override
    public void printTests() {
        super.printTests();
        System.out.println(BRIGHT_GREEN +  "1 - Assegnamenti composti" + RESET);
    }

    @Override
    public  String getTests(int i){
        return switch (i){
            case TEST_FAST_ASSIGN -> test1;
            case TEST_TO_DO -> test2;
            case TEST_TO_DO_2 -> test3;
            default -> null;
        };
    }
}
