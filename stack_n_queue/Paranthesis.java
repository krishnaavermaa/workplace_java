package stack_n_queue;
import java.util.Scanner;

class Paranthesis//using stack
{
	public static void main(String args[])
	{
		System.out.println("Enter an expression.");
		String exp=(new Scanner(System.in)).next();
		char[] stack=new char[exp.length()];
		int top=-1;
		TAG:
		for(int i=0;i<exp.length();i++)
		{
			char c=exp.charAt(i);
			if(c=='(' || c=='{' || c=='[')
			{
				top++;
				stack[top]=c;
			}
			else if(c==')' || c=='}' || c==']')
			{
				if(top<-1){
				System.out.println("wrong paranthesis placement found");
				break;
				}
				else{
					switch(c)
					{
						case ')':
							if(stack[top]=='(') top--;
							else break TAG;
							break;
						case '}':
							if(stack[top]=='{') top--;
							else break TAG;
							break;
						case ']':
							if(stack[top]=='[') top--;
							else break TAG;		
					}
				}
			}
		}
		if(top!=-1) System.out.println("wrong paranthesis placement found");
		else System.out.println("paranthesis are in balance");
	}
}