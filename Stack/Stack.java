import java.util.*;
import java.lang.reflect.Array;

class Stack<T>
{
	private int top=-1;
	private int size;
	private T[] stack;
	
	Stack(Class<T> wrapperclass_dot_class,int size)
	{
		this.size=size;
		stack=(T[])Array.newInstance(wrapperclass_dot_class,size);
	}
	
	T peek()
	{
		if(top!=-1) return stack[top];
		return null;
	}
	
	void push(T val)
	{
		if(top==size) System.out.println("Stack Overflow!!");
		else
		{
			top++;
			stack[top]=val;
		}
	}
	
	T pop()
	{
		if(top==-1)
		{
			System.out.println("Stack Underflow!!");
			return null;
		}
		return stack[top--];
	}
	
	void displayAll()
	{
		int t=top;
		System.out.print("[ ");
		for(t=0;t<=top;t++){ System.out.print(stack[t]+" ");}
		System.out.println("]");
			
	}
	
	void clearAll()
	{
		top=-1;
	}	
	
	T[] reverse(T[] arr)
	{
		int len=arr.length;
		for(int i=0;i<len;i++)
		{
			push(arr[i]); 
		}
		for(int i=0;i<len;i++)
		{
			arr[i]=pop();
		}
		return arr;
	}
}