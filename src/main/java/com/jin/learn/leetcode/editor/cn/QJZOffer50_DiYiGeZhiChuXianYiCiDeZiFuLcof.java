//  [剑指 Offer 50]第一个只出现一次的字符

//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 
// 👍 107 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedList;


public class QJZOffer50_DiYiGeZhiChuXianYiCiDeZiFuLcof{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public char firstUniqChar(String s) {
        if(s == null) return ' ';
        HashMap<Character, Integer> map = new HashMap<>();

        LinkedList<Character> list = new LinkedList<>();

        for (char c : s.toCharArray()) {
            list.add(c);
            map.put(c,1+map.getOrDefault(c, 0));
        }

        for (char c : list) {
            Integer count = map.get(c);
            if (count != null && count == 1) {
                return c;
            }
        }

        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution();
    }
  
}
