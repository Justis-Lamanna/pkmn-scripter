import lucbui.pkmnscripter.editor.PkmnScripterFrame;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import lucbui.pkmnscripter.editor.*;

public class Main {

    public static String UI_PROPERTIES_FILE = "pkmn-scripter.properties";

    /**
     * Starts the Pkmn Scripter.
     * Any exceptions that get this far will trigger an appropriate popup, and the app will close.
     * @param args Unused
     */
    public static void main(String... args){
        try{
            initializePkmnScripter();
        } catch (Exception e) {
            Popups.debugPopup("Unexpected Error", "There was an unexpected error encountered.", e);
        }
    }

    /**
     * Initialize the Pkmn Scripter.
     * Loads properties, sets look-and-feel, builds and shows frame.
     */
    private static void initializePkmnScripter(){
        Properties properties = getProperties();
        String lookAndFeel = properties.getProperty("ui");
        String uiTheme = properties.getProperty("ui-theme");

        ScripterGraphics.updateGraphics(lookAndFeel, uiTheme);

        JFrame frame = new PkmnScripterFrame();

        frame.setSize(800, 800 );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Load properties from the properties file.
     * @return The loaded properties.
     */
    private static Properties getProperties(){
        Properties properties = new Properties();
        try(InputStream input = new FileInputStream(UI_PROPERTIES_FILE)) {
            properties = new Properties();
            properties.load(input);
        } catch (Exception e) {
            Popups.debugPopup("Error loading Properties", "There was an error reading the Properties file. Default properties will be used.", e);
        }
        properties.list(System.out);
        return properties;
    }
}
