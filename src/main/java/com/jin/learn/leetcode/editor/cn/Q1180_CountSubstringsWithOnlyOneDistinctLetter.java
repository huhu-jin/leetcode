//  [1180]统计只含单一字母的子串

//给你一个字符串 S，返回只含 单一字母 的子串个数。 
//
// 示例 1： 
//
// 输入： "aaaba"
//输出： 8
//解释： 
//只含单一字母的子串分别是 "aaa"， "aa"， "a"， "b"。
//"aaa" 出现 1 次。
//"aa" 出现 2 次。
//"a" 出现 4 次。
//"b" 出现 1 次。
//所以答案是 1 + 2 + 4 + 1 = 8。
// 
//
// 示例 2: 
//
// 输入： "aaaaaaaaaa"
//输出： 55
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 1000 
// S[i] 仅由小写英文字母组成。 
// 
// Related Topics 数学 字符串 
// 👍 27 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q1180_CountSubstringsWithOnlyOneDistinctLetter{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 可以不看
    public int countLetters(String s) {
        if(s == null || s == "") return 0;
        char[] chars = s.toCharArray();
        char cur = chars[0];
        int count =1;
        int sum =0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == cur) {
                count++;
            }else {
                sum += getCount(count);
                count=1;
                cur = chars[i];
            }
        }
        sum += getCount(count);
        return sum;
    }
    // 关键是这个个数
    private int getCount(int c) {
        return (1 + c) * c / 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().countLetters("aaaba");
        
    }
  
}
