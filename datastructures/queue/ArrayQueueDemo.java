package queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//接受用户输入
        Scanner input = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while(loop){
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列中取出队列");
            System.out.println("h(head)：查看队列头数据");
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            key = input.next().charAt(0);//接受一个字符
            switch(key){

                case 'a':
                    System.out.println("请输入一个数：");
                    int value = input.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int result = arrayQueue.getQueue();
                        //System.out.println("取出的数据是：" + result);
                        System.out.printf("取出的数据是%d\n", result);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n", result);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    input.close();
                    loop = false;

            }
        }
        System.out.println("程序退出");
    }
}

//使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue{
    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数据用于存放数据，模拟队列

    //创建队列的构造方法

    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front = -1;//指向队列头部，分析出front指向队列头的前一个位置
        rear = -1;//指向队列尾，指向队列的数据源（就是队列最后一个数据）
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能加入数据");
            return;
        }
        rear++;//让rear后移
        arr[rear] = n;
    }

    //获取队列的数据，出队列
    public int getQueue(){
        if(isEmpty()){
            //通过抛出异常来处理
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;//front后移
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for(int i = 0; i < arr.length; i++){
            //System.out.printf("arr[%d] = %d\n", i, arr[i]);
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }

    //显示数据的头数据，注意不是取数据
    public int headQueue(){
        //判断
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front + 1];
    }


}
