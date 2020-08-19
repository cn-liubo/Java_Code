package 练习.bank;

public class OldMan extends Person{

    public OldMan(){}
    public OldMan(String name){
        this.name = name;
    }

    //1.进银行 叫一个号码 排队
    public void CallNumber(){
        System.out.println("年事已高，不知道在哪叫号，请工作人员的帮助");
    }
    //2.去窗口办理
    public void transact(){
        System.out.println("到窗口，拿出存折，取钱");
    }
    //3.办理完毕离开
    public void leave(){
        System.out.println("办理完毕，慢慢离开");
    }
}
