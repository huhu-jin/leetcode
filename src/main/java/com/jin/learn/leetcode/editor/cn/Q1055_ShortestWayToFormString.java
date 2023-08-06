//  [1055]形成字符串的最短路径

//对于任何字符串，我们可以通过删除其中一些字符（也可能不删除）来构造该字符串的子序列。 
//
// 给定源字符串 source 和目标字符串 target，找出源字符串中能通过串联形成目标字符串的子序列的最小数量。如果无法通过串联源字符串中的子序列来构造
//目标字符串，则返回 -1。 
//
// 
//
// 示例 1： 
//
// 输入：source = "abc", target = "abcbc"
//输出：2
//解释：目标字符串 "abcbc" 可以由 "abc" 和 "bc" 形成，它们都是源字符串 "abc" 的子序列。
// 
//
// 示例 2： 
//
// 输入：source = "abc", target = "acdbc"
//输出：-1
//解释：由于目标字符串中包含字符 "d"，所以无法由源字符串的子序列构建目标字符串。
// 
//
// 示例 3： 
//
// 输入：source = "xyz", target = "xzyxz"
//输出：3
//解释：目标字符串可以按如下方式构建： "xz" + "y" + "xz"。
// 
//
// 
//
// 提示： 
//
// 
// source 和 target 两个字符串都只包含 "a"-"z" 的英文小写字母。 
// source 和 target 两个字符串的长度介于 1 和 1000 之间。 
// 
// Related Topics 贪心 字符串 动态规划 
// 👍 62 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q1055_ShortestWayToFormString{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 模拟
    // 迭代target中每一个字母, 查找 在source中位置
    public int shortestWay(String source, String target) {
        int ans=1;
        int start=0;
        for (char c : target.toCharArray()) {
            int i = source.indexOf(c, start);
            if (i == -1) {
                i = source.indexOf(c);
                if(i == -1) return -1;
                ans++;
            }
            start = i+1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().shortestWay("aa", "aaaa");
    }
  
}
