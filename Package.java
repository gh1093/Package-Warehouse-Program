package javaappgabe;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
Package class - contains all functions that will make the menu run
*/
public class Package {
    private String trackingNum;
    private String type;
    private String specification;
    private String mailingClass;
    private float weight;
    private int vol;
    private int myArray[]; 
    private ArrayList<Package> arr;
    
    /*
    helper function used by the addpackage function to add a package 
    to the arraylist
    */
    public void addToArr(Package a)
    {
        
        arr.add(a);
    }
    /*
    Constructor: creates a new package object and a new arraylist to be 
    used by the object
    */
    public Package() {
        arr=new ArrayList();
    
    }
    /*
    Setter function. Sets package type
    */
    public void setType(String s)
    {
        this.type=s;
    }
 /*
    setter function. Sets package tracking number. 
    Parameter is a string that is used to set the tracking variable
    */
    public void setTracking(String t)
    {
        this.trackingNum=t;
    }
    /*
    Setter function used to set package 
    */
   /* public void setPackType(String t)
    {
        this.type=t;
    }*/
    /*
    getter functions. Returns a string containing the package type
    */
    public String getType()
    {
        return this.type;
    }
    /*
    getter function. returns a string containing package specification
    */
    
    public String getSpec()
    {
        return this.specification;
    }
    /*
    setter functions. Sets package specification
    */
    public void setSpec(String t)
    {
        this.specification=t;
    }
    /*
    setter function. sets package mailing class
    */
    public void setMailing(String t)
    {
        this.mailingClass=t;
    }
    /*
    getter function. returns a string containing the mailing class
    */
    public String getMailing()
    {
        return this.mailingClass;
    }
    /*
    setter functions-sets package weight
    */
    public void setWeight(float f)
    {
        this.weight=f;
    }
    /*
    getter function returns a float containing package weight
    */
    public float getWeight()
    {
        return this.weight;
    }
    /*
    setter function. Sets package volume
    */
    public void setVolume(int a)
    {
        this.vol=a;
    }
    /*
    getter function returns int containing package volume
    */
    public int getVol()
    {
        return this.vol;
    }
    /*
    add a package function. When users enter 2 in the menu, this function 
    is ran asks for package info and verifies them to make sure no bogus 
    input is received. Adds that input to a package object which is then 
    added to the arraylist
    */
    public void addPackage() throws IOException
    {
        Package a=new Package();
        System.out.println("Enter 5 digit tracking number");
        Scanner sc = new Scanner(System.in);
        String i = sc.nextLine();
        while(i.length()!=5)
        {
            System.out.println("Tracking number must be 5 digits");
               sc = new Scanner(System.in);
               i = sc.nextLine();
        }
        a.setTracking(i);
        System.out.println("Enter package type ");
         sc = new Scanner(System.in);
         i = sc.nextLine();   
         while(!i.equals("Postcard") && !i.equals("postcard") && !i.equals("Letter") &&
                 !i.equals("letter") && !i.equals("Envelope") && !i.equals("envelope") 
                 && !i.equals("Box") && !i.equals("box") && !i.equals("Packet") && 
                 !i.equals("packet") && !i.equals("Crate") && !i.equals("crate") &&
                 !i.equals("Drum") && !i.equals("drum") && !i.equals("Roll") &&
                 !i.equals("roll") && !i.equals("Tube") && !i.equals("tube")){
                      System.out.println("That is not a valid package type. Try again: ");
                      sc = new Scanner(System.in);
                      i = sc.nextLine();
                  }
        a.setType(i);
        
        System.out.println("Enter specification: ");
        sc = new Scanner(System.in);
        i = sc.nextLine();
        while(!i.equals("Fragile") && !i.equals("fragile") && !i.equals("Books") 
                && !i.equals("books") && !i.equals("Catalogs")
                && !i.equals("catalogs") && !i.equals("N/A") && !i.equals("n/a") && 
                !i.equals("Do-not-Bend") && !i.equals("do-not-bend"))
        {
             System.out.println("That is not a valid specification. Try again: ");
              sc = new Scanner(System.in);
              i = sc.nextLine();
        }
        a.setSpec(i);
        
         System.out.println("Enter mailing class: ");
         sc = new Scanner(System.in);
         i = sc.nextLine();
         while(!i.equals("First-Class") && !i.equals("first-class") && !i.equals("Priority")
                 && !i.equals("priority") && !i.equals("Retail") && !i.equals("retail")
                 && !i.equals("Ground") && !i.equals("Metro") && !i.equals("metro")
                 && !i.equals("first"))
         {
               System.out.println("That is not a valid mailing class. Try again: ");
              sc = new Scanner(System.in);
              i = sc.nextLine();
         }
         a.setMailing(i);
         
        
         System.out.println("Enter weight (in oz): ");
         sc = new Scanner(System.in);
         float fl = sc.nextFloat();
        
         a.setWeight(fl);
         
         System.out.println("Enter the length of your package (in inches):");
         sc = new Scanner(System.in);
         int length = sc.nextInt();
         System.out.println("Enter the width of your package (in inches):");
         sc = new Scanner(System.in);
         int width = sc.nextInt();
         System.out.println("Enter the height of your package (in inches):");
         sc = new Scanner(System.in);
         int height = sc.nextInt();
         int volume = length * width * height;
         
         a.setVolume(volume);
         
         arr.add(a);
         
    }
    
