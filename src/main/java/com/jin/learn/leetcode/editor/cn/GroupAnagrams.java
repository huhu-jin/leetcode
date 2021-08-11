//  [49]字母异位词分组

//给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 104 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 排序 
// 👍 788 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;


public class GroupAnagrams{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    HashMap<String,List<String>> map = new HashMap<>();
    // hashmap + 排序
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return Collections.emptyList();
        for (String s : strs) {
            String key = generate(s);
            if (map.containsKey(key)) {
                List<String> orDefault = map.get(key);
                orDefault.add(s);
            } else {
                List<String> orDefault = new LinkedList<>();
                orDefault.add(s);
                map.put(key,orDefault);
            }

        }

        return new ArrayList<>(map.values());
    }

        private String generate(String s) {
            String temp="";
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            for (char c : chars) {
                temp = temp + c;
            }
            return temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}