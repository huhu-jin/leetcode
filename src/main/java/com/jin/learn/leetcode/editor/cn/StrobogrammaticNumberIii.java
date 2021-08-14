//  [248]中心对称数 III

//中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。 
//
// 写一个函数来计算范围在 [low, high] 之间中心对称数的个数。 
//
// 示例: 
//
// 输入: low = "50", high = "100"
//输出: 3 
//解释: 69，88 和 96 是三个在该范围内的中心对称数 
//
// 注意: 
//由于范围可能很大，所以 low 和 high 都用字符串表示。 
// Related Topics 递归 数组 字符串 
// 👍 37 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class StrobogrammaticNumberIii{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strobogrammaticInRange(String low, String high) {
        List<String> all = new LinkedList<>();
        for (int i = low.length(); i <= high.length(); i++) {
            all.addAll(helper(i, i));
        }
        int ans = 0;
        long L = Long.valueOf(low);
        long H = Long.valueOf(high);
        for (String s : all) {
            if(L<=Long.valueOf(s) && H>=Long.valueOf(s)) ans++;
        }
        return ans;
    }
         // 参考 247
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
        new Solution().strobogrammaticInRange("50", "100");
    }
  
}