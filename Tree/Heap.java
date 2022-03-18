import java.util.Scanner;

public class Heap {

	private int[]H;
	private int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap hs=new Heap();
		hs.create();
		hs.display();
		hs.delete();
		hs.display();
		hs.heapSort();
		
	}
	
	void create()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of heap ");
		n=sc.nextInt();
		H=new int[n+1];
		System.out.println("Enter elements: ");
		H[0]=0;
		for(int i=1;i<=n;i++)
			H[i]=sc.nextInt();
		//int nn=0;
		for(int i=1;i<=n;i++)
		{
			Insert(i);
		}
		sc.close();
	}
	
	void Insert(int i)
	{
		if(i/2==0) return;
		if(H[i]>H[i/2])
		{
			int temp=H[i/2];
			H[i/2]=H[i];
			H[i]=temp;
			Insert(i/2);
		}
		else return;
	}
	
	void display()
	{
		for(int i=1;i<=n;i++)
			System.out.print(H[i]+" ");
		System.out.println();
	}
	
	void delete()
	{
		int temp=H[n],i=1;
		H[n]=H[i];
		H[i]=temp;
		
		n--;
		while(2*i<=n)
		{
			int l=H[2*i],r=-1;
			temp=H[i];
			if(2*i+1<=n) r=H[2*i+1];
			if(l>r && l>H[i])
			{
				H[i]=l;
				H[2*i]=temp;
			}
			else if(r>l && r>H[i])
			{
				H[i]=r;
				H[2*i+1]=temp;
			}
			i++;
		}
	}
	
	void heapSort()
	{
		int A[]=H;
		int nn=n;
		for(int i=1;i<=nn;i++)
		{
			delete();
		}
		for(int i=nn;i>=1;i--)
		{
			System.out.print(A[i]+" ");
		}
		System.out.println();
		
	}
}
