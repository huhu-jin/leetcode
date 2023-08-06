//  [剑指 Offer 05]替换空格

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 122 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class QJZOffer05_TiHuanKongGeLcof{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        if(s == null ) return "";

        StringBuffer ret =  new StringBuffer();
        for(char c: s.toCharArray()){
            if(c == ' '){
                ret.append("%20");

            }else{
                ret.append(c);
            }

        }
        return ret.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
