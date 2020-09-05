package testbuffered;

import java.io.*;

public class TestBufferedInputStream {

    public static void main(String[] args){

        try {
            //创建一个流
            File file = new File("D://test//ATMService.txt");
            FileInputStream fis = new FileInputStream(file);//file String
            BufferedInputStream bis = new BufferedInputStream(fis);
//            bis.available();
//            bis.read(int);
//            bis.read(byte[]);
//            bis.close();
//            bis.skip(long);

            FileOutputStream fos = new FileOutputStream("",true);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
//            bos.write(int);
//            bos.write(byte[]);
//            bos.flush();
//            bos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
