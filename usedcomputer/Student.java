package usedcomputer;

import java.util.Scanner;

public class Student {


    //属性-学生的名字
    private String name;
    //属性-学生的人品 素质 0-9的整数 0-4人品好 5-9人品不好
    private int rp = (int)(Math.random()*10);

    //构造方法
    public Student(){

    }
    public Student(String name){
        this.name = name;
    }

    //设计一个获取学生名字的方法
    public String getName(){
        return this.name;
    }

    //依赖关系 学生使用电脑
    public void usecomputer(Computer computer){
        System.out.println(this.name+"开始使用电脑啦");
        computer.beOpen();
        computer.beUsing();
        if(this.rp < 5){
            computer.beClose();
        }else{
            System.out.println(this.name+"rp有问题，没关电脑");
        }
    }
}
