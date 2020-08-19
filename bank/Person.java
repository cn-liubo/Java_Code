package 练习.bank;

public abstract class Person {

    protected String name;
    public String getName() {
        return this.name;
    }

    //1.进银行 叫一个号码 排队
    public abstract void CallNumber();
    //2.去窗口办理
    public abstract void transact();
    //3.办理完毕离开
    public abstract void leave();
}
