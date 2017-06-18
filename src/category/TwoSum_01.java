package category;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by angela on 17/6/18.
 */
public class TwoSum_01 {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}
