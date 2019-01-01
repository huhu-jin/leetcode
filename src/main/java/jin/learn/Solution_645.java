package jin.learn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_645 {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int[] flag = new int[nums.length + 1];
        int i;
        for (i = 0; i < nums.length; ++i) {
            flag[nums[i]]++;
            if (flag[nums[i]] == 2) {
                result[0] = nums[i];
            }
        }
        for (i = 1; i <= nums.length; ++i) {
            if (flag[i] == 0) {
                result[1] = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] errorNums = new Solution_645().findErrorNums(new int[]{1,2,2,4});
        System.out.println(errorNums);

    }
}
