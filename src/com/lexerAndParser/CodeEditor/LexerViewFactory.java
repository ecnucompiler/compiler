package com.lexerAndParser.CodeEditor;

import javax.swing.text.Element;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;

/**
 * Created by Burgess on 2016/1/2.
 */
public class LexerViewFactory implements ViewFactory {
    @Override
    public View create(Element elem) {
        return new LexerEditView(elem);
    }
}
