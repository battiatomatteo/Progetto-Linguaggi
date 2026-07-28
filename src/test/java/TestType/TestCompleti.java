package TestType;

public class TestCompleti extends GenericTest{
    public static final int TEST_1= 1;
    public static final int TEST_2= 2;
    public static final int TEST_3= 3;
    public static final int TEST_4= 4;
    public static final int TEST_5= 5;


    public static final String test1 =
            """
            int x;
            int y;
            """;
    public static final String test2 =
            """
            int x;
            int y;
            """;
    public static final String test3 =
            """
            int x;
            int y;
            """;
    public static final String test4 =
            """
            int x;
            int y;
            """;
    public static final String test5 =
            """
            int x;
            int y;
            """;
    @Override
    public void printTests() {
        System.out.println("inserire test");
    }

    @Override
    public  String getTests(int i){
        return switch (i){
            case TEST_1 -> test1;
            case TEST_2 -> test2;
            case TEST_3 -> test3;
            case TEST_4 -> test4;
            case TEST_5 -> test5;
            default -> null;
        };
    }
}
