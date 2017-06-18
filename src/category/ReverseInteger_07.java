package category;

/**
 * Created by angela on 17/6/18.
 */
public class ReverseInteger_07 {


    public static int reverse(int x) {
        long result = 0;

        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }

        return (result > 0x7FFFFFFF || result < 0x80000000) ? 0 : (int) result;
    }
}
