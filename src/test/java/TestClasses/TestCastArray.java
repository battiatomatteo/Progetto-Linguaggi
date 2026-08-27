package TestClasses;

import progetto.utils.FormattedLogs;
import progetto.utils.OutputColor;

public class TestCastArray extends GenericEntry{
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
            print a;
            a = (int[]) b;
            print a;
            a = (int[]) c;
            print a;
            a = (int[]) d;
            print a
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
            print b;
            b = (dec[]) a;
            print b;
            b = (dec[]) c;
            print b;
            b = (dec[]) d;
            print b
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
            print c;
            c = (bool[]) a;
            print c;
            c = (bool[]) b;
            print c;
            c = (bool[]) d;
            print c
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
            print d;
            d = (string[]) a;
            print d;
            d = (string[]) b;
            print d;
            d = (string[]) c;
            print d
            """;

    private static final String test5 = """
            /* commento inizio */
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
            a = a * 2;
            print a;
            print "prova";
            a = a / 2;
            print "prova";
            print a;
            print "prova"
            /* commento fine */
            """;
    @Override
    public void printTests() {
        super.printTests();
        FormattedLogs.println(OutputColor.BRIGHT_GREEN, "1 - Cast di array verso int");
        FormattedLogs.println(OutputColor.BRIGHT_GREEN, "2 - Cast di array verso dec");
        FormattedLogs.println(OutputColor.BRIGHT_GREEN, "3 - Cast di array verso bool");
        FormattedLogs.println(OutputColor.BRIGHT_GREEN, "4 - Cast di array verso string");
        FormattedLogs.println(OutputColor.BRIGHT_GREEN, "5 - Cast di array verso char");
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
