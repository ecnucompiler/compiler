package com.lexerAndParser.JNI;

import java.awt.List;

public class Jni_helper {
	String code;
	String error;
	String tokens;
	private TestJNI jni; 
	public String getTokens() {
		
//		return "local a \n global b\n";
		
		return tokens;
	}
	public void setTokens(String tokens) {
		this.tokens = tokens;
	}
	public Jni_helper(String str){
		this.code=str;
		error="";
		tokens="";
		jni=new TestJNI();
	}
	public void compile(){
		System.out.println("code in: "+code);
		
	
		error=jni.parse(code);
		tokens=jni.scan(code);
		System.out.println("error: "+error);
		System.out.println("token: "+tokens);
		
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getError() {

		return error;
		//return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
}
