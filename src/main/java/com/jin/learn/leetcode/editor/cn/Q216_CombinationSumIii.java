//  [216]组合总和 III

//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件： 
//
// 
// 只使用数字1到9 
// 每个数字 最多使用一次 
// 
//
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。 
//
// 
//
// 示例 1: 
//
// 
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//解释:
//1 + 2 + 4 = 7
//没有其他符合的组合了。 
//
// 示例 2: 
//
// 
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//解释:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//没有其他符合的组合了。 
//
// 示例 3: 
//
// 
//输入: k = 4, n = 1
//输出: []
//解释: 不存在有效的组合。
//在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
// 
//
// 
//
// 提示: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
//
// Related Topics 数组 回溯 👍 730 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.*;

// 回溯 + 减枝
public class Q216_CombinationSumIii{


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), k, new ArrayList<>(), n);
        return ans;
    }

    public void backtracking(List<Integer> candidates, int count, List<Integer>path, int target){
        // 出口1
        if (target == 0 && count ==0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 出口2
        if (target < 0 ||  count == 0) {
            return;
        }

        for (Integer i : candidates) {

            List<Integer> newCandidate = new LinkedList<>(candidates);
            if (path.size() >0 && i < path.get(path.size()-1)) continue; // 去重 减枝

            path.add(i);
            newCandidate.remove(i);
            backtracking(newCandidate, count - 1, path, target - i);
            path.remove(i);
        }




    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().combinationSum3(3, 7);
    }
  
}