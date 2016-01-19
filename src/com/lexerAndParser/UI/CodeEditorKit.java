package com.lexerAndParser.UI;

import com.lexerAndParser.CodeEditor.LexerViewFactory;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.ViewFactory;

/**
 * Created by Burgess on 2016/1/2.
 */
public class CodeEditorKit extends StyledEditorKit {
    @Override
    public Document createDefaultDocument() {
        return new DefaultStyledDocument();
    }

    @Override
    public ViewFactory getViewFactory() {
        return new LexerViewFactory();
    }
}
