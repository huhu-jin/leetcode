//  [666]路径总和 IV

//对于一棵深度小于 5 的树，可以用一组三位十进制整数来表示。 
//
// 对于每个整数： 
//
// 
// 百位上的数字表示这个节点的深度 D，1 <= D <= 4。 
// 十位上的数字表示这个节点在当前层所在的位置 P， 1 <= P <= 8。位置编号与一棵满二叉树的位置编号相同。 
// 个位上的数字表示这个节点的权值 V，0 <= V <= 9。 
// 
//
// 给定一个包含三位整数的升序数组，表示一棵深度小于 5 的二叉树，请你返回从根到所有叶子结点的路径之和。 
//
// 
//
// 示例 1： 
//
// 
//输入: [113, 215, 221]
//输出: 12
//解释: 
//这棵树形状如下:
//    3
//   / \
//  5   1
//
//路径和 = (3 + 5) + (3 + 1) = 12.
// 
//
// 示例 2： 
//
// 
//输入: [113, 221]
//输出: 4
//解释: 
//这棵树形状如下: 
//    3
//     \
//      1
//
//路径和 = (3 + 1) = 4.
// 
//
// 
// Related Topics 树 深度优先搜索 数组 二叉树 
// 👍 34 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class PathSumIv{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        int ans = 0;
        Map<Integer, Integer> values;
        public int pathSum(int[] nums) {
            values = new HashMap<>();
            for (int num: nums)
                values.put(num / 10, num % 10);

            dfs(nums[0] / 10, 0);
            return ans;
        }

        public void dfs(int node, int sum) {
            if (!values.containsKey(node)) return;
            sum += values.get(node);

            int depth = node / 10, pos = node % 10;
            int left = (depth + 1) * 10 + 2 * pos - 1;
            int right = left + 1;
            //这里的 递归退出写的 很棒
            if (!values.containsKey(left) && !values.containsKey(right)) {
                ans += sum;
            } else {
                dfs(left, sum);
                dfs(right, sum);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}