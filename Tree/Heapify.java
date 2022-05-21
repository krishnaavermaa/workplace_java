package tree;
import java.util.Scanner;

public class Heapify extends Heap{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heapify hp=new Heapify();
		hp.create();
		hp.display();
	}
	
	@Override
	void create()
	{
		Scanner sc=new Scanner(System.in);
		int ele;
		System.out.println("Enter size of Heap:");
		n=sc.nextInt();
		H=new int[n+1];
		System.out.println("Enter elements of Heap:");
		for(int i=0;i<=n;i++)
		{
			H[i]=-1;
		}
		H[0]=0;
		for(int i=n;i>0;i--)
		{
			ele=sc.nextInt();
			Insert(ele,i);
		}
		sc.close();
	}
	
	void Insert(int ele,int i)
	{
		H[i]=ele;
		int l=-1,r=-1;
		if(2*i<=n && 2*i+1<=n) 
		{
			l=H[2*i];
			r=H[2*i+1];
		}
		else if(2*i<=n) l=H[2*i];
		//if(l and r exists)
		if(l>=r && ele<l) 
		{
			H[i]=H[2*i];
			Insert(ele,2*i);
		}
		else if(r>l && ele<r)
		{
			H[i]=H[2*i+1];
			Insert(ele,2*i+1);
		}
	}

}
