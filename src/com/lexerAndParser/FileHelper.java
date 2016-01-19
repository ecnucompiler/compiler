package com.lexerAndParser;

import javax.swing.*;
import java.io.*;

/**
 * Created by Burgess on 2016/1/1.
 * 负责处理文件的IO操作
 */
public class FileHelper {
    public void save(String filename) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        PrintStream p = new PrintStream(fileOutputStream);
        
        //Todo
        p.print(saved);
        p.close();
    }
    private String readIn;
    private String saved;
    public String getReadIn() {
		return readIn;
	}


	public void setReadIn(String readIn) {
		this.readIn = readIn;
	}


	public String getSaved() {
		return saved;
	}


	public void setSaved(String saved) {
		this.saved = saved;
	}
    public void open(String filename) throws IOException {
        File file = checkFileExist(filename);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String tmpRead;
        tmpRead = br.readLine();
        String str="";
        while (tmpRead != null){
            //Todo
        	str+=tmpRead+"\n";
            tmpRead = br.readLine();
            
        }
        readIn=str;
        br.close();
    }

    public String fileChoose(){
        JFileChooser jfc=new JFileChooser();
        jfc.setDialogType(JFileChooser.FILES_ONLY);
        jfc.showDialog(new JLabel(), "选择");
        if (jfc.getSelectedFile() != null) {
            System.out.println(jfc.getSelectedFile().getName());
            return jfc.getSelectedFile().getPath();
        }else
            return "";
    }

    public File checkFileExist(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()){
            file.createNewFile();
        }
        return file;
    }
}
