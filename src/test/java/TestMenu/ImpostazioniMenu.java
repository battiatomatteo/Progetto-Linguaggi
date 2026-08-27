package TestMenu;

import TestClasses.GenericEntry;
import config.ProgramConfig;
import progetto.utils.FormattedLogs;
import progetto.utils.OutputColor;

public class ImpostazioniMenu extends GenericEntry {

    public static final int COLORI_OUT = 1;
    public static final int AVVISI = 2;

    public ImpostazioniMenu() {
        super(true,false);
    }

    public String cambioColore(){
        boolean newOptionSetting = !ProgramConfig.getColorVisibility();
        ProgramConfig.setColorVisibility(newOptionSetting);
        return "il colore del menu è " + (newOptionSetting ? "abilitato " : "disabilitato");
    }

    public String cambioWarning(){
        boolean newOptionSetting = !ProgramConfig.getWarningVisibility();
        ProgramConfig.setWarningVisibility(newOptionSetting);
        return "la visibilità dei warning è " + (newOptionSetting ? "abilitata " : "disabilitata");
    }


    @Override
    public void printTests() {
        System.out.println();
        FormattedLogs.println(OutputColor.CYAN, "Configurazione del programma di test");
        FormattedLogs.println(OutputColor.RED, "0 - Chiudi");
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
