package TestType;

public class TestNonDeterminismo extends GenericTest{
    public static final int TEST_NON_DETERMINISMO = 1;
    public static final int TEST_NON_DETERMINISMO_DUE = 2;

    public static final String test1 =
            """
            int x;
            int y;
            << x = 5 @ x = 4 @ x = 3 >>;
            << y = 3 @ y = 2 @ y = 1 >>;
            print (string) x;
            print toStr(y)
            """;

    public static final String test2 =
            """
            int x;
            int y;
            << x = 5 @ x = 4 @ x = 3 >>;
            << y = 3 @ y = 2 @ y = 1 >>;
            print (string) x;
            print toStr(y)
            """;


    @Override
    public void printTests() {
        System.out.println("inserire test");
    }

    @Override
    public String getTests(int i){
        return switch (i){
            case TEST_NON_DETERMINISMO -> test1;
            case TEST_NON_DETERMINISMO_DUE -> test2;
            default -> null;
        };
    }
}
