public class Solution {
    public static int maximalniBrojBalona(String text){
        int b=0,a=0,l=0,o=0,n=0;
        for(char slovo:text.toCharArray()){
            switch(slovo){
                case 'B': ++b;
                    break;
                case 'A': ++a;
                    break;
                case 'L': ++l;
                    break;
                case 'O': ++o;
                    break;
                case 'N': ++n;
                    break;
            }
        }
        return Math.min(Math.min(o/2, l/2), Math.min(Math.min(b, a), n));
    }
}
