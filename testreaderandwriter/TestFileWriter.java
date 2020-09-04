package testreaderandwriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//                 字符型文件输出流-->纯文本的文件
public class TestFileWriter {

    public static void main(String[] args){
        File file = new File("D://test//Text0.txt");
        try {
            FileWriter fw = new FileWriter(file);
            String str = "abc";
            char[] c = str.toCharArray();
            fw.write(97);
            fw.write(c);
            fw.write(str);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}