
/**
 * Write a description of class brokenTypes here.
 *
 * @author (Nikolas Antoun)
 * @version (a version number or a date)
 */
public class brokenTypes
{
    public static int add2(int a, int b)
    {
        int sum = a + b;
        return sum;
    }
    
    public static double getVelocity(double distance, double time)
    {
        double velocity = distance / time;
        return velocity;
    }
    
    public static char whatDoesItStartWith(String word)
    {
        char s = word.charAt(0);
        return s;
    }
    
    public static int exclamationFinder(String word)
    {
        int loc = word.indexOf("!");
        return loc;
    }
       
    public static boolean isRaining()
    {
        // we assume it is always raining and we are wet
        boolean isWet = true;
        return isWet;
    }
    
    
    public static void main(String[] args)
    {
        int x = add2(20, 30);
        assert(x == 50);
        double v = getVelocity(65.0, 90.0);
        assert(v < 1.0d);
        assert(v > 0.0d);
        boolean areWeWet = isRaining();
        assert(areWeWet);
        assert(whatDoesItStartWith("Java Rocks!") == 'J');
        assert(exclamationFinder("Java Rocks!") == 10);
        System.out.println("If we got here, all is well!");
    }
}