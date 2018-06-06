/*Calculate mileage reimbursement based on a table.
  This program reads the input file, creates arrays, and  will calculate mileage 
  reimbursements using if/else/if statements. It will also keep track of the 
  positive numbers, numbers to process, and add the totals of the miles and 
  reimbursements. All of this information will be sent to view on the console 
  and will also be in a file that the program will create. 	
  Ernesto Estrada
  Program #8, CS 1050, Section 1
  Eclipse 4.5.0, MacBook Pro OS X El Capitan
  Endemic - Natural to or characteristic of a specific people or place; native; 
  	indigenous. Belonging exclusively or confined to a particular place. An 
  	endemic disease. 
  "The most important six inches on the battlefield is between your ears."
  					- General James "Mad Dog" Mattis (b.1950)
 */
import java.util.Scanner;
import java.io.*;

public class ErnestoEstrada_1_08 {
	
	static toolKit tools = new toolKit(); 
	static final String CURRENCY_MASK = "#,##0.00";
	static final String NUMBER_MASK = "#,##0.0";
	
	public static void programSum(PrintWriter outputFile) {
		String line = "Calculates mileage reimbursement using arrays.\n"
				+ "Once it calculates the information it will print to screen\n"
				+ "and it will also write a file with the information";
		System.out.println(line);
		outputFile.write(line);
		outputFile.println();
	}
//*****************************************************************************	
	public static void heading(PrintWriter outputFile) {
		String line = ("\n Mileage  " + "  Reimbursement \n" +  "________  " 
	            + "  _____________\n");
		System.out.print(line);
		outputFile.print(line);
		
	}
//*****************************************************************************		
	public static int readData(Scanner input, double[] values) {
		int nRead = 0;
		
		while (nRead < values.length && input.hasNext()) {
			values[nRead] = input.nextDouble();
			nRead++;
		}	
		return nRead;
	}
//*****************************************************************************		
	public static void calcReimbursement(double[] miles, double [] reimb, int nValue) {	
		double base = 0.0;
		double rate = 0.0;
		double overage = 0.0;
	
		// Beginning of the reimbursement calculations 
		for (int i = 0; i < nValue; i++){
			if (i == nValue) break;
			else if (miles[i] <= 0) 	
				{base = 0.0; rate = 0.0; overage = 0.0;}
			else if (miles[i] < 400) 	
				{base = 0.0; rate = .18; overage = miles[i];}
			else if (miles[i] < 900) 	
				{base = 65.0; rate = .15; overage = miles[i] - 400;}
			else if (miles[i] < 1300)   
				{base = 115.0; rate = .12; overage = miles[i] - 900;}
			else if (miles[i] < 1900)   
				{base = 140.0; rate = .10; overage = miles[i] - 1300;}
			else if (miles[i] < 2600)	
				{base = 165.0; rate = .08; overage = miles[i] - 1900;}
			else 						
				{base = 195.0; rate = .06; overage = miles[i] - 2600;}
		reimb[i] = base + rate * overage;
		} // End for
	} // End calcReimbursement
//*****************************************************************************	
	public static void detailLines(PrintWriter outputFile, double[] miles, 
													double[] reimbursements) {
		String noMileage = "*****";
		
		for (int i = 0; i < miles.length; i++) {
			if (i == miles.length) break;
			else if (reimbursements[i] > 0) {
				String line1 = tools.leftPad(miles[i],  8, NUMBER_MASK)
						+ tools.leftPad(reimbursements[i], 12, CURRENCY_MASK);
				System.out.println(line1);
				outputFile.println(line1);
			}
			else {
				String line2 = tools.leftPad(miles[i],  8, NUMBER_MASK)
						+ tools.padString(noMileage, 12, " ", "");
				System.out.println(line2);
				outputFile.println(line2);
			}
		}
	}
//*****************************************************************************	
	public static double[] avCalc(double[] miles, double[] reimbursements, int nValue) {
		double[] avCalc = new double[4];
		double sumMiles = 0.0;
		double averageMiles = 0.0;
		double sumReimb = 0.0;
		double averageReimb = 0.0;
		
		// Begins calculating the averages 
		for (int i = 0; i < nValue; i++) {
			sumMiles += miles[i];
			sumReimb += reimbursements[i];		
			}
		if (nValue > 0) {
			averageMiles = sumMiles / nValue;
			averageReimb = sumReimb / nValue;
		}
		// sends results to array 
		avCalc[0] = sumMiles;			
		avCalc[1] = averageMiles;
		avCalc[2] = sumReimb;
		avCalc[3] =	averageReimb;	
		return avCalc;
	} 
//*****************************************************************************
	public static int positiveNum(double[] values, int nValue) {
		int pos = 0;	// Local variable for positive numbers
		
		// begins to find all the positive miles in array
		for (int i = 0; i < nValue; i++) {
			if (i == nValue) break;
			if (values[i] > 0) {
				++pos;
			}
		}
		return pos;
	}
//*****************************************************************************
	public static void outputSummary (PrintWriter outputFile, int nValues, 
			int posNumbers, double[] averages) { 
		// Creating string to display end result message
		String finalLine = "\nThe total miles is " + 
			tools.leftPad(averages[0], 2, CURRENCY_MASK) + 
			"\nThe total amount of reinumbermbursement is " + 
			tools.leftPad(averages[2], 2, NUMBER_MASK) + 
			"\nThe number miles that were processed is " +
			nValues + "\nThe amount of miles that were greater than zero  " + 
			posNumbers + "\nThe average miles travel is " + 
			tools.leftPad(averages[1], 2, NUMBER_MASK) + 
			 "\nThe average reimbursement is " + 
			tools.leftPad(averages[3], 2, CURRENCY_MASK);
		
		System.out.println(finalLine);
		outputFile.println(finalLine);
		
	}
//*****************************************************************************		
	public static void main(String[] args) throws IOException {
		
		final String INPUT_FILE = "ErnestoEstrada_1_08_Input.txt";
		final String OUTPUT_FILE = "ErnestoEstrada_1_08_Output.txt";
		
		int nValues = 0;			// Amount of values in file 
		int nRead = 0;				// Value that will be processed
		int posNumbers = 0;			// Amount of positive numbers from data
		// List containing value of all the miles
		double[] miles = new double[nValues];
		// Values of all the miles reimbursement
		double[] reimbursements = new double[nValues];	
		// Averages of the miles and reimbursements
		double[] averages = new double[4];			

		// Access the input/output files
	    File inputDataFile = new File(INPUT_FILE);
	    Scanner inputFile  = new Scanner(inputDataFile);
	    FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
	    PrintWriter outputFile = new PrintWriter(outputDataFile);
	    System.out.println("Reading  file " + INPUT_FILE + "\r\n" +
		                   "Creating file " + OUTPUT_FILE + "\n");
	    
	    // Creates message to explain what the program does to the user
	    programSum(outputFile);
	    
	    // Creates heading for console and output file
 	    heading(outputFile);
 	    
 	    // Reading values that will be processed and creating an array with 
 	    // that length 
 	    nValues = inputFile.nextInt();
 	    
 	    // Reading the file and transferring data to the miles array
 	    nRead = readData(inputFile, miles);
 	    
 	    // Sends miles array to a method that will calculate the reimbursements 
 	    // and will transfer the results to the reimbursements array
 	    calcReimbursement(miles, reimbursements, nRead);
 	    
 	    // This method will read both the miles and reimbursement arrays and 
 	    // create a table the will sent to the console and will print 
 	    // information on a different file
 	    detailLines(outputFile, miles, reimbursements);
 	    
 	    // Uses a method to count positive miles and assigning that result to 
 	    // to given variable 
 	    posNumbers = positiveNum(miles, nRead);
 	    
 	    // Method that will calculate totals and averages of miles and of 
 	    // reimbursements. Will store results in array
 	    averages = avCalc(miles, reimbursements, nRead);
 	       
 	    // Organize and write the left over information to the console and file 
 	    outputSummary (outputFile, nRead, posNumbers, averages);
 	   
 	    inputFile.close();
        outputFile.close();  
	} // End Main
} // End Class	
