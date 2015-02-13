/**
 *
 * @author Bernardo Pla_3885008
 */

/**
 * This is a class that creates a CD object. The object knows its principal,
 * interest rate, maturity, and compounding mode.   
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CD {
   private int principal ; // principal value of CD
   private double interestRate; // stores the interest rate as a double
   private int maturity ; // time for the CD to mature
   private String compoundingMode; // how often interest is added to principal per year
   private double current ; // the current value of interest
   private int count = 1 ; // counts the number of years that have passed initialized to 1
   
   /**
    * Creates a CD object
    * @param principal the initial deposit on CD
    * @param interestRate the interest rate on that principal
    * @param maturity  time for CD to mature in years
    * @param compoundingMode frequency interest is added each year
    */
   public CD (int principal, double interestRate, int maturity, String compoundingMode)
   {
       this.principal = principal;
       this.interestRate = interestRate ;
       this.maturity = maturity ;
       this.compoundingMode = compoundingMode ; 
        
       
   }
   
   /**
    * Returns the principal
    * @return principal
    */
   public int getPrincipal()
           {
               return principal;
           }
   
   /**
    * Returns the interest rate
    * @return interestRate
    */
   public double getInterestRate()
   {
       return interestRate;
       
   }
   
   /**
    * Returns the maturity in years
    * @return maturity
    */
   public int getMaturity()
   {
       return maturity ;
   }
   
   /**
    * Returns the compounding mode as a string
    * @return compoundingMode
    */
   public String getCompoundingMode()
   {
       return compoundingMode; 
   }
   
   /**
    * Returns the annual interest
    * @return annual interest
    */
   public double getYearlyInterest()
   {
       return current;
   }
   
   /**
    * Returns the value on the CD
    * @return value of CD
    */
   public double CDValue()
   {
       int compoundingMode = 0 ; // initialize compounding mode to 0
       double CDValue = 0 ; // initialize the value of the CD to 0
       
       /** set up a series of if statements to convert the compounding mode to
        *  a series of integers
        */ 
       if(this.compoundingMode.equalsIgnoreCase("daily"))
       {
           compoundingMode = 365; // assume year is exactly 365 days and convert to int            
       }
       else if(this.compoundingMode.equalsIgnoreCase("monthly"))
       {
           compoundingMode = 12 ; // year is exactly 12 months
       }
       else if(this.compoundingMode.equalsIgnoreCase("quarterly"))
       {
           compoundingMode = 4 ; // year is divided into 4 quarters of 3 months
       }
       
       // formula for the value of the CD
       CDValue = principal * Math.pow(1 + ((interestRate/100)/compoundingMode),
               compoundingMode * count);
       
       if (count == 0)
       {
           current = CDValue - principal ; // set the current value
       }
       else
       {
           // formula for current value
           current = CDValue - principal * Math.pow((1 + (interestRate/100)/compoundingMode),
           compoundingMode * (count - 1)); //gets the current value
       }
       count++; // increase the count by 1
       return CDValue; // gets the CD value at the given year
       
   }
    
}
//end of CD class declaration
