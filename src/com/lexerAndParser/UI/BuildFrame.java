package com.lexerAndParser.UI;

import javax.swing.*;

import com.lexerAndParser.JNI.Jni_helper;

import java.awt.*;

/**
 * Created by Burgess on 2016/1/2.
 */
public class BuildFrame extends BaseFrame {
    TextAreaWithTitle lexer = new TextAreaWithTitle("lexer");
    TextAreaWithTitle parser = new TextAreaWithTitle("parser");
    TextAreaWithTitle log = new TextAreaWithTitle("log");
    Jni_helper jni;
    String code;
    public BuildFrame(){
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addTextArea();
    }
    
    public BuildFrame(String str){
    	
    	super();
    	System.out.println("code: "+str);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addTextArea();
        jni=new Jni_helper(str);
        jni.compile();
        lexer.getTextArea().setText(jni.getTokens());
        parser.getTextArea().setText(jni.getError());
    }

    private void addTextArea(){
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(lexer, BorderLayout.EAST);
        panel.add(parser, BorderLayout.WEST);
        add(panel, BorderLayout.CENTER);
        add(log, BorderLayout.SOUTH);
    }
}
