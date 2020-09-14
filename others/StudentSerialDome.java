package liubo;

import java.io.Serializable;
import java.io.*;

public class StudentSerialDome {
	public static void main(String[] args) throws IOException,ClassNotFoundException {
		Student s1=new Student(123,"liu",12);
		Student s2=new Student(124,"wang",12);
		
		//把对象写入文件中
		FileOutputStream fo=new FileOutputStream("E:\\1.dat");
		ObjectOutputStream ou=new ObjectOutputStream(fo);
		ou.writeObject(s1);
		ou.close();
		
		//从文件中读取一个对象
		FileInputStream fi=new FileInputStream("E:\\1.dat");
		ObjectInputStream iu=new ObjectInputStream(fi);
		Student s3=(Student)iu.readObject();
		System.out.println(s3.getAge()+s3.getId()+s3.getName());
	}
}

class Student implements Serializable{
	int Id;
	String Name;;
	int Age;
	public Student(int i, String string, int j) {
		// TODO Auto-generated constructor stub
	}
	public void Studnt(int Id,String Name,int Age) {
    	this.Id=Id;
    	this.Name=Name;
    	this.Age=Age;	
    }
	public int getAge() {
		// TODO Auto-generated method stub
		return Age;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return Id;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return Name;
	}

    
}
