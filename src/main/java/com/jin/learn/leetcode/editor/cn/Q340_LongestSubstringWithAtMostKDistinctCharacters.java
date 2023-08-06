//  [340]至多包含 K 个不同字符的最长子串

//给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "eceba", k = 2
//输出: 3
//解释: 则 T 为 "ece"，所以长度为 3。 
//
// 示例 2: 
//
// 
//输入: s = "aa", k = 1
//输出: 2
//解释: 则 T 为 "aa"，所以长度为 2。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 * 104 
// 0 <= k <= 50 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 145 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashMap;



public class Q340_LongestSubstringWithAtMostKDistinctCharacters{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
    // 窗口滑动
class Solution {
    private HashMap<Character,Integer> map = new HashMap<>();
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if (s == null || s.length() == 0 || k==0) return 0;
            int left =0;
            int right = 0;
            int ans =1;
        while (right < s.length()) {
            if (map.size() < k || map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                right++;
            }else {
                ans = Math.max(right - left, ans);
                // 窗口减少时候 一个一个出去
                int val = map.get(s.charAt(left));
                if (val == 1) {
                    map.remove(s.charAt(left));
                }else {
                    map.put(s.charAt(left), val - 1);
                }
                left++;
            }
        }
        ans = Math.max(right - left, ans);
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase() {
        Solution solution = new Solution();
        new Solution().lengthOfLongestSubstringKDistinct("eceba", 2);
    }
  
}
