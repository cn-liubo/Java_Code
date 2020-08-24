package 工具类;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestDate {
    public static void main(String[] args){

        Date date = new Date();
        System.out.printf("%tc",date);

//        //返回当前系统时间与计算机元年之间的毫秒差
//        //本初子午线 1970-01-01 00:00:00    东八区 1970-01-01 00:08:00
//        long time = System.currentTimeMillis();
//        System.out.println(time);//1594293065631
//
//
//        Date date1 = new Date(1594293065631L);//3分钟之前的时间
//        Date date2 = new Date();//默认就是当前的系统时间构建的date对象
//        System.out.println(date2);//重写了toString()方法 格林威治格式 Fri Jul 10 08:10:39 CST 2020
//
//        boolean x = date1.before(date2);//date1是否在date2之前
//        boolean y = date2.after(date2);//date1是否在date2之后
//
//        //date对象中应该有一个long的属性 time
//        date1.setTime(1594293648822L);//设置date1的时间 毫秒值
//        long resultTime = date1.getTime();//获取date1的时间 毫秒值
//        System.out.println(x+"--"+y);
//        System.out.println(date1.compareTo(date2));//按照顺序比较  -1:调用的在前，参数在后  1:调用的在后，参数在前
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String s = sdf.format(date2);//通过sdf对象讲date1格式化成描述的样子
//        System.out.println(s);//2020-07-10 08:10:39
//
//
//        Calendar calendar = Calendar.getInstance();//系统当前时间的calender对象
//        calendar.set(Calendar.YEAR,2015);
//        System.out.println(calendar);//java.util.GregorianCalendar[name=value,name=value……]
//        System.out.println(calendar.get(Calendar.YEAR));
//        System.out.println(calendar.get(Calendar.MONTH));//这个month是从0开始计算的
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//
//        TimeZone tz = calendar.getTimeZone();
//        //TimeZone tz = TimeZone.getDefault();
//        System.out.println(tz);
//        System.out.println(tz.getID());//时区对应的号码
//        System.out.println(tz.getDisplayName());//描述时区的名字
    }
}
