package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.polynomial;

class polynomialTest {

	@Test
	void test() {
		int test[][]=new int [3][2];
		test[0][0]=1;test[0][1]=2;
		test[1][0]=-2;test[1][1]=3;
		test[2][0]=4;test[2][1]=0;
		polynomial opj=new polynomial();
		opj.setPolynomial('A', test);
		assertEquals("-2x^3 + x^2 + 4",opj.print('A'));
		
	}
	@Test
	void test1() {
		int test[][]=new int [3][2];
		test[0][0]=3;test[0][1]=-4;
		test[1][0]=0;test[1][1]=5;
		test[2][0]=-1;test[2][1]=-1;
		polynomial opj=new polynomial();
		opj.setPolynomial('B', test);
		assertEquals("-x^-1 + 3x^-4",opj.print('B'));
		
	}
	@Test
	void test2() {
		int test[][]=new int [8][2];
		test[0][0]=1;test[0][1]=2;
		test[1][0]=-2;test[1][1]=3;
		test[2][0]=4;test[2][1]=0;
		test[3][0]=8;test[3][1]=9;
		test[4][0]=-3;test[4][1]=6;
		test[5][0]=7;test[5][1]=12;
		test[6][0]=9;test[6][1]=-7;
		test[7][0]=15;test[7][1]=0;
		polynomial opj=new polynomial();
		opj.setPolynomial('C', test);
		assertEquals("7x^12 + 8x^9 - 3x^6 - 2x^3 + x^2 + 4 + 15 + 9x^-7",opj.print('C'));
		
	}
	@Test
	void test3() {
		int test[][]=new int [3][2];
		test[0][0]=3;test[0][1]=-4;
		test[1][0]=0;test[1][1]=5;
		test[2][0]=-1;test[2][1]=-1;
		polynomial opj=new polynomial();
		opj.setPolynomial('b', test);
		assertEquals("-x^-1 + 3x^-4",opj.print('b'));
		
	}
	@Test
	void tes4() {
		int test[][]=new int [3][2];
		test[0][0]=1;test[0][1]=2;
		test[1][0]=-2;test[1][1]=3;
		test[2][0]=4;test[2][1]=0;
		polynomial opj=new polynomial();
		opj.setPolynomial('a', test);
		assertEquals("-2x^3 + x^2 + 4",opj.print('a'));
		
	}
	@Test
	void test5() {
		int test[][]=new int [8][2];
		test[0][0]=1;test[0][1]=2;
		test[1][0]=-2;test[1][1]=3; 
		test[2][0]=4;test[2][1]=0;
		test[3][0]=8;test[3][1]=9;
		test[4][0]=-3;test[4][1]=6;
		test[5][0]=7;test[5][1]=12;
		test[6][0]=-1;test[6][1]=-7;
		test[7][0]=15;test[7][1]=0;
		polynomial opj=new polynomial();
		opj.setPolynomial('c', test);
		assertEquals("7x^12 + 8x^9 - 3x^6 - 2x^3 + x^2 + 4 + 15 - x^-7",opj.print('c'));
		
	}
	@Test
	void test6() {
		polynomial opj=new polynomial();
		
		assertThrows (RuntimeException.class,() -> opj.setPolynomial('A', null));
		}
	@Test
	void test7() {
		polynomial opj=new polynomial();
		int test[][]=new int [3][2];
		test[0][0]=1;test[0][1]=2;
		test[1][0]=-2;test[1][1]=3;
		test[2][0]=4;test[2][1]=0;
		assertThrows (RuntimeException.class,() -> opj.setPolynomial('f',test ));
		}
	@Test
	void test8() {
		polynomial opj=new polynomial();
		int test[][]=new int [1][2];
		test[0][0]=0;test[0][1]=0;
		
		opj.setPolynomial('A',test );
		assertEquals("0",opj.print('a'));
		
		}
	@Test
	void test9() {
		polynomial opj=new polynomial();
		assertEquals(null,opj.print('A'));
	}
	@Test
	void test10() {
		int test[][]=new int [3][2];
		test[0][0]=1;test[0][1]=2;
		test[1][0]=-2;test[1][1]=3;
		test[2][0]=4;test[2][1]=0;
		polynomial opj=new polynomial();
		opj.setPolynomial('B', test);
		opj.clearPolynomial('B');
		assertEquals(null,opj.print('B'));
	}
	@Test
	void test11() {
		int test[][]=new int [3][2];
		test[0][0]=1;test[0][1]=2;
		test[1][0]=-2;test[1][1]=3;
		test[2][0]=4;test[2][1]=0;
		polynomial opj=new polynomial();
		opj.setPolynomial('C', test);
		opj.clearPolynomial('C');
		assertEquals(null,opj.print('C'));
	}
	@Test
	void test12() {
		int test[][]=new int [3][2];
		test[0][0]=1;test[0][1]=2;
		test[1][0]=-2;test[1][1]=3;
		test[2][0]=4;test[2][1]=0;
		polynomial opj=new polynomial();
		opj.setPolynomial('A', test);
		opj.clearPolynomial('A');
		assertEquals(null,opj.print('A'));
	}
	@Test
	void test13() {
		polynomial opj=new polynomial();
		int test[][]=new int [3][2];
		test[0][0]=1;test[0][1]=2;
		test[1][0]=-2;test[1][1]=3;
		test[2][0]=4;test[2][1]=0;
		int test1[][]=new int [3][2];
		test1[0][0]=3;test1[0][1]=-4;
		test1[1][0]=2;test1[1][1]=2;
		test1[2][0]=-1;test1[2][1]=-1;
		opj.setPolynomial('b', test1);
		opj.setPolynomial('A', test);
		int ans[][]=new int [5][2];
		ans[0][0]=-2;ans[0][1]=3;
		ans[1][0]=3;ans[1][1]=2;
		ans[2][0]=4;ans[2][1]=0;
		ans[3][0]=-1;ans[3][1]=-1;
		ans[4][0]=3;ans[4][1]=-4;
		opj.multiply('A', 'b');  
		opj.clearPolynomial('R'); 
		assertEquals(null,opj.print('R'));
	}
	@Test
	void test14() {
		polynomial opj=new polynomial();
		assertThrows (RuntimeException.class,() -> opj.clearPolynomial('f'));
		}
	@Test
	void tes15() {
		int test[][]=new int [3][2];
		test[0][0]=1;test[0][1]=2;
		test[1][0]=-2;test[1][1]=3;
		test[2][0]=4;test[2][1]=0;
		polynomial opj=new polynomial();
		opj.setPolynomial('A', test);
	 	 String ans=Float.toString(opj.evaluatePolynomial('A',5));
		assertEquals("-221.0",ans);
		
	}
	@Test
	void test16() {
		polynomial opj=new polynomial();
		assertThrows (RuntimeException.class,() ->opj.evaluatePolynomial('A',5));
		}
	@Test
	void tes17() {
		polynomial opj=new polynomial();
		int test[][]=new int [3][2];
		test[0][0]=1;test[0][1]=2;
		test[1][0]=-2;test[1][1]=3;
		test[2][0]=4;test[2][1]=0;
		int test1[][]=new int [3][2];
		test1[0][0]=3;test1[0][1]=-4;
		test1[1][0]=2;test1[1][1]=2;
		test1[2][0]=-1;test1[2][1]=-1;
		opj.setPolynomial('b', test1);
		opj.setPolynomial('A', test);
		int ans[][]=new int [5][2];
		ans[0][0]=-2;ans[0][1]=3;
		ans[1][0]=3;ans[1][1]=2;
		ans[2][0]=4;ans[2][1]=0;
		ans[3][0]=-1;ans[3][1]=-1;
		ans[4][0]=3;ans[4][1]=-4;
	 	int solution[][]=opj.add('b','a');
	 	for(int i=0;i<solution.length;i++) {
	 		for(int j=0;j<2;j++) {
	 			assertEquals(ans[i][j],solution[i][j] );
	 	}
	 	
	 	
	}
	
	 
	 	}
	
