import java.util.*;

class Stack
{
	private int top=-1;
	private int size;
	private int []stack;
	
	Stack(int size)
	{
		this.size=size;
		stack=new int[size];
	}
	
	int peek()
	{
		if(top!=-1) return stack[top];
		return -1;
	}
	
	void push(int val)
	{
		if(top==size) System.out.println("Stack Overflow!!");
		else
		{
			top++;
			stack[top]=val;
		}
	}
	
	int pop()
	{
		if(top==-1)
		{
			System.out.println("Stack Underflow!!");
			return -1;
		}
		return stack[top--];
	}
	
	void clearAll()
	{
		top=-1;
	}	
}