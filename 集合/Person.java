package 集合;

public class Person implements Comparable<Person>{
    private String name;
    private  int testNum;
    public Person(String name,int testNum){
        this.name = name;
        this.testNum = testNum;
    }

    //重写equal方法  将Person放入set集合中，去掉重复
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Person){
            //obj还原成Person类型
            Person anotherPerson = (Person)obj;
            //this  anotherPerson比较对象中的name属性
            if(this.name.equals(anotherPerson.name)){
                return true;
            }
        }
        return false;
    }
    //重写hashCode方法
    public int hashCode(){
        //两个Person对象的name属性一致，需要让hashCode返回值一致
        return this.name.hashCode();
    }
    //重写toString()方法  让对象打印输出的时候直接输出对象的属性，而不是hashCode码
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append(this.name);
        stringBuilder.append("--");
        stringBuilder.append(this.testNum);
        stringBuilder.append("}");
        return new String(stringBuilder);
        //return stringBuilder.toString();
        //return "{"+this.name+","+this.testNum+"}";
    }
    //如果想要让Person对象存入TreeSet集合内，必须实现接口 重写这个方法
    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);//当前对象name和另一个对象name的comPareTo结果
    }


    public String getName(){
        return this.name;
    }
    public int getTestNum(){
        return this.testNum;
    }
}
