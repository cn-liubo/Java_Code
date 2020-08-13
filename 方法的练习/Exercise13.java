package exercise;

public class Exercise13 {
	//舍近一个方法  用来将一个数组按最大值出拆分
	//需要提供一个大的数组  需要 返回值二维数组
	public int[][] splitArray(int[] array){
		//找寻最大索引位置
		int max=array[0];//记录最大值
		int index=0;//纪录最大值的索引位置
		for(int i=1;i<array.length;i++) {
			if(array[i]>max) {
				max=array[i];
				index=i;
			}
		}
		//通过找寻到的index判断数组拆分的前后长度
		int[] newa=new int[index];
		int[] newb=new int[array.length-index-1];
		//分别将两个小数组填满
		for(int i=0;i<newa.length;i++) {
			newa[i]=array[i];
		}
		for(int i=0;i<newb.length;i++) {
			newb[i]=array[(index+1)+i];
		}
		//将两个小数组一起返回
//		int[][] result= {newa,newb};
//		return result;
		return new int[][] {newa,newb};
	}
	public static void main(String[] args) {
		Exercise13 e=new Exercise13();
		int[][] x=e.splitArray(1,2,3,9,4,5);
	}
	private int[][] splitArray(int i, int j, int k, int l, int m, int n) {
		// TODO Auto-generated method stub
		return null;
	}
}
