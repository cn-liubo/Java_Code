package liubo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class project20 {
	public static void main(String[] args) throws java.io.IOException{
		FileReader in=new FileReader("KY10_2.HTML ");//�����ļ�������
		BufferedReader bin=new BufferedReader(in);//��������������
		FileWriter out=new FileWriter("KY10_2.txt",true);//�����ļ������
		String str;
		while ((str=bin.readLine())!=null) {
		
		System.out.println(str);
		out.write(str+"\r\n");
		}
		in.close();
		out.close();


	}
}