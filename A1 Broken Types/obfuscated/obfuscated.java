public class obfuscated{
    static int doMath(int num){
        int x=0;
        int y;
        int powerof2=1;
        while(num!=0){ 
            y=num%10;
            num=num/10;
            x=x+y*powerof2;
            powerof2=powerof2*2;
        }
        return x;
    }
    public static void main(String[] args) {
        assert(doMath(1101)!=10);
        assert(doMath(0000)==0);
        assert(doMath(1111)==15);
        assert(doMath(1001)==9);
        System.out.println("If we got here, all is well!");
    }
} 
