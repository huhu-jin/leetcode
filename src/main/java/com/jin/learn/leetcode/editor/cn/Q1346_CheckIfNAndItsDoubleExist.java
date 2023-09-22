//  [1346]检查整数及其两倍数是否存在
//给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。 
//
// 更正式地，检查是否存在两个下标 i 和 j 满足： 
//
// 
// i != j 
// 0 <= i, j < arr.length 
// arr[i] == 2 * arr[j] 
// 
//
// 
//
// 示例 1： 
//
// 输入：arr = [10,2,5,3]
//输出：true
//解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
// 
//
// 示例 2： 
//
// 输入：arr = [7,1,14,11]
//输出：true
//解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
// 
//
// 示例 3： 
//
// 输入：arr = [3,1,7,11]
//输出：false
//解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 500 
// -10^3 <= arr[i] <= 10^3 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 102 👎 0

package com.jin.learn.leetcode.editor.cn;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Q1346_CheckIfNAndItsDoubleExist{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //         链接：https://leetcode.cn/problems/check-if-n-and-its-double-exist/solutions/1819843/by-fan-zhi-xuan-b80z/
        public boolean checkIfExist(int[] arr) {
            Set<Integer> set = new HashSet<>();
            for (int i : arr) {
                if (set.contains(i) || set.contains(i * 4)) {
                    return true;
                }
                set.add(i * 2);
            }
            return false;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    @Test
    public void testCase(){
    new Solution().checkIfExist(new int[]{-2,0,10,-19,4,6,-8});
    }
}