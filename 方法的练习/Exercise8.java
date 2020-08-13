package exercise;

public class Exercise8 {
	//true表示向左      false表示向右
	public void drawStar(int line,boolean b) {
//		if(b) {
//			for(int i=0;i<line;i++) {
//				for(int j=0;j<line-i;j++) {
//					System.out.print("*");
//				}
//				System.out.println();
//			}
//		}
//		else {
//			for(int i=0;i<line;i++) {
//				for(int j1=0;j1<i;j1++) {
//					System.out.print(" ");
//		       }
//				for(int j=0;j<line-i;j++) {
//					System.out.print("*");
//
//				}
//				System.out.println();
//			}
//		}
		for(int i=0;i<line;i++) {
			if(b) {
				for(int j=0;j<line-i;j++) {
					System.out.print("*");
				}
//	    		System.out.print(" ");
			}
			else {
				for(int j=0;j<i;j++) {
					System.out.print(" ");
				}
				for(int j=0;j<line-i;j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}

		
	}
	
	public static void main(String[] args) {
		Exercise8 e=new Exercise8();
		e.drawStar(6,true);
	}

}
