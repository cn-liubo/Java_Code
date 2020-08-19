package 练习.bank;

public class Bank {

    //银行开门 等待用户办理业务
    public void profession(Person p){
        System.out.println(p.getName()+"客户进入银行");
        p.CallNumber();
        p.transact();
        p.leave();
    }

//    public void profession(OldMan om){
//        System.out.println(om.getName()+"客户进入银行");
//        om.CallNumber();
//        om.transact();
//        om.leave();
//    }
//    public void profession(YoungMan ym){
//        System.out.println(ym.getName()+"客户进入银行");
//        ym.CallNumber();
//        ym.transact();
//        ym.leave();
//    }
//    public void profession(Toff t){
//        System.out.println(t.getName()+"客户进入银行");
//        t.CallNumber();
//        t.transact();
//        t.leave();
//    }
}
