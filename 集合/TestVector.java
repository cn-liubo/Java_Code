package 集合;

import java.util.Vector;

public class TestVector {

    public static void main(String[] args){

        Vector<String> vector = new Vector<String>();
        for(int i = 1; i <= 20; i++){
            vector.add("a");
            System.out.println(vector.size()+"--"+vector.capacity());

        }
        System.out.println(vector);
//        System.out.println(vector.size());//有效元素的个数
//        System.out.println(vector.capacity());//底层真实数组的容量

    }
}
