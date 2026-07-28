package TestType;

public class TestInput extends GenericTest{
    public static final int TEST_INPUT = 1;
    public static final int TEST_INPUT_ARRAY = 2;
    public static final int TEST_INPUT_ERROR = 3;
    
    public static final String test1 = 
            """
            string a;
            input a;
            print a
            """;

    public static final String test2 =
            """
            string a;
            int[] c = [0,0,0,0,0,0,0,0,0,0,0,0,0];
            int i;
            for i from 0 to 9 {
                print "inserire un numero :";
                input a;
                c[i] = (int) a
            };
            print c
            """;

    public static final String test3 =
            """
            string a;
            input a;
            print a
            """;
    @Override
    public void printTests() {
        System.out.println("inserire test");
    }

    @Override
    public  String getTests(int i){
        return switch (i){
            case TEST_INPUT -> test1;
            case TEST_INPUT_ARRAY -> test2;
            case TEST_INPUT_ERROR -> test3;
            default -> null;
        };
    }
}
