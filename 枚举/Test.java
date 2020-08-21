package 枚举;

public class Test {
    public static void main(String[] args) {
        MyDay myDay = MyDay.monday;//day类中访问了一个对象 7个

        Day day = Day.monday;
        //day-->枚举类型的对象  默认继承Object
        //除了继承自Object类的方法外 还有一些 compareTo getDeClearingClass name()
        //证明我们自己创建的enum类型 默认继承Enum
        //我们自己定义的每一个eunm类型 都会默认继承Enum 间接继承Object


        Day d = Day.valueOf("monday");
        System.out.println(d.name()+"--"+d.ordinal());
//        Day[] days = Day.values();//获取所有枚举对象
//        for(Day d:days){
//            System.out.println(d.name()+"--"+d.ordinal());
//        }
    }
}
