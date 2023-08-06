//  [161]相隔为 1 的编辑距离

//给定两个字符串 s 和 t，判断他们的编辑距离是否为 1。 
//
// 注意： 
//
// 满足编辑距离等于 1 有三种可能的情形： 
//
// 
// 往 s 中插入一个字符得到 t 
// 从 s 中删除一个字符得到 t 
// 在 s 中替换一个字符得到 t 
// 
//
// 示例 1： 
//
// 输入: s = "ab", t = "acb"
//输出: true
//解释: 可以将 'c' 插入字符串 s 来得到 t。
// 
//
// 示例 2: 
//
// 输入: s = "cab", t = "ad"
//输出: false
//解释: 无法通过 1 步操作使 s 变为 t。 
//
// 示例 3: 
//
// 输入: s = "1203", t = "1213"
//输出: true
//解释: 可以将字符串 s 中的 '0' 替换为 '1' 来得到 t。 
// Related Topics 双指针 字符串 
// 👍 75 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q161_OneEditDistance{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 分类讨论
    public boolean isQ161_OneEditDistance(String s, String t) {
        int n = s.length(); int m = t.length();
        // 长度差2
        if(Math.abs(n-m)>1) return  false;

        // 长度相同
        if(n==m) {
            int diff=0;
            for(int i=0; i<n; i++){
                if(s.charAt(i) != t.charAt(i)) diff++;
                if(diff > 1) return false;
            }
            return diff==1;
        }
        // 长度不同
        String L;
        String S;
        if (m > n) {
            L = t;
            S = s;
        }else {
            S = t;
            L = s;
        }

        for(int i=0; i<S.length(); i++){
            if(L.charAt(i)!=S.charAt(i)){
                // 后半段  应该相等
                return L.substring(i + 1).equals(S.substring(i));
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().isQ161_OneEditDistance("ba", "a");
        new Solution().isQ161_OneEditDistance("ab", "acb");
    }
  
}
