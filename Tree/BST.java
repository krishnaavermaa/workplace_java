package tree;
import java.util.Scanner;


public class BST {

	private Node root;
	private class Node
	{
		int data;
		Node left;
		Node right;
		Node(int data)
		{
			this.data=data;
			left=null;
			right=null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST bst=new BST();
		Scanner sc=new Scanner(System.in);
		bst.create();
		bst.display();
//		System.out.println("Enter an element to insert");
//		bst.insert(sc.nextInt());
//		bst.display();
//		System.out.println("Enter an element to be searched");
//		bst.search(sc.nextInt());
		System.out.println("Enter an element to be deleted");
		bst.delete(sc.nextInt());
		bst.display();
		
		
		
	}
	
	void create()
	{
		System.out.print("Enter values and press enter or -1 to stop");
		Scanner sc=new Scanner(System.in);
		int inpt=sc.nextInt();
		while(inpt!=-1)
		{
		insert(inpt);
		inpt=sc.nextInt();
		}
	}
	
	void insert(int ele)
	{
		Node parentnode=null;
		insert(ele,root,parentnode);
	}
	void insert(int ele,Node node,Node pnode)
	{
		if(node==null && pnode==null) root=new Node(ele);
		else if(node==null)
		{
			node=new Node(ele);
			if(ele<pnode.data) pnode.left=node;
			else if(ele>pnode.data) pnode.right=node;
		}
		else if(ele==node.data) return;
		else if(ele<node.data) insert(ele,node.left,node);
		else if(ele>node.data) insert(ele,node.right,node);
	}
	
	void search(int key)
	{
		search(key,root,1);
	}
	void search(int key,Node node,int level)
	{
		if(node==null) System.out.println(key+" not found");
		else if(key==node.data) System.out.println(key+" found at level "+level);
		else if(key<node.data) search(key,node.left,level+1);
		else if(key>node.data) search(key,node.right,level+1);
	}
	
	Node inPre(Node node)
	{
		if(node.right==null) return node;
		while(node.right!=null) node=node.right;
		return node;
	}
	Node inSuc(Node node)
	{
		if(node.left==null) return node;
		while(node.left!=null) node=node.left;
		return node;
	}
	
	void delete(int key)
	{
		Node pnode=null;
		delete(key,root,pnode);
	}
	void delete(int key,Node node,Node pnode)
	{
		if(node==null) System.out.println("Not Found");
		else if(key<node.data) delete(key, node.left, node);
		else if(key>node.data) delete(key, node.right, node);
		else if(node.data==key)
		{
			if(node.left==null && node.right==null) 
			{
				if(node==root) root=null;
				else if(key<pnode.data) pnode.left=null;
				else if(key>pnode.data) pnode.right=null;
			}
			else if(count(node.left)>count(node.right)) 
			{
				Node tmp=inPre(node.left);
				node.data=tmp.data;
				delete(node.data,node.left,node);
			}
			else
			{
				Node tmp=inSuc(node.right);
				node.data=tmp.data;
				delete(node.data,node.right,node);
			}
		}
	}
	
	int count(Node node)
	{
		if(node==null) return 0;
		int x=0,y=0;
		if(node.left!=null) x=count(node.left);
		if(node.right!=null) y=count(node.right);
		return x+y+1;
	}
	
	
	
	void display()
	{
		display(root);
		System.out.println();
	}
	void display(Node node)
	{
		if(node.left!=null) display(node.left);
		System.out.print(node.data+" ");
		if(node.right!=null) display(node.right);
	}

}
