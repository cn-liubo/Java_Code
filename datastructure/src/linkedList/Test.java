package linkedList;

public class Test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        /*myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addLast(4);
        myLinkedList.addLast(5);
        myLinkedList.addLast(6);
        myLinkedList.addIndex(0,1);
        myLinkedList.addIndex(0,3);
        myLinkedList.display();*/
        myLinkedList.addFirst(6);//6
        myLinkedList.addLast(1);//6 1
        myLinkedList.addFirst(4);//4 6 1
        myLinkedList.addLast(8);//4 6 1 8
        myLinkedList.addLast(9);
        myLinkedList.display();

        myLinkedList.remove(6);
        myLinkedList.display();

        System.out.println("==================");
        System.out.println(myLinkedList.contains(8));

        //myLinkedList.clear();
        Node newHead = myLinkedList.reverseList();
        myLinkedList.display2(newHead);
    }
}
