package liubo;

public class project9 {
	public static void main(String[] args) {
		int twoArray[][]=new int[4][];
		twoArray[0]=new int[1];
		twoArray[1]=new int[2];
		twoArray[2]=new int[3];
		twoArray[3]=new int[4];
		int i,j,k=0;
		for(i=0;i<twoArray.length;i++) {
			for(j=0;j<twoArray[i].length;j++,k++) {
				twoArray[i][j]=k;
			}
		}
		for(i=0;i<twoArray.length;i++) {
			for(j=0;j<twoArray[i].length;j++) {
				System.out.print(twoArray[i][j]+" ");
			}
			System.out.println();
		}
	}
}
