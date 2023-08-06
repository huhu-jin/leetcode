//  [351]安卓系统手势解锁

//我们都知道安卓有个手势解锁的界面，是一个 3 x 3 的点所绘制出来的网格。用户可以设置一个 “解锁模式” ，通过连接特定序列中的点，形成一系列彼此连接的线
//段，每个线段的端点都是序列中两个连续的点。如果满足以下两个条件，则 k 点序列是有效的解锁模式： 
//
// 
// 解锁模式中的所有点 互不相同 。 
// 假如模式中两个连续点的线段需要经过其他点，那么要经过的点必须事先出现在序列中（已经经过），不能跨过任何还未被经过的点。 
// 
//
// 
//
// 以下是一些有效和无效解锁模式的示例： 
//
// 
// 
//
// 
// 无效手势：[4,1,3,6] ，连接点 1 和点 3 时经过了未被连接过的 2 号点。 
// 无效手势：[4,1,9,2] ，连接点 1 和点 9 时经过了未被连接过的 5 号点。 
// 有效手势：[2,4,1,3,6] ，连接点 1 和点 3 是有效的，因为虽然它经过了点 2 ，但是点 2 在该手势中之前已经被连过了。 
// 有效手势：[6,5,4,1,9,2] ，连接点 1 和点 9 是有效的，因为虽然它经过了按键 5 ，但是点 5 在该手势中之前已经被连过了。 
// 
//
// 给你两个整数，分别为 m 和 n ，那么请你统计一下有多少种 不同且有效的解锁模式 ，是 至少 需要经过 m 个点，但是 不超过 n 个点的。 
//
// 两个解锁模式 不同 需满足：经过的点不同或者经过点的顺序不同。 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 1, n = 1
//输出：9
// 
//
// 示例 2： 
//
// 
//输入：m = 1, n = 2
//输出：65
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 9 
// 
// Related Topics 动态规划 回溯 
// 👍 88 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class Q351_AndroidUnlockPatterns{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
    // 题意:重复不行 必须挨着走. 跳一个也行 比如1->3 那么中间那个(比如2)必须已经走过了
    //dfs next 1->9  把不能直接走的列举 放入map中
    // 然后dfs 出口 步数 ==n 或 者走过了

class Solution {
        private Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
        private int m;
        private int n;
        private boolean[] used = new boolean[10];
    public int numberOfPatterns(int m, int n) {
        this.m =m;
        this.n = n;
        HashMap<Integer,Integer> temp = new HashMap<>();
        // 到达3 必须要经过2,只能不能到3
        temp.put(3, 2);
        temp.put(7, 4);
        temp.put(9, 5);
        memo.put(1, temp);

        temp = new HashMap<>();
        temp.put(8, 5);
        memo.put(2, temp);

        temp = new HashMap<>();
        temp.put(1, 2);
        temp.put(7, 5);
        temp.put(9, 6);
        memo.put(3, temp);

        temp = new HashMap<>();
        temp.put(6, 5);
        memo.put(4, temp);

        temp = new HashMap<>();
        memo.put(5, temp);

        temp = new HashMap<>();
        temp.put(4, 5);
        memo.put(6, temp);

        temp = new HashMap<>();
        temp.put(1, 4);
        temp.put(3, 5);
        temp.put(9, 8);
        memo.put(7, temp);

        temp = new HashMap<>();
        temp.put(2, 5);
        memo.put(8, temp);

        temp = new HashMap<>();
        temp.put(1, 5);
        temp.put(7, 8);
        temp.put(3, 6);
        memo.put(9, temp);

        int ans =0;
        ans += 4 * dfs(1, 1);
        ans += 4 * dfs(2, 1);
        ans += dfs(5, 1);

        return ans;
    }

        private int dfs(int p, int count) {
            if(used[p]) return 0;
            if(count == n) return 1;

            int ans = count >= m ? 1 : 0;

            used[p] = true;
            for (int next = 1; next <= 9; next++) {
                if (!memo.get(p).containsKey(next) || used[memo.get(p).get(next)]) {
                   ans += dfs(next, count + 1);

                }
            }
            used[p] = false;
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Solution solution = new Solution();
    }
  
}
