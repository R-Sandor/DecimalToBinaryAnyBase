package decimalToBinary;

import java.text.DecimalFormat;

/**
 * 
 * @author 	Raphael J. Sandor
 * @version 2.0
 * @since 	2019-09-07
 * 
 * The program decimalToBinary takes an a number from the command line as input.
 * It converts the given number from the command to binary representation and prints
 * a table of the provided input as a binary fraction up to the precision of 8 digits. 
 */

public class DecimalToBinary {

	final static int MAX_DIGITS=8; 
	
	private int base = 0;
	//.0001 was the original threshold
	final double THRESHOLD = .001;
	
	
	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Please run the program again with valid input.");
			// ends program early.
			return;
		}
		
		int size = args.length -1;
		double base10[]= new double[size];
		double otherbase[] = new double[size];
		
		
		/*
		 * Converts all of the command line arguments to doubles
		 * c0 is the notation used in the algorithm for user input. 
		 */
		for (int i=0; i < args.length-1; i++) {		
			double c0 = Double.parseDouble(args[i+1]);
			base10[i] = c0; 
		}
		
		DecimalToBinary solver = new DecimalToBinary();
		solver.setBase(Integer.parseInt(args[0]));
		
		// return the decimal to binary mantissa.
		otherbase = solver.fractionSolver(base10);

		solver.printOutput(base10, otherbase);
	}

	/**
	 * 
	 * @param base10 The base 10 input number.
	 * @param otherbase  The output of the conversion to another base. 
	 * @param base the value of the other base.
	 */
	void printOutput(double base10[], double otherbase[]) {
		System.out.format("%-13s%-7s%-5s%-7s", "|  Base 10   |", "  Base ", this.getBase(), " |");
		System.out.format("%-13s%-11s", "\n|:-----------|", ":------------|\n");
		int x = base10.length;
		DecimalFormat df = new DecimalFormat("#.########"); 
		
		  for (int i = 0 ; i < x; i++) { 
			  	System.out.format("%-2s%-11s%-2s", "| ", base10[i], "| ");
			  	System.out.format("%-10s%-1s", df.format(otherbase[i]),"  |\n");

		  }
	}
	
	/**
	 * 
	 * @param dec The decimal number to be converted to binary.
	 * The conversion is up to 8 binary digits.
	 */
	double[] fractionSolver(double dec[]){
		double base2[] = new double[dec.length];
		DecimalFormat df = new DecimalFormat("#.########"); 
		
		// Need to find out how many place the base needs to be modified 
		// for bases greater than 10 they require two decimal places 11...99
		// and of course for bases greater 100 it requires places .###^-1 +###^-2 ... + ####^-n
		int baseModifier = 0;
		double baseGreaterThan10 = this.getBase();
		while (baseGreaterThan10 > 10 ) {
				baseGreaterThan10 = baseGreaterThan10 / 10; 
				baseModifier++;
		}
				
		// Given the size and convoluted nature of this code,
		// if I had more time I would break this up with more helper functions
		for (int i = 0; i < dec.length; i++)
		{
			double ci = dec[i];
			double bi = 0;
			
			// starting at 1 because that would (.1)base2
			for (int binDig= 1; binDig < MAX_DIGITS+1; binDig++)
			{
				
				bi = 0;
				if (ci == 0)
				{
					break;
				}

				// Check if this is a perfect 1/ base
				double mathFormulaForBase = (1.0/(this.getBase()));
				double result;
	
				if (this.getBase() > 10) {
					result = Math.abs(ci - mathFormulaForBase);
				}
				else 
					result = Math.abs(ci - mathFormulaForBase);
				double testfor1ofBase = Math.abs((ci/10) - mathFormulaForBase);

				ci = ci*this.getBase();		
	
				
				if (result < THRESHOLD && this.getBase() < 10) {
					bi = 1;
					bi = bi * Math.pow(10, -binDig);
					base2[i] += bi;
					break;
				}
				if (result < THRESHOLD && this.getBase() > 10) {
					bi = 1;
					if (binDig == 1)
						bi = bi * Math.pow(10, -binDig*binDig-1);
					else
						bi = bi * Math.pow(10, -binDig*binDig);
					base2[i] += bi;
					break;
				}
				else if (testfor1ofBase <THRESHOLD && this.getBase() > 10)
				{
					bi = 1;
					bi = bi * Math.pow(10, -binDig*binDig-1);
					base2[i] += bi;
					break;
				}


				
				// Take only the integer value.
				bi = (int) ci;
				

				// Leave only the fractional value.
				ci = ci - bi;
				
			
				// Noticed strange behavior with subtracting the integer. 
				// e.g ci = .2400000005 to eliminate I said just round to the 7th,
				// ought be good enough.... 
				ci = Double.parseDouble(df.format(ci));

				
				 if (binDig > 1 && this.getBase() > 10) {  baseModifier++; }
				 
				// Now multiply the integer bi by 10^binDig.
				bi = bi * Math.pow(10, -binDig-baseModifier);
				
				// Lastly add that value to that base2.
				base2[i] += bi;
				if (binDig > 5) {		
					base2[i] = Double.parseDouble(df.format(base2[i]));
				}
			}
		}
		return base2;
	}
}
