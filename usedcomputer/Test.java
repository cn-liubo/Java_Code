package usedcomputer;

public class Test {
    public static void main(String[] args) {
        MachineRoom room = new MachineRoom();
        Student student1 = new Student("小小傻逼");
        room.welcomeStudent(student1);
        Student student2 = new Student("小傻逼");
        room.welcomeStudent(student2);
        Student student3 = new Student("中中傻逼");
        room.welcomeStudent(student3);
        Student student4 = new Student("中傻逼");
        room.welcomeStudent(student4);
        Student student5 = new Student("大傻逼");
        room.welcomeStudent(student5);
        Student student6 = new Student("大大傻逼");
        room.welcomeStudent(student6);

    }
}
