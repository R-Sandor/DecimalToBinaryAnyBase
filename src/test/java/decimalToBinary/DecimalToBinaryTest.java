package decimalToBinary;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecimalToBinaryTest {

	public DecimalToBinary solver = new DecimalToBinary();


	
	
	  @Test public void test1() { double base10numbers[] = new double[] { .5 };
	  double checkedBase2Answers[] = new double[] { .1 }; solver.setBase(2); double
	  base2[] = solver.fractionSolver(base10numbers); assertEquals(base2[0],
	  checkedBase2Answers[0], .0); }
	 
	  @Test public void test2() { double base10numbers[] = new double[]{.15};
	  double checkedBase2Answers[] = new double[]{.00100110}; solver.setBase(2); double base2[] =
	  solver.fractionSolver(base10numbers);
	  assertEquals(checkedBase2Answers[0], base2[0],0); }
	  
	  @Test public void test3() { double base10numbers[] = new double[]{.33};
	  double checkedBase2Answers[] = new double[]{.0101010}; solver.setBase(2); double base2[] =
	  solver.fractionSolver(base10numbers);
	  assertEquals(checkedBase2Answers[0], base2[0], 0 ); }
	  
	  @Test public void test4() { double base10numbers[] = new double[]{.10};
	  double checkedBase2Answers[] = new double[]{.00011001}; solver.setBase(2); double base2[] =
	  solver.fractionSolver(base10numbers);
	  assertEquals(checkedBase2Answers[0], base2[0],0); }
	  
	  @Test public void test5() { double base10numbers[] = new double[]{.25};
	  double checkedBase2Answers[] = new double[]{.01}; solver.setBase(2); double base2[] =
	  solver.fractionSolver(base10numbers);
	  assertEquals(checkedBase2Answers[0], base2[0],0); }
	  
	  
	  @Test public void base3_test1_1_divided_by_base() { double base10numbers[] = new double[] { .3333 };
	  double checkedBase3Answers[] = new double[] { .1 }; solver.setBase(3); double
	  base3[] = solver.fractionSolver(base10numbers); assertEquals(base3[0],
	  checkedBase3Answers[0], .0); }
	  
	  @Test public void base3_test2_1_divided_by_base_squared() { double base10numbers[] = new double[] { .1111 };
	  double checkedBase3Answers[] = new double[] { .01 }; solver.setBase(3); double
	  base3[] = solver.fractionSolver(base10numbers); assertEquals(base3[0],
	  checkedBase3Answers[0], .0); }
	  
	  
	  @Test public void base3_test3() { double base10numbers[] = new double[] { .25 };
	  double checkedBase3Answers[] = new double[] { .02020202 }; solver.setBase(3); double
	  base3[] = solver.fractionSolver(base10numbers); assertEquals(base3[0],
	  checkedBase3Answers[0], .0); }
	  
	  @Test public void base3_test4() { double base10numbers[] = new double[] { .50 };
	  double checkedBase3Answers[] = new double[] { .11111111 }; solver.setBase(3); double
	  base3[] = solver.fractionSolver(base10numbers); assertEquals(base3[0],
	  checkedBase3Answers[0], .0); }
	  
	  @Test public void base11_test1_1_divided_by_base() { double base10numbers[] = new double[] { .090909 };
	  double checkedBase11Answers[] = new double[] { .01 }; solver.setBase(11); double
	  base11[] = solver.fractionSolver(base10numbers); assertEquals(base11[0],
	  checkedBase11Answers[0], .01); }
	  
	  @Test public void base11_test1_1_divided_by_base_sqrd() { double base10numbers[] = new double[] { .0082644 };
	  double checkedBase11Answers[] = new double[] { .0001 }; solver.setBase(11); double
	  base11[] = solver.fractionSolver(base10numbers); assertEquals(base11[0],
	  checkedBase11Answers[0], .01); }
	  
}
