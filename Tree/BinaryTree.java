import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree {
	private Node root;

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
		System.out.println("tree height: "+bt.height());
		System.out.println("nodes count: "+bt.count());
		bt.display();
		bt.displayAsTree();
		//bt.inorder();
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
		System.out.println();
	}
	
	int level()
	{
		return level(root);
	}
	int level(Node node)
	{
		int left=0,right=0;
		if(node.left!=null)
			left=level(node.left);
	    if(node.right!=null)
	    	right=level(node.right);
		if(left>right) return left+1;
		if(right>left) return right+1;
		return left+1;
	}
	
	int height()
	{
		return height(root);
	}
	
	int height(Node node)
	{
		return level(node)-1;
	}
	
	void display()
	{
		Queue <Node>q=new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null) q.offer(temp.left);
			if(temp.right!=null) q.offer(temp.right);
		}
		System.out.println();
	}
	
	void inorder()
	{
		System.out.println("Inorder:");
		inorder(root);
	}
	void inorder(Node node)
	{
		if(node.left!=null) inorder(node.left);
		System.out.print(node.data+" ");
		if(node.right!=null) inorder(node.right);
	}
	
	void preorder()
	{
		System.out.println("preorder:");
		preorder(root);
	}
	void preorder(Node node)
	{
		if(node.left!=null) preorder(node.left);
		if(node.right!=null) preorder(node.right);
		System.out.print(node.data+" ");
	}
	
	void postorder()
	{
		System.out.println("postorder:");
		postorder(root);
	}
	void postorder(Node node)
	{
		System.out.print(node.data+" ");
		if(node.left!=null) postorder(node.left);
		if(node.right!=null) postorder(node.right);
	}
	
	int count()
	{
		return count(root);
	}
	int count(Node node)
	{
		int x=0,y=0;
		if(node.left!=null) x=count(node.left);
		if(node.right!=null) y=count(node.right);
		return x+y+1;
	}
	
	void displayAsTree()
	{
		displayAsTree(root);
	}
	public void displayAsTree(Node node)
	{
		int height=height();
		//System.out.println(height);
		int maxNodes=(int)Math.pow(2,height+1)-1;
		
		Queue<Node> q=new LinkedList<>();
		Queue<Node> q2=new LinkedList<>();
		
		q.offer(node);
		
		Node temp,fake=new Node(-1);
		while(q2.size()<maxNodes)
		{
			temp=q.poll();
			q2.offer(temp);
			
			if(temp==fake)
			{
				q.offer(fake);
				q.offer(fake);
			}
			else
			{
				if(temp.left!=null) q.offer(temp.left);
				else q.offer(fake);
				if(temp.right!=null) q.offer(temp.right);
				else q.offer(fake);
			}
		}
		
		System.out.println();
		
		int counter;
		int h=counter=height;
		while(counter-->=0)
		{
			int l=(int)Math.pow(2, height-h);
			int k=(int)Math.pow(2, h);
			//System.out.print("log "+h+" "+l+" "+k);
			int space=0;
			for(int i=1;i<=h+1;i++)
				space=space*2+1;
			for(int i=1;i<=l;i++)
			{
				if(i==1)
					for(int j=0;j<space-k;j++)
						System.out.print(" ");
				else
					for(int j=0;j<space;j++)
						System.out.print(" ");
				Node data=q2.poll();
				if(data!=null && data.data!=-1)
					System.out.print(data.data);
				else System.out.print(" ");
			}
			System.out.println();
			System.out.println();
			h--;
		}
	}
	


}
