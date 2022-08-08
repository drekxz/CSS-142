// Lab1b.java
// This is a practice lab to output a few verses of "99 bottles of beer on the wall"
// Authors: Carol Zander, Clark Olson, you

public class Lab1b {
   
   public static void main (String[] args) { 
      int x = 5;
      verse(x);
      x--;
      verse(x);
      x--;
      verse(x);
      x--;
      verse(x);
      x--;
      verse(x);
      System.out.print("No more bottles of beer on the wall!");
   }
    
   public static void verse(int x){
      int numBottles; 
      numBottles = x;
      if(numBottles >= 1){
          System.out.print(numBottles);
       }
      
      if(x > 1){
          System.out.println(" bottles of beer on the wall");
    }
      else if(x == 1){
          System.out.println(" bottle of beer on the wall");
      }
      if(x > 1){
          System.out.print(numBottles);
          System.out.println(" bottles of beer");
    }
      else if(x == 1){
          System.out.print(numBottles);
          System.out.println(" bottle of beer");
      }else{
          System.out.println("No bottles of beer on the wall");
        }
      takeOneDown();
      numBottles--;
      if(numBottles > 1){
          System.out.print(numBottles);
          System.out.println(" bottles of beer on the wall");
          System.out.println(); 
    }
      else if(numBottles == 1){
          System.out.print(numBottles);
          System.out.println(" bottle of beer on the wall");
          System.out.println(); 
      }
      
    }
   
   public static void takeOneDown() {
       System.out.println("Take one down, pass one down");
    }
}
