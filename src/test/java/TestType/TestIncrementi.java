package TestType;

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
            print toStr(x);
            print toStr(y);
            y = ++x + 9;
            print toStr(x);
            print toStr(y);
            y = x-- + 7;
            print toStr(x);
            print toStr(y);
            y = --x + 3;
            print toStr(x);
            print toStr(y);
            print "corretto"
            """;



    private static final String test2 =
            """
           int x;
           int y;
           x=5;
           x++;
           print toStr(x);
           ++x;
           print toStr(x);
           x--;
           print toStr(x);
           --x;
           print toStr(x);
           print "corretto";
           """;

    private static final String test3 =
           """
           int a;
           int b;
           b = 2;
           a = b++;
           print toStr(a);
           print toStr(b)
           """;
    @Override
    public void printTests() {
        System.out.println("inserire test");
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
