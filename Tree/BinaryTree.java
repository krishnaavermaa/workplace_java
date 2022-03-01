import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree {
	Node root;

	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.create();
	}

	void create()
	{
		Scanner sc=new Scanner(System.in);
		Queue <Node>q;
		System.out.print("Enter root element ");
		root=new Node(sc.nextInt());
		q=new LinkedList<>();
		Node temp;
		q.offer(root);
		while(!q.isEmpty())
		{
			temp=q.poll();
			int data;
			System.out.print("\nEnter left element of "+temp.data+" or -1 ");
			data=sc.nextInt();
			if(data!=-1)
			{
				temp.left=new Node(data);
				q.offer(temp.left);
			}
			System.out.print("\nEnter right element of "+temp.data+" or -1 ");
			data=sc.nextInt();
			if(data!=-1)
			{
				temp.right=new Node(data);
				q.offer(temp.right);
			}
		}
	}

}
