package exercise.ATM;

import java.util.Scanner;

public class TestMain {

    public static void main(String[] args){
        ATMService service = new ATMService();
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎您使用银行自助服务系统\n请输入账号：");
        String name = input.nextLine();
        System.out.println("请输入密码：");
        String password = input.nextLine();
        String loginResult = service.login(name, password);
        if(loginResult.equals("登录成功")){
            System.out.println(loginResult);
            while(true){
                System.out.println("1.查询\n2.存款\n3.取款\n4.转账\n5.退出\n如需帮助请拨打123456789");
                System.out.println("请输入您所需的功能：");
                String option = input.nextLine();
                switch (option){
                    case "1":
                        Float balance = service.queryBalance(name);
                        System.out.println("尊敬的"+name+"用户，您的可用余额为"+balance);
                        break;
                    case "2":
                        service.deposit(name,100.0F);
                        break;
                    case "3":
                        service.withdrawal(name,500.F);
                        break;
                    case "4":
                        service.transfer(name,"王五",200.0F);
                        break;
                    case "5":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("您的输入有误");
                }
            }
        }else{
            System.out.println("对不起"+loginResult);
        }
    }
}
