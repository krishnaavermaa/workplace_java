package stack_n_queue;
import java.util.*;
import java.lang.reflect.Array;

class Queue<T>
{
	private int size;
	private int first=-1;
	private int last=-1;
	private T []Q;
	
	Queue(int size, Class<T> clazz)
	{
		this.size=size;
		Q=(T[])Array.newInstance(clazz,size);
	}
	
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of Queue");
		int sz=sc.nextInt();
		Queue<Integer> q=new Queue<>(sz,Integer.class);
		System.out.print("\nPress 1 to enqueue element or 0 to dequeue element or -1 to stop!\t");
		int ch=sc.nextInt();
		while(ch!=-1)
		{
			if(ch==1)
			{
				System.out.print("Enter an Element: ");
				q.enqueue(sc.nextInt());
			}
			if(ch==0) q.dequeue();	
			System.out.print("\nPress 1 to enqueue element or 0 to dequeue element or -1 to stop!\t");
			ch=sc.nextInt();			
		}
		if(q.isEmpty()==1) System.out.println("Queue empty.");
		if(q.isFull()==1) System.out.println("Queue full.");
		q.Display();
	}
	
	void enqueue(T val)
	{
		if(last==size-1) System.out.println("Queue full!");
		else if(last<size-1) Q[++last]=val;
	}
	T dequeue()
	{
		if(first==last) System.out.println("Queue Empty!");
		else
		{
			return Q[++first];
		}
		return null;
	}
	
	int isEmpty()
	{
		if(first==last) return 1;
		else return 0;
	}
	
	int isFull()
	{
		if(last==size-1)  return 1;
		else return 0;
	}
	
	void Display()
	{
		System.out.print("[ ");
		for(int i=first+1; i<=last;i++)
			System.out.print(Q[i]+" ");
		System.out.print("]");
	}
}