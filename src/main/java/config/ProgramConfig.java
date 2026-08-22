package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import progetto.utils.FormattedLogs;
import progetto.utils.OutputColor;

import java.io.File;
import java.io.IOException;

public class ProgramConfig {

    private static final String CONFIG_FILE =
            "src/main/java/config/config.json";

    private static boolean showWarning = true;
    private static boolean showColors = true;

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT);

    static {
        loadSettings();

        FormattedLogs.println(
                OutputColor.PURPLE,
                "File di configurazione caricato"
        );
    }

    // =========================
    // WARNING
    // =========================

    public static void setWarningVisibility(boolean visibility) {
        showWarning = visibility;
        saveSettings();
    }

    public static boolean getWarningVisibility() {
        return showWarning;
    }

    // =========================
    // COLORI OUTPUT
    // =========================

    public static void setColorVisibility(boolean visibility) {
        showColors = visibility;
        saveSettings();
    }

    public static boolean getColorVisibility() {
        return showColors;
    }

    // =========================
    // CARICAMENTO CONFIGURAZIONE
    // =========================

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
            showColors = configData.showColors;

        } catch (IOException e) {

            System.err.println(
                    "Errore durante il caricamento della configurazione:"
            );

            e.printStackTrace();

            // Valori di default
            showWarning = true;
            showColors = true;
        }
    }

    // =========================
    // CONFIGURAZIONE DEFAULT
    // =========================

    public static void createDefaultConfig() {
        showWarning = true;
        showColors = true;

        saveSettings();
    }

    // =========================
    // SALVATAGGIO
    // =========================

    private static void saveSettings() {

        ConfigData configData = new ConfigData();

        configData.showWarning = showWarning;
        configData.showColors = showColors;

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

    // =========================
    // STRUTTURA DEL JSON
    // =========================

    public static class ConfigData {

        public boolean showWarning;
        public boolean showColors;

        public ConfigData() {
        }
    }
}