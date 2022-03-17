import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class AVLTree{

	private Node root;
	
	private class Node
	{
		int data;
		Node left;
		Node right;
		int height;
		Node(int data)
		{
			this.data=data;
			left=null;
			right=null;
			height=0;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTree avl=new AVLTree();
		avl.create();
		avl.displayAsTree(avl.root);
		
	}
	void create() {
		// TODO Auto-generated method stub
		System.out.print("Enter values and press enter or -1 to stop");
		Scanner sc=new Scanner(System.in);
		int inpt=sc.nextInt();
		while(inpt!=-1)
		{
		insert(inpt);
		inpt=sc.nextInt();
		}
		sc.close();
	}
	
	void insert(int ele)
	{
		root=insert(root,ele);
	}

	
	Node insert(Node node,int ele)
	{
		int lh=-1,rh=-1;
		if(node==null)
		{
			Node temp=new Node(ele);
			return temp;
		}
		if(ele<node.data)node.left=insert(node.left, ele);
		else if(ele>node.data)node.right=insert(node.right,ele);
		else if(ele==node.data) return node;
		node.height=height(node);
		//System.out.print("_"+node.height+"_");
		if(node.left!=null) lh=node.left.height;
		if(node.right!=null) rh=node.right.height;
		if(lh-rh==-2 || lh-rh==2 ) balance(node, ele);
		return node;
	}
	
	void balance(Node node,int ele)
	{
		int lh=-1,rh=-1;
		if(node==null) return;
		
		if(node.left!=null) lh=node.left.height;
		if(node.right!=null) rh=node.right.height;
		if(lh-rh==2)
		{
			if(ele<node.left.data) LLRotation(node);
			else if(ele>node.left.data) LRRotation(node);
		}
		else if(lh-rh==-2)
		{
			if(ele>node.right.data) RRRotation(node);
			else if(ele<node.right.data) RLRotation(node);
		}
		//System.out.println("b_"+node.height);
	}
	
	void LLRotation(Node node)
	{
		Node l=node.left;
		Node r=node.right;
		
		int d=node.data;
		node.data=l.data;
		Node temp=new Node(d);
		temp.left=l.right;
		node.right=temp;
		temp.right=r;
		node.left=l.left;
		
//		if(node.right!=null)
//		{
//		int lh=-1,rh=-1;
//		if(node.right.left!=null) lh=node.right.left.height;
//		if(node.right.right!=null) lh=node.right.right.height;
		
		node.right.height=height(node.right);
		node.height=height(node);
//		}
//		else node.height=node.left.height+1;
	}
	
	void RRRotation(Node node)
	{
		Node l=node.left;
		Node r=node.right;
		
		int d=node.data;
		node.data=r.data;
		Node temp=new Node(d);
		temp.left=l;
		node.left=temp;
		node.right=r.right;
		temp.right=r.left;
		
//		if(node.left!=null)
//		{
//		int lh=-1,rh=-1;
//		if(node.left.left!=null) lh=node.left.left.height;
//		if(node.left.right!=null) lh=node.left.right.height;
//		
		node.left.height=height(node.left);
		node.height=height(node);	
//		}
//		else node.height=node.right.height+1;
	}
	void LRRotation(Node node)
	{
		Node l=node.left.right.left;
		Node r=node.left.right.right;
		Node temp=new Node(node.data);
		temp.right=node.right;
		node.right=temp;
		temp.left=r;
		node.data=node.left.right.data;
		node.left.right=l;
		
//		int lh=-1,rh=-1;
//		if(node.left.left!=null) lh=node.left.left.height;
//		if(node.left.right!=null) rh=node.left.right.height;
		node.left.height=height(node.left);
//		lh=rh=-1;
//		if(node.right.left!=null) lh=node.right.left.height;
//		if(node.right.right!=null) rh=node.right.right.height;
		node.right.height=height(node.right);
		node.height=height(node);
	}
	void RLRotation(Node node)
	{
		Node l=node.right.left.left;
		Node r=node.right.left.right;
		Node temp=new Node(node.data);
		temp.left=node.left;
		node.left=temp;
		temp.right=l;
		node.data=node.right.left.data;
		node.right.left=r;
		
		node.left.height=height(node.left);
		node.right.height=height(node.right);
		node.height=height(node);
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
	
	int level()
	{
		return level(root);
	}
	int level(Node node)
	{
		if(node==null) return 0;
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
}
