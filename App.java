package com.epam.dharani;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

abstract class New1
{
	String n;
	Integer q;
	Integer w;
	abstract int totalWeight();
}

class Choco extends New1
{
	Choco(String n,int q,int w)
	{
		this.n=n;
		this.q =q;
		this.w = w;
	}
	
	int totalWeight()
	{
		return this.q*this.w;
	}
}

class Swe extends New1
{
	Swe(String n,int q,int w)
	{
		this.n=n;
		this.q =q;
		this.w = w;
	}
	int totalWeight()
	{
		return this.q*this.w;
	}
}

class Can extends New1
{
	Can(String n,int q,int w)
	{
		this.n=n;
		this.q =q;
		this.w = w;
	}
	int totalWeight()
	{
		return this.q*this.w;
	}
}

 
public class App 
{
	static void name_sort(Vector<New1> c1,Vector<New1> c2)
	{
		Vector<Choco> ve=new Vector<Choco>();
		for(New1 n1 : c1)
		{
			if(n1 instanceof Choco)
			{
				Choco ch=(Choco) n1;
				ve.add(ch);
			}
		}
		Comparator<Choco> byname=new Comparator<Choco>() {
			public int compare(Choco ch1, Choco ch2) {
				return ch1.n.compareTo(ch2.n);
			}
		};
		Collections.sort(ve,byname);
		System.out.println("\tFirst gift box : ");
		for(Choco ch:ve)
			System.out.println("->"+ch.n);
		ve.clear();
		for(New1 n1 : c2)
		{
			if(n1 instanceof Choco)
			{
				Choco ch=(Choco) n1;
				ve.add(ch);
			}
		}
		Collections.sort(ve,byname);
		System.out.println("\n\tSecond gift box : ");
		for(Choco ch:ve)
			System.out.println("->"+ch.n);
	}
	
	static void quantity_sort(Vector<New1> c1,Vector<New1> c2)
	{
		Vector<Choco> ve=new Vector<Choco>();
		for(New1 n1 : c1)
		{
			if(n1 instanceof Choco)
			{
				Choco ch=(Choco) n1;
				ve.add(ch);
			}
		}
		Comparator<Choco> byquant=new Comparator<Choco>() {
			public int compare(Choco ch1, Choco ch2) {
				return ch1.q.compareTo(ch2.q);
			}
		};
		Collections.sort(ve,byquant);
		System.out.println("\tFirst gift box : ");
		for(Choco ch:ve)
			System.out.println("->"+ch.n+":"+ch.q);
		ve.clear();
		for(New1 n1 : c2)
		{
			if(n1 instanceof Choco)
			{
				Choco ch=(Choco) n1;
				ve.add(ch);
			}
		}
		Collections.sort(ve,byquant);
		System.out.println("\n\tSecond gift box : ");
		for(Choco ch:ve)
			System.out.println("->"+ch.n+":"+ch.q);
	}
	static void weight_sort(Vector<New1> c1,Vector<New1> c2)
	{
		Vector<Choco> ve=new Vector<Choco>();
		for(New1 n1 : c1)
		{
			if(n1 instanceof Choco)
			{
				Choco ch=(Choco) n1;
				ve.add(ch);
			}
		}
		Comparator<Choco> byweight=new Comparator<Choco>() {
			public int compare(Choco ch1, Choco ch2) {
				return ch1.w.compareTo(ch2.w);
			}
		};
		Collections.sort(ve,byweight);
		System.out.println("\nFirst gift box : ");
		for(Choco ch:ve)
			System.out.println("->"+ch.n+" : "+ch.w+" gms");
		ve.clear();
		for(New1 n1 : c2)
		{
			if(n1 instanceof Choco)
			{
				Choco ch=(Choco) n1;
				ve.add(ch);
			}
		}
		Collections.sort(ve,byweight);
		System.out.println("\n\tSecond gift box : ");
		for(Choco ch:ve)
			System.out.println("->"+ch.n+" : "+ch.w+" gms");
	}
	
