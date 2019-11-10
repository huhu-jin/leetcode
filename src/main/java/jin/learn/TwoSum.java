package jin.learn;

import java.util.HashMap;

/**
 * 难点在于,如何迭代
 *
 *
 */

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] ret =  new int[]{-1,-1};
        if (nums == null || nums.length < 2) {
            return ret;
        }
        HashMap<Integer, Integer> content = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (content.containsKey(target - nums[i])) {
                ret[0] = i;
                ret[1] = content.get(target - nums[i]);
                break;
            }
            // 难点在于如何构建content,一遍遍历,一遍放入
            content.put(nums[i], i);
        }
        return ret;
    }
}
