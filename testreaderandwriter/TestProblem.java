package testreaderandwriter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestProblem {

    public static void main(String[] args) {

        //产生在读取的时候编码字符集问题
        try {
            FileReader fr = new FileReader(new File("D://test//Test2.txt"));
            int code = fr.read();

//            System.out.println(code);//25105
//            System.out.println((char)code);//我

            while(code!=-1){
                System.out.println(code);//25105
                System.out.println((char)code);
                code = fr.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
