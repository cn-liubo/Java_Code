package 属性和方法;

public class Exercise1 {
    //设计一个方法 用来画星星
    //f-->表示方向  f==true 偏左 没有空格      f==false 偏右 有空格
    public void drawStar(int line,boolean f){
//        if(f){//没有空格
//            for(int i=1;i<=line;i++){
//                for(int j=1;j<=i;j++){
//                    System.out.print("*");
//                }
//                System.out.println();
//            }
//        }else{//有空格
//            for(int i=1;i<=line;i++){
//                for(int j=1;j<line-i;j++){
//                    System.out.print(" ");
//                }
//                for(int j=1;j<=i;j++){
//                    System.out.print("*");
//                }
//                System.out.println();
//            }
//        }
        //优化后的 没有代码的冗余
        for(int i=1;i<=line;i++){
            if(!f){//f == false;  偏右  带空格
                for(int j=1;j<=line-i;j++){
                    System.out.print(" ");
                }
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
