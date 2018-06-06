/**
   Interactive Average Program with Methods
   Accompanies Programming Assignment #5
   
   Using methods, this program asks the user to input two real numbers, 
   calculates the average of these numbers, and prints the results
   
   Methods used:
   
    explain() - explain the program to the user
    getNum() -  return the numbers input by the user
    calcAvg() - return the average of the numbers
    outputResults()- output the numbers and their average
*/

import java.util.Scanner;

public class InteractiveAverageMethods
{ 
  static Scanner console = new Scanner(System.in); // Keyboard input
  
  public static void main (String [] args) throws Exception
  { 
    double num1, num2;   // Input values
    double average;      // Average of the input values
    
    // Explain the program to the user
    explain();
    
    // Input the numbers 
    num1 = getOneNumber("first");
    num2 = getOneNumber("second");
    
    // Determine the average of the two numbers
    average = calcAvg(num1, num2);
    
    // Output the results
    outputResults(num1, num2, average); 
  } // End main
  
  // **************************************************************
 
  // Methods section
  
  // Explain the program to the user
  public static void explain()
  { 
    System.out.println(
         "This program averages two real numbers " +
         "entered by the user.\n" +
         "The output is the two numbers and their average.\n" +
         "Note: methods are used.");
  }
  
  // ***************************************************************
  
  // Return the number input by the user
  public static double getOneNumber(String which) throws Exception
  { 
    double num;   // number input by the user
    System.out.print("Input your " + which + " number: "); 
    num = console.nextDouble();
    return num;
  } // end getOneNumber
  
  // ***************************************************************
 
  // Return the average of a and b
  public static double calcAvg(double a, double b)
  { 
    return (a + b)/2;
  } // End calcAvg
  
  // ***************************************************************
  
  // Output the values of the numbers and their average
   public static void outputResults(double num1, 
                                   double num2, 
                                   double average)
  { 
    System.out.print(
             "The average of " + num1 +
             " and " + num2 + " is " + average);
             
    System.exit(0);
  } // End outputResults
} // End class
