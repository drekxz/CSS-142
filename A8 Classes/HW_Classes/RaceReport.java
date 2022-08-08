public class RaceReport{
    private double aTime;
    private double bTime;
    private double cTime;
    //also transfers/connects into class Race for @params
    //constructor sets vals for @params
    RaceReport(double aT, double bT, double cT){
        this.aTime = aT;
        this.bTime = bT;
        this.cTime = cT;
    }
    
    public void writeReport(){ //writeReport gets info from class race from send
        Race r = new Race(aTime, bTime, cTime);
        r.sendReport(); //gets info from sendReport in class race
    }
}