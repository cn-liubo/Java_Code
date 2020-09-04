package testobjectstream;

import java.io.Serializable;

public class Person implements Serializable {

    private long serialVersionUID = 8475827506471258990L;
    private String name;
    private int age;

    public Person(){

    }
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return this.name+"-"+this.age;
    }

    public String getName() {
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public void eat(){
        System.out.println(this.name+"的吃饭方法");
    }
}
