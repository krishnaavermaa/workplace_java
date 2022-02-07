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
		this.size=size;
		first=0;
		last=0;
		Q=Array.newInstance(clazz,size);
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
		if(cq.isEmpty()==1) System.out.println("Queue empty.");
		if(cq.isFull()==1) System.out.println("Queue full.");
		cq.Display();
	}
	
	void enqueue(T val)
	{
		last++;
		if(last==first)
		{
			System.out.println("Queue full!");
			last--;
		}
		else cq.Q[last]=val;
	}
	
	
}