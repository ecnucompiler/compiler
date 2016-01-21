package com.lexerAndParser;

import com.lexerAndParser.UI.EditFrame;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
    	
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                EditFrame frame = new EditFrame();
              

            }
        });
    }
}
