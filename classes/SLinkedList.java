package classes;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class SLinkedList implements ILinkedList{

	 SNode head ;
	public void add(int index, Object element) { // I assume  index starts  from 0 as java.api . 
		
		if(index==0)
		{
			 SNode node = new  SNode() ;
			node.data = element ;
			node.next = head ;
			head = node ;
		}
		else if (index>0 && index <= size() ) 
		{
			 SNode  node = new  SNode() ;
			node.data = element ;
			 SNode n = head ;
			for(int i =0 ; i<index-1;i++)
					n=n.next ;
			node.next = n.next ;
			n.next = node ;
		}
		else 
		{
			throw new IndexOutOfBoundsException ("Please,Enter a valid index.");
		}
	}

	
	public void add(Object element) {
		
		SNode node = new SNode();
		node.data = element ;
		node.next = null ; 
		if(head==null)
		{
			head = node ; 
		}
		else 
		{
			SNode n = head  ;
			while(n.next!=null)
			{
				n=n.next ;
			}	
			n.next = node ;
		}
	}
	
	public Object get(int index) {
	
		if(index>=0 && index < size() )
		{
			SNode node = head ;
			for(int i =0 ;i < index ; i++)
				node=node.next ;
		
			return node.data ;		
		}
		
		else 
		{
			throw new IndexOutOfBoundsException ("Please,Enter a valid index.");
		}
	
	}

	
	public void set(int index, Object element) {
		SNode node = head ;
		if(index>=0 && index < size() )
		{	
			for(int i =0 ;i<index;i++)
				node=node.next ;
			node.data = element ;
		}
		else 
		{
			throw new IndexOutOfBoundsException ("Please,Enter a valid index.");
		}
	}

	
	public void clear() {
		head = null ;
		// Garbage collector will  free the memory from nodes because there is  no pointers points to it .
		
	}

	public boolean isEmpty() {
		if(size()==0)
			return true ;
		else
			return false;
	}

	
	public void remove(int index) {
		
		if(index==0)
			head=head.next ;
		else if(index>=0 && index<size())
		{
			SNode node = head ;
			for(int i =0;i<index-1;i++)
				node=node.next ;
			node.next = node.next.next ;
		}
		else 
		{
			throw new IndexOutOfBoundsException ("Please,Enter a valid index.");
		}
	}

	
	public int size() {
		if(head == null)
			return 0;
		else 
			{
			 	SNode n = head ;
				int count =1 ;
				while(n.next!=null)
				{
					count++;
					n=n.next ;
				}
				return count ;
			}
	}

	public ILinkedList sublist(int fromIndex, int toIndex) {
		ILinkedList sub = new  SLinkedList()  ;
		if((fromIndex>=0 &&fromIndex<size()) && ( toIndex>=0 &&toIndex<size()))
		{
			SNode node = head ; 
			for(int i=0;i<fromIndex;i++)
				node=node.next ;
			while(fromIndex<=toIndex)
				{
					sub.add(node.data);
					node = node.next ;
					fromIndex++;
				}
			
		}
		else 
		{
			throw new IndexOutOfBoundsException ("Please,Enter a valid index.");
		}
		return sub;
	}
	public boolean contains(Object o) {
		SNode node = head ;
		
		while(node.next!=null)
		{
			if(node.data==o)
				return true ;
			node=node.next ;
		}
		if(node.data==o) // check the last node or if the size=1 ;
			return true;
		
		return false;
	}
	

}
