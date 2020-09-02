package 集合;

import java.util.ArrayList;

public class TestLinkedList {

    public static void main(String[] args) {

//        //LinkedList   200000为例
//        //向后追加元素 6ms
//        //向前插入元素 6ms
//        //遍历轮询元素 5ms
//        //向前删除元素 2ms
//        LinkedList<String> linkedList = new LinkedList<>();
//        //插入
//        for(int i = 1; i <= 200000; i++){
//            linkedList.addFirst("a");
//        }//有200000个a
//        long time1 = System.currentTimeMillis();
//        //删除
//        for(int i = 1; i <= 200000; i++){
//            linkedList.removeFirst();
//        }
//        //遍历
////        for(String v:linkedList){
////            //System.out.println(v);
////        }
//        long time2 = System.currentTimeMillis();
//        System.out.println(time2 - time1);


        //ArrayList   200000次为例
        //向后追加元素 10ms
        //向前插入元素 2456ms
        //遍历轮询元素 4ms
        //向前删除元素 2279ms
        ArrayList<String> arrayList = new ArrayList<>();
        //插入
        for(int i = 1; i <= 200000; i++){
            arrayList.add(0,"a");
        }//有200000个a
        long time1 = System.currentTimeMillis();
        //删除
        for(int i = 1; i <= 200000; i++){
            arrayList.remove(0);
        }
        //遍历
//        for(String v:arrayList){
//            //System.out.println(v);
//        }
        long time2 = System.currentTimeMillis();
        System.out.println("ArrayList向后追加元素的存放时间"+(time2 - time1));
    }
}