	static void search(String cn,Vector<New1> c1,Vector<New1> c2)
	{
		boolean cf1=false,cf2=false;
		for(New1 n1 : c1)
		{
			if(n1 instanceof Can)
			{
				Can c=(Can) n1;
				if(c.n.equals(cn))
				{
					cf1=true;
					break;
				}
			}
		}
		for(New1 n1 : c2)
		{
			if(n1 instanceof Can)
			{
				Can c=(Can) n1;
				if(c.n.equals(cn))
				{
					cf2=true;
					break;
				}
			}
		}
		if(cf1==false && cf2==false)
			System.out.println(cn+" not found in either of boxes ");
		else
		{
			if(cf1)
				System.out.println(cn+" found in gift box 1");
			if(cf2)
				System.out.println(cn+" found in gift box 2");
		}
	}
	
    public static void main( String[] args ) throws IOException
    {
    	Vector<New1> c1=new Vector<New1>();
    	Vector<New1> c2=new Vector<New1>();
    	c1.add(new Choco("Dairy milk",2,15));
    	c1.add(new Choco("Eclairs",10,2));
    	c1.add(new Choco("Five star",5,20));
    	c1.add(new Choco("Munch",1,10));
    	c1.add(new Swe("gulab jamun",1,250));
    	c1.add(new Swe("ladoo",1,150));
    	c1.add(new Swe("jalebi",1,200));
    	c1.add(new Can("Friut candy",20,2));
    	c1.add(new Can("Mangobite",10,2));
    	c1.add(new Can("Kopiko",5,2));
    	
    	c2.add(new Choco("Five star",10,20));
    	c2.add(new Choco("Dairy milk silk",1,100));
    	c2.add(new Choco("Dark chocolate",1,200));
    	c2.add(new Swe("Kaju barfi",2,500));
    	c2.add(new Swe("Motichoor ladoo",1,50));
    	c2.add(new Can("Alpenlibe",20,2));
    	c2.add(new Can("Lollipop",10,2));
    	c2.add(new Can("Skittles",1,20));
    	c2.add(new Can("Gems",1,20));
    	c2.add(new Can("Kopiko",5,2));
    	
    	System.out.println("The contents of gift boxes of two children are :- ");
    	System.out.println("1st gift box");
    	for(New1 n1:c1)
    	{
    		System.out.println("\t"+n1.n);
    	}
    	
    	System.out.println("2nd gift box");
    	for(New1 n1:c2)
    	{
    		System.out.println("\t"+n1.n);
    	}
    	
    	System.out.print("\nTotal weight of the Gift Boxes (in grams) : ");
    	int totalWeight=0;
    	for(New1 n1:c1)
    		totalWeight += n1.totalWeight();
    	for(New1 n1:c2)
    		totalWeight += n1.totalWeight();
    	System.out.println(totalWeight+"\n");
    	
    	
    	int dec=0;
    	BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
    	while(dec!=4)
    	{
	    	System.out.println("\nOptions for sorting the chocolates of children :-");
	    	System.out.println("1) by name");
	    	System.out.println("2) by quantity");
	    	System.out.println("3) by weight");
	    	System.out.println("4) quit menu");
	    	dec=Integer.parseInt(b.readLine());
	    	switch(dec)
	    	{
	    	case 1: System.out.println("Sorted according to names : ");
	    			name_sort(c1,c2);
	    			break;
	    	case 2: System.out.println("Sorted according to quantity : ");
	    			quantity_sort(c1,c2);
	    			break;
	    	case 3: System.out.println("Sorted according to weight : ");
	    			weight_sort(c1,c2);
	    			break;
	    	case 4:break;
	    	default:System.out.println("Invalid option !");
	    	}
    	}
    	String s="yes";
    	while(!s.toLowerCase().equals("no"))
    	{
	    	System.out.println("Enter the candy's name you want to search in gift Boxes : ");
	    	String cn=b.readLine();
	    	search(cn,c1,c2);
	    	System.out.println("Do you want to continue to search candies( type yes/no)");
	    	s=b.readLine();
    	}
    }
}