    /*
    getter function. returns a string containing the tracking #
    */
    public String getTracking()
    {
        return trackingNum;
    }
    
    //delete a package. is this supposed to be via tracking number?
    public void deletePackage()
    {
        System.out.println("Enter associated tracking number to delete record: ");
        Scanner sc=new Scanner(System.in);
         String s = sc.nextLine();
        while(s.length()!=5)
        {
            System.out.println("Tracking number must be 5 digits");
               sc = new Scanner(System.in);
               s = sc.nextLine();
        }
        String trackingnumber=s;
        
        for (int x=0; x<arr.size();x++)
        {
            
            
           Package a=arr.get(x);
            if(a.getTracking().equals(trackingnumber))
            { 
                arr.remove(x);
                System.out.println("Package removed!");
                System.out.println("Press enter to continue");
               try {
                   System.in.read();
               } catch (IOException ex) {
                   
               }
                return;
            
            }
                
        } //do we need else right here?
        System.out.println("That tracking number does not exist");
        System.out.println("Press enter to continue");
               try {
                   System.in.read();
               } catch (IOException ex) {
                   
               }
    }
    /* When user enters 4 in menu, this function is called. Asks for a tracking number and
    searches the arraylist to see if it exists. If it does not exist, user is notified via output
    
    */
    public void search() 
    {
        System.out.println("Enter a tracking number to look up: ");
        Scanner sc=new Scanner(System.in);
         String s = sc.nextLine();
        while(s.length()!=5)
        {
            System.out.println("Tracking number must be 5 digits");
               sc = new Scanner(System.in);
               s = sc.nextLine();
        }
        String trackingnumber=s;
          for (int x=0; x<arr.size();x++)
        {
           Package a=arr.get(x);
            if(a.getTracking().equals(trackingnumber))
            { 
               System.out.println("------------------------------------------"
                    + "----------------------------");
            System.out.printf("%10s %10s %10s %10s %10s %10s\n", "TRACKING #|","TYPE| ","SPECIFICATION|",
            "CLASS|", "WEIGHT|","VOLUME |");
             System.out.println("------------------------------------------"
                    + "----------------------------");
             
              System.out.printf("%10s %10s %15s %10s %10.2f %10s\n", arr.get(x).getTracking(),
                  arr.get(x).getType(),
                   arr.get(x).getSpec(),arr.get(x).getMailing(),
                        arr.get(x).getWeight(),  arr.get(x).getVol()); 
                 System.out.println("------------------------------------------"
                    + "----------------------------");
                 System.out.println("Press enter to continue");
               try {
                   System.in.read();
               } catch (IOException ex) {  
               }
                 return;
            }
        }
         System.err.println("Tracking number not found, press enter to continue!"); 
         try {
             System.in.read();
         } catch (IOException ex){
             
         }
    }
     
    
    /*
    When user enters 1 in menu, this function is called. Goes through arraylist and prints 
    all contents
    */
    public void showAll()
    {
        if(arr.size()==0)
        {
            System.out.println("Database is empty!");
            return;
        }
        else
        {
            System.out.println("------------------------------------------"
                    + "----------------------------");
            System.out.printf("%10s %10s %10s %10s %10s %10s\n", "TRACKING #|","TYPE| ","SPECIFICATION|",
            "CLASS|", "WEIGHT|","VOLUME |");
             System.out.println("------------------------------------------"
                    + "----------------------------");
            
        }
        for (int x=0; x<arr.size();x++)
        {
           Package a=arr.get(x);  
           System.out.printf("%10s %10s %15s %10s %10.2f %10s\n", arr.get(x).getTracking(),
                  arr.get(x).getType(),
                   arr.get(x).getSpec(),arr.get(x).getMailing(),
                        arr.get(x).getWeight(),  arr.get(x).getVol());        
        }
        
         System.out.println("------------------------------------------"
                    + "----------------------------");
         System.out.println("Press enter to continue");
               try {
                   System.in.read();
               } catch (IOException ex) {
                   
               }
    }
    /*
    when user presses 6, this function is called. Contents of arraylist are sent to text file and the program 
    ends
    */
    public void quitProgram()
    {
        //everything in our arraylist is to go to packages file
        
        try{
        PrintWriter writer = new PrintWriter("packages", "UTF-8");
        for(int x=0;x<arr.size();x++)
        {
            writer.println(arr.get(x).getTracking() + " " + arr.get(x).getType()
            + " " + arr.get(x).getSpec()+ " "+ arr.get(x).getMailing()+ " "+arr.get(x).getWeight()+ " " + 
                    arr.get(x).getVol());
        }
        writer.close();
    
}   catch (IOException e) {
            System.err.println("Can't write to packages file");
}
    }
    
    
    /*
    when user enters 5 at menu, this function is called. Takes 2 numbers and searches for
    packages with weight that is in between those numbers.
    */
    public void showWeight()
{
    
    System.out.print("Enter lower bound: ");
    Scanner in=new Scanner(System.in);
    float low=in.nextFloat();
    System.out.print("Enter upper bound: ");
    in=new Scanner(System.in);
    float high=in.nextFloat();
    
    // output header here
     System.out.println("------------------------------------------"
                    + "----------------------------");
            System.out.printf("%10s %10s %10s %10s %10s %10s\n", "TRACKING #|","TYPE| ","SPECIFICATION|",
            "CLASS|", "WEIGHT|","VOLUME |");
             System.out.println("------------------------------------------"
                    + "----------------------------");
             boolean packagesWithinRange=false;
    for(int x=0;x<arr.size();x++)
    {
        if(arr.get(x).getWeight()<high && arr.get(x).getWeight()>low)
        {
            packagesWithinRange=true;
            System.out.printf("%10s %10s %15s %10s %10.2f %10s\n", arr.get(x).getTracking(),
                  arr.get(x).getType(),
                   arr.get(x).getSpec(),arr.get(x).getMailing(),
                        arr.get(x).getWeight(),  arr.get(x).getVol());
        }
    }
    if(packagesWithinRange==false) {
        System.out.println("Sorry - no packages exist within that range");
    }
    
   
     System.out.println("------------------------------------------"
                    + "----------------------------");
         System.out.println("Press enter to continue");
               try {
                   System.in.read();
               } catch (IOException ex) {
                   
               }
    
        
  
        
}

    
    
}

