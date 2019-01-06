package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RunProperties {

    private static final String DEFAULT_PROPERTIES_FILE = "run.properties";
    private static Properties properties;

    private static Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            try {
                //Read all options from default properties file
                InputStream defaultPropertiesFile = RunProperties.class.getClassLoader()
                        .getResourceAsStream(DEFAULT_PROPERTIES_FILE);
                properties.load(defaultPropertiesFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    private static String getPropertyByName(String propertyName) {
        try {
            return getProperties().getProperty(propertyName);
        } catch (Exception e) {
            System.err.println("There is not property with name: " +  propertyName + "in properties file");
            e.printStackTrace();
            return ("There is not property with name: " +  propertyName + "in properties file");
        }
    }

    public static Integer getSudokuSize() { return Integer.valueOf(getPropertyByName("sudoku_size")); }

    public static String getChromeName() { return getPropertyByName("chrome_name"); }

    public static String getChromePath() { return getPropertyByName("chrome_path"); }

    public static String getWebPortalAddress() { return  getPropertyByName("web_portal_adress"); }

    public static String getBrowser() { return  getPropertyByName("browser"); }
}
