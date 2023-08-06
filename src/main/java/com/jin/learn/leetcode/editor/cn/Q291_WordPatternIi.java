//  [291]单词规律 II

//给你一种规律 pattern 和一个字符串 str，请你判断 str 是否遵循其相同的规律。 
//
// 这里我们指的是 完全遵循，例如 pattern 里的每个字母和字符串 str 中每个 非空 单词之间，存在着 双射 的对应规律。双射 意味着映射双方一一对
//应，不会存在两个字符映射到同一个字符串，也不会存在一个字符分别映射到两个不同的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：pattern = "abab", s = "redblueredblue"
//输出：true
//解释：一种可能的映射如下：
//'a' -> "red"
//'b' -> "blue" 
//
// 示例 2： 
//
// 
//输入：pattern = "aaaa", s = "asdasdasdasd"
//输出：true
//解释：一种可能的映射如下：
//'a' -> "asd"
// 
//
// 示例 3： 
//
// 
//输入：pattern = "abab", s = "asdasdasdasd"
//输出：true
//解释：一种可能的映射如下：
//'a' -> "a"
//'b' -> "sdasd"
//注意 'a' 和 'b' 不能同时映射到 "asd"，因为这里的映射是一种双射。
// 
//
// 示例 4： 
//
// 
//输入：pattern = "aabb", s = "xyzabcxzyabc"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= pattern.length <= 20 
// 0 <= s.length <= 50 
// pattern 和 s 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 58 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class Q291_WordPatternIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 十分经典
        Map<Character, String> map = new HashMap<>();
        public boolean wordPatternMatch(String pattern, String str) {
            if (pattern.length() == 0) return (str.length() == 0) ? true : false;
            char letter = pattern.charAt(0);
            for (int i = 1; i <= str.length() - pattern.length()+1; i++) {//从1位开始尝试是否有映射，由于每个pattern至少得对应一个字符，所以如果字符串剩下的字符少于pattern剩下的字符数就可以停止循环了
                String mapStr = map.get(letter);
                String substr = str.substring(0, i);
                //这个pattern有映射，并且等于这段字符；或者这段字符不是pattern的映射并且没有其他映射，就可以假设这个映射成立并继续尝试匹配剩下的字符
                if ((substr.equals(mapStr)) || (mapStr == null && !map.containsValue(substr))) {
                    map.put(letter, substr);
                    if (wordPatternMatch(pattern.substring(1), str.substring(i))) {
                        return true;
                    }else if (mapStr == null) {
                        map.remove(letter);
                    }
                }
            }
            return false;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
