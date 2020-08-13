package exercise;

public class Exercise14 {
	//设计一个方法 去掉数组中的0元素
	public int[] removeElementFromArray(int[] array,int element) {
		//找寻原数组中去掉被删除元素的个数
		int count=0;//记录非删除元素的个数
		for(int i=0;i<array.length;i++) {
			if(array[i]!=element) {
				count++;
			}
		}
		//通过找到的count创建一个新数组
		int[] newArray=new int[count];
		int index=0;//控制新数组的索引变化
		//将原来数组中的非删除的元素存入新数组里
		for(int i=0;i<array.length;i++) {
			if(array[i]!=0) {
				newArray[index++]=array[i];
			}
		}
		//将新数组返回
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
