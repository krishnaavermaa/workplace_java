import java.util.Scanner;
import java.lang.reflect.Array;

class CircularQueue<T>
{
	private int size;
	private int first;
	private int last;
	private T []Q;
	CircularQueue(Class clazz,int size)
	{
		this.size=size+1;
		first=0;
		last=0;
		Q=(T[])Array.newInstance(clazz,this.size);
	}
	
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter size of queue: ");
		int size=sc.nextInt();
		CircularQueue<Integer> cq=new CircularQueue<>(Integer.class,size);
		System.out.print("\nPress 1 to enqueue element or 0 to dequeue element or -1 to stop!\t");
		int ch=sc.nextInt();
		while(ch!=-1)
		{
			if(ch==1)
			{
				System.out.print("Enter an Element: ");
				cq.enqueue(sc.nextInt());
			}
			if(ch==0) cq.dequeue();	
			System.out.print("\nPress 1 to enqueue element or 0 to dequeue element or -1 to stop!\t");
			ch=sc.nextInt();			
		}
		//if(cq.isEmpty()==1) System.out.println("Queue empty.");
		//if(cq.isFull()==1) System.out.println("Queue full.");
		cq.Display();
	}
	
	void enqueue(T val)
	{
		int check=last-first;
		//if(check<0) check=check*-1;
		if(check==-1 || check==size-1) System.out.println("Queue full!");
		else
		{
			if(last==size-1) last=-1;
			Q[++last]=val;
		}
	}
	
	//@Nullable
	T dequeue()
	{
		if(first==last)
		{
			System.out.println("Queue empty!");
			return null;
		}
		first++;
		if(first==size) first=0;
		T temp=Q[first];
		Q[first]=null;
		return temp;
	}
	
	void Display()
	{
		int j=first;
		System.out.print("[ ");
		while(j!=last)
		{
			if(j==size-1) j=-1;
			System.out.print(Q[++j]+" ");
		}
		System.out.print("]");
	}
	
}