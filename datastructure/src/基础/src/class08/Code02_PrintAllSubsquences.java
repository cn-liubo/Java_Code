package class08;

import java.util.ArrayList;
import java.util.List;

public class Code02_PrintAllSubsquences {

	public static void printAllSubsquence(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0);
	}

	//当前来到i位置，要和不要，走两条路
	//res之前的选择，所形成的列表，是str
	public static void process(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
			return;
		}
		process(chs, i + 1);//要当前字符的路
		char tmp = chs[i];
		chs[i] = 0;
		process(chs, i + 1);//不要当前字符的路
		chs[i] = tmp;
	}
	
	public static void function(String str) {
		char[] chs = str.toCharArray();
		process(chs, 0, new ArrayList<Character>());
	}

	//当前来到i位置，要和不要，走两条路
	//res之前的选择，所形成的列表
	public static void process(char[] chs, int i, List<Character> res) {
		if(i == chs.length) {
			printList(res);
			return;
		}
		List<Character> resKeep = copyList(res);
		resKeep.add(chs[i]);
		process(chs, i+1, resKeep);//要当前字符的路
		List<Character> resNoInclude = copyList(res);
		process(chs, i+1, resNoInclude);//不要当前字符的路
	}
	
	public static void printList(List<Character> res) {
		// ...;
	}
	
	public static List<Character> copyList(List<Character> list){
		return null;
	}
	

	public static void main(String[] args) {
		String test = "abc";
		printAllSubsquence(test);
	}

}
