package com.ydd.shangxuetang;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReadFile {

        public static void main(String[] args) {
                // TODO Auto-generated method stub
                FileReader reader = null;
                try{
                        reader = new FileReader("h://a.txt");
                        char c1 = (char) reader.read();
                        char c2 = (char) reader.read();
                        System.out.println("输出读取内容："+""+c1+c2);
                }catch(FileNotFoundException e){
                        System.out.println("文件不存在！");
                        e.printStackTrace();
                }catch(IOException e){
                        System.out.println("读取文件错误！");
                        e.printStackTrace();
                }finally{
                        System.out.println("不管有没有异常，我肯定会被执行！");
                        try{
                                if(reader != null){
                                        reader.close();
                                }
                        }catch(Exception e ){
                                e.printStackTrace();
                        }
                }
        }
}