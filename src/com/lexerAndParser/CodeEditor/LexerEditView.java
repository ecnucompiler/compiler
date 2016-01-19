package com.lexerAndParser.CodeEditor;

import javax.swing.text.*;
import java.awt.*;

/**
 * Created by Burgess on 2016/1/2.
 */
public class LexerEditView extends PlainView {

    /**
     * Constructs a new PlainView wrapped on an element.
     *
     * @param elem the element
     */
    public LexerEditView(Element elem) {
        super(elem);
    }

    @Override	
    protected int drawSelectedText(Graphics g, int x, int y, int p0, int p1) throws BadLocationException {
        return super.drawSelectedText(g, x, y, p0, p1);
    }

    @Override
    protected int drawUnselectedText(Graphics g, int x, int y, int startOffset, int endOffset) throws BadLocationException {
        int docLength = getDocument().getLength();
        System.out.println("x: "+x+"y: "+y);
        System.out.println("start: "+startOffset+"end: "+endOffset);
       // System.out.println("docLength: "+docLength);
        int length = (endOffset < docLength ? endOffset : docLength) - startOffset;
     //   System.out.println("length: "+length);
        return scanParagraph(g, x, y, startOffset, length);
    }

    private int scanParagraph(Graphics g, int x, int y, int startOffset, int length) throws BadLocationException
    {
    	 Segment seg = new Segment();
    	 CodeEditor editor = (CodeEditor) getContainer();
    	 g.setColor(Color.blue);
    	 getDocument().getText(startOffset, length, seg);
       Utilities.drawTabbedText(seg, x, y, g, this, startOffset );
    	 return 0;
    	//if(startOffset>30) return 1;
    	//return 1;
//        Segment seg = new Segment();
//        //得到编辑器组件
//        CodeEditor editor = (CodeEditor) getContainer();
//        //得到startOffset,位置开始的length个长度的字符串，其实也就是我们要处理的字符串
//        getDocument().getText(startOffset, length, seg);
//        for (int wordIndex = 0; wordIndex < seg.length();){
//            char currentChar = seg.charAt(wordIndex);
//            if (Character.isJavaIdentifierStart(currentChar)){
//                //下面我默认用Object说明，实际中要处理seg中的内容。
//                String identifier = "Object";
//                int len = identifier.length();
//                //比如说以红色显示类名
//                Segment text = getLineBuffer();
//                getDocument().getText(startOffset + wordIndex, len, text);
//                //还有其它样式的话只管给g加
//                g.setColor(Color.blue);
//                Utilities.drawTabbedText(text, x, y, g, this, startOffset + wordIndex);
//            }
//        }
//        return length;
    	
    	//   System.out.println("1");
//    	 Segment seg = new Segment();
//    	// System.out.println("2");
//    	     //得到编辑器组件
//    	 CodeEditor editor = (CodeEditor) getContainer();
//    	// System.out.println("startOffset: "+startOffset);
//    	// System.out.println("length: "+length);
//    	//     //得到startOffset,位置开始的length个长度的字符串，其实也就是我们要处理的字符串
//    	     getDocument().getText(startOffset, length, seg);
//    	 //    System.out.println("seg length: "+seg.length());
//    	   //  System.out.println("4");
//    	    // System.out.println("length: "+ seg.length()); 
//    	  //   g.setColor(Color.blue);
//    	//     System.out.println("x: "+x+"y: "+y);
//    	 //    Utilities.drawTabbedText(seg, x, y, g, this, startOffset );
//    	     System.out.println("lengthhaha: "+seg.toString());
//    	    
//    	     
////    	     int wordIndex=0;
////    	     
////    	     while(wordIndex<seg.length()){
////    	    	 while(wordIndex<seg.length() &&
////    	    		 (seg.charAt(wordIndex)==' ' || seg.charAt(wordIndex)=='\n' || seg.charAt(wordIndex)=='\t') 
////    	    		 ) wordIndex++;
////    	    	 int wordEnd=wordIndex;
////    	    	 while(wordEnd+1<seg.length() &&
////        	    		 (seg.charAt(wordEnd+1)!=' ' && seg.charAt(wordEnd+1)!='\n' && seg.charAt(wordEnd+1)!='\t') 
////        	    		 ) wordEnd++;
////    	    	 
////    	    	 if(wordEnd<seg.length()){
////    	    		 	int len=wordEnd-wordIndex+1;
////    	    		 	String str = seg.subSequence(wordIndex, wordEnd+1).toString();
////    	    		 	System.out.println("word: "+str);
////    	    		 	Color color=Color.black;
////    	    		 	switch(str){
////    	    		 	case "global":
////    	    		 		color=Color.blue;
////    	    		 		break;
////    	    		 	case "local":
////    	    		 		color=Color.red;
////    	    		 		break;
////    	    		 	case "0":
////    	    		 	case "1":
////    	    		 		color=Color.green;
////    	    		 		break;
////    	    		 	case "define ":
////    	    		 		color=Color.PINK;
////    	    		 		break;
////    	    		 	case "&":
////    	    		 	case "^":
////    	    		 	case "=":
////    	    		 	case "|":
////    	    		 	case "!=":
////    	    		 	case "=>":
////    	    		 		color=Color.gray;
////    	    		 		break;
////    	    		 	case "*":
////    	    		 		color=Color.yellow;
////    	    		 		break;
////    	    		 	}
////    	    		 	Segment text =new Segment();
////    	    		 	 getDocument().getText(startOffset + wordIndex, len, text);
////        	            g.setColor(color);
////        	            Utilities.drawTabbedText(text, x, y, g, this, startOffset + wordIndex);
////    	    	 } 
////    	    	 wordIndex=wordEnd+1;
////    	     }
//    	     
//for (int wordIndex = 0; wordIndex < seg.length();wordIndex++)
//    	 {
//    	   char currentChar = seg.charAt(wordIndex);
//    	   if (currentChar=='O')
//    	  {
//    	//下面我默认用Object说明，实际中要处理seg中的内容。
//    	String identifier = "Object";
//    int len = identifier.length();
//
//   //比如说以红色显示类名
//    	Segment text = getLineBuffer();
//    	  getDocument().getText(startOffset + wordIndex, len, text);
//    //还有其它样式的话只管给g加
//    	 g.setColor(Color.red);
//
//    	  Utilities.drawTabbedText(text, x, y, g, this, startOffset + wordIndex);
//    	
//    //下面的代码略
//   
//  }
//    	 }
//    	  
//
//    	   
//    	   return x+length;
    }

	private boolean Eq(Segment seg, int begin, int end, String key) {
		// TODO Auto-generated method stub
		for(int i=begin;i<=end;i++) if(seg.charAt(i)!=key.charAt(i)) return false;
		return true;
	}
}
