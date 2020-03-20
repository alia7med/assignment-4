package Application;

import java.util.Arrays;
import java.util.Scanner;
import classes.polynomial; 
public class UIAppplication {
	
	static  polynomial obj  = new polynomial();
	
	public static void printOptions ()
	{
		System.out.println("Please choose an action");
		System.out.println("-----------------------");
		System.out.println("1 - Set a polynomial variable");
		System.out.println("2 - Print the value of a polynomial variable");
		System.out.println("3 - Add two polynomials");
		System.out.println("4 - Subtract two polynomials"); 
		System.out.println("5 - Multiply two polynomials");
		System.out.println("6 - Evaluate a polynomial at some point");   
		System.out.println("7 - Clear a polynomial variable");
		System.out.println("8 - Back to menu(enter 8 in any character input to back to menu)");
		System.out.println("9 - Close the Program");
		System.out.println("====================================================================");
	}
	public static void print_res(int[][] res)
	{
		System.out.println("The value set in R as follows");
		for(int i =0 ;i<res.length;i++)
		{
			System.out.printf("coeff%d = %d,exponent%d= %d\n",i+1,res[i][0],i+1,res[i][1]);
		}
		System.out.println("====================================================================");
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int x = 0 ;
		while(x!=9)
		{
			printOptions();
			boolean validInput = false ;
			while(!validInput)	
			{
				try {
					System.out.println("Please,Enter your choice :");
					x = in.nextInt() ;
					validInput = true ;
				}
				catch(Exception e)
				{
					in.nextLine(); // swallow token .
					System.out.println("Wrong input,please enter a numeric number.");
				}
			}
			validInput = false ;
			if(x==1)
			{	
					System.out.println("Please,Enter the terms in this form :");
					System.out.println("coeff1,exponent1\ncoeff2,exponent2.....");
					System.out.println("When you finish entering inputs,Please enter \"ok\"\nNote:any wrong input will not be considered.");
					int  arr[][]=new int[1000][2];
					int counter=0;
					String s="";
					s=in.next();
					
					while(!s.equalsIgnoreCase("ok") ) {
						
						int need ;
						boolean out=false;
						need=s.indexOf(",");
						for(int i=need-1;i>0;i--) {
							if(!Character.isDigit(s.charAt(i))) {
								out=true;
							}
						}
						for(int i=s.length()-1;i>need;i--) {
							if(!Character.isDigit(s.charAt(i))&&s.charAt(i)!='-') {
								out=true;
							}
						}
						
						if(out) {
							System.out.println("Wrong input");
						}
						
						else if(!s.contains(",")||(!Character.isDigit(s.charAt(0))&&s.charAt(0)!='-')||!Character.isDigit(s.charAt(s.length()-1))) {
							if(s.equalsIgnoreCase("ok")) {}
							else
							System.out.println("Wrong input");
							
						}
						else {
							int coeff=0,exp=0,pos=1;
							
							
							int stop=0;
							if(s.charAt(0)=='-'){
								stop++;
							}
							for(int i=need-1;i>=stop;i--) {
								coeff+=(s.charAt(i)-'0')*pos;
								pos*=10;
								
							}
							stop=need;
							if(s.charAt(need+1)=='-') {
								stop++;
							}
							pos=1;
							
							for(int i=s.length()-1;i>stop;i--) {
								exp+=(s.charAt(i)-'0')*pos;
								pos*=10;
								
							} 
							//in case of negative coeff
							if(s.charAt(0)=='-'){
								coeff*=-1;
							}
								arr[counter][0]=coeff;
								//in case of negative exponent
								if(s.charAt(need+1)=='-') {
									exp*=-1;
								}
								arr[counter][1]=exp;
								counter++;
								
						}
						s=in.next();
					}
					int[][] terms=Arrays.copyOfRange(arr,0,counter);
					while(!validInput)
					{
						try {
						System.out.println("Insert the variable name to set these terms in  : A , B or C");
						char poly = in.next().charAt(0);
						if(poly-'0'==8)
							break ;
						poly = Character.toUpperCase(poly);
							obj.setPolynomial(poly, terms);
							validInput = true ;
						}
						catch(Exception e ) 
							{
							in.nextLine();
							System.out.println("please,insert a valid character");
						}
					}
					System.out.println("====================================================================");
			}
			else if (x==2)
			{
				while(!validInput)
				{
				try {
					System.out.println("Please,Enter a variable:A , B ,C or R");
					char poly = in.next().charAt(0);
					if(poly-'0'==8)
						break ;
					System.out.println("the Value in "+poly+": "+obj.print(poly));
					validInput = true ;
				 }
				catch(Exception e) {
					in.nextLine();
					System.out.println("please,insert a valid character");
				   }
				}
				System.out.println("====================================================================");
			}
			else if (x==3)
			{
				while(!validInput)
				{
					try {
					System.out.println("Insert the first operand variable name: A, B or C");
					char poly1 = in.next().charAt(0);
					if(poly1-'0'==8)
						break ;
					System.out.println("Insert the second operand variable name: A, B or C");
					char poly2 = in.next().charAt(0);
					if(poly2-'0'==8)
						break ; 	
					int[][] res = obj.add(poly1,poly2);
					print_res(res);
					validInput = true ;
					}
					catch(Exception e ){
						in.nextLine();
						System.out.println("Invalid operation----please insert a valid one. ");
					}
				}
				System.out.println("====================================================================");
			}
			else if (x==4)
			{
				while(!validInput)
				{
					try {
					System.out.println("Insert the first operand variable name: A, B or C");
					char poly1 = in.next().charAt(0);
					if(poly1-'0'==8)
						break ;
					System.out.println("Insert the second operand variable name: A, B or C");
					char poly2 = in.next().charAt(0);
					if(poly2-'0'==8)
						break ;
					int[][] res = obj.subtract(poly1,poly2);
					print_res(res);
					validInput = true ;
					}
					catch(Exception e ){
						in.nextLine();
						System.out.println("Invalid operation----please insert a valid one. ");
					}
				}
				System.out.println("====================================================================");
			}
			else if (x==5)
			{
				while(!validInput)
				{
					try {
					System.out.println("Insert the first operand variable name: A, B or C");
					char poly1 = in.next().charAt(0);
					if(poly1-'0'==8)
						break ;
					System.out.println("Insert the second operand variable name: A, B or C");
					char poly2 = in.next().charAt(0);
					if(poly2-'0'==8)
						break ;
					int[][] res = obj.multiply(poly1,poly2);
					print_res(res);
					validInput = true ;
					}
					catch(Exception e ){
						in.nextLine();
						System.out.println("Invalid operation----please insert a valid one. ");
					}
				}
				System.out.println("====================================================================");
			}
			else if (x==6)
			{
				float value = 0 ;
				while(!validInput)
				{
					try {
						System.out.println("insert the value :");
						 value = in.nextFloat();
						 validInput = true ;
					}
					catch(Exception e ){
						in.nextLine();
						System.out.println("Wrong input,please insert a numeric nubmer");
					}
				}
				validInput = false ;
				while(!validInput){
				
					try
					{
				System.out.println("insert the variable:A ,B ,C or R");
				char poly = in.next().charAt(0);
				if(poly-'0'==8)
					break ;
				System.out.println("THe result is : "+obj.evaluatePolynomial(poly, value)) ;
					validInput = true ;
					}
				catch(Exception e ){
					in.nextLine();
					System.out.println("please,insert a valid character");
				}
			   }
				System.out.println("====================================================================");
			}
			else if (x==7)
			{
				while(!validInput)
				{
					try {
						System.out.println("Please,insert a variable:A ,B ,C or R");
						char poly = in.next().charAt(0);
						if(poly-'0'==8)
							break ;
						obj.clearPolynomial(poly);
						validInput = true ;
						}
					catch(Exception e)
					{
						in.nextLine();
						System.out.println("please,insert a valid character");
					}
				}
				System.out.println("====================================================================");
			}
			else if(x==8)
				continue ;
			else if(x==9)
				break;
			else
				System.out.println("Please,insert a valid choice");
		}	
		System.out.println("\t<thanks for using our app.>\n\t<bye ^--^>");
		in.close();
		
	}

}
