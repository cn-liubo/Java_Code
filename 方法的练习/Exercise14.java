package exercise;

public class Exercise14 {
	//���һ������ ȥ�������е�0Ԫ��
	public int[] removeElementFromArray(int[] array,int element) {
		//��Ѱԭ������ȥ����ɾ��Ԫ�صĸ���
		int count=0;//��¼��ɾ��Ԫ�صĸ���
		for(int i=0;i<array.length;i++) {
			if(array[i]!=element) {
				count++;
			}
		}
		//ͨ���ҵ���count����һ��������
		int[] newArray=new int[count];
		int index=0;//����������������仯
		//��ԭ�������еķ�ɾ����Ԫ�ش�����������
		for(int i=0;i<array.length;i++) {
			if(array[i]!=0) {
				newArray[index++]=array[i];
			}
		}
		//�������鷵��
		return newArray;
	}

	public static void main(String[] args) {
		Exercise14 e=new Exercise14();
		int[] x=new int[] {1,2,3,0,4,5,0,6,7,8,9};
		int[] result=e.removeElementFromArray(x,0);
		for(int v:result) {
			System.out.println(result);
		}
	}
}
