/** File: CS1050_Assignment_04_File_Input_Output_Example.java
    Accompanies Programming Assignment 4

	 Read a file of numbers and sum them
	 
	 Input	File <path>NumbersToSum.txt that has DOUBLE numbers to
	 			sum, possibly more than one number to a line
	 
	 Process	Read the data values and sum them
	 
	 Output	A file with the original data values, one to a line, plus 
            three lines at the end with three numbers: the number of numbers 
            read, their sum and their average
            and the sum
            
    Note 	Without your added code, the program will display the number
		      of numbers in the input file and a sum of 0.0

*/

import java.util.Scanner;
import java.io.*;

public class CS1050_Assignment_04_File_Input_Output_Example {

	public static void main(String[] args) throws IOException {
      // Declare variables
		// Define your file names on the next two lines as needed.
		// You may want to add a flash drive letter like F:\\  (Why \\?)
		final String INPUT_FILE  = "YourName_S_04_Input.txt";
		final String OUTPUT_FILE = "YourName_S_04_Output.txt";
      
		int numberOfNumbers = 0; // Number of numbers in the input file
		double sum = 0;		 	 // The sum of the numbers
      double average = 0;      // The average of the numbers read
		double oneNumber;			 // An individual number read from the file
		
		// Access the input/output files
		File inputDataFile = new File(INPUT_FILE);
		Scanner inputFile  = new Scanner(inputDataFile);
		FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
		PrintWriter outputFile = new PrintWriter(outputDataFile);
      System.out.println("Reading  file " + INPUT_FILE + "\r\n" +
		                   "Creating file " + OUTPUT_FILE);
		
		// Read the input file and sum the numbers. 
		
		while (inputFile.hasNext()) {
				numberOfNumbers++;
				oneNumber = inputFile.nextDouble();
				// Add code here to:
				// 1. add the number to the running total (variable 'sum')
				// 2. write the number and running total to the output file
				// 3. echo on the console the number and the running total
				//		(use System.out.println)
			} // End while
		
		// Add code here to:
		// 1. write the number of numbers, the sum and the average
      //    to the output file using DecimalFormat to format the sum and average
		// 2. close the input file
		// 3. close the output file

		System.out.println("The sum of the " + numberOfNumbers + 
								 " numbers is " + sum + "\n" +
                         " and the average is " + average);
								 
		System.exit(0);	
	} // End main
} // End class