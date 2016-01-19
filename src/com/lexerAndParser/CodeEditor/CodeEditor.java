package com.lexerAndParser.CodeEditor;

import com.lexerAndParser.UI.CodeEditorKit;

import javax.swing.*;
import javax.swing.text.EditorKit;

/**
 * Created by Burgess on 2016/1/2.
 */
public class CodeEditor extends JEditorPane {
    @Override
    protected EditorKit createDefaultEditorKit() {
        return new CodeEditorKit();
    }
}
