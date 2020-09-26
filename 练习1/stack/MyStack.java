package 练习.stack;

public class MyStack {

    private Object[] array;
    private int top;//栈顶指针

    public MyStack(){
        array = new Object[5];
    }
    public MyStack(int length) {
        array = new Object[length];
    }

    public boolean push(Object element){
        if(top == array.length){
            return false;
        }
        array[top] = element;
        top++;
        return true;
    }

    public Object pop(){
        if(top == 0){
            return Integer.MAX_VALUE;
        }
        Object temp = array[top - 1];
        array[top - 1] = null;
        top--;
        return temp;
    }
    public void print(){
        for(int i = 0; i < top; i++){
            System.out.print(array[i]);
        }
        System.out.println();
    }

}
