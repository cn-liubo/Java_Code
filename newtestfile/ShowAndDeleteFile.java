package newtestfile;

import java.io.File;

public class ShowAndDeleteFile {

    //设计一个方法  删除文件夹
    // 参数-->file
    public void delete(File file){

        //判断file不是空文件夹 找人做事
        File[] files = file.listFiles();
        if(files != null && files.length != 0){
            for(File f:files){
                this.delete(f);
            }
        }
        //删除file(file是文件或空文件夹)
        file.delete();
    }

    //设计一个方法  用来展示(遍历)文件夹
    // 参数-->file(代表文件或文件夹)
    public void showFile(File file){

        //判断如果file是一个文件夹 文件夹内有元素 找一个人做
        //获取fil的子元素 file==null证明file是文件  file!=null证明file是文件夹  files.length!= 0证明是带元素的文件夹

        File[] files = file.listFiles();
        if(files != null && files.length != 0){
            for(File f:files){//将每一个子元素都找人遍历
                this.showFile(f);
            }
        }
        //做自己的(file是一个文件或空的文件夹)
        System.out.println(file.getAbsolutePath());
    }

    public static void main(String[] args){
        ShowAndDeleteFile sadf = new ShowAndDeleteFile();
        File file = new File("D://test");
        sadf.showFile(file);
    }
}
