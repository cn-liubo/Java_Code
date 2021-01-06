package linkedList.int_type;

public class Test {
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add(0, 998);
        list.add(31);
        list.add(32);
        list.add(33);
        System.out.println(list);//998,31,32,33

        list.add(0, 1000);
        System.out.println(list);//1000,998,31,32,33
        list.add(3, 28);
        System.out.println(list);//1000,998,31,28,32,33
        list.add(1, 98);
        System.out.println(list);//1000,98,998,31,28,32,33

        Iterator it = list.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
