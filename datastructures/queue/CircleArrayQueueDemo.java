package queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列的案例：");
        //创建一个环形队列
        CircleArrayQueue arrayQueue = new CircleArrayQueue(4);
        //设置4，其队列的有效数据最大是3
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

class CircleArrayQueue {
    private int maxSize;//表示数组的最大容量
    private int front;//队列头：
    //front变量的含义做一个调整，front就指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素，front的初始值=0
    private int rear;//队列尾：
    //rear变量的含义做一个调整，rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定，rear的初始值=0
    private int[] arr;//该数据用于存放数据，模拟队列

    public CircleArrayQueue (int arrMaxSize){
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能加入数据");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移，这里必须考虑
        rear = (rear + 1)% maxSize;
    }

    //获取队列的数据，出队列
    public int getQueue(){
        if(isEmpty()){
            //通过抛出异常来处理
            throw new RuntimeException("队列空，不能取数据");
        }
        //这里需要分析出是front是指向队列的第一个元素
        //1.先把front对应的临时变量的值保存到一个临时变量
        //2.将front后移，考虑取模
        //3.将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        //思路：从front开始遍历，遍历多少个元素
        for(int i = front; i < front + size(); i++){
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size(){
        //rear = 1; front = 0; maxSize = 3;
        return (rear + maxSize - front) % maxSize;
    }

    //显示数据的头数据，注意不是取数据
    public int headQueue(){
        //判断
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }

}
