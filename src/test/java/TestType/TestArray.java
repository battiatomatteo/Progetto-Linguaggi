package TestType;

public class TestArray extends GenericTest {
    public final static int TEST_ARRAY_GENERIC = 1;
    public final static int TEST_ARRAY_ASSIGNMENT = 2;
    public final static int TEST_ARRAY_ACCESS = 3;

    private static final String test1 =
            """
            int[] a;
            string[] s;
            int[] d;
            int[] arrayCiclo ;
            int x;
            int c;
            int y;
            int i;
            a = [1, 2, 3];
            s = ["ciao", "bau", "miao"];
            arrayCiclo = [0,0,0,0];
            x = a[2];
            print x;
            c = 2;
            a[1] = 2;
            d = a;
            print a;
            print d;
            i = 3;
            y = 0;
            while(y < 4){
              arrayCiclo[y] = i * y;
              print arrayCiclo[y];
              y = y + 1;
              i = i + 1
            };
            print a;
            print d[1];
            d[1] = d[1] + a[c] + c;
            a = arrayCiclo;
            print a;
            print d;
            print a;
            print a[c]
            """;

    // assegnamento per indirizzo degli array
    private static final String test2 =
            """
            int[] a;
            int[] b;
            int[] c;
            a = [1, 2];
            c = [3, 4, 5];
            print ("-----Prima delle modifiche------");
            print ("Primo array a : ");
            print a;
            print ("Terzo array c : ");
            print c;
            print ("-----Inizio modifiche------");
            print ("Assegno a all'array b :");
            b = a;
            print ("Primo array a : ");
            print a;
            print ("Secondo array b : ");
            print b;
            print ("Terzo array c : ");
            print c;
            print ("-----Seconda modifica------");
            print ("Modifico array a :");
            a[0] = 27;
            print ("Primo array a : ");
            print a;
            print ("Secondo array b : ");
            print b;
            print ("Terzo array c : ");
            print c;
            print ("-----Terza modifica------");
            print ("Assegno c all'array a :");
            a = c;
            print ("Primo array a : ");
            print a;
            print ("Secondo array b : ");
            print b;
            print ("Terzo array c : ");
            print c;
            print ("-----Quarta modifica------");
            print ("Modifico array a :");
            a[1] = 8;
            print ("Primo array a : ");
            print a;
            print ("Secondo array b : ");
            print b;
            print ("Terzo array c : ");
            print c;
            print ("-----Quinta modifica------");
            print (" assegno a c un nuovo array");
            c = [7,9];
            print ("Primo array a : ");
            print a;
            print ("Secondo array b : ");
            print b;
            print ("Terzo array c : ");
            print c
            """;

    private static final String test3 =
            """
            int[] a;
            a = [1, 2, 3];
            print  ("-----Prima delle modifiche------");
            print a;
            a[1] = 5;
            print ("-----Post delle modifiche------");
            print a
            """;

    public void printTestMenu(){

    }
    @Override
    public void printTests() {
        System.out.println("inserire test");
    }

    @Override
    public String getTests(int i){
        return switch (i){
            case TEST_ARRAY_GENERIC -> test1;
            case TEST_ARRAY_ASSIGNMENT -> test2;
            case TEST_ARRAY_ACCESS -> test3;
            default -> null;
        };
    }
}