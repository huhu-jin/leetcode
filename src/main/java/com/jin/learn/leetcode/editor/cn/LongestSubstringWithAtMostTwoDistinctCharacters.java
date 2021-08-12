//  [159]至多包含两个不同字符的最长子串

//给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。 
//
// 示例 1: 
//
// 输入: "eceba"
//输出: 3
//解释: t 是 "ece"，长度为3。
// 
//
// 示例 2: 
//
// 输入: "ccaabbb"
//输出: 5
//解释: t 是 "aabbb"，长度为5。
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 128 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class LongestSubstringWithAtMostTwoDistinctCharacters{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 题意: 有两不同字母组成的 最长连续子串长度
    // 滑动窗口: 一般流程
    // 条件满足: 右窗口扩大
    // 条件不满足: 新值 入窗口, 左窗口缩小 直到满足条件
    // 退出循环 最后计算ans
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null) return 0;
        int ans =0;
        int left =0,right=0;
        Map<Character,Integer> map = new HashMap<>();
        for (; right < s.length(); right++) {
            Character key = s.charAt(right);
            //满足条件
            if (map.size() <2 || map.containsKey(key)) {
                map.put(key, map.getOrDefault(key,0)+1);
            }else {
                //不满足条件
                map.put(key, 1); // 入窗口
                ans = Math.max(ans, right - left);
                while (map.size() > 2) { // 边界条件
                    Integer count = map.get(s.charAt(left));
                    if (count == 1) {
                        map.remove(s.charAt(left));
                    } else {
                        map.put(s.charAt(left), --count);
                    }
                    left++;
                }
            }
        }
        ans = Math.max(ans, right - left);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().lengthOfLongestSubstringTwoDistinct("ccaabbb");
    }
  
}