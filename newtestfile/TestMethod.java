package newtestfile;

public class TestMethod {

//    public void testOne(){
//        this.testTwo();
//        System.out.println("我是testOne方法");
//    }
//    public void testTwo(){
//        this.testThree();
//        System.out.println("我是testTwo方法");
//    }
//    public void testThree(){
//        System.out.println("我是testThree方法");
//    }

    //递归 --> 本质是方法的调用
    //设计一个方法  描述盖宝塔
    public void buildTower(int floor){
        if(floor > 1) {
            this.buildTower(floor - 1);
        }
        System.out.println("盖到第"+floor+"层宝塔");

    }

    public static void main(String[] args){
        TestMethod tm = new TestMethod();
        tm.buildTower(5);



//        //加载TestMethod类的过程
//        TestMethod tm = new TestMethod();
//        tm.testOne();//调用testOne让其执行一遍 --> 在栈内存中开辟临时的执行空间
    }
}
