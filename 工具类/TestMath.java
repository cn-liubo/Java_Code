package 工具类;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;

public class TestMath {

    //设计一个方法 用来就散给定数字的阶乘
    public BigInteger factorial(int num){
        BigInteger result = new BigInteger("1");
        for(int i = 1 ;i <= num ;i++){
            result = result.multiply(new BigInteger(i + ""));
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(Math.ceil(1.4));//1.0
        System.out.println(Math.floor(1.4));//1.0
        System.out.println(Math.rint(1.4));//1.0
        System.out.println(Math.round(1.4));//1.0
        System.out.println(Math.sqrt(16));//4.0

        Random r = new Random();
        int value1 = r.nextInt();//随机产生一个整数
        System.out.println(value1);//范围 -2147483648 ~ 2147483646

        int value2 = r.nextInt(10);
        System.out.println(value2);//范围 [0 - 10)

        float v = r.nextFloat();
        System.out.println(v);//范围 [0.0 - 1.0)

        //范围5.0 - 10.9
        float f = r.nextInt(6) + 5 + r.nextFloat();
        System.out.println(f);
        double d = (Math.random()*6)+5;
        System.out.println(d);

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());//数据库表格主键 primary key

        BigDecimal bd = new BigDecimal("123.456");
        //小数点之后保留两位  按照向下取整的方式进行截取
        bd = bd.setScale(2,BigDecimal.ROUND_DOWN);
        System.out.println(bd);

        DecimalFormat df = new DecimalFormat("000.###");//0表示必须有 #表示可有可无  四舍五入原则
        String value = df.format(123.456789);
        System.out.println(value);

        //创建对象 调用计算阶乘的方法
        TestMath tm = new TestMath();
        BigInteger bi = tm.factorial(6);
        System.out.println(bi.toString());
    }
}
