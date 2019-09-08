package decimalToBinary;

import static org.junit.Assert.*;

import org.junit.Test;

public class DecimalToBinaryTest {

	public DecimalToBinary solver = new DecimalToBinary();


	
	  @Test public void test1() { double base10numbers[] = new double[] { .5 };
	  double checkedBase2Answers[] = new double[] { .1 }; double base2[] =
	  solver.fractionSolver(base10numbers); 
	  assertEquals(base2[0], checkedBase2Answers[0], .0); }
	 
	  @Test public void test2() { double base10numbers[] = new double[]{.15};
	  double checkedBase2Answers[] = new double[]{.00100110}; double base2[] =
	  solver.fractionSolver(base10numbers);
	  assertEquals(checkedBase2Answers[0], base2[0],0); }
	  
	  @Test public void test3() { double base10numbers[] = new double[]{.33};
	  double checkedBase2Answers[] = new double[]{.0101010}; double base2[] =
	  solver.fractionSolver(base10numbers);
	  assertEquals(checkedBase2Answers[0], base2[0], 0 ); }
	  
	  @Test public void test4() { double base10numbers[] = new double[]{.10};
	  double checkedBase2Answers[] = new double[]{.00011001}; double base2[] =
	  solver.fractionSolver(base10numbers);
	  assertEquals(checkedBase2Answers[0], base2[0],0); }
	  
	  @Test public void test5() { double base10numbers[] = new double[]{.25};
	  double checkedBase2Answers[] = new double[]{.01}; double base2[] =
	  solver.fractionSolver(base10numbers);
	  assertEquals(checkedBase2Answers[0], base2[0],0); }
}
