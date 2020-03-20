package classes;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class DLinkedList implements ILinkedList{
	public class DNode {
		Object data ;
		DNode next=null; 
	    DNode prev=null;
	}
 public  DNode head;
	
	public void add(int index, Object element) { // I assume  index starts  from 0 as java.api .
		 DNode  node = new  DNode() ;
			node.data = element ;
		if(index==size()) {
			 DNode n = head ;
			for(int i =0 ; i<index-1;i++)
				n=n.next ;
			node.prev=n;
			n.next = node ;
			
		}
		else if(index==0)
		{
			
			node.next = head ;
			head = node ;
		}
		else  
		{
			
			 DNode n = head ;
			for(int i =0 ; i<index-1;i++)
					n=n.next ;
			
			node.next = n.next ;
			n.next.prev=node;
			node.prev=n;
			n.next = node ;
			
		}
		
	}

	public void add(Object element) {
		DNode newnode = new DNode();
		newnode.data = element ;
		if(isEmpty()) {
			head=newnode;
		}
		else {
			DNode n = head  ;
			while(n.next!=null)
			{
				n=n.next ;
			}	
			n.next = newnode ;
			newnode.prev=n;
		}
	}

	
	public Object get(int index) {	
			DNode newnode =  head ;
			for(int i =0 ;i < index ; i++)
				newnode=newnode.next ;
		
			return newnode.data ;		
	}

	
	public void set(int index, Object element) {
		DNode node = head ;
		
			for(int i =0 ;i<index;i++)
				node=node.next ;
			node.data = element ;
			
		
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
		else 
		{
			DNode node = head ;
			for(int i =0;i<=index-1;i++) {
				node=node.next ;}
			if(node.next==null) {
				node.prev.next=null;
			}
			else {
			DNode v = node.prev ;
			DNode u = node.next ;
			u.prev=v;
			v.next=u;
			node.next=null;
			node.prev=null;
			}
		}

	}

	
	public int size() {
		if(head == null)
			return 0;
		else 
			{
			 	DNode n = head ;
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
		ILinkedList sub = new  DLinkedList()  ;
		
			DNode node = head ; 
			for(int i=0;i<fromIndex;i++)
				node=node.next ;
			while(fromIndex<=toIndex)
				{
					sub.add(node.data);
					node = node.next ;
					fromIndex++;
				}
			
		
		return sub;
		
	}
	
	public boolean contains(Object o) {
	DNode node = head ;
		
		while(node!=null)
		{
			if(node.data==o) {
				return true ;}
			
			node=node.next ;
		}
		
		return false;
	
	}
}