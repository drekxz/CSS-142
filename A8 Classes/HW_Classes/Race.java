public class Race{
    private double aTime;
    private double bTime;
    private double cTime;
    Race(double aT, double bT, double cT){ //constructor sets vals for @params
        this.aTime = aT;
        this.bTime = bT;
        this.cTime = cT;
    }
    
    public void sendReport(){ //is public so class racereport can access race
        sortTimesAscending(aTime, bTime, cTime);
        System.out.print("The average time of all racers (in seconds): ");
        System.out.printf("%.2f", setAverage(aTime, bTime, cTime));
        System.out.println();
    }

    private void sortTimesAscending(double a, double b, double c){
        String first = "First place (time in seconds): ";
        String second = "Second place (time in seconds): ";
        String third = "Third place (time in seconds): ";
        double largest = 0.0;
        double middle = 0.0;
        double smallest = 0.0;
        if(a > b && c > b){ //b is last
            smallest = b;
            if(a > c){ //a is first 
                largest = a;
                System.out.println(first + a);
                middle = c;
                System.out.println(second + c);
                System.out.println();
            }else if(a == c){ //a and c are first
                largest = a;
                System.out.println(first + a);
                middle = c;
                System.out.println(second + c);
                System.out.println();
                System.out.println("Two racers shared first place");
            }else{ //c is first
                largest = c;
                System.out.println(first + c);
                middle = a;
                System.out.println(second + a);
            }
            System.out.println(third + b);
        }else if(a > c && b > c){ //c is last
            smallest = c;
            if(a > b){ //a is first
                largest = a;
                System.out.println(first + a);
                middle = b;
                System.out.println(second + b);
            }else if(a == b){ //a and b are first
                largest = a;
                System.out.println(first + a);
                middle = b;
                System.out.println(second + b);
            }else{ //b is first
                largest = b;
                System.out.println(first + b);
                middle = a;
                System.out.println(second + a);
            }
            System.out.println(third + c);
            System.out.println();
            if(a == b)
                System.out.println("Two racers shared first place");
        }else if(b > a && c > a){ //a is last
            smallest = a;
            if(b > c){ //b is first
                largest = b;
                System.out.println(first + b);
                middle = c;
                System.out.println(second + c);
            }else if(b == c){ //b and c are first
                largest = b;
                System.out.println(first + b);
                middle = c;
                System.out.println(second + c);
            }else{ //c is first
                largest = c;
                System.out.println(first + c);
                middle = b;
                System.out.println(second + b);
            }
            System.out.println(third + a);
            System.out.println();
            if(b == c)
                System.out.println("Two racers shared first place");
        }else if(a > b && a > c){ //b and c are tied for last
            if(b == c){
                largest = a;
                middle = b;
                smallest = c;
                System.out.println(first + a);
                System.out.println(second + b);
                System.out.println(third + c);
                System.out.println();
                System.out.println("Two racers shared last place.");
            }
        }else if(b > a && b > c){ //a and c are tied for last
            if(a == c){
                largest = b;
                middle = a;
                smallest = c;
                System.out.println(first + b);
                System.out.println(second + a);
                System.out.println(third + c);
                System.out.println();
                System.out.println("Two racers shared last place.");
            }
        }else if(c > a && c > b){ //a and b are tied for last
            if(a == b){
                largest = c;
                middle = a;
                smallest = b;
                System.out.println(first + c);
                System.out.println(second + a);
                System.out.println(third + b);
                System.out.println();
                System.out.println("Two racers shared last place.");
            }
        }else{ //all are tied
            largest = a;
            middle = b;
            smallest = c;
            System.out.println(first + a);
            System.out.println(second + b);
            System.out.println(third + c);
            System.out.println();
            System.out.println("All racers are tied.");
        }
        System.out.print("The range of the race times (in seconds): ");
        System.out.printf("%.1f", setRange(largest, middle, smallest));
        //setRange called in sortTimeAsc. because a b & c are already sorted
        System.out.println();
    }

    private double setRange(double large, double mid, double small){
        double range = 0.0;
        if(large == mid)
            mid = 0 + 1; //+1 to fix the range result
        else if(mid == small)
            small = 0 + 1; //+1 to fix the range result
        else if(large == mid && mid == small){ 
            return 0.0; //all are 0 because there is no range
        }
        double temp1 = large - mid;
        double temp2 = mid - small;
        range = temp1 + temp2;
        return range;
    }

    private double setAverage(double a, double b, double c){
        double sum = a + b + c; //adds up a b c
        double average = sum / 3; //divides to find avg
        return average;
    }
}