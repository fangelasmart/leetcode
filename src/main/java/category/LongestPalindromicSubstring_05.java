package main.java.category;


/**
 * Created by angela on 17/6/19.
 */
public class LongestPalindromicSubstring_05 {

    public static String longestPalindrome(String s) {
        int size = 0;//最优解
        int i = 0;
        for (int middle = 0; middle < s.length(); middle++) {
            //如果之前的长度小于现在的长度，则将中间值的位置修改为当前位置
            int tmp = findSize(middle, s);
            if (size < tmp) {
                i = middle;
                size = tmp;
            }
        }
        if (size % 2 == 0) {
            return s.substring(i - size / 2 + 1, i + size / 2 +1);
        }

        return s.substring(i - size / 2, i + size / 2 + 1);
    }


    public static int findSize(int middle, String str) {

        /**
         *
         * tabcbay 0<=m-i == m+i<size
         *
         * abccba   0<=m-i == m+i+1<size
         *
         */
        int size = 0;
        int distance = 0;

        for (distance = 0; distance <= middle && distance < str.length() - middle; distance++) {
            int left = middle - distance;
            int right = middle + distance;
            if (str.charAt(left) == str.charAt(right)) {
                continue;
            }
            break;
        }
        size = 2 * distance - 1;


        for (distance = 0; distance <= middle && middle + distance + 1 < str.length(); distance++) {
            int left = middle - distance;
            int right = middle + distance + 1;

            if (str.charAt(left) == str.charAt(right)) {
                continue;
            }
            break;
        }

        int size2 = 2 * distance;

        return size > size2 ? size : size2;
    }

}
