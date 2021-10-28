//  [1062]最长重复子串

//给定字符串 S，找出最长重复子串的长度。如果不存在重复子串就返回 0。 
//
// 
//
// 示例 1： 
//
// 输入："abcd"
//输出：0
//解释：没有重复子串。
// 
//
// 示例 2： 
//
// 输入："abbaba"
//输出：2
//解释：最长的重复子串为 "ab" 和 "ba"，每个出现 2 次。
// 
//
// 示例 3： 
//
// 输入："aabcaabdaab"
//输出：3
//解释：最长的重复子串为 "aab"，出现 3 次。
// 
//
// 示例 4： 
//
// 输入："aaaaa"
//输出：4
//解释：最长的重复子串为 "aaaa"，出现 2 次。 
//
// 
//
// 提示： 
//
// 
// 字符串 S 仅包含从 'a' 到 'z' 的小写英文字母。 
// 1 <= S.length <= 1500 
// 
// Related Topics 字符串 二分查找 动态规划 后缀数组 哈希函数 滚动哈希 
// 👍 55 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class LongestRepeatingSubstring{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 滑动窗口
    // 注意 left+1, 开始 例子 aaaaa  ans = 4
    public int longestRepeatingSubstring(String s) {
        int ans =0,left = 0,  right = 0;

        while (right < s.length()) {
            if (left == right) {
                right++;continue;
            }
            int i = s.indexOf(s.substring(left, right + 1), left+1);
            if (i > 0) {
                ans = Math.max(right - left + 1, ans);
                right++;
            }else {
                left++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}