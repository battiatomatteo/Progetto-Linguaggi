package TestClasses;

import progetto.utils.FormattedLogs;
import progetto.utils.OutputColor;

public class TestCompleti extends GenericEntry{
    public static final int TEST_1= 1;
    public static final int TEST_2= 2;
    public static final int TEST_3= 3;

    public static final String test1 =
            """
            int a;
            int scelta;
            int i;
            int x;
            string s;
            print "Benvenuto";
            print "Scegli quale tra le opzioni vuoi provare";
            print "1 - countdown da 10 ";
            print "2 - while";
            input s;
            a = 0;
            scelta = (int) s;
            print "";
            if (scelta == 1 ) {
                for i from 0 to 10 {
                    // print "for";
                    a = i;
                    print (string) a
                }
            }
            else{
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
            }
            """;

    public static final String test2 =
            """
            int[] x = [0, 0, 0, 0, 0];
            int num;
            int ind;
            string t;
            print "Quanti numeri vuoi inserire ?";
            input t;
            num = (int) t;
            if(num > 5){
                print("Mi dispiace sono troppi non ne voglio di piu' di 5 ;) ");
                num = 5
            };
            if(num < 1){
                print("Se non vuoi inserire numeri potevi anche non avviare il programma ;) ");
                exit
            };
            for ind from 0 to num {
                print "inserire un numero intero:";
                input t;
                x[ind] = (int) t
            };
            print "Array inserito " :: x;
            for ind from 0 to num {
                if(ind % 2 == 0){
                    x[ind] = x[ind] * 5
                }
                else{
                    x[ind] = x[ind] - 2
                }
            };
            print "Array modificato " :: x
            
            """;

    public static final String test3 =
            """
            int scelta = 0;
            int ind;
            string t;
            int estratto;
            for ind from 0 to 3{
                print "tenta la fortuna inserendo un numero intero";
                input t;
                scelta = (int) t;
                <<estratto = scelta @ estratto = scelta @ estratto = -100>>;
                if(estratto != -100){
                    print "hai vinto "
                }
                else{
                    if(scelta == -100){
                        print "non avevi possibilita' di vincere, hai messo il numero perdente"
                    }
                    else{
                        print "hai perso "
                    }
                }
            }
            """;

    @Override
    public void printTests() {
        super.printTests();
        FormattedLogs.println(OutputColor.GREEN, "1 - Mini menu a scelta");
        FormattedLogs.println(OutputColor.GREEN, "2 - Modifica di un array intero inserito da console");
        FormattedLogs.println(OutputColor.GREEN, "3 - Estrazione fortunata");
    }

    @Override
    public  String getTests(int i){
        return switch (i){
            case TEST_1 -> test1;
            case TEST_2 -> test2;
            case TEST_3 -> test3;
            default -> null;
        };
    }
}
