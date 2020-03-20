package classes;


import java.util.Arrays;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class polynomial implements IPolynomialSolver{

	private  ILinkedList listA = new SLinkedList() ;
	private	 ILinkedList listB = new SLinkedList() ;
	private	 ILinkedList listC = new SLinkedList() ;
	private	 ILinkedList listR = new SLinkedList() ;
	private int sign = 1 ;		
	private class Pair {
		int coeff ;
		int exponent ;

		public  Pair (int coef,int exponen)
		{
			coeff = coef ;
			exponent = exponen ;
		}
	} 
	public void setPolyHelper (ILinkedList list , int[][] terms ) //convert array to list.
	{
		list.clear();// to ensure the polynomial is empty.
		sort(terms);
		
		for(int i =0;i<terms.length;i++)
		{
			if(terms[i][0]!=0)
			{
				Pair temp = new Pair (terms[i][0],terms[i][1]);
				list.add(temp);
			}
		}
		if(list.size()==0) // if all terms equal zero put {0,0} in the polynomial.
		{
			Pair c = new Pair(0,0);
			list.add(c);	
		}
	}
	
	public void setPolynomial(char poly, int[][] terms) {
	poly=Character.toUpperCase(poly) ;
		if(terms == null)
			throw new RuntimeException("Error,you cann't set a polynomial to null"); 
		if(poly == 'A')
		{
			setPolyHelper (listA,terms);
		} 
		else if(poly == 'B') 
		{
			setPolyHelper (listB,terms);
		}
		else if(poly == 'C')
		{
			setPolyHelper (listC,terms);
		}
		else 
			throw new RuntimeException("error invalid input");

	}
	
	
	public String print(char poly) {
		poly = Character.toUpperCase(poly);
		if(! (checkAction(poly) || poly=='R') )
			throw new RuntimeException("error invalid input");
		String res ="";	
		poly = Character.toUpperCase(poly);
		ILinkedList list = set_list(poly);
		if(list.size()==0) // if polynomial is unset .
			return null;
		else if(list.size()>0)
		{	
			for(int i=0;i<list.size();i++)
			{    
				Pair a = new Pair (0,0);  
				a= (Pair) list.get(i);
				 if(a.coeff>0&&i!=0)
						res+=" + ";
				 if(a.coeff==-1&&a.exponent!=0) {
					if(i==0) {
						res+="-";
					}
					else res+=" - "; 
				 }
				if((a.coeff!=1&&a.coeff!=-1)||a.exponent==0) {
					if(a.coeff<-1&&i!=0) {
						res+=" - ";
						res +=  Integer.toString(Math.abs(a.coeff));
						
					}
					else {
						res +=  Integer.toString(a.coeff);
					}
				}
				if(a.exponent !=0)
					res +="x";
				if(a.exponent!=1 && a.exponent !=0 )
				res+="^"+Integer.toString(a.exponent);
			}
		}
		 
			
		
		return res ;
	}

	public void clearPolynomial(char poly) {
		poly=Character.toUpperCase(poly) ;
		
		if(poly == 'A')
		{
			listA.clear();
		}
		else if(poly == 'B')
		{
			listB.clear();
		}
		else if(poly == 'C')
		{
			listC.clear();
		}
		else if(poly == 'R')
		{
			listR.clear();
		}
		else 
			throw new RuntimeException("error invalid input");
	}
	
	public float evaluatePolynomial(char poly, float value) {
		ILinkedList evalute = new SLinkedList() ;
		if(!isSet(poly))
			throw new RuntimeException("error invalid operation");
		 
		evalute=set_list(poly);
		float sum=0;
		for(int i=0;i<evalute.size();i++) {
		Pair a = new Pair (0,0);  
		a= (Pair) evalute.get(i);
		sum+= (float)a.coeff*Math.pow(value, a.exponent);	
		}
		return sum;
	}

	
	public int[][] add(char poly1, char poly2) {
		poly1=Character.toUpperCase(poly1);
		poly2=Character.toUpperCase(poly2);
		listR.clear();
		if(!isSet(poly1) || !isSet(poly2)) //accessing an unset polynomial.
			throw new RuntimeException("error invalid operation");

		int arr1[][]=changetoarray(set_list(poly1));
		int arr2[][]=changetoarray(set_list(poly2));
		int len1=arr1.length ; 
		int len2=arr2.length;
		int size = len1+len2+1;
		int[][] arrtmp = new int[size][2];
		int i=0,j=0,counter=0;
		while(i<len1 && j<len2)
		{
			Pair a = new Pair(arr1[i][0],arr1[i][1]);
			Pair b =  new Pair(arr2[j][0],arr2[j][1]);
			if(a.exponent > b.exponent) 
			{
				listR.add(a);
				i++;
				arrtmp[counter][0]=a.coeff;
				arrtmp[counter++][1]=a.exponent;
			}
			else if(a.exponent < b.exponent )
			{
				b.coeff*=sign;
				listR.add(b);
				j++;
				arrtmp[counter][0]=b.coeff;
				arrtmp[counter++][1]=b.exponent;
			}
			else
			{
				b.coeff*=sign;
				a.coeff +=b.coeff ;
				if(a.coeff!=0)
				{	
					listR.add(a);
					arrtmp[counter][0]=a.coeff;
					arrtmp[counter++][1]=a.exponent;
				}
				i++;
				j++;
			}
	
		}
		while(i<len1)
		{
			Pair a =  new Pair(arr1[i][0],arr1[i][1]);
			if(a.coeff==0)
				{
					i++;
					continue;
				}
			listR.add(a);
			i++;
			arrtmp[counter][0]=a.coeff;
			arrtmp[counter++][1]=a.exponent;
		}
		while(j<len2)
		{			
			Pair b =  new Pair(arr2[j][0],arr2[j][1]);
			b.coeff*=sign;
			if(b.coeff==0)
				{
					j++;
					continue;
				}
			listR.add(b);
			j++;
			arrtmp[counter][0]=b.coeff;
			arrtmp[counter++][1]=b.exponent;
		}
		if(listR.size()==0)
		{
			Pair c = new Pair(0,0);
			listR.add(c);
			arrtmp[counter][0]=0;
			arrtmp[counter++][1]=0;
		}
		int[][] terms = Arrays.copyOfRange(arrtmp, 0, counter);	
		return terms ;
	}

	
	public int[][] subtract(char poly1, char poly2) {
		sign=-1 ;
		int[][] terms = add(poly1,poly2);
		sign=1;
		return terms;
	}

	public int[][] multiply(char poly1, char poly2) {
		listR.clear();
		if(!isSet(poly1) || !isSet(poly2)) //accessing an unset polynomial.
			throw new RuntimeException("error invalid operation");
		int arr1[][]=changetoarray(set_list(poly1));
		int arr2[][]=changetoarray(set_list(poly2));
		int ans[][]=new int [arr1.length*arr2.length][2];
		int counter=0,k=0;
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				ans[k][0]=arr1[i][0]*arr2[j][0];
				ans[k][1]=arr1[i][1]+arr2[j][1];
				k++;
			}
		}
		
		int solution[][]=new int [ans.length][2];
		for(int i=0;i<ans.length;i++) {
			for(int j=i+1;j<ans.length;j++) {
				if((ans[i][1]==ans[j][1])&&ans[j][0]!=0) {
					ans[i][0]+=ans[j][0];
					ans[j][0]=0;
				}
			}
			if(ans[i][0]!=0) {
				solution[counter][0]=ans[i][0];
				solution[counter][1]=ans[i][1];
				counter++;
			}
		}
		if(counter==0) // means that all terms are 0 .
		{
			solution[counter][0]=0;
			solution[counter++][1]=0;
		}
		int[][] terms = Arrays.copyOfRange(solution,0,counter) ;
		setPolyHelper(listR,terms);
		sort(terms);
		return terms;
	}
	
	public	void sort(int arr[][])
	{
		int temp;
		for(int i=0;i<arr.length;i++) 
		{
			for(int j=i+1;j<arr.length;j++)
			{		
				if(arr[i][1]<arr[j][1])
				{
		            temp=arr[j][1];
		            arr[j][1]=arr[i][1];
		            arr[i][1]=temp;
		            temp=arr[j][0];
		            arr[j][0]=arr[i][0];
		            arr[i][0]=temp;
		        }
			}
		}
	}
	
	public boolean checkAction(char poly)
	{
		poly=Character.toUpperCase(poly) ;
		if(poly=='A'||poly=='B'||poly=='C')
			return true ;
		
		return false ;
	}
	
	public boolean isSet(char poly) {
		poly =Character.toUpperCase(poly) ;
		if(poly=='A')
		{
			if(listA.isEmpty())
				return false ;
			else 
				return	true ;
		}
		if(poly=='B')
		{
			if(listB.isEmpty())
				return false ;
			else 
				return	true ;
		}
		if(poly=='C')
		{
			if(listC.isEmpty())
				return false ;
			else 
				return	true ;
		}
		
		else
			return false ;
	}
	 
	public int [][] changetoarray(ILinkedList list){
		Pair a = new Pair (0,0);  
		int arr[][]=new int[list.size()][2];
		for(int i=0;i<list.size();i++) {
			a= (Pair) list.get(i);
			arr[i][0]=a.coeff;
			arr[i][1]=a.exponent;
		}
		return arr ;
	 }	
		
	public ILinkedList set_list(char poly) {
		poly = Character.toUpperCase(poly);	
			if(poly == 'A')
			{
				return listA;
			}
			else if(poly == 'B')
			{
				return listB;
			}
			else if(poly=='C') 
			{
				return listC;
			}
			else 
				return listR;
			
		}
}