    @Test
	void tes18() {
		polynomial opj=new polynomial();
		int test[][]=new int [3][2];
		test[0][0]=1;test[0][1]=2;
		test[1][0]=-2;test[1][1]=3;
		test[2][0]=4;test[2][1]=0;
		opj.setPolynomial('A', test);
		int test1[][]=new int [3][2];
		test1[0][0]=3;test1[0][1]=-4;
		test1[1][0]=2;test1[1][1]=2;
		test1[2][0]=-1;test1[2][1]=-1;
		opj.setPolynomial('B', test1);
		int ans[][]=new int [7][2];
		ans[0][0]=-4;ans[0][1]=5;
		ans[1][0]=2;ans[1][1]=4;
		ans[2][0]=10;ans[2][1]=2;
		ans[3][0]=-1;ans[3][1]=1;
		ans[4][0]=-10;ans[4][1]=-1;
		ans[5][0]=3;ans[5][1]=-2;
		ans[6][0]=12;ans[6][1]=-4;
	 	int solution[][]=opj.multiply('A','B');
	 	for(int i=0;i<ans.length;i++) {
	 		for(int j=0;j<2;j++) {
	 			 assertEquals(ans[i][j],solution[i][j] ); 
	 	}
	}
	 
	}
	@Test
	void tes19() {
		polynomial opj=new polynomial();
		int test[][]=new int [3][2];
		test[0][0]=1;test[0][1]=2;
		test[1][0]=-2;test[1][1]=3;
		test[2][0]=4;test[2][1]=0;
		opj.setPolynomial('A', test);
		int test1[][]=new int [3][2];
		test1[0][0]=3;test1[0][1]=-4;
		test1[1][0]=2;test1[1][1]=2;
		test1[2][0]=-1;test1[2][1]=-1;
		opj.setPolynomial('c', test1);
		int ans[][]=new int [5][2];
		ans[0][0]=-2;ans[0][1]=3;
		ans[1][0]=-1;ans[1][1]=2;
		ans[2][0]=4;ans[2][1]=0;
		ans[3][0]=1;ans[3][1]=-1;
		ans[4][0]=-3;ans[4][1]=-4;
		int solution[][]=opj.subtract('A','c');
	 	for(int i=0;i<ans.length;i++) {
	 		for(int j=0;j<2;j++) {
	 			 assertEquals(ans[i][j],solution[i][j] ); 
	 	}
	}
		
	}
	
