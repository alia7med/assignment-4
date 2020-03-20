package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import classes.SLinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

class SLTest {

	@Test
	void test_1() {
		 ILinkedList list = new SLinkedList() ;
		 list.add(10);
		 list.add(20);
		 list.add(30);
		 list.add(40);
		 list.add(50);
	assertEquals(10,list.get(0));
	assertEquals(20,list.get(1));	 
	assertEquals(30,list.get(2));	 
	assertEquals(40,list.get(3));	 
	assertEquals(50,list.get(4));	 
	}
	@Test
	void test_2() {
		 ILinkedList list = new SLinkedList() ;
		 list.add(10);
		 list.add(20);
		 list.add(30);	 
	assertEquals(30,list.get(2));	 
	Assertions.assertThrows(NullPointerException .class, () -> {
		  list.get(10);
		  list.get(4);
	  });       
	}
	@Test
	void test_3() {
		 ILinkedList list = new SLinkedList() ;
		 list.add(1);
		 list.add(2);
		 list.add(3);
		 list.add(4);
		 list.add(5);
		 list.add(2,100);
		 assertEquals(100,list.get(2));
	}
	@Test
	void test_4() {
		 ILinkedList list = new SLinkedList() ;
		 list.add(10);
		 list.add(20);
		 list.add(30);
		 list.add(40);
		 list.add(50);
		 list.set(4,100);
	assertEquals(100,list.get(4));
	Assertions.assertThrows(NullPointerException .class, () -> {
		  list.set(10,70);
	  });       
	}
	@Test
	void test_5() {
		 ILinkedList list = new SLinkedList() ;
		 list.add("arw");
		 list.add("swa");
		 list.add("abc");
		 list.add("cmm");
		 list.add("add");
		 list.add("leo");
		 list.add("adele");
		 list.add("polar");
		 list.add("lf");
		 ILinkedList sublist = list.sublist(2,5) ;
		 	assertEquals("abc",sublist.get(0));
			assertEquals("cmm",sublist.get(1));	 
			assertEquals("add",sublist.get(2));	 
			assertEquals("leo",sublist.get(3));	
	}
	@Test
	void test_6() {
		 ILinkedList list = new SLinkedList() ;
		 list.add("arw");
		 list.add("swa");
		 list.add("abc");
		 list.add("cmm");
		 list.add("add");
		 list.add("leo");
		 list.add("adele");
		 list.add("polar");
		 list.add("lf");
		 ILinkedList sublist = list.sublist(2,7) ;
			assertEquals(7-2+1,sublist.size());
	}
	@Test
	void test_7() {
		 ILinkedList list = new SLinkedList() ;
		 list.add("arw");
		 list.add("swa");
		 list.add("abc");
		 list.add("cmm");
		 list.add("add");
		 list.add("leo");
		 list.add("adele");
		 list.add("polar");
		 list.add("lf");
	}
	@Test
	void test_8() {
		 ILinkedList list = new SLinkedList() ;
		 list.add("arw");
		 list.add("swa");
		 list.add("abc");
		 list.add("cmm");
		 list.add("add");
		 list.add("leo");
		 list.add("adele");
		 list.add("polar");
		 list.add("lf");
		 list.remove(0);
		 list.remove(1);
		 list.remove(3);
		assertEquals(6,list.size());
		Assertions.assertThrows(NullPointerException .class, () -> {
			  list.remove(10);
		  });   
	}
	@Test
	void test_9() {
		 ILinkedList list = new SLinkedList() ;
		 list.add("arw");
		 list.add("swa");
		 list.add("abc");
		 list.add("cmm");
		 list.add("add");
		 list.add("leo");
		 list.add("adele");
		 list.add("polar");
		 list.add("lf");
		 Object a = list.get(1);
		 Object b = list.get(3);
		list.remove(1);
		list.remove(3);
		assertNotEquals(a,list.get(1));	
		assertNotEquals(b,list.get(3));		
	}
	@Test
	void test_10() {
		 ILinkedList list = new SLinkedList() ;
		 list.add(1);
		 list.add(2);
		 list.add(3);
		 list.add(4);
		 list.add(5);
		 assertEquals(true,list.contains(5));
		 assertEquals(false,list.contains(7));
		 assertEquals(false,list.contains(10));
	}
	@Test
	void test_11() {
		 ILinkedList list = new SLinkedList() ;
		 list.add(1);
		 list.add(2);
		 list.add(3);
		 list.add(4);
		 list.add(5);
		 list.clear();
		 assertEquals(true,list.isEmpty());
	}
	@Test
	void test_12() {
		 ILinkedList list = new SLinkedList() ;
		 list.add(1);
		 list.add(2);
		 list.add(3);
		 list.add(4);
		 list.add(5);
		 assertEquals(false,list.isEmpty());
	}
	@Test
	void test_13() {
		 ILinkedList list = new SLinkedList() ;
		 list.add(1);
		 list.add(2);
		 list.add(3);
		 list.add(4);
		 list.add(5);
		 Assertions.assertThrows(NullPointerException .class, () -> {
			  list.add(10,100);
		  });   	
	}
	@Test
	void test_14() {
		 ILinkedList list = new SLinkedList() ;
		 list.add(1);
		 list.add(2);
		 list.add(3);
		 list.add(4);
		 list.add(5);
		list.add(0, 100);
		 assertEquals(100,list.get(0));		
	}
	@Test
	void test_15() {
		 ILinkedList list = new SLinkedList() ;
		 list.add(1);
		 list.add(0,20);
		 list.add(1, 30);
		 list.add(3,100);
		 list.add(4,110);
		 assertEquals(20,list.get(0));
		 assertEquals(true,list.contains(20));
		 assertEquals(110,list.get(4));
	}
	@Test
	void test_16() {
		 ILinkedList list = new SLinkedList() ;
		 list.add(1);
		 list.add(2);
		 list.add(3);
		 list.add(4);
		 list.add(5);
		list.remove(4);
		 assertEquals(false,list.contains(5));		
	}
	@Test
	void test_17() {
		 ILinkedList list = new SLinkedList() ;
		list.add(0,4);
		 assertEquals(1,list.size());		
	}
	
}
