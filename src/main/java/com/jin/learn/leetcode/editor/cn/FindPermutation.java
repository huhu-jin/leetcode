//  [484]寻找排列

//现在给定一个只由字符 'D' 和 'I' 组成的 秘密签名。'D' 表示两个数字间的递减关系，'I' 表示两个数字间的递增关系。并且 秘密签名 是由一个特定
//的整数数组生成的，该数组唯一地包含 1 到 n 中所有不同的数字（秘密签名的长度加 1 等于 n）。例如，秘密签名 "DI" 可以由数组 [2,1,3] 或 [
//3,1,2] 生成，但是不能由数组 [3,2,4] 或 [2,1,3,4] 生成，因为它们都不是合法的能代表 "DI" 秘密签名 的特定串。 
//
// 现在你的任务是找到具有最小字典序的 [1, 2, ... n] 的排列，使其能代表输入的 秘密签名。 
//
// 示例 1： 
//
// 输入： "I"
//输出： [1,2]
//解释： [1,2] 是唯一合法的可以生成秘密签名 "I" 的特定串，数字 1 和 2 构成递增关系。
// 
//
// 
//
// 示例 2： 
//
// 输入： "DI"
//输出： [2,1,3]
//解释： [2,1,3] 和 [3,1,2] 可以生成秘密签名 "DI"，
//但是由于我们要找字典序最小的排列，因此你需要输出 [2,1,3]。
// 
//
// 
//
// 注： 
//
// 
// 输出字符串只会包含字符 'D' 和 'I'。 
// 输入字符串的长度是一个正整数且不会超过 10,000。 
// 
//
// 
// Related Topics 栈 贪心 数组 
// 👍 43 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class FindPermutation{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //D:递减，I:递增；s的长度加1为返回数组（1~n）长度，所以s为空时，必定返回[1]；
    //不为空时该怎么解题呢，我们举个例子，比如s为"DDIDD",一步一步来
    //1、首先不管s是否为空肯定有个原始数组为[1]
    //2、s="D"时，结果为[2,1],相当于在1前面插入2
    //3、s="DD"时，结果为[3,2,1],相当于在数组最前面插入3，这都是固定结果
    //4、s="DDI"时，这时我按照贪心，肯定要插入最小的数字4，关键是插在哪，I为递增，所以我们直接在最后插入4，结果为[3,2,1,4]
    //5、s="DDID"时，现在按照贪心到了5这个值，因为是递减的关系，所以我们插在4的前面，结果为[3,2,1,5,4]
    //6、s="DDIDD"时，现在最大值为6，递减，所以我们在5之前插入，结果为[3,2,1,6,5,4]
    public int[] findPermutation(String s) {
        if(s == null) return new int[]{1};
        int n = s.length();
        ArrayList<Integer> ans = new ArrayList<>(n+1);
        ans.add(1);
        int lastDPosition = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'D') {
                ans.add(lastDPosition, i+2);
            }else {
                ans.add(i+2);
                lastDPosition = i+1;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }


}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().findPermutation("IID");
    }
  
}