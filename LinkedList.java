import java.util.*;

class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
		this.data=data;
		//next=null;
		//prev=null;
	}
}

class LinkedList
{
	Node head;
	
	public static void main(String []args)
	{
		LinkedList ll=new LinkedList();
		ll.createLL();
		ll.display();
		ll.displayReverse();
	}
	void createLL()
	{
		Scanner sc=new Scanner(System.in);
		Node p,q;
		System.out.println("Enter an integer element.");
		head=new Node(sc.nextInt());
		head.prev=null;
		head.next=null;
		p=head;
		while(true)
		{
			System.out .print("Enter next element or 'X' to exit\t");
			char c=sc.next().charAt(0);
			if(c=='X' || c=='x') break;
			q=new Node(Integer.parseInt(String.valueOf(c)));
			p.next=q;
			q.next=null;
			q.prev=p;
			p=q;
		}
	}
	void display()
	{
		if(head==null) System.out.println("No element!");
		Node tmp=head;
		while(tmp!=null)
		{
			System.out.print(tmp.data+" ");
			tmp=tmp.next;
		}
		System.out.println();
	}
	void displayReverse()
	{
		if(head==null) System.out.println("No element!");
		Node tmp=head;
		while(tmp.next!=null)
		{
			tmp=tmp.next;
		}
		while(tmp!=null)
		{
			System.out.print(tmp.data+" ");
			tmp=tmp.prev;
		}
		System.out.println();
	}
	
}