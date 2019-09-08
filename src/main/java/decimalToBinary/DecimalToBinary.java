package decimalToBinary;

import java.text.DecimalFormat;

/**
 * 
 * @author 	Raphael J. Sandor
 * @version 1.0
 * @since 	2019-09-07
 * 
 * The program decimalToBinary takes an a number from the command line as input.
 * It converts the given number from the command to binary representation and prints
 * a table of the provided input as a binary fraction up to the precision of 8 digits. 
 */

public class DecimalToBinary {

	final static int MAX_DIGITS=8; 
	
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Please run the program again with valid input.");
			// ends program early.
			return;
		}
		double base10[]= new double[args.length];
		double base2[] = new double[args.length];
		
		
		/*
		 * Converts all of the command line arguments to doubles
		 * c0 is the notation used in the algorithm for user input. 
		 */
		for (int i=0; i < args.length; i++) {
			double c0 = Double.parseDouble(args[i]);
			base10[i] = c0; 
		}
		
		DecimalToBinary solver = new DecimalToBinary();
		
		// return the decimal to binary mantissa.
		base2 = solver.fractionSolver(base10);
		
		solver.printOutput(base10, base2);
	}

	/**
	 * 
	 * @param base10 The base 10 input number.
	 * @param base2  The output of the conversion to base 2. 
	 */
	void printOutput(double base10[], double base2[]) {
		System.out.format("%-13s%-12s", "|  Base 10   |", "  Base 2   |\n");
		System.out.format("%-13s%-12s", "|:-----------|", ":----------|\n");
		int x = base10.length;
		DecimalFormat df = new DecimalFormat("#.########"); 
		
		  for (int i = 0 ; i < x; i++) { 
			 // System.out.format("%-2s%-11s%-2s%-10f%-1s", "| ", base10[i], "| ", base2[i] ,"|\n"); }
			  	System.out.format("%-2s%-11s%-2s", "| ", base10[i], "| ");
			  	System.out.format("%-10s%-1s", df.format(base2[i]),"|\n");

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
		for (int i = 0; i < dec.length; i++)
		{
			double ci = dec[i];
			double bi = (int) ci;
			
			base2[i] = bi; 
			
			// starting at 1 because that would (.1)base2
			for (int binDig= 1; binDig < MAX_DIGITS+1; binDig++)
			{
				
				bi =0;
				if (ci == 0)
				{
					break;
				}
				
				ci = ci*2;				
				
				// Take only the integer value.
				bi = (int) ci;

				// Leave only the fractional value.
				ci = ci - bi;
				
				// Noticed strange behavior with subtracting the integer. 
				// e.g ci = .2400000005 to eliminate I said just round to the 7th,
				// ought be good enough.... 
				ci = Double.parseDouble(df.format(ci));

				bi = (int)bi;
				if (bi > 0)
				{
					// Now multiply the integer bi by 10^binDig.
					bi =  Math.pow(10, -binDig);
				}
				
				
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
