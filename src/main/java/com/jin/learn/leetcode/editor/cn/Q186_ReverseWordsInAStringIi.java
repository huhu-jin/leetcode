//  [186]翻转字符串里的单词 II

//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 示例： 
//
// 输入: ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
//输出: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"] 
//
// 注意： 
//
// 
// 单词的定义是不包含空格的一系列字符 
// 输入字符串中不会包含前置或尾随的空格 
// 单词与单词之间永远是以单个空格隔开的 
// 
//
// 进阶：使用 O(1) 额外空间复杂度的原地解法。 
// Related Topics 双指针 字符串 
// 👍 61 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q186_ReverseWordsInAStringIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 两次旋转, 第一整体 第二次局部
    public void reverseWords(char[] s) {
        if(s == null || s.length<2) return;
        //第一次
        reverse(s, 0, s.length - 1);

        // 第二次
        int start =0;
        int end = 0;
        for (; end < s.length; end++) {
            if (' ' == s[end]) {
                reverse(s, start, end-1);
                start = end+1;
            }
        }
        reverse(s, start, end-1); // 注意减1的细节
    }

    private void reverse(char[] s, int start, int end){
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        char[] input = new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        new Solution().reverseWords(input);
        System.out.println("ssss");
    }
  
}
