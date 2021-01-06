package doubleList;

public class Test {
    public static void main(String[] args) {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(3);
        doubleLinkedList.addFirst(3);
        doubleLinkedList.addFirst(3);
        doubleLinkedList.display();//5 4 3 2 1
        doubleLinkedList.addLast(19);
        doubleLinkedList.display();//5 4 3 2 1 19

        doubleLinkedList.addIndex(3, 9999);
        doubleLinkedList.display();//5 4 3 9999 2 1 19

        System.out.println(doubleLinkedList.contains(9999));//true

        doubleLinkedList.remove(19);
        doubleLinkedList.display();

        doubleLinkedList.removeAllKey(3);
        doubleLinkedList.display();

        doubleLinkedList.clear();
        System.out.println("salkjdfoisf");

    }
}
