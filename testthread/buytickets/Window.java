package testthread.buytickets;

import testthread.buytickets.System12306;
import testthread.buytickets.Ticket;

public class Window extends Thread{

    private String windowName;//窗口的名字
    public Window(String windowName){
        this.windowName = windowName;
    }


    public void run(){
        this.sellTicket();
    }

    public void sellTicket(){

        while(true){
            System12306 sys = System12306.getInstance();
            Ticket ticket = sys.getTicket();
            if(ticket == null){
                System.out.println("对不起"+windowName+"窗口车票已售完");
                break;
            }

            System.out.println("从"+windowName+"售出："+ticket);
        }
    }
}
