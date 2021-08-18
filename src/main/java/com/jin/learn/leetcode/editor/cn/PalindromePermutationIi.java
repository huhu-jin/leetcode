//  [267]回文排列 II

//给定一个字符串 s ，返回其通过重新排列组合后所有可能的回文字符串，并去除重复的组合。 
//
// 如不能形成任何回文排列时，则返回一个空列表。 
//
// 示例 1： 
//
// 输入: "aabb"
//输出: ["abba", "baab"] 
//
// 示例 2： 
//
// 输入: "abc"
//输出: [] 
// Related Topics 哈希表 字符串 回溯 
// 👍 64 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;


public class PalindromePermutationIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<String> ans =  new LinkedList<String>();
    private String ori ;
    public List<String> generatePalindromes(String s) {
        ori =s;
        int[] cnt = new int[26]; // 记录具体的 字符个数
        for (int i = 0; i < s.length(); ++i) cnt[s.charAt(i) - 'a']++;
        int count = 0;
        int pos = 0;
        for (int i =0 ; i< cnt.length;i++) {
            if (cnt[i] % 2 == 1) {
                count++;
                pos = i;
            }
        }
        if (count > 1) return new LinkedList<>();
        // 以上是回文排序1的 内容

        //通过中心扩散法 + 回溯
        String middle ="";
        if (count == 1) {
            middle = middle +(char)('a' + pos);
            cnt[pos]--;
        }
        backtracking(middle, cnt);
        return ans;
    }

        private void backtracking(String s, int[] cnt) {
            if (s.length() == ori.length()) {
                ans.add(s);
                return;
            }
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] != 0) {
                    cnt[i]-=2;
                    backtracking((char)(i +'a') + s + (char)(i +'a'), cnt.clone());
                    cnt[i]+=2;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().generatePalindromes("a");
        new Solution().generatePalindromes("aabb");
    }
  
}