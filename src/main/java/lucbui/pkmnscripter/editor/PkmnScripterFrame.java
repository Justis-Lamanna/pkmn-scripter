package lucbui.pkmnscripter.editor;

import javax.swing.*;
import java.awt.*;

public class PkmnScripterFrame extends JFrame {

    private JEditorPane scriptField;

    public PkmnScripterFrame(){
        super("Pkmn Scripter");
        buildFrame();
    }

    private void buildFrame(){
        //this.setLayout(new GridBagLayout());
        this.setLayout(new BorderLayout());
        this.setJMenuBar(buildMenuBar());

        //GridBagConstraints c = new GridBagConstraints();
        //c.gridx = 0; c.gridy = 0; c.gridwidth = 1; c.gridheight = 1; c.fill = GridBagConstraints.BOTH;
        JPanel emptyPanel = new JPanel();
        emptyPanel.setBackground(Color.BLUE);
        this.add(emptyPanel, BorderLayout.NORTH);
        scriptField = buildScriptField();
        //c.gridheight = 8; c.gridy = 1;
        this.add(scriptField, BorderLayout.CENTER);
    }

    private JMenuBar buildMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        //File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        fileMenu.add(newItem);

        menuBar.add(fileMenu);

        return menuBar;
    }

    private JEditorPane buildScriptField() {
        JEditorPane scriptField = new JEditorPane();
        scriptField.setText("Hello World");
        //scriptField.setPreferredSize(new Dimension(500, 500));
        return scriptField;
    }
}
