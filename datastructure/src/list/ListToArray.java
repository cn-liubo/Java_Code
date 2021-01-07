package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToArray {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");


        /*
        Object[] objects = list.toArray();
        for(Object o : objects) {
            String s = (String) o;
            System.out.print(s.toLowerCase());
        }
        System.out.println();

        String[] sArray = new String();
        String[] strings = list.toArray();
        System.out.println(strings != sArray);

        //数组容量 < list.size()
        String[] sArray = new String[1];
        sArray[0] = "hello";
        String[] strings = list.toArray(sArray);
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(sArray));*/

        //数组容量 = list.size()
        /*String[] sArray = new String[5];
        String[] strings = list.toArray(sArray);
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(sArray));
        System.out.println(sArray == strings);//两个引用指向的是同一个对象*/

        //数组容量 > list.size() 不建议使用
        String[] sArray = {"1", "2", "3", "4", "5", "6", "7", "8"};
        String[] strings = list.toArray(sArray);
        System.out.println(strings == sArray);//两个引用指向同一个对象
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(sArray));
    }
}
