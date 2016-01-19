package com.lexerAndParser.UI;

import javax.swing.*;

/**
 * Created by Burgess on 2016/1/2.
 */
public class BaseFrame extends JFrame{
    private String plaf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    public static int DEFAULT_HEIGHT = 600;
    public static int DEFAULT_WEIGHT = 800;
    public BaseFrame() {
        try {
            UIManager.setLookAndFeel(plaf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.updateComponentTreeUI(this);
        build();
    }

    public void build(){
        setLocationByPlatform(true);
        setSize(DEFAULT_WEIGHT, DEFAULT_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
