package com.lexerAndParser.UI;

import com.lexerAndParser.CodeEditor.CodeEditor;
import com.lexerAndParser.FileHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

/**
 * Created by Burgess on 2016/1/2.
 */
public class EditFrame extends BaseFrame implements ActionListener{
    private CodeEditor codeArea;
	private JMenuBar menuBar;
    private JTextField status;
    private FileHelper fileHelper = new FileHelper();
   private int col = 0, row = 1;
    public EditFrame(){
        super();
        setTitle("EditFrame");
        addDefaultTextArea();
        addMenu();
    }




	private void addDefaultTextArea(){
        codeArea = new CodeEditor();
        codeArea.setFont(new Font("dialog", 0, 15));
        codeArea.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyChar() == '\n'){
					row++;
					col = 0;
				}else{
					col++;
				}
				updateStatus(row, col);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        JScrollPane codePanel = new JScrollPane(codeArea);
        add(codePanel);
        status = new JTextField();
        status.setEnabled(false);
        add(status, BorderLayout.SOUTH);
        updateStatus(1,1);
    }

    private void addMenu(){
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        //add Menu
        JMenu fileMenu = new JMenu("File");
        JMenu buildMenu = new JMenu("Build");
        menuBar.add(fileMenu);
        menuBar.add(buildMenu);

        //add Menu Item
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(this);
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(this);
        JMenuItem buildItem = new JMenuItem("Build");
        buildItem.addActionListener(this);

        fileMenu.add(openItem);
        fileMenu.add(saveItem);

        buildMenu.add(buildItem);
    }

    private void updateStatus(int lineNumber, int columnNumber) {
        status.setText("第 " + lineNumber + " 行, 第 " + columnNumber+" 列  ");
        status.setHorizontalAlignment(JTextField.RIGHT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Open" :
                try {
                    String filename = fileHelper.fileChoose();
                    if (!filename.equals(""))
                        fileHelper.open(filename);
                    	
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                codeArea.setText(fileHelper.getReadIn());
                break;
            case "Save" :
                try {
                    String filename = fileHelper.fileChoose();
                    fileHelper.setSaved(codeArea.getText());
                    if (!filename.equals(""))
                        fileHelper.save(filename);
                    
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            case "Build":
                new BuildFrame(codeArea.getText());
                break;
        }
    }
}
