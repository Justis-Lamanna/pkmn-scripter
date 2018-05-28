package editor;

import javax.swing.*;

public class Popups {
    private Popups(){}

    /**
     * Constructs a debug message popup. Right now more or less a placeholder for something more advanced.
     * Right now, "Cause:" followed by the exception message is appended to the specified message.
     * Stack trace is printed to the console for debugging.
     * @param title The title of the popup
     * @param message The message of the popup.
     * @param ex The exception which caused the popup.
     */
    public static void debugPopup(String title, String message, Exception ex){
        ex.printStackTrace();
        StringBuilder sb = new StringBuilder(message);
        sb.append("\nCause: ").append(ex.getLocalizedMessage());
        JOptionPane.showMessageDialog(null, sb.toString(), title, JOptionPane.INFORMATION_MESSAGE, null);
    }
}
