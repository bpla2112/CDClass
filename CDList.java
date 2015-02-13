/**
 *
 * @author Bernardo Pla_3885008
 */

/**
 * This is a class to read the text file that holds the data from each of 
 * the CDs in the text file. 
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CDList 
{
    //instance variable
    private ArrayList<CD> list; // list of CD data  


/**
 * Creates an empty list
 */
public CDList()
{
list = new ArrayList<CD>();

}

/**
 * Adds the CD object to the list
 * @param next finds the next object to be added to the list
 */
public void addData(CD next)
{
    list.add(next) ; //calls add method to populate the list
}

/**
 * This next method will print the yearly report for the next 10 years.
 * This will occur after the list has been populated
 */
public void printReport()
{
    for(int i = 0; i <= 9; i++)
    {
        System.out.println("Year " + (i+1) + " Reports");
        System.out.printf("%37s%12s%13s%n","current","annual","total");
        
        System.out.printf("%9s%7s%7s%14s%11s%15s%13s%n", "principal","term","rate",
                "compounding","value","interest","interest");
        
        System.out.printf("%9s%7s%7s%14s%14s%13s%13s%n", "=========","====","====",
                "===========","===========","==========","==========");
        
        //initialize the current cd value, the yearly interest and the total interest to 0
        double totalCDValue = 0;
        double totalYearlyInterest = 0;
        double totalInterestPaid = 0;
        
        // the next for statement will populate the file
        for(int x = 0; x < list.size(); x++)
        {
            CD current = list.get(x); // populates list
            
            // call the variables from the CD class
            int principal = current.getPrincipal();
            int maturity = current.getMaturity();
            double interestRate = current.getInterestRate();
            double CDValue = current.CDValue();
            String compoundingMode = current.getCompoundingMode();
            
            // if statement will give a protocol for when the maturity has been reached
            if(i<maturity)
            {
                double totalIntPaid = CDValue - principal;
                double totalYearInt = current.getYearlyInterest();
                
                totalCDValue = totalCDValue + CDValue;
                totalYearlyInterest = totalYearlyInterest + totalYearInt ;
                totalInterestPaid = totalIntPaid + totalInterestPaid;
                System.out.printf("$%,8d%7d%7.2f%14s%3s$%,10.2f%,13.2f%,13.2f%n", principal, 
                                   maturity, interestRate, compoundingMode, "", CDValue, totalYearInt, totalIntPaid) ;
                              
                
            }
            if(x == list.size() - 1)
            {
                System.out.printf("%37s%14s%13s%13s%n", "", "===========", "==========", "==========") ;
                    System.out.printf("%40s$%,10.2f%,13.2f%,13.2f%n%n", "", totalCDValue, totalYearlyInterest, 
                            totalInterestPaid) ;
                    
                    totalCDValue = 0 ;
                    totalYearlyInterest = 0 ;
                    totalInterestPaid = 0 ;
            }
            
        }
    }
}




}
