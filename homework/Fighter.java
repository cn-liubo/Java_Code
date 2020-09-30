package 练习.homework;

//战斗机是武器，可以移动，可以射击
public class Fighter extends Weapon implements Moveable,Shootable{
    @Override
    public void move() {
        System.out.println("战斗机起飞！！！");
    }

    @Override
    public void shoot() {
        System.out.println("战斗机射击！！！");
    }
}
