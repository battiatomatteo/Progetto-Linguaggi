package TestClasses;

public class TestControlloCondizionato extends GenericTest {

    public static final int TEST_IN = 1;
    public static final int TEST_IN2 = 2;
    public static final int TEST_IN3 = 3;
    public static final int TEST_IN4 = 4;
    public static final int TEST_IN5 = 5;
    public static final String BRIGHT_GREEN   = "\u001B[92m";
    public static final String RESET  = "\u001B[0m";

    public static final String test1 =
            """
            int n;
            int x;
            int i;
            n = 9;
            x = 2;
            for i from 2 to (n) {
                if(x == 0) {
                    break
                }
                else {
                    print "ciao mondo"
                };
                x--
            }
            else{
                print "Not prime!"
            };
            x=2;
            for i from 2 to (n) {
                switch ( x * 2 ){
                    case 4: print "quattro" ;
                    case 6: print "sei" ;
                    default : print "error 404"
                };
                x++
            }else{
                print "ERROR!"
            }
            """;

    public static final String test2 =
            """
            int n;
            int x;
            int i;
            n = 9;
            x = 2;
            for i from 2 to (n) {
                print ">> x=" :: ${x} :: " i=" :: ${i} :: " n= " :: ${n};
                if(x == 10) {
                    print ">> break";
                    break
                }
                else {
                print ">> continuo"
                };
                x--
            }
            else{
                print ">> Ciclo non interrotto"
            }
            """;

    public static final String test3 =
            """
            int n;
            int x;
            int i;
            n = 9;
            x = 2;
            for i from 2 to (n) {
                switch ( x * 2 ){
                    case 4: print "quattro" ;
                    case 6: print "sei";
                    default : break
                };
                x++
            }else{
                print "ERROR!"
            }
            """;
    public static final String test4 =
            """
            int x;
            x = 0;
            while(x < 5){
                if(x == 2){
                    print ">>fine anticipata";
                    break
                }
                else{
                    print ">>ciao"
                };
                x++
            }
            """;
    public static final String test5 =
            """
            int i;
            int x;
            for i from 2 to 10{
                for x from 2 to 10{
                    print (string) x;
                    if (i == 5){
                        print "fine preventiva di i " :: (string) i;
                        break
                    }
                }
                else{
                    print "x finito correttamente " :: (string) i
                };
                if(i == 9){
                    print "chiusura preventiva di i " :: (string) i;
                    exit
                }
            }
            """;

    @Override
    public void printTests() {
        super.printTests();
        System.out.println(BRIGHT_GREEN + "SISTEMARE TEST 1, 2, 3" + RESET);
        System.out.println(BRIGHT_GREEN + "1 - forElse e if + forElse e switch" + RESET);
        System.out.println(BRIGHT_GREEN + "2 - forElse + break" + RESET);
        System.out.println(BRIGHT_GREEN + "3 - forElse + switchCase" + RESET);
        System.out.println(BRIGHT_GREEN + "4 - while + break" + RESET);
        System.out.println(BRIGHT_GREEN + "5 - for annidato + break" + RESET);
    }

    @Override
    public  String getTests(int i){
        return switch (i){
            case TEST_IN -> test1;
            case TEST_IN2 -> test2;
            case TEST_IN3 -> test3;
            case TEST_IN4 -> test4;
            case TEST_IN5 -> test5;
            default -> null;
        };
    }
}
