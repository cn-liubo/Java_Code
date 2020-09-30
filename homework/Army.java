package 练习.homework;


//军队
public class Army {
    private Weapon[] weapons;

    public Army(int count){
        weapons = new Weapon[count];
    }

    //将武器加入数组
    public void addWeapon(Weapon weapon) throws AddWeaponException {
        for(int i = 0; i < weapons.length; i++){
            if(null == weapons[i]){
                weapons[i] = weapon;
                System.out.println(weapon + "武器添加成功！");
                return;
            }
        }
        //程序执行到这里，说明武器数组已满，
        throw new AddWeaponException("武器数量已达上限！");
    }
    //所有可攻击的武器攻击
    public void attackAll(){
        for(int i = 0; i < weapons.length; i++){
            if(weapons[i] instanceof Shootable){
                Shootable s = (Shootable)weapons[i];
                s.shoot();
            }
        }
    }
    //所有可移动的武器移动
    public void moveAll(){
        for(int i = 0; i < weapons.length; i++){
            if(weapons[i] instanceof Moveable){
                Moveable m = (Moveable)weapons[i];
                m.move();
            }
        }
    }

}
