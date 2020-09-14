package liubo;
import java.io.*;
public class RandomAccess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			RandomAccessFile file=new RandomAccessFile("E:\\2.txt","rw");
			file.seek(10);
			file.writeChars("hello,RandomAccessFile");
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
