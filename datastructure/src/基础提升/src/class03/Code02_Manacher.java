package class03;

public class Code02_Manacher {

	/*public static int[] manacher(String s) {
		//1221 -> #1#2#2#1#
		char[] str;
		int[] pArr = new int[str.length];
		int R = 0;
		int C = 0;
		for (int i = 0; i < str.length; i++) {
			if(i在R外部) {
				从i开始往两边暴力扩，R变大
			} else {
				if(i回文区域彻底在L...R内) {
					pArr[i] = 某个O(1)表达式
				} else if(i回文区域有一部分在L...R外) {
					pArr[i] = 某个O(1)表达式
				} else {//i回文区域和L，R的左边界压线
					从R之外的字符开始，往外扩，然后确定pArr[i]的答案
					第一步扩失败了，R不变
					否则，R变大
				}
			}
		}
	}*/

	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	public static int maxLcpsLength(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] charArr = manacherString(str);//1221 -> #1#2#2#1#
		int[] pArr = new int[charArr.length];//回文半径数组
		int C = -1;//中心点位置
		int R = -1;//回文右边界的再往右一个位置，最右的有效区是R-1位置
		int max = Integer.MIN_VALUE;//扩出来的最大值
		for (int i = 0; i != charArr.length; i++) {//每一个位置都求回文半径
			//i至少的回文区域，先给pArr[i]
			pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;

			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			if (i + pArr[i] > R) {
				R = i + pArr[i];
				C = i;
			}
			max = Math.max(max, pArr[i]);
		}
		return max - 1;//原串的长度=处理串半径-1
	}

	public static void main(String[] args) {
		String str1 = "abc1234321ab";
		System.out.println(maxLcpsLength(str1));
	}

}
