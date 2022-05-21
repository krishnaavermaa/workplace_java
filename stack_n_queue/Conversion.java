package stack_n_queue;
import java.util.Scanner;
import java.lang.reflect.Array;

//works on the assumption that expression is valid
//does not work for unary, logical, bitwise operators and 
//two-charactered operators
class Conversion
{
	public static void main(String[] args)
	{
		Conversion c=new Conversion();
		System.out.println("Enter an infix expression");
		String exp=(new Scanner(System.in).next());
		System.out.println("Enter 1 to convert to prefix OR 2 to convert to postfix");
		int choice=(new Scanner(System.in)).nextInt();
		if(choice==1) System.out.println(c.infixToPrefix(exp));
		else if(choice==2) System.out.println(c.infixToPostfix(exp));
	}
	
	String infixToPrefix(String exp)
	{
		String e="";
		char c;
		int len=exp.length();
		Stack <Character>stack=new Stack<>(Character.class,len);
		/*for(int i=0;i<len;i++)
		{
			stack.push(exp.charAt(i)); 
		}
		exp="";
		char ch;
		for(int i=0;i<len;i++)
		{
			ch=stack.pop();
			System.out.print(ch);
			exp=exp+String.valueOf(ch); 
		}
		stack.clearAll();*/
		
		//code to reverse string exp
		Character[] a=(Character[])Array.newInstance(Character.class,len);
		for(int i=0;i<len;i++) { a[i]=exp.charAt(i); }
		a=stack.reverse(a);
		exp="";
		for(int i=0;i<len;i++) { exp=exp+a[i]; }
		stack.clearAll();
		
		for(int i=0;i<len;i++)
		{
			c=exp.charAt(i);
			System.out.println("_"+c+"_");
			if(isOperand(c))
			{
				e=e+String.valueOf(c);
				System.out.println("operand print");
			}
			else
			{
				int thisCharPrec=newPrecedance(c);
				char ch='\0';
				if(stack.peek()!=null) ch=stack.peek();
				int prevCharPrec=oldPrecedance(ch);
				System.out.println("operator");
				if(thisCharPrec>prevCharPrec)
				{
					stack.push(c);
					System.out.println("push in");
				}
				else if(thisCharPrec==prevCharPrec)
				{
					stack.pop();
					System.out.println("ignored as bracket");
				}
				else if(thisCharPrec<prevCharPrec)
				{
					e=e+String.valueOf(stack.pop());
					System.out.println("print");
					i--;
				}
			}
			stack.displayAll();
		}
		while(stack.peek()!=null) e=e+String.valueOf(stack.pop());
		
		//code to reverse string e
		stack.clearAll();
		len=e.length();
		a=(Character[])Array.newInstance(Character.class,len);
		for(int i=0;i<len;i++) { a[i]=e.charAt(i); }
		a=stack.reverse(a);
		e="";
		for(int i=0;i<len;i++) { e=e+a[i]; }
		return e;
	}
	
	String infixToPostfix(String exp)
	{
		String e="";
		char c;
		int len=exp.length();
		Stack <Character>stack=new Stack<>(Character.class,len);
		for(int i=0;i<len;i++)
		{
			c=exp.charAt(i);
			System.out.println("_"+c+"_");
			if(isOperand(c))
			{
				e=e+String.valueOf(c);
				System.out.println("operand print");
			}
			else
			{
				int thisCharPrec=oldPrecedance(c);
				char ch='\0';
				if(stack.peek()!=null) ch=stack.peek();
				int prevCharPrec=newPrecedance(ch);
				System.out.println("operator");
				if(thisCharPrec>prevCharPrec)
				{
					stack.push(c);
					System.out.println("push in");
				}
				else if(thisCharPrec==prevCharPrec)
				{
					stack.pop();
					System.out.println("ignored as bracket");
				}
				else if(thisCharPrec<prevCharPrec)
				{
					e=e+String.valueOf(stack.pop());
					System.out.println("print");
					i--;
				}
			}
			stack.displayAll();
		}
		while(stack.peek()!=null) e=e+String.valueOf(stack.pop());
		return e;
	}
	
	boolean isOperand(char c)
	{
		if(c>=48 && c<=57 || c>=65 && c<=90 || c>=97 && c<=122) return true;
		return false;
	}
	
	int oldPrecedance(char c)
	{
		
		switch(c)
		{
			case ',': return 1;
			case '=': return 4;
			case '<': 
			case '>': return 4;
			case '+':
			case '-': return 6;
			case '*':
			case '/':
			case '%': return 8;
			case '^': return 11;
			//case '[':
			//case '{':
			case '(': return 12;
			//case ']':
			//case '}':
			case ')': return 0;//exceptional
			case '\0': return -1;
			default: System.out.println("Unknown operator encountered!!");
		}
		return -1;
	}
	
	int newPrecedance(char c)//based on associativity
	{
		//for each case c:
		//if L2R_asso do prec++ else if R2L_asso do prec--
		//if bracket found do prec=0
		//if(c=='/0') return 0;
		switch(c)
		{
			case ',': return 2;//L2R
			case '=': return 3;//R2L
			case '<': 
			case '>': return 5;//L2R
			case '+':
			case '-': return 7;//L2R
			case '*':
			case '/':
			case '%': return 9;//L2R
			case '^': return 10;//R2L
			//case '[':
			//case '{':
			case ')': return 12;//lalalalalala
			//case '[':
			//case '{':
			case '(': return 0;//exceptional 0 assigned
			case '\0': return -1;
			default: System.out.println("Unknown operator encountered!!");
		}
		return -1;
	}
}