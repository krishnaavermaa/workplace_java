package linkedList;
import java.util.Scanner;

public class temp2 {

	double v1,P;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		temp2 t2=new temp2();
		int target;
		int P;
		int T;
		int H;
		int r=0;
		
		Scanner sc=new Scanner(System.in);
		System.out.print("monthly amt. to invest: ");
		P=sc.nextInt();
		t2.P=P;
		System.out.print("investing periods in yrs.: ");
		T=sc.nextInt();
		System.out.print("holding period in yrs.: ");
		H=sc.nextInt();
		System.out.print("final maturity value: ");
		target=sc.nextInt();
		System.out.println();
		
		
		//int check=0;
		while(true)
		{
			t2.calculate(P,r,12*T,1);
			System.out.println("v1="+t2.v1);
			//if(t2.v1>target) System.out.print(0);
			double a=t2.v1*Math.pow((1+r/1200.0),H*12);
			System.out.println("v2="+a);
			if(a>target) {
				System.out.print("RATE CALCULATED: "+((r-1)>0?(r-1):0));
				break;
			}
			else if(a==target) {
				System.out.print("RATE CALCULATED: "+((r)>0?(r):0));
				break;
			}
			r++;
			System.out.println("\nTRY WITH RATE "+r+"\n");
		}
	}
	void calculate(double p,int r,int t,int i)
	{
		double a=p+p*(r/1200.0);
		
		if(t==0) 
		{
			v1=a;
			t--;
		}
		if(t>0) 
		{
			System.out.println("log."+i+"_"+a);
			calculate(a+P,r,--t,++i);
		}
	}

}
