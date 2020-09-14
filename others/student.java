package liubo;

public class student {
	String name,stuNumber;
	double score1,score2,score3;
	
	void set1(String s1,String s2) {
		name=s1;
		stuNumber=s2;
		System.out.println(name+""+stuNumber);
	}
	double setScore(double d1,double d2,double d3) {
		double d;
		score1=d1;
		score2=d2;
		score3=d3;
		d=d1+d2+d3;
		return d;
	}
}
