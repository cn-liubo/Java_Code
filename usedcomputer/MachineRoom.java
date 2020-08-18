package usedcomputer;

public class MachineRoom {

    //机房-电脑  聚合关系  机房内有电脑
    //数组-存放5台电脑  Computer[]
    public Computer[] computers = new Computer[5];//电脑数组

//    public MachineRoom(){
//        this.init();
//    }
//    //设计一个方法 用来给电脑数组进行初始化(赋值)
//    public void init(){
//        for(int i = 0; i < computers.length; i++){
//            computers[i] = new Computer(i + 1);
//        }
//    }

    //设计一个程序块 用来给电脑数组进行初始化(赋值) 在创建对象之前，会执行块
    {
        for(int i = 0; i < computers.length; i++){
            computers[i] = new Computer(i + 1);
        }
    }

    //机房-学生  依赖关系  机房欢迎学生使用
    public void welcomeStudent(Student student){
        String studentName = student.getName();
        System.out.println("欢迎"+studentName+"同学进入机房");
        //学生进入机房后 挨个找寻 选择一台状态关闭的电脑
        for(int i = 0; i < computers.length; i++){
            boolean computersState = computers[i].isUsed();//找寻某一台电脑 获取它的状态
            if(!computersState){//表示电脑没有人使用
                student.usecomputer(computers[i]);
                break;
            }
        }

    }
}
