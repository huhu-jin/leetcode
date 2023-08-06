//  [1100]长度为 K 的无重复字符子串

//给你一个字符串 S，找出所有长度为 K 且不含重复字符的子串，请你返回全部满足要求的子串的 数目。 
//
// 
//
// 示例 1： 
//
// 输入：S = "havefunonleetcode", K = 5
//输出：6
//解释：
//这里有 6 个满足题意的子串，分别是：'havef','avefu','vefun','efuno','etcod','tcode'。
// 
//
// 示例 2： 
//
// 输入：S = "home", K = 5
//输出：0
//解释：
//注意：K 可能会大于 S 的长度。在这种情况下，就无法找到任何长度为 K 的子串。 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 10^4 
// S 中的所有字符均为小写英文字母 
// 1 <= K <= 10^4 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 28 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


public class Q1100_FindKLengthSubstringsWithNoRepeatedCharacters{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 类似于k长的滑动窗口
    // 遇到一样left 的缩短到 同字母位置
    // 不让right++
    public int numKLenSubstrNoRepeats(String s, int k) {
        int left =0;
        int right = 0;
        int ans =0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {
                Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Character, Integer> next = iterator.next();
                    iterator.remove();
                    if (c == next.getKey()) {
                        left = next.getValue() + 1;
                        break;
                    }
                }
            }else {
                map.put(c, right);
                if (right - left + 1 == k) {
                    ans++;
                    map.remove(s.charAt(left));
                    left++;
                }
               right++;

            }
        }



        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().numKLenSubstrNoRepeats("havefunonleetcode", 5);
    }
  
}
