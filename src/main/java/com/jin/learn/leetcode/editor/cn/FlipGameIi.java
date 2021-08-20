//  [294]翻转游戏 II

//你和朋友玩一个叫做「翻转游戏」的游戏。游戏规则如下： 
//
// 给你一个字符串 currentState ，其中只含 '+' 和 '-' 。你和朋友轮流将 连续 的两个 "++" 反转成 "--" 。当一方无法进行有效
//的翻转时便意味着游戏结束，则另一方获胜。 
//
// 请你写出一个函数来判定起始玩家 是否存在获胜的方案 ：如果存在，返回 true ；否则，返回 false 。 
// 
//
// 示例 1： 
//
// 
//输入：currentState = "++++"
//输出：true
//解释：起始玩家可将中间的 "++" 翻转变为 "+--+" 从而得胜。 
//
// 示例 2： 
//
// 
//输入：currentState = "+"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= currentState.length <= 60 
// currentState[i] 不是 '+' 就是 '-' 
// 
//
// 
//
// 进阶：请推导你算法的时间复杂度。 
// Related Topics 记忆化搜索 数学 动态规划 回溯 博弈 
// 👍 73 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.*;


public class FlipGameIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 对手 有不赢 return
    private Map<String,Boolean> memo = new HashMap<>();
     public boolean canWin(String s) {
            if(memo.containsKey(s)) return memo.get(s);
            for (int i = 1; i < s.length(); ++i) {
                if (s.charAt(i) == '+' && s.charAt(i-1) == '+'){
                    String curr = s.substring(0, i - 1) + "--" + s.substring(i + 1);
                    if(!canWin(curr)) {
                        memo.put(curr,false);
                        return true;
                    }
                    memo.put(curr,true);
                }
            }
            return false;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        boolean b = new Solution().canWin("+++++");
        System.out.println(b);
    }
  
}