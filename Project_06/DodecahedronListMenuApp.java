import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
//import java.io.File; 

/**
 *Program that presents a menu to the user with eight options.
 *
 *Project 6(DodecahedronListMenuApp)
 *@author Erika Yardumian - CPSC - 1213
 *@version 9/30/18
 */
 

 
public class DodecahedronListMenuApp {
   /**
    *Creates a class that .
    *@param args - Command line arguments - not used.
    *@exception IOException on input error
    */
   public static void main(String[] args) throws IOException {
      String fileName = "";
      String getName = "*** no list name assigned ***";
      ArrayList<Dodecahedron> dodList = new ArrayList<Dodecahedron>();
      DodecahedronList dodecahedronList = 
         new DodecahedronList(getName, dodList);
      Scanner userInput = new Scanner(System.in);
      
      char choice = 'Q';
      System.out.print("Dodecahedron List System Menu" 
            + "\nR - Read File and Create Dodecahedron List"
            + "\nP - Print Dodecahedron List"
            + "\nS - Print Summary"
            + "\nA - Add Dodecahedron"
            + "\nD - Delete Dodecahedron"
            + "\nF - Find Dodecahedron"
            + "\nE - Edit Dodecahedron"
            + "\nQ - Quit");
   
      do {
         System.out.print("\nEnter Code [R, P, S, A, D, F, E, or Q]: ");
         choice = userInput.next().toUpperCase().charAt(0);
      
         switch (choice)
         {
            case 'R':
               System.out.print("\tFile name: ");
               fileName = userInput.next();
               dodecahedronList = dodecahedronList.readFile(fileName);
               System.out.println("\tFile read in and Dodecahedron" 
                  + "List created");
               break;
               
            case 'P':
               // Prints the DodecahedronList Object
               // DodecahedronList dodecahed = new DodecahedronList(null, null);
               System.out.println(dodecahedronList.toString());
               break;
               
            case 'S':
               System.out.print(dodecahedronList.summaryInfo());
               break;
               
            case 'A':
               userInput.nextLine();
               System.out.print("\tLabel: ");
               String label = userInput.nextLine();
               System.out.print("\tColor: ");
               String color = userInput.nextLine();
               System.out.print("\tEdge: ");
               double edge = userInput.nextDouble();
               dodecahedronList.addDodecahedron(label, color, edge);
               System.out.print("\t*** Dodecahedron added ***\n");
               break; 
               
            case 'D':
               userInput.nextLine();
               System.out.print("\tLabel: ");
               label = userInput.nextLine();
               
               if (dodecahedronList.findDodecahedron(label) != null) {
                  dodecahedronList.deleteDodecahedron(label);
                  System.out.println("\"" + label + "\"" + " deleted.");   
               } else {
                  System.out.println("\"" + label + "\"" + " not found.");
               }
               
               break;
            
            case 'F': 
               userInput.nextLine();
               System.out.print("\tLabel: ");
               label = userInput.nextLine();
               if (dodecahedronList.findDodecahedron(label) != null) {
                  System.out.println("Eureka - Found it!");
               } else {
                  System.out.println("Bummer - Not Found!");                  }
               break;
         
            case 'E':
               userInput.nextLine();
               System.out.print("\tLabel: ");
               label = userInput.nextLine();
               System.out.print("\tColor: ");
               color = userInput.nextLine();
               System.out.print("\tEdge: ");
               edge = userInput.nextDouble();
               dodecahedronList.editDodecahedron(label, color, edge);
               break;
         
            case 'Q':
               break;
                              
            default:
               System.out.println("*** invalid choice***\n");
               break;
         }
      } while (choice != 'Q');
   
   }
               
                                 
} 
      

 
