import exceptions.Assignment2FileNotFoundException;

import java.io.FileNotFoundException;

public class Solution {
    public int maximalniBrojBalona(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        try {

            for (char slovo : text.toCharArray()) {
                switch (slovo) {
                    case 'B' -> ++b;
                    case 'A' -> ++a;
                    case 'L' -> ++l;
                    case 'O' -> ++o;
                    case 'N' -> ++n;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Math.min(Math.min(o / 2, l / 2), Math.min(Math.min(b, a), n));
    }
}
