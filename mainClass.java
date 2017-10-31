package javaappgabe;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/* main class. Extends our package class which contains all the functions
that will be used via the user menu
*/
public class JavaAppGabe extends Package {
    public static void main(String[] args) throws IOException {
        int[] myArray = new int[5];
        
        Package pack =new Package();
        Package pack2=new Package();
        
            try {
    String fileName = "packages";
    Scanner in = new Scanner(new File(fileName));
   
        int a=0;
        while(in.hasNext())
        {
            if(a==0)
                pack.setTracking(in.next());
            else if(a==1)
                pack.setType(in.next());
            else if(a==2)
                pack.setSpec(in.next());
            else if(a==3)
                pack.setMailing(in.next());
            else if(a==4)
                pack.setWeight(Float.parseFloat(in.next()));
            else if(a==5)
            {
                a=-1;
                pack.setVolume(Integer.parseInt(in.next()));
                pack2.addToArr(pack); //why do you add pack here?
                pack=new Package();
            }
             a++;
        }
}
catch (FileNotFoundException e){
System.err.println("This file could not be found!");
    } 
        int i=0;
        while(i!=6){
        System.out.println("1. Show all existing package records in the database (in any order)");
        System.out.println("2. Add a new package record to the database");
        System.out.println("3. Delete package record from a database");
        System.out.println("4. Search for a package (given its tracking number)");
        System.out.println("5. Show a list of packages within a given weight range");
        System.out.println("6. Exit program");
           Scanner sc = new Scanner(System.in);
        i = sc.nextInt();
        if(i==1)
            pack2.showAll();
        else if(i==2)
            pack2.addPackage();
        else if(i==3)
            pack2.deletePackage();
        else if(i==4)
            pack2.search();
        else if(i==5)
            pack2.showWeight();//fix
        else if(i==6)
            pack2.quitProgram();
            
        }
        
        
        
    
        
    }
    
}
