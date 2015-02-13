/**
 *
 * @author Bernardo Pla_3885008
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CDTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        //create the file scanner object
        Scanner fileScan = new Scanner (new File("CD-Data.txt")); 
        
        // create the array list object
        CDList banking = new CDList();
        
        while(fileScan.hasNext())
        {
            //scan the file for each token for the instance variables
            int principal = fileScan.nextInt();
            int maturity = fileScan.nextInt();
            double interestRate = fileScan.nextDouble();            
            String compoundingMode = fileScan.next();
            
            //create new CD object
            CD batBank = new CD (principal, interestRate, maturity, compoundingMode);
            
            //compile the list
            banking.addData(batBank);
        }
        banking.printReport();
         
         
         
         
        
    }
    
}
