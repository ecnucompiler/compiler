package com.lexerAndParser.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Burgess on 2016/1/2.
 */
public class TextAreaWithTitle extends JComponent {
    JTextArea textArea = new JTextArea();
    JLabel label = new JLabel();

    public TextAreaWithTitle(String labelString){
        setLayout(new BorderLayout());
        JScrollPane scrollText = new JScrollPane(textArea);
        label.setText(labelString);
        label.setFont(new Font("dialog", 0, 15));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        textArea.setRows(5);
        textArea.setFont(new Font("dialog", 0, 15));
        add(scrollText, BorderLayout.CENTER);
        add(label, BorderLayout.NORTH);
    }

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

}
