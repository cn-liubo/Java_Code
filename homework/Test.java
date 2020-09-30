package 练习.homework;

public class Test {
    public static void main(String[] args){

        Army army = new Army(4);
        Fighter fighter = new Fighter();
        GaoShePao gaoShePao = new GaoShePao();
        Tanke tanke = new Tanke();
        WuZiFeiJi wuZiFeiJi = new WuZiFeiJi();

        try {
            army.addWeapon(fighter);
            army.addWeapon(gaoShePao);
            army.addWeapon(tanke);
            army.addWeapon(wuZiFeiJi);
        } catch (AddWeaponException e) {
            e.printStackTrace();
        }
        army.attackAll();
        army.moveAll();

//        Weapon weapon1 = new WuZiFeiJi();
//        Weapon weapon2 = new Fighter();
//        Weapon weapon3 = new GaoShePao();
//        Weapon weapon4 = new Tanke();
//        Tanke tanke = (Tanke)weapon4;
//        tanke.move();
//        ((Tanke) weapon4).shoot();
    }
}
