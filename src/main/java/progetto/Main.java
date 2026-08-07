package progetto;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {

    private static final String STRING_TEST =
            """
            int a;
            int index = 0;
            dec b;
            bool c = false;
            char z = '0';
            string d;
            char f;
            string e;
            int prova;
            dec x = 6.8;
            dec lp;
            dec[] loop = [3.5,6.4,5.0,7.0];
            print index;
            index++;
            print index;
            --index;
            print index;
            prova = index++;
            print index;
            print prova;
            prova = index--;
            print index;
            print prova;
            prova = ++index;
            print index;
            print prova;
            prova = --index;
            print index;
            print prova;
            a = 2;
            f = (char) a;
            print f;
            b = 3.5;
            f = (char) b;
            print f;
            c = false;
            f = (char) c;
            print f;
            d = "ciao";
            f = (char) d;
            print f;
            d = "t";
            f = (char) d;
            print f;
            f =(char) (3 :: "c" :: 'd' :: "1");
            print f;
            e = (3 :: "c" :: 'd' :: "1");
            print e;
            lp = loop[1];
            for index from 0 to 4{
                print loop[index]
            };
            print lp
            """;

    private static final String test =
            """
            int x;
            int y;
            int z;
            int[] arr;
            bool v;
            int[] a;
            int[] b;
            a = [1,2,3];
            b = [3,7];
            v = true;
            y = 5;
            x = v ? 3 : 1;
            z = (false or (x < 10 and y > 0)) ? a[0] + 5 : b[1] - 3;
            arr = (z == 4) ? a : b;
            print x;
            print y;
            print z;
            print arr
            """;



    public static void main(String[] args) {

        String prog = test;
        CharStream cs = CharStreams.fromString(prog);
        LinguaggioLexer lexer = new LinguaggioLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LinguaggioParser parser = new LinguaggioParser(tokens);
        ParseTree tree = parser.main();
        TypedImpTS typeSystem = new TypedImpTS();
        try {
            typeSystem.visit(tree);
            Interprete interpreter = new Interprete();
            interpreter.visit(tree);
        } catch (RuntimeException re) {
            System.out.println("Typing error(s) found.");
            System.out.println(re.getMessage());
            re.printStackTrace();
        }
    }

}
