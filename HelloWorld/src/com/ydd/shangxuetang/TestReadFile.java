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
                        System.out.println("�����ȡ���ݣ�"+""+c1+c2);
                }catch(FileNotFoundException e){
                        System.out.println("�ļ������ڣ�");
                        e.printStackTrace();
                }catch(IOException e){
                        System.out.println("��ȡ�ļ�����");
                        e.printStackTrace();
                }finally{
                        System.out.println("������û���쳣���ҿ϶��ᱻִ�У�");
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