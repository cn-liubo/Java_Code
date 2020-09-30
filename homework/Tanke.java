package 练习.homework;

//坦克是武器，可以移动，可以射击
public class Tanke extends Weapon implements Moveable,Shootable{
    @Override
    public void move() {
        System.out.println("坦克移动！！！");
    }

    @Override
    public void shoot() {
        System.out.println("坦克射击！！！");
    }
}
