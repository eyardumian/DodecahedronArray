import java.util.ArrayList;
import java.text.DecimalFormat;
import java.io.File; 
import java.util.Scanner;
import java.io.IOException;

/**
 *Class that stores the name of the list and
 *an array list of Dodecahedron objects.
 *
 *Project 6 (DodecahedronList)
 *@author Erika Yardumian - CPSC - 1213
 *@version 9/30/18
 */
public class DodecahedronList {
 /**Creates DodecahedronList class.
  *@param args - Command line arguments - not used.
  */

   // Instance variable to declare array of Dodecahedron objects.
   private String listName;
   private ArrayList<Dodecahedron> dodList;
      
   /**
    *Constructor to initialize the array.
    * @param listNameIn is DodecahedronList
    * @param dodListIn is DodecahedronList
    */
   public DodecahedronList(String listNameIn, 
      ArrayList<Dodecahedron> dodListIn) {
      dodList = dodListIn;
      listName = listNameIn;
   }
         
    /**
     *Method to return the name of the list.
     *@return the name of the list
     */
   public String getName() {
      return listName;
   }
         
    /**Method to return the number of object in the list.
     *@return the size of the list
     */
   public int numberOfDodecahedrons() {
      return dodList.size();
   }
            
    /**
     *Method to get the total surface area for all objects.
     *@return the total surface area
     */
   public double totalSurfaceArea() {
      double totalSurfArea = 0;
      int index = 0;
      while (dodList.size() > index) {
         totalSurfArea += dodList.get(index).surfaceArea();
         index++;
      }
      return totalSurfArea;
   }
    
    /**
     *Method to get the total volume for all objects.
     *@return the total volume
     */
   public double totalVolume() {
      double totalVol = 0;
      int index = 0;
      while (dodList.size() > index) {
         totalVol += dodList.get(index).volume();
         index++;
      }
      return totalVol;
   } 
   
   /**
    *Method to get the average surface area for all objects.
    *@return the average surface area
    */
   public double averageSurfaceArea() {
      double averageSurfArea = 0;
      if (dodList.size() > 0) {
         averageSurfArea = totalSurfaceArea() / dodList.size();
      }
      return averageSurfArea;
   }
   
   /**
    *Method to get the average volume for all objects.
    *@return the average volume
    */
   public double averageVolume() {
      double averageVol = 0;
      if (dodList.size() > 0) {
         averageVol = totalVolume() / dodList.size();
      }
      return averageVol;
   }
   
   /**
     *Method to get the total surface to volume ration for all objects.
     *@return the total surface to volume ratio
     */
   public double totalSurfaceToVolumeRatio() {
      double totalSTVRatio = 0;
      int index = 0;
      while (dodList.size() > index) {
         totalSTVRatio += dodList.get(index).surfaceToVolumeRatio();
         index++;
      }
      return totalSTVRatio;
   } 

   /**
    *Method to get the average surface to volume ratio.
    *@return the average surface to volume ratio
    */
   public double averageSurfaceToVolumeRatio() {
      double averageSTVRatio = 0;
      if (dodList.size() > 0) {
         averageSTVRatio = totalSurfaceToVolumeRatio() / dodList.size();
      }
      return averageSTVRatio;
   }
   
   /**
    *Method to get a list of all Dodecahedron objects.
    *@return a list of Dodecahedron objects
    */
   public String toString() {
      String list = listName;
      int index = 0;
      while (dodList.size() > index) {
         list += "\n\n" + dodList.get(index);
         index++;
      }
      return list;
   }
   /**
    *Method to get a summary of the objects.
    *@return a summary of the objects
    */
   public String summaryInfo() {
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
      String output = "";
      output += "\n----- Summary for " + getName() + " -----";
      output += "\nNumber of Dodecahedrons: " 
         + fmt.format(numberOfDodecahedrons());
      output += "\nTotal Surface Area: " + fmt.format(totalSurfaceArea());
      output += "\nTotal Volume: " + fmt.format(totalVolume());
      output += "\nAverage Surface Area: " + fmt.format(averageSurfaceArea());
      output += "\nAverage Volume: " + fmt.format(averageVolume());
      output += "\nAverage Surface/Volume Ratio: " 
         + fmt.format(averageSurfaceToVolumeRatio());
      output += "\n";  
      return output;   
   }
   
   /**
    *Method call to return the ArrayList of Dodecahedron objects.
    *@return the ArrayList
    */
   public ArrayList<Dodecahedron> getList() {
      return dodList;
   }
   
   /**
    *Method call to store and use the list name.
    *@return the DodecahedronList object
    *@param fileName is readFile
    *@exception IOException on input error
    */

   public DodecahedronList readFile(String fileName) throws IOException {
   
      String name;
      
      // ArrayList<Dodecahedron> ddList = new ArrayList<Dodecahedron>();
      File file = new File(fileName);
      Scanner scan = new Scanner(file);
      int lineCounter = 0;
      
      String listNamme;
      ArrayList<Dodecahedron> ard = new ArrayList<Dodecahedron>();
      listNamme = scan.nextLine(); //read listname from file
      String st;
      //read all the dodecahedron objects present in the file          
      String label = scan.nextLine();
      // System.out.println(label);
      String color = scan.nextLine();
      // System.out.println(color);
      double edge = Double.parseDouble(scan.nextLine());
      // System.out.println(edge);
      Dodecahedron dd = new Dodecahedron(label, color, edge);
      ard.add(dd); //add       
                            
      DodecahedronList dList = new DodecahedronList(listNamme, ard);
      scan.close();
      return dList;   
   }
   
       
            
   /**
    *Method to add a new Dodecahedron object.
    *@param label is addDodecahedron
    *@param edge is addDodecahedron
    *@param color is addDodecahedron
    */
   public void addDodecahedron(String label, String color, double edge) {
      dodList.add(new Dodecahedron(label, color, edge));
   }
   
   /**
    *Method to locate a Dodecahedron object.
    *@param label is findDodecahedron
    *@return dodec
    */
   public Dodecahedron findDodecahedron(String label) {
      for (int i = 0; i < dodList.size(); i++) {
         Dodecahedron dodec = dodList.get(i);
         if (dodec.getLabel().equalsIgnoreCase(label)) {
            return dodec;
         }
      }
      return null;
   }
   /**
    *Method to delete Dodecahedron object.
    *@param label is deleteDodecahedron
    *@return label
    */
   public String deleteDodecahedron(String label) {
      for (int i = 0; i < dodList.size(); i++) {
         Dodecahedron dodec = dodList.get(i);
         if (dodec.getLabel().equalsIgnoreCase(label)) {
            dodList.remove(dodec);
            return label;
         }
      }
      return null;
   }
   
   /**
    *Method to edit a Dodecahedron object.
    *@param label is editdodecahedron
    *@param color is editdodecahedron
    *@param edge is editdodecahedron
    *@return true
    */
   public boolean editDodecahedron(String label, String color, double edge) {
      for (int i = 0; i < dodList.size(); i++) {
         Dodecahedron dodeca = dodList.get(i);
         if (dodeca.getLabel().equalsIgnoreCase(label)) {
            dodeca.setColor(color);
            dodeca.setEdge(edge);
            return true;
         }
      }
      return false;
   }

}
