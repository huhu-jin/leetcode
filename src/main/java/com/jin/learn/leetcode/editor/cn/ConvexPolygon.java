//  [469]凸多边形

//给定一个按顺序连接的多边形的顶点，判断该多边形是否为凸多边形。（凸多边形的定义） 
//
// 注： 
//
// 
// 顶点个数至少为 3 个且不超过 10,000。 
// 坐标范围为 -10,000 到 10,000。 
// 你可以假定给定的点形成的多边形均为简单多边形（简单多边形的定义）。换句话说，保证每个顶点处恰好是两条边的汇合点，并且这些边 互不相交 。 
// 
//
// 
//
// 示例 1： 
//
// [[0,0],[0,1],[1,1],[1,0]]
//
//输出： True
//
//解释：
// 
//
// 示例 2： 
//
// [[0,0],[0,10],[10,10],[10,0],[5,5]]
//
//输出： False
//
//解释：
// 
// Related Topics 几何 数学 
// 👍 25 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.List;

public class ConvexPolygon{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //严谨点，叉乘，叉乘的定义符合右手规则，
    // 所以 如果是顺时针变化，叉乘结果的方向是指向屏幕内的，始终指向屏幕内，反之指向屏幕外，所以重点是看叉乘结果方向是否变化
    //数学问题 跳过
    public boolean isConvex(List<List<Integer>> points) {
       int len = points.size();
       int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
       int cur = 0, pre = 0;
       for (int i = 0; i < len; i++) {
           x1 = points.get((i+1)%len).get(0) - points.get(i).get(0);
           x2 = points.get((i+2)%len).get(0) - points.get(i).get(0);
           y1 = points.get((i+1)%len).get(1) - points.get(i).get(1);
           y2 = points.get((i+2)%len).get(1) - points.get(i).get(1);
           cur = x1 * y2 - x2 * y1;
           if (cur != 0) {
               if ((long)cur * pre < 0) {//cur*pre可能会溢出
                   return false;
               } else {
                   pre = cur;
               }
           }
       }
       return true;
   }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Solution solution = new Solution();
    }
  
}