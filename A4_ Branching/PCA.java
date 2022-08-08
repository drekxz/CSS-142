public class PCA{
    public static void main(String[] args){
        System.out.println(bobThere("abcbob"));
        System.out.println(bobThere("b9b"));
        System.out.println(bobThere("bbb"));
        System.out.println(bobThere("bbc"));
        System.out.println(bobThere("123abcbcdbabxyz"));
        System.out.println(bobThere("b1b"));
        System.out.println(bobThere("b12b1b"));
        System.out.println(bobThere("bbb"));
    }

    public static boolean bobThere(String str) {
        boolean result = false;
        outerloop:
        for(int i = 0; i <= str.length(); i++){
            if(str.length() <= 2)
                break outerloop;
            if(i == str.length() - 2)
                break outerloop;
            if(str.charAt(i) == 'b' && str.charAt(i + 2) == 'b'){
                result = true;
                break outerloop;
            }
        }
        return result;
    }
}