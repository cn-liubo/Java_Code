package liubo;

import java.math.*;

public class project17 {
	
public static void main(String[] args) {
	// TODO Auto-generated method stub
	BigInteger sum=new BigInteger("0");
	for(int i=1;i<=59;i+=2) {
		BigInteger mul=new BigInteger("1");
		for(int j=1;j<=i;j++) {
			BigInteger Bigj=BigInteger.valueOf(j);
			mul=mul.multiply(Bigj);
		}
		sum=sum.add(mul);
	}
	System.out.println("1!+3!+5!+7!+...+59!="+sum);
    }
}
