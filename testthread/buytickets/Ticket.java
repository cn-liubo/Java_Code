package testthread.buytickets;

public class Ticket {


    //User类  Ticket类 没有任何的逻辑
    //只是包含一些基本属性
    //一个对象 包含很多属性 增强可读性 类名 属性名 属性类型不一致
    //POJO   JavaBean


    private String start;//起始站名
    private String end;//终点站名
    private Float price;//null 123.4

    public  Ticket(String start,String end,Float price){
        this.start = start;
        this.end = end;
        this.price = price;
    }

    //为了让打印输出是方便 重写toString方法
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(this.start);
        stringBuilder.append("-->");
        stringBuilder.append(this.end);
        stringBuilder.append("：");
        stringBuilder.append(this.price);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }

    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
}
