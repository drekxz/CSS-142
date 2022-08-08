import java.math.BigDecimal;
import java.math.RoundingMode;
public class Temperature{
    private double temp;
    private char scale;
    Temperature(){

    }

    Temperature(double myTemp, char myScale){
        setBoth(myTemp, myScale);
    }

    public double getCelcius(){
        return calcTemp('C');
    }

    public double getFahrenheit(){
        return calcTemp('F');
    }

    private double calcTemp(char requestedScale){
        double val = 0.0;
        if(requestedScale == this.scale){
            val =  this.temp;
        }else{
            switch(requestedScale){
                case 'F':
                val =  (9 * (temp)/5) + 32;
                break;
                case 'C':
                val = 5 * (temp - 32) / 9;
                break;
            }
        }
        return val;
    }

    public int setValue(double myTemp){
        this.temp = myTemp;
        return compare(myTemp);
    }

    public void setScale(char myScale){
        this.scale = myScale;
    }

    public void setBoth(double myTemp, char myScale){
        setValue(myTemp);
        setScale(myScale);
    }

    private int compare(double myTemp){
        if(myTemp > this.temp)
            return 1;
        else if(myTemp < this.temp)
            return -1;
        else
            return 0;
    }

    public String toString(){
        BigDecimal fmt = new BigDecimal(scale);
        fmt = fmt.setScale(2, RoundingMode.HALF_UP);
        return "<Temp: " + fmt + " " + scale + ">";
    }
}