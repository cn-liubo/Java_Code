package class08;

public class Code01_Hanoi {

	public static void hanoi(int n) {
		if (n > 0) {
			func(n, n, "left", "mid", "right");
		}
	}

	//1~i圆盘目标是from -> to，other是另一个
	public static void func(int i, String start, String end, String other) {
		if(i == 1) {
			System.out.println("Move 1 from " + start + " to " + end);
		} else {
			func(i - 1, start, other, end);
			System.out.println("Move " + i + " from " + start + " to " + end);
			func(i - 1, other, end, start);
		}
	}

	public static void func(int rest, int down, String from, String help, String to) {
		if (rest == 1) {
			System.out.println("move " + down + " from " + from + " to " + to);
		} else {
			func(rest - 1, down - 1, from, to, help);
			func(1, down, from, help, to);
			func(rest - 1, down - 1, help, from, to);
		}
	}

	public static void main(String[] args) {
		int n = 3;
		hanoi(n);
	}

}
