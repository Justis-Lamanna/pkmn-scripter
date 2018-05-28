package editor;

import javax.swing.*;

public class PkmnScripterFrame extends JFrame {

    public PkmnScripterFrame(){
        super("Pkmn Scripter");
        buildFrame();
    }

    private void buildFrame(){
        this.setJMenuBar(buildMenuBar());
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
}
