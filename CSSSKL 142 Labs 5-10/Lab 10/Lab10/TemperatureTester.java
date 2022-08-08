public class TemperatureTester
{
    public static void main(String[] args){
        Temperature a = new Temperature(0.0, 'C');     
        System.out.println(a);
        System.out.println("Fahrenheit: " + a.getFahrenheit());
        System.out.println();
        Temperature b = new Temperature(-40.0, 'F');
        System.out.println(b);
        System.out.println("Fahrenheit: " + b.getCelcius());
        System.out.println();
        Temperature c = new Temperature(100.0, 'C');
        System.out.println(c);
        System.out.println("Celcius: " + c.getFahrenheit());
        System.out.println();
        Temperature d = new Temperature(72.0, 'F');
        System.out.println(d);
        System.out.println("Celcius: " + d.getCelcius());
        System.out.println();
    }
}