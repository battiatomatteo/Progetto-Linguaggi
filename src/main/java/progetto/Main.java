package progetto;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import progetto.exception.InterpreterExitException;
import progetto.utils.FormattedLogs;
import progetto.utils.OutputColor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            FormattedLogs.println(OutputColor.RED, "Wrong number of arguments.");
            return;
        }

        String filePath = args[0];
        Path path = Paths.get(filePath);
        String fileContent;

        if (!Files.exists(path)) {
            FormattedLogs.println(OutputColor.RED, "File does not exist: " + filePath);
            return;
        }

        if (!Files.isRegularFile(path)) {
            FormattedLogs.println(OutputColor.RED, "The path is not a file: " + filePath);
            return;
        }

        if (!path.getFileName().toString().endsWith(".vlrx")) {
            FormattedLogs.println(OutputColor.RED, "Invalid file extension. Expected .vlrx");
            return;
        }
        try {
            fileContent = Files.readString(path);
        } catch (IOException e) {
            FormattedLogs.println(OutputColor.RED, "Error reading file: " + e.getMessage());
            return;
        }


        CharStream cs = CharStreams.fromString(fileContent);
        LinguaggioLexer lexer = new LinguaggioLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LinguaggioParser parser = new LinguaggioParser(tokens);
        ParseTree tree = parser.main();
        TypedImpTS typeSystem = new TypedImpTS();
        try {
            typeSystem.visit(tree);
            Interprete interpreter = new Interprete();
            interpreter.visit(tree);
        }catch (InterpreterExitException _){}
        catch (RuntimeException re) {
            FormattedLogs.println(OutputColor.RED,"Typing error(s) found.");
            FormattedLogs.println(OutputColor.RED,re.getMessage());
            re.printStackTrace();
        }
    }

}