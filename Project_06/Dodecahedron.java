import java.text.DecimalFormat;
/**
 *Creates a Dodecahedron class that stores the label, color, and edge.
 *
 *Project 5 (Dodecahedron)
 *@author Erika Yardumian - CPSC - 1213
 *@version 9/21/18
 */
public class Dodecahedron {
 /**Creates Dodecahedron class.
  *@param args - Command line arguments - not used.
  */
 
 //Instance variables.
   private String label = "";
   private String color = "";
   private double edge = 0;
      
 /** 
  * Constructor to assign values to variables.
  * @param labelIn is Dodecahedron
  * @param colorIn is Dodecahedron
  * @param edgeIn is Dodecahedron
  */  
  
   public Dodecahedron(String labelIn, String colorIn, double edgeIn) {
      setLabel(labelIn);
      setColor(colorIn);
      setEdge(edgeIn);
   } 
      
   // methods
   /**
    * @return String value of object
    */
   public String getLabel() {
      return label;
   }
   
   /**
   *Method call for label.
   *@param labelIn is setLabel
   *@return boolean value of object
   */
   public boolean setLabel(String labelIn) {
      if (labelIn != null) {
         label = labelIn.trim();
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
   *Method call to get color.
   *@return String color
   */
   public String getColor() {
      return color;
   }
   
   /**
   *Method call to set color.
   *@param colorIn is setColor
   *@return boolean value of object
   */
   public boolean setColor(String colorIn) {
      if (colorIn != null) {
         color = colorIn.trim();
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
   *Method call to get edge.
   *@return Double edge
   */
   public double getEdge() {
      return edge;
   }
   
   /**
   *Method call to set edge.
   *@param edgeIn is setEdge
   *@return Double edge
   */
   public boolean setEdge(double edgeIn) {
      if (edgeIn > 0) {
         edge = edgeIn;
         return true;
      } 
      else {
         return false;
      }
   }
   
   /**
   *Method call to calculate surfaceArea.
   *@return Double area
   */
   public double surfaceArea() {
      double area;
      area = 3 * Math.sqrt(25 + (10 * Math.sqrt(5))) * (Math.pow(edge, 2));
      return area;
   }
   
   /**
   *Method call to calculate volume.
   *@return Double volume
   */
   public double volume() {
      double volume;
      volume = (15 + (7 * Math.sqrt(5))) / 4 * (Math.pow(edge, 3));
      return volume;
   }
   
   /**
   *Method call to calculate surfaceToVolumeRatio.
   *@return Double surfaceToVolumeRatio
   */
   public double surfaceToVolumeRatio() {
      double ratio;
      ratio = surfaceArea() / volume();
      return ratio;
   }
    
    /**
   *Method call to return information about the Dodecahedron object.
   *@return output
   */    
   public String toString() {
      DecimalFormat fmt = new DecimalFormat("#,##0.0##");
     
      String output = "Dodecahedron" + " \"" + label + "\" " + "is" + " \"" 
         + color + "\"" + " with 30 edges of length " + fmt.format(edge) 
         + " units." + "\n";
      output += "\t" + "surface area = " + fmt.format(surfaceArea()) 
         + " square units" + "\n";
      output += "\t" + "volume = " + fmt.format(volume()) 
         + " cubic units" + "\n";
      output += "\t" + "surface/volume ratio = " 
         + fmt.format(surfaceToVolumeRatio());
      return output;
   }
}