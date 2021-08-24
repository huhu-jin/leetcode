//  [320]列举单词的全部缩写

//单词的 广义缩写词 可以通过下述步骤构造：先取任意数量的不重叠的子字符串，再用它们各自的长度进行替换。例如，"abcde" 可以缩写为 "a3e"（"bcd
//" 变为 "3" ），"1bcd1"（"a" 和 "e" 都变为 "1"），"23"（"ab" 变为 "2" ，"cde" 变为 "3" ）。 
//
// 给你一个字符串 word ，返回一个由所有可能 广义缩写词 组成的列表。按 任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "word"
//输出：["4","3d","2r1","2rd","1o2","1o1d","1or1","1ord","w3","w2d","w1r1","w1rd","
//wo2","wo1d","wor1","word"]
// 
//
// 示例 2： 
//
// 
//输入：word = "a"
//输出：["1","a"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 15 
// word 仅由小写英文字母组成 
// 
// Related Topics 位运算 字符串 回溯 
// 👍 61 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class GeneralizedAbbreviation{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            // 双变量 元素 回溯
            List<String> ans = new ArrayList<>();
            public List<String> generateAbbreviations(String word){
                backtrack(word, new StringBuilder(),0, 0);
                return ans;
            }

            // i 位置 k是缩写长度
            private void backtrack( String word, StringBuilder builder, int i, int k){
                int len = builder.length();
                if(i == word.length()){ // 出口
                    if (k != 0) builder.append(k);
                    ans.add(builder.toString());
                } else {
                    // k长度++ i++(尽可能缩写)
                    backtrack( word ,builder, i + 1, k + 1);

                    // k i 都入builder(尽可能字母)
                    if (k != 0) builder.append(k);
                    builder.append(word.charAt(i));
                    backtrack(word , builder,  i + 1, 0);
                }
                builder.setLength(len); // reset builder to the original state
            }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().generateAbbreviations("abcd");
        
    }
  
}