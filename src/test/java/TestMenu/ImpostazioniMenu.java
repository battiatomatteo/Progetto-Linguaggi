package progetto.utils;

public class ImpostazioniMenu {

    public static final int COLORI_OUT = 1;
    public static final int AVVISI = 2;

    @Override
    public void printTests() {
        //super.printTests();
        FormattedLogs.println(FormattedLogs.BRIGHT_GREEN, "1 - Impostazioni colori output");
        FormattedLogs.println(FormattedLogs.BRIGHT_GREEN, "2 - Impostazioni warning");
    }

    @Override
    public  String getTests(int i){
        return switch (i){
            case COLORI_OUT->  ;
            case  AVVISI-> ;
            default -> null;
        };
    }
}
