package editor;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Static methods for graphics regarding the Pkmn Scripter
 */
public class ScripterGraphics {

    private static String PACKAGE_PREFIX = "com.jtattoo.plaf.";

    private ScripterGraphics(){
        //Static methods only.
    }

    /**
     * Safely update graphics.
     * This updates the graphics when Swing is ready, rather than immediately.
     * @param laf The Look-and-feel to use.
     * @param theme The theme to use
     */
    public static void safeUpdateGraphics(String laf, String theme){
        SwingUtilities.invokeLater(() -> updateGraphics(laf, theme));
    }

    /**
     * Update graphics immediately.
     * Once the frame is up and running, use safeUpdateGraphics instead.
     * If the specified look-and-feel or themes fail, an appropriate popup will display.
     * @param laf The Look-and-feel to use.
     * @param theme The theme to use.
     */
    public static void updateGraphics(String laf, String theme){
        try{
            UIManager.setLookAndFeel(getLookAndFeel(laf, theme));
        }  catch (ClassNotFoundException e) {
            Popups.debugPopup("Error loading Look and Feel", "There was an error retrieving the Look and Feel specified. Default will be used", e);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            Popups.debugPopup("Error loading Look and Feel theme", "There was an error retrieving the Look and Feel theme specified. Default will be used", e);
        } catch (Exception e) {
            Popups.debugPopup("Error loading Look and Feel", "There was an unexpected error loading Look and Feel.", e);
        }
    }

    /**
     * Parse out the Look-and-feel specified from two strings.
     * laf can be null, a package name, or an abbreviated name (mint, mcwin, etc). If null,
     * returns the default look-and-feel. If abbreviated, it attempts to find a matching fully
     * qualified name in the classpath, and return it, otherwise returning the default look-and-feel.
     * @param laf The Look-and-feel to find.
     * @param theme The theme to use.
     * @return The fully qualified look-and-feel class name.
     * @throws ClassNotFoundException look-and-feel was not found on the classpath
     * @throws NoSuchMethodException Theme was specified, and look-and-feel did not have a setTheme(String) method.
     * @throws InvocationTargetException Target of setTheme invocation was incorrect.
     * @throws IllegalAccessException setTheme is inaccessible.
     */
    private static String getLookAndFeel(String laf, String theme) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String qualifiedClassName = getFullyQualifiedClassName(laf);
        Class<LookAndFeel> lookAndFeel = (Class<LookAndFeel>) Class.forName(qualifiedClassName);
        if (theme != null) {
            Method setTheme = lookAndFeel.getMethod("setTheme", String.class);
            setTheme.invoke(null, theme);
        }
        return qualifiedClassName;
    }

    private static String getFullyQualifiedClassName(String className){
        if(className == null){
            //Default
            return PACKAGE_PREFIX + "hifi.HiFiLookAndFeel";
        } else if(className.contains(".")) {
            //Assume a full package name was provided. Maybe they want a custom one and they put it in their classpath.
            return className;
        } else {
            switch(className.toLowerCase()){
                case "acryl": return PACKAGE_PREFIX + "acryl.AcrylLookAndFeel";
                case "aero": return PACKAGE_PREFIX + "aero.AeroLookAndFeel";
                case "aluminium":
                case "aluminum": return PACKAGE_PREFIX + "aluminium.AluminiumLookAndFeel";
                case "bernstein": return PACKAGE_PREFIX + "bernstein.BernsteinLookAndFeel";
                case "graphite": return PACKAGE_PREFIX + "graphite.GraphiteLookAndFeel";
                case "fast": return PACKAGE_PREFIX + "fast.FastLookAndFeel";
                case "mcwin": return PACKAGE_PREFIX + "mcwin.McWinLookAndFeel";
                case "mint": return PACKAGE_PREFIX + "mint.MintLookAndFeel";
                case "noire": return PACKAGE_PREFIX + "noire.NoireLookAndFeel";
                case "smart": return PACKAGE_PREFIX + "smart.SmartLookAndFeel";
                case "luna": return PACKAGE_PREFIX + "luna.LunaLookAndFeel";
                case "texture": return PACKAGE_PREFIX + "texture.TextureLookAndFeel";
                case "hifi":
                default: return PACKAGE_PREFIX + "hifi.HiFiLookAndFeel";
            }
        }
    }
}
