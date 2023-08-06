//  [6]Z 字形变换

//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 👍 1683 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class Q6_ZigzagConversion{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        if (s.length()<=2 || numRows==1 ) return s;
        int n = numRows * 2 - 2; // 为一个规律
        List<StringBuilder> temp = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            temp.add(i, new StringBuilder());
        }

        for (int i = 0; i < s.length(); i++) {
            int k = i % n;
            if (k < numRows) {
                temp.get(k).append(s.charAt(i)); // 正向
            }else {
                temp.get(n - k).append(s.charAt(i)); // 反向
            }
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder builder : temp) {
            ans.append(builder);
        }
        return ans.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
