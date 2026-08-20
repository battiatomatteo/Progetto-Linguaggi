package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import progetto.utils.FormattedLogs;
import java.io.File;
import java.io.IOException;

public class ProgramConfig {

    private static final String CONFIG_FILE =
            "src/main/java/config/config.json";

    private static boolean showWarning = true;

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    static {
        loadSettings();
        FormattedLogs.println(
                FormattedLogs.PURPLE,
                "File di configurazione caricato"
        );
    }

    public static void setWarningVisibility(boolean visibility) {
        showWarning = visibility;
        saveSettings();
    }

    public static boolean getWarningVisibility() {
        return showWarning;
    }

    private static void loadSettings() {

        File configFile = new File(CONFIG_FILE);

        if (!configFile.exists()) {
            createDefaultConfig();
            return;
        }

        try {
            ConfigData configData =
                    objectMapper.readValue(configFile, ConfigData.class);

            showWarning = configData.showWarning;

        } catch (IOException e) {
            System.err.println(
                    "Errore durante il caricamento della configurazione:"
            );
            e.printStackTrace();

            // Valori di default in caso di errore
            showWarning = true;
        }
    }

    public static void createDefaultConfig() {
        showWarning = true;
        saveSettings();
    }

    private static void saveSettings() {

        ConfigData configData = new ConfigData();
        configData.showWarning = showWarning;

        try {
            objectMapper.writeValue(
                    new File(CONFIG_FILE),
                    configData
            );

        } catch (IOException e) {
            System.err.println(
                    "Errore durante il salvataggio della configurazione:"
            );
            e.printStackTrace();
        }
    }

    // Classe che rappresenta il contenuto del JSON
    public static class ConfigData {

        public boolean showWarning;

        public ConfigData() {
        }
    }
}