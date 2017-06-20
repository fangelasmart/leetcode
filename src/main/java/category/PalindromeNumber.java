package main.java.category;

/**
 *
 * 判断一个数是不是回文
 *
 * Created by angela on 17/6/20.
 */
public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int tempX = x;
        int reverse = 0;
        // 当tempX剩下一位数的时候停下来
        while (tempX >= 10) {
            reverse = reverse * 10 + tempX % 10;
            tempX /= 10;
        }
        //对比整个x的头尾两位，以及中间所有位reverse以后是否与不reverser时一致
        return tempX == x % 10 && reverse == x / 10;
    }
}
