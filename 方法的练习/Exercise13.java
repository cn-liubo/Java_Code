package exercise;

public class Exercise13 {
	//���һ������  ������һ�����鰴���ֵ�����
	//��Ҫ�ṩһ���������  ��Ҫ ����ֵ��ά����
	public int[][] splitArray(int[] array){
		//��Ѱ�������λ��
		int max=array[0];//��¼���ֵ
		int index=0;//��¼���ֵ������λ��
		for(int i=1;i<array.length;i++) {
			if(array[i]>max) {
				max=array[i];
				index=i;
			}
		}
		//ͨ����Ѱ����index�ж������ֵ�ǰ�󳤶�
		int[] newa=new int[index];
		int[] newb=new int[array.length-index-1];
		//�ֱ�����С��������
		for(int i=0;i<newa.length;i++) {
			newa[i]=array[i];
		}
		for(int i=0;i<newb.length;i++) {
			newb[i]=array[(index+1)+i];
		}
		//������С����һ�𷵻�
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
