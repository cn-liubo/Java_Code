package exercise;

public class Exercise7 {
	//设计一个方法画星星
//	public void drawStar(int line) {
//		for(int i=0;i<=line;i++) {
//			for(int j=0;j<=line-i;j++) {
//				System.out.print(" ");
//			}
//			for(int j=0;j<=i;j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
//	}
	//f表示方向 true--右      false--左
	public void drawStar(int line,boolean f) {
		if(f){
			for(int i=0;i<=line;i++) {
				for(int j=0;j<=line-i;j++) {
					System.out.print(" ");
				}
				for(int j=0;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		else {
			for(int i=0;i<=line;i++) {
				for(int j=0;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
//	public void drawStar(int line,boolean f) {
//		for(int i=0;i<=line;i++) {
//			if(!f) {
//				for(int j=0;j<=line-i;j++) {
//				System.out.print(" ");
//			    }
//			}
//			else {
//				for(int j=0;j<=i;j++) {
//					System.out.println("*");
//			}
//				System.out.println();
//
//			}
//		}
//	}
	public static void main(String[] args) {
		Exercise7 e=new Exercise7();
		e.drawStar(4,true);
	}
}
