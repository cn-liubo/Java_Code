package 依赖;

public class Butcher {//描述屠夫


    //属性  名字


    //方法
    //描述一个杀猪方法   需要提供条件  猪
    public void killPig(Pig pig){
        System.out.println("屠夫执行了杀猪方法");
        String pigName = pig.getName();
        int pigWeight = pig.getWeight();
        System.out.println(pigName+"的体重为："+pigWeight);
        pig.beKilled();
    }
}
