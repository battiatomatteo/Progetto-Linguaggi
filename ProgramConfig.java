package config;

import progetto.utils.FormattedLogs;

import java.io.*;
import java.util.Properties;

public class ProgramConfig {

    private static final String CONFIG_FILE = "src/main/java/config/config.properties";

    private static boolean showWarning = true;

    static {
        loadSettings();
        FormattedLogs.println(FormattedLogs.PURPLE,"file caricato");
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

        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(configFile)) {
            properties.load(input);
            showWarning = Boolean.parseBoolean(
                    properties.getProperty("showWarning", "true")
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createDefaultConfig() {
        showWarning = true;
        saveSettings();
    }

    private static void saveSettings() {
        Properties properties = new Properties();
        properties.setProperty(
                "showWarning",
                String.valueOf(showWarning)
        );

        try (OutputStream output = new FileOutputStream(CONFIG_FILE)) {
            properties.store(
                    output,
                    "Program Configuration"
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}