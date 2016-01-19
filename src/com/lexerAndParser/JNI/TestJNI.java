package com.lexerAndParser.JNI;

public class TestJNI {
	static{  
		  
        System.loadLibrary("goodlucky");  
  
    }  
  
    public native void set(int value);  
  
    public native int get();  
    public native String scan(String str);
    
    public native String parse(String str);
//    public static void main(String[] args) {  
//  
//         TestJNI td=new TestJNI();  
//         System.out.println("haha");
//         System.out.println(td.compile("lalala"));
////  
//     td.set(10);  
////  
//       System.out.println(td.get());  
//  
//    }  
}
