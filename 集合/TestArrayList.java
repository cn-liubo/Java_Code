package 集合;

import java.util.ArrayList;

public class TestArrayList {

    public static void main(String[] args){

//        //ArrayList 有序可重复
//        ArrayList<String> list = new ArrayList<String>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//        list.add("e");
//        list.add("abc");
//        list.get(0);
//        list.remove(0);
//        list.size();



//        System.out.println(list.size());//有效元素个数 5
//        System.out.println(list.get(6));//取第i个元素  a  IndexOutOfBoundsException
//        for(int i = 0; i < list.size(); i++){
//            String value = list.get(i);
//            System.out.println(value);
//        }

//        System.out.println(list);//[a, b, c, d, e]
//        //list底层重写了toString方法

//        //集合元素全部删掉
//        int size = list.size();//5
//        for(int i = 0; i < size; i++){
//            list.remove(0);
//        }
//        //list.remove(i);             list.remove(0);
//        //i==0  size==5  abcde        i==0  size==5  abcde
//        //      bcde                        bcde
//        //i==1  size==4  bcde         i==1  size==4  bcde
//        //      bde                         cde
//        //i==2  size==3  bde          i==2  size==3  cde
//        //      bd                          de
//        //i==3  size==2               i==3  size==2
//        //      bd                          de
//        System.out.println(list);//[]


        //泛型不能使用基本类型--如果想要使用基本类型，需要使用其对应的包装类
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);
        list1.add(50);
        list1.add(60);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(100);
        list2.add(200);
        list2.add(300);

//        //不知道集合是什么类型的
//        Object[] array = list1.toArray();//不知道集合是什么类型的
//        for(Object o:array){
//            Integer value = (Integer)o;
//            System.out.println(value);
//        }
        //知道集合的类型
        //事先准备好一个空的数组-->接受返回值
        Integer[] i = new Integer[list1.size()];
        list1.toArray(i);
        System.out.println(i.length);


        //list2集合中的所有元素添加到list1中
        list1.addAll(2, list2);
        //list1.addAll(Collection<? extends E> list2)
        //将list2集合中的全部元素存入list1集合中
        //System.out.println(list1);
//        list1.clear();
//        System.out.println(list1);

//        int index = list1.indexOf(100);
//        System.out.println(index);

        //ArrayList<String> --> "a""b""c";
        //String value = list.remove("a");
        //ArrayList<Integer> --> 1 2 3
        //list.remove(1); --> 1号索引位置 index == 1
        //1参数默认看起来是基本类型
        //list.remove(new Integer(1)); --> 元素1 obj == 1

    }
}
