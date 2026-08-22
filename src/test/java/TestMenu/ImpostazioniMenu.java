package TestMenu;

import TestClasses.GenericTest;
import config.ProgramConfig;
import progetto.utils.FormattedLogs;
import progetto.utils.OutputColor;

public class ImpostazioniMenu extends GenericTest {

    public static final int COLORI_OUT = 1;
    public static final int AVVISI = 2;

    public String cambioColore(){
        ProgramConfig.setColorVisibility(!ProgramConfig.getColorVisibility());
        return "il colore del menu è stato cambiato";
    }

    public String cambioWarning(){
        ProgramConfig.setWarningVisibility(!ProgramConfig.getWarningVisibility());
        return "le impostazioni della visibilità dei warning sono state cambiare";
    }

    @Override
    public void printTests() {
        super.printTests();
        FormattedLogs.println(OutputColor.BRIGHT_GREEN, "1 - Impostazioni colori output");
        FormattedLogs.println(OutputColor.BRIGHT_GREEN, "2 - Impostazioni warning");
    }

    @Override
    public  String getTests(int i){
        return switch (i){
            case COLORI_OUT -> cambioColore();
            case AVVISI -> cambioWarning();
            default -> null;
        };
    }

}
