package linkedList;

import java.util.Scanner;

public class temp {

	double v1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		temp tmp=new temp();
		//int counter=10*12;
		//tmp.calculate(1000,35*12,12*10,1);
		tmp.calculate(1000,12*10,1);
		System.out.println("v1="+tmp.v1);
		double a=tmp.v1*Math.pow((1+0.0483/12.0),25*12);
		System.out.println("v2="+a);
		
		
	}
	void calculate(double P,int counter,int i)
	{
		double a=P+P*(0.0483/12.0);
		
		if(counter==0) 
		{
			v1=a;
			counter--;
		}
		if(counter>0) 
		{
			System.out.println(i+"_"+a);
			calculate(a+1000,--counter,++i);
		}
	}
//	void calculate(double P,double t,int counter,int i)
//	{
//		counter--;
//		double a=P*Math.pow((1+0.0483/12.0),t);
//		System.out.println(i+"_"+a);
//		if(counter==0) 
//		{
//			//if(v1!=0)
//			//  v2=a;
//			//else if(v1==0) 
//			v1=a;
//			counter--;
//			//return a;
//		}
//		else if(counter>0) 
//		{
//			//if(v1==0)
//			calculate(a+1000,--t,counter,++i);
//			//else calculate(a,t-(1/12.0),counter);
//		}
//		
//	}

}
