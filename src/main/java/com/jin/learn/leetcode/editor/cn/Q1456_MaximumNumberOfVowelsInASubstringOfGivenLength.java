//  [1456]定长子串中元音的最大数目

//给你字符串 s 和整数 k 。 
//
// 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。 
//
// 英文中的 元音字母 为（a, e, i, o, u）。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abciiidef", k = 3
//输出：3
//解释：子字符串 "iii" 包含 3 个元音字母。
// 
//
// 示例 2： 
//
// 输入：s = "aeiou", k = 2
//输出：2
//解释：任意长度为 2 的子字符串都包含 2 个元音字母。
// 
//
// 示例 3： 
//
// 输入：s = "leetcode", k = 3
//输出：2
//解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
// 
//
// 示例 4： 
//
// 输入：s = "rhythms", k = 4
//输出：0
//解释：字符串 s 中不含任何元音字母。
// 
//
// 示例 5： 
//
// 输入：s = "tryhard", k = 4
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s 由小写英文字母组成 
// 1 <= k <= s.length 
// 
//
// Related Topics 字符串 滑动窗口 👍 74 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

// 滑动窗口 不用看
public class Q1456_MaximumNumberOfVowelsInASubstringOfGivenLength{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<Character> memo = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        int ans=0;
        int l =0;
        int i = 0;
        for (; i < k && i < s.length(); i++) {
            if (memo.contains(s.charAt(i))) ans++;
        }
        if (i == s.length()-1) return ans;

        int r = k-1;

        int temp = ans;
        while (r < s.length()) {

            r++;
            if (r < s.length() && memo.contains(s.charAt(r))) {
                temp ++;
            }

            if (r < s.length() && memo.contains(s.charAt(l))) {
                temp --;
            }
            l++;

            ans = Math.max(ans, temp);

        }



        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().maxVowels("leetcode", 3);
        
    }
  
}