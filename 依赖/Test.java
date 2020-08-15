package 依赖;

public class Test {
    public static void main(String[] args){
        //创建农夫对象
        Farmer farmer = new Farmer();
        //农夫做一件事-->养猪
        Pig pig = farmer.feedPig(5);
        //创建屠夫对象
        Butcher b = new Butcher();
        //屠夫做事-->杀猪
        b.killPig(pig);
    }
}