	@Test
	void tes20() {
		polynomial opj=new polynomial();
		int test[][]=new int [1][2];
		opj.setPolynomial('A', test);
		opj.setPolynomial('B', test);
        int solution[][]=opj.multiply('A', 'b');
        assertEquals(0, solution[0][0]);
        assertEquals(0, solution[0][1]);
	}
	@Test
	void test21() {
		polynomial opj=new polynomial();
		assertThrows (RuntimeException.class,() ->opj.multiply('A','b'));
		}
	@Test
	void test22() {
		polynomial opj=new polynomial();
		assertThrows (RuntimeException.class,() ->opj.subtract('c','a'));
		}
	@Test
	void tes23() {
		polynomial opj=new polynomial();
		int test[][]=new int [1][2];
		opj.setPolynomial('A', test);
		opj.setPolynomial('B', test);
        int solution[][]=opj.add('A', 'b');
        assertEquals(0, solution[0][0]);
        assertEquals(0, solution[0][1]);
	}
	@Test
	void test24() {
		polynomial opj=new polynomial();
		assertThrows (RuntimeException.class,() -> opj.print('f'));
		}
	@Test
	void test25() {
		polynomial opj=new polynomial();
		assertThrows (RuntimeException.class,() ->opj.multiply('b','a'));
		}
	@Test
	void test26() {
		polynomial opj=new polynomial();
		assertThrows (RuntimeException.class,() ->opj.multiply('f','b'));
		}
	@Test
	void test27() {
		polynomial opj=new polynomial();
		int test[][]=new int [3][2];
		test[0][0]=1;test[0][1]=2;
		test[1][0]=-2;test[1][1]=3;
		test[2][0]=4;test[2][1]=0;
		opj.setPolynomial('A', test);
		int test1[][]=new int [3][2];
		test1[0][0]=3;test1[0][1]=-4;
		test1[1][0]=2;test1[1][1]=2;
		test1[2][0]=-1;test1[2][1]=-1;
		opj.setPolynomial('c', test1);
		int ans[][]=new int [5][2];
		ans[0][0]=-2;ans[0][1]=3;
		ans[1][0]=-1;ans[1][1]=2;
		ans[2][0]=4;ans[2][1]=0;
		ans[3][0]=1;ans[3][1]=-1;
		ans[4][0]=-3;ans[4][1]=-4;
		opj.subtract('A','c');
		assertEquals("-2x^3 - x^2 + 4 + x^-1 - 3x^-4",opj.print('R'));
	}
}
