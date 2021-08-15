//  [249]移位字符串分组

//给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，比如："abc" -> "bcd"。这样，我们可
//以持续进行 “移位” 操作，从而生成如下移位序列： 
//
// "abc" -> "bcd" -> ... -> "xyz" 
//
// 给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。 
//
// 
//
// 示例： 
//
// 输入：["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
//输出：
//[
//  ["abc","bcd","xyz"],
//  ["az","ba"],
//  ["acef"],
//  ["a","z"]
//]
//解释：可以认为字母表首尾相接，所以 'z' 的后续为 'a'，所以 ["az","ba"] 也满足 “移位” 操作规律。 
// Related Topics 数组 哈希表 字符串 
// 👍 53 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class GroupShiftedStrings{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 关键是abc bcd 他们的相对于前一个位移值相等 011 011
        // seq[i] - seq[0] + 26) % 26  + 'a' 转化到 'a'上
        public List<List<String>> groupStrings(String[] strings) {
            HashMap<String, List<String>> map = new HashMap<>();
            for (String str : strings) {
                char[] seq = str.toCharArray();
                // "" 情况
                if (seq.length == 0) {
                    map.put("", new ArrayList<String>() {{ add(str); }});
                    continue;
                }
                // 转为以a开头的 作为key
                if (seq[0] != 'a') {
                    for (int i = 1; i < seq.length; ++i)
                        seq[i] = (char) ((seq[i] - seq[0] + 26) % 26 + 'a');
                    seq[0] = 'a';
                }

                String key = String.valueOf(seq);
                map.computeIfAbsent(key, x -> new LinkedList<>()).add(str);
            }
            return new ArrayList<>(map.values());
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"});
    }
  
}