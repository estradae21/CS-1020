/*Calculate mileage reimbursement based on a table.
  This program reads the input file and will calculate mileage reimbursements 
  using if/else/if statements. It will also keep track of the positive numbers,
  numbers to process, and add the totals of the miles and reimbursements. All 
  of this information will be sent to view on the console and will also be 
  in a file that the program will create. 	
  Ernesto Estrada
  Program #6, CS 1050, Section 1
  JGRASP 2.0.1_09, MacBook Pro OS X El Capitan
  Affinal - related by or concerning marriage.
  "The difference between a winner and a loser - they both failed, but 
  the winner gets back up and does it again and again until it goes his way."
  Greg Plitt (1977-2015) */

import java.util.Scanner;
import java.io.*;

public class ErnestoEstrada_1_06 {

	public static void heading(PrintWriter outputFile) {
		System.out.println(" Mileage  " + "  Reimbursement \n" +  "________  " 
            + "  _____________");
		outputFile.write(" Mileage  " + "  Reimbursement \n" +  "________  " 
            + "  _____________");
		outputFile.println();
	}
		
	public static void outputSummary (PrintWriter outputFile, int posNumbers, 
			double totalReimbursement, double totalMileage) { 
		System.out.println("\nThe total reimbursement is " + totalReimbursement
             + "\nThe total amount of miles is " + totalMileage + 
				"\nThe number of mileage values that are greater than 0 are " + posNumbers 
            + "\nErnesto Estrada");
		outputFile.println();
		outputFile.write("The total reimbursement is " + totalReimbursement);
		outputFile.println();
		outputFile.write("The total amount of miles is " + totalMileage);
		outputFile.println();
		outputFile.write("The number of mileage values that are greater than 0 are " 
            + posNumbers);
		outputFile.close();
	}
	
	public static void main(String[] args) throws IOException {	
		
		final String INPUT_FILE = "ErnestoEstrada_1_06_Input.txt";
		final String OUTPUT_FILE= "ErnestoEstrada_1_06_Output.txt";

		int i = 0;
		int posNumbers= 0;
		int numbersToProcess = 0;
		double numberOfMiles = 0.0;
		double mileageReimbursement = 0.0;
		double totalReimbursement = 0.0;
		double totalMileage = 0.0;
		
		// Access the input/output files
	    File inputDataFile = new File(INPUT_FILE);
	    Scanner inputFile  = new Scanner(inputDataFile);
	    FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
	    PrintWriter outputFile = new PrintWriter(outputDataFile);
	    System.out.println("Reading  file " + INPUT_FILE + "\r\n" +
		                   "Creating file " + OUTPUT_FILE + "\n");
	   
	    // Creates heading for console and output file
 	    heading(outputFile);
 	    
        numbersToProcess = inputFile.nextInt();
        // begining of the reimbursement calculations 
        while ( i < numbersToProcess) {     	  						
         	numberOfMiles = inputFile.nextDouble();
		        if (numberOfMiles > 0) {  
		        	++posNumbers;
		            if (numberOfMiles < 400) {
		            	mileageReimbursement = numberOfMiles * .18;	
		            }
		            else if (numberOfMiles < 900) {
		            	mileageReimbursement = ((numberOfMiles - 400) * .15 + 65);
		            }
		            else if (numberOfMiles < 1300) {
		            	mileageReimbursement = ((numberOfMiles - 900) * .12 + 115);
		            }
		            else if (numberOfMiles < 1900) {
		            	mileageReimbursement = ((numberOfMiles - 1300) * .10 + 140);
		            }
		            else if (numberOfMiles < 2600) {
		            	mileageReimbursement = ((numberOfMiles - 1900) * .08 + 165);
		            }
		            else {
		            	mileageReimbursement = ((numberOfMiles - 2600) * .06 + 195);
		            }
		            totalMileage += numberOfMiles;
		        }
		        if (numberOfMiles == 0) {
		        	mileageReimbursement = 0;
		        }
		        if (numberOfMiles < 0) {
		        	i++; // add one to repeat the loop
		        	// Print this instance to the console and the file 
		        	String line = toolKit.leftPad(numberOfMiles,  8, "0.0", " ") + 
	              			toolKit.padString(" ",7) + toolKit.padString("*****", 5);
		        	
		        	System.out.println(line);
	          		outputFile.println(line);
		        }  
		        else {		  
		        i++; // add one to repeat the loop
		        // Print these instances to the console and the file 
          		totalReimbursement += mileageReimbursement;
          		String line2 = toolKit.leftPad(numberOfMiles,  8, "0.0", " ") + 
              			toolKit.leftPad(mileageReimbursement, 12, "#,##0.00");
          		
          		System.out.println(line2);
          		outputFile.println(line2);
           }       
        } // End of reimbursement calculations 
        
        // organize and write the left over information to the console and file 
        outputSummary(outputFile, posNumbers, totalReimbursement, totalMileage);
        inputFile.close();
        outputFile.close();
	}
}
		  

 

          	