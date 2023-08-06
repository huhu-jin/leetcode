//  [370]区间加法

//假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k 个更新的操作。 
//
// 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... endInd
//ex]（包括 startIndex 和 endIndex）增加 inc。 
//
// 请你返回 k 次操作后的数组。 
//
// 示例: 
//
// 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
//输出: [-2,0,3,5,3]
// 
//
// 解释: 
//
// 初始状态:
//[0,0,0,0,0]
//
//进行了操作 [1,3,2] 后的状态:
//[0,2,2,2,0]
//
//进行了操作 [2,4,3] 后的状态:
//[0,2,5,5,3]
//
//进行了操作 [0,2,-2] 后的状态:
//[-2,0,3,5,3]
// 
// Related Topics 数组 前缀和 
// 👍 83 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;


public class Q370_RangeAddition{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 方法一 暴力++ 效率低


    // 差分数组: 记录前一位与后一位差值
    // 比如 [2,1,0,0,0] 表示 [2,3,3,3,3]
    // 对应更新三元组 就是 [1,3,2]
    // [0,0,0,0,0] -> [0,2,0,0,-2]
    // 最后将差分数组还原就好
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        Arrays.fill(res, 0);
        if(updates.length == 0) return res;
        for(int[] update : updates) {
            res[update[0]] += update[2];
            if(update[1] < length - 1) {
                res[update[1] + 1] -= update[2];
            }
        }
        for(int i = 1; i < res.length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Solution solution = new Solution();
    }
  
}
