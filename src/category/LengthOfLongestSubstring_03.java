package category;

import java.util.HashSet;

/**
 * Created by angela on 17/6/18.
 */
public class LengthOfLongestSubstring_03 {
    public static int lengthOfLongestSubstring(String s) {
        int head = -1;
        int tail = -1;
        int result = 0;

        HashSet<Character> set = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            //current
            char current = s.charAt(i);

            //保证current能正常入队
            while (set.contains(current)) {
                //出队
                head += 1;
                set.remove(s.charAt(head));
            }

            //入队
            tail += 1;
            set.add(current);
            result = result > set.size() ? result : set.size();
        }
        return result;
    }
}
