package TestType;

public class TestCastArray extends GenericTest{
    public final static int TEST_CAST_TO_INTEGER = 1;
    public final static int TEST_CAST_TO_DECIMAL = 2;
    public final static int TEST_CAST_TO_BOOLEAN = 3;
    public final static int TEST_CAST_TO_STRING  = 4;
    public final static int TEST_CAST_ERRORS  = 5;


    private static final String test1 =
            """
            int[] a;
            dec[] b;
            bool[] c;
            string[] d;
            print "test1";
            a = [1,2];
            b = [5.0,3.5];
            c = [false,true];
            d = ["12","3"];
            a = (int[]) a;
            print toStr(a);
            a = (int[]) b;
            print toStr(a);
            a = (int[]) c;
            print toStr(a);
            a = (int[]) d;
            print toStr(a)
            """;

    private static final String test2 =
            """
            int[] a;
            dec[] b;
            bool[] c;
            string[] d;
            print "test2";
            a = [1,2];
            b = [5.0,3.5];
            c = [false,true];
            d = ["12","3"];
            b = (dec[]) b;
            print toStr(b);
            b = (dec[]) a;
            print toStr(b);
            b = (dec[]) c;
            print toStr(b);
            b = (dec[]) d;
            print toStr(b)
            """;

    private static final String test3 =
            """
            int[] a;
            dec[] b;
            bool[] c;
            string[] d;
            print "test3";
            a = [1,0];
            b = [0.1,1.1];
            c = [false,true];
            d = ["true","false"];
            c = (bool[]) c;
            print toStr(c);
            c = (bool[]) a;
            print toStr(c);
            c = (bool[]) b;
            print toStr(c);
            c = (bool[]) d;
            print toStr(c)
            """;
    private static final String test4 =
            """
            int[] a;
            dec[] b;
            bool[] c;
            string[] d;
            print "test4";
            a = [1,2];
            b = [5.0,3.5];
            c = [false,true];
            d = ["12","3"];
            d = (string[]) d;
            print toStr(d);
            d = (string[]) a;
            print toStr(d);
            d = (string[]) b;
            print toStr(d);
            d = (string[]) c;
            print toStr(d)
            """;

    private static final String test5 = """
            int a;
            int[] b;
            string[] d;
            string c;
            int[] f;
            string[] g;
            a = 1;
            b = [1,2,3,4];
            d = ["ciao","bau"];
            c = "miao";
            print "test5 casi disperati";
            f = (int[]) a;
            print toStr(f);
            g = (string[]) c;
            print toStr(g)
            """;
    @Override
    public void printTests() {
        System.out.println("inserire test");
    }

    @Override
    public  String getTests(int i){
        return switch (i){
            case TEST_CAST_TO_INTEGER -> test1;
            case TEST_CAST_TO_DECIMAL -> test2;
            case TEST_CAST_TO_BOOLEAN -> test3;
            case TEST_CAST_TO_STRING -> test4;
            case TEST_CAST_ERRORS -> test5;
            default -> null;
        };
    }
}
