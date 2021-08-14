//  [247]中心对称数 II

//中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。 
//
// 找到所有长度为 n 的中心对称数。 
//
// 示例 : 
//
// 输入:  n = 2
//输出: ["11","69","88","96"]
// 
// Related Topics 递归 数组 字符串 
// 👍 62 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StrobogrammaticNumberIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 这个递归很精彩
    // 第一 做到奇数偶数分开 递归的起点不同
    // 第二  前后递推  不断地在两边添加 11，69，88，96 就可以了 (这点我看出来)
    // 第三  对于最外层 00 处理
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    public List<String> helper(int n, int m){
        // 判断递归是否应当结束
        if (n==0)
            return new ArrayList<>(Arrays.asList(""));
        if (n==1)
            return new ArrayList<>(Arrays.asList("0","1","8"));

        //  缩小问题规模
        List<String> list = helper(n-2, m);

        // 整合结果
        List<String> res = new ArrayList<>();
        for (String s : list){
            if (n!=m)
                // n=m时，表示最外层处理。
                // 例如：原始需求n=m=2, '00'不合法
                // 若原始需求n=m=4, 内层循环n=2,m=4,'00';
                // 最外层循环，n=m=4时，'1001'
                res.add("0"+s+"0");
            res.add("1"+s+"1");
            res.add("6"+s+"9");
            res.add("8"+s+"8");
            res.add("9"+s+"6");
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().findStrobogrammatic(4);
    }
  
}