//  [345]反转字符串中的元音字母

//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 319 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

// 不用看
public class Q345_ReverseVowelsOfAString{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public  Set<Character> memo = new HashSet<>();

         {
            memo.add('a');
            memo.add('A');
            memo.add('e');
            memo.add('E');
            memo.add('i');
            memo.add('I');
            memo.add('o');
            memo.add('O');
            memo.add('u');
            memo.add('U');


        }
        public String reverseVowels(String s) {


            int i = 0;
            int j = s.length()-1;

            char [] arr =s.toCharArray();


            while(i<j){
                while(i < j && !isResved(arr[i])){
                    i++;
                }

                while(i < j && !isResved(arr[j])){
                    j--;
                }

                swap(arr, i,j);
                i++;
                j--;

            }


          return String.valueOf(arr);

        }

        public boolean isResved(Character c){
            return memo.contains(c);
        }

        public void swap(char [] arr, int i, int j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){


        
    }
  
}