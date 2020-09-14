package liubo;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataOutputStream out=new DataOutputStream(new FileOutputStream("E:\\invoice1.txt"));
		double prices[]= {19.99,9.99};
		int units[]= {12,8};
		String descs[]= {"Java T-shirt","Java Mug"};
		for(int i=0;i<prices.length;i++) {
			out.writeDouble(prices[i]);
			out.writeChar('\t');
			out.writeInt(units[i]);
			out.writeChar('\t');
			out.writeChars(descs[i]);
			out.writeChar('\n');
		}
		out.close();
	}

}
