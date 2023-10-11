//  [242]有效的字母异位词

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// Related Topics 哈希表 字符串 排序 👍 853 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashMap;


public class Q242_ValidAnagram{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
    // 不用看
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> memo = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer value = memo.getOrDefault(c, 0);
            memo.put(c, value + 1);
        }


        for (char c : t.toCharArray()) {
            Integer value = memo.get(c);
            if (value == null) return false;
            if (value == 1) {
                memo.remove(c);
            }else {
                memo.put(c, value - 1);
            }
        }

        return memo.size() == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        boolean anagram = new Solution().isAnagram("anagram", "nagaram");
    }
  
}