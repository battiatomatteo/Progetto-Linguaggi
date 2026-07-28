package TestClasses;

public class TestCast extends GenericTest{
    public final static int TEST_CAST_TO_INTEGER = 1;
    public final static int TEST_CAST_TO_DECIMAL = 2;
    public final static int TEST_CAST_TO_BOOLEAN = 3;
    public final static int TEST_CAST_TO_STRING  = 4;
    public final static int TEST_CAST_TO_CHAR     = 5;
    public static final String BRIGHT_GREEN   = "\u001B[92m";
    public static final String RESET  = "\u001B[0m";


    private static final String test1 =
            """
            int a;
            dec b;
            bool c;
            string d;
            char e;
            print "test1";
            a = 1;
            b = 5.0;
            c = false;
            d = "12";
            e = '1';
            a = (int) a;
            print a;
            a = (int) b;
            print a;
            a = (int) c;
            print a;
            a = (int) d;
            print a;
            a = (int) e;
            print a
            """;

    private static final String test2 =
            """
            int a;
            dec b;
            bool c;
            string d;
            char e;
            print "test2";
            a = 1;
            b = 5.0;
            c = false;
            d = "12";
            e = '1';
            b = (dec) b;
            print b;
            b = (dec) a;
            print b;
            b = (dec) c;
            print b;
            b = (dec) d;
            print b;
            b = (dec) e;
            print b
            """;

    private static final String test3 =
            """
            int a;
            dec b;
            bool c;
            string d;
            char e;
            print "test3";
            a = 1;
            b = 0.5;
            c = false;
            d = "true";
            e = 't';
            c = (bool) c;
            print c;
            c = (bool) a;
            print c;
            c = (bool) b;
            print c;
            c = (bool) d;
            print c;
            c = (bool) e;
            print c
            """;
    private static final String test4 =
            """
            int a;
            dec b;
            bool c;
            string d;
            char e;
            print "test4";
            a = 1;
            b = 5.0;
            c = false;
            d = "12";
            e = '1';
            d = (string) d;
            print d;
            d = (string) a;
            print d;
            d = (string) b;
            print d;
            d = (string) c;
            print d;
            d = (string) e;
            print d
            """;

    public static final String test5 =
            """
            int a;
            dec b;
            bool c;
            string d;
            char f;
            string e;
            a = 2;
            f = (char) a;
            print f;
            b = 3.5;
            f = (char) b;
            print f;
            c = false;
            f = (char) c;
            print f;
            d = "c";
            f = (char) d;
            print f;
            d = "c";
            f = (char) d;
            print f;
            f =(char) (3 :: "c" :: 'd' :: "1");
            print f;
            e = (3 :: "c" :: 'd' :: "1");
            print e
            """;
    @Override
    public void printTests() {
        super.printTests();
        System.out.println(BRIGHT_GREEN + "1 - Cast di valori verso int" + RESET);
        System.out.println(BRIGHT_GREEN + "2 - Cast di valori verso dec" + RESET);
        System.out.println(BRIGHT_GREEN + "3 - Cast di valori verso bool" + RESET);
        System.out.println(BRIGHT_GREEN + "4 - Cast di valori verso string" + RESET);
        System.out.println(BRIGHT_GREEN + "5 - Cast di valori verso char" + RESET);
    }

    @Override
    public  String getTests(int i){
        return switch (i){
            case TEST_CAST_TO_INTEGER -> test1;
            case TEST_CAST_TO_DECIMAL -> test2;
            case TEST_CAST_TO_BOOLEAN -> test3;
            case TEST_CAST_TO_STRING -> test4;
            case TEST_CAST_TO_CHAR -> test5;
            default -> null;
        };
    }
}
