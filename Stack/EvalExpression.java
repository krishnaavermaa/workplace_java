import java.util.Scanner;

class EvalExpression
{
	private String exp;
	EvalExpression(String exp)
	{
		this.exp=exp;
	}
	
	public static void main(String []args)
	{
		System.out.println("Enter an expression");
		String exp=(new Scanner(System.in)).next();
		Conversion conv=new Conversion();
		exp=conv.infixToPostfix(exp);
		System.out.println(exp);
		System.out.println();
		EvalExpression ee=new EvalExpression(exp);
		System.out.println(ee.evaluate());
	}
	double evaluate()
	{
		int len=exp.length();
		double res;
		double left,right;
		char c;
		Stack<Double> st=new Stack<>(Double.class,len);
	    for(int i=0;i<len;i++)
		{
			c=exp.charAt(i);
			if(!(new Conversion()).isOperand(c))
			{
				right=st.pop();
				left=st.pop();
				res=calc(left,right,c);
				System.out.println(left+""+c+""+right+"="+res);
				st.push(res);
			}
			else{
				System.out.println("push "+Double.parseDouble(String.valueOf(c)));
				st.push(Double.parseDouble(String.valueOf(c)));
			}
		}
		res=st.peek();
		return res;
	}
	
	
	//@Nullable
	double calc(double left,double right,char operator)
	{
		double result=-1;
		switch(operator)
		{
			//case '^': result=Math.pow(left,right);
			//break;
			//case ',':
			//case '=': left=right;
			//case '<': if(left<right) result=true;
			//else result=false;
			//break;
			//case '>': if(left>right) result=true;
			//else result=false;
			//break;
			case '+': result=left+right;
			break;
			case '-': result=left-right;
			break;
			case '*': result=left*right;
			break;
			case '/': result=left/right;
			break;
			case '%': result=left%right;
			default: System.out.println("unknown operator encountered!!");
		}
		return result;
	}
}