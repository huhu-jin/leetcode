//  [14]最长公共前缀

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1536 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class LongestCommonPrefix{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer stringBuffer = new StringBuffer();
        if(strs == null || strs.length==0) return "";
        if(strs.length == 1) return strs[0];

        String temp = strs[0];

        for (char c : temp.toCharArray()) {
            stringBuffer.append(c);
            for (int i = 1; i < strs.length; i++) {
                if (!strs[i].startsWith(stringBuffer.toString())) {
                    return stringBuffer.deleteCharAt(stringBuffer.length()-1).toString();
                }
            }
        }
        return stringBuffer.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().longestCommonPrefix(new String[]{"flower", "flow", "flight"});
    }
  
}