package 练习;

public class prime {

    public static int is_prime(int n) {
        int j = 0;
        for (j = 2; j < n; j++) {
            if (n % j == 0) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args){
        int i = 0;
        int count = 0;
        for (i = 100; i < 200; i++) {
            if (1 == is_prime(i)) {
                count++;
                System.out.print(" "+i);
            }
        }
        System.out.println("\ncount = "+count);
    }
}
