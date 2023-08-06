//  [223]矩形面积

//给你 二维 平面上两个 由直线构成且边与坐标轴平行/垂直 的矩形，请你计算并返回两个矩形覆盖的总面积。 
//
// 每个矩形由其 左下 顶点和 右上 顶点坐标表示： 
//
// 
// 
// 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。 
// 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。 
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
//输出：45
// 
//
// 示例 2： 
//
// 
//输入：ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
//输出：16
// 
//
// 
//
// 提示： 
//
// 
// -10⁴ <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 10⁴ 
// 
// Related Topics 几何 数学 👍 203 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q223_RectangleArea{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int computeArea(int a, int b, int c, int d, int e, int f, int g, int h) {
        if (a > e) {
            return computeArea(e, f, g, h, a, b, c, d);
        }
        // 没有重叠
        if (b >= h || d <= f || c <= e) {
            return Math.abs(a - c) * Math.abs(b - d) + Math.abs(e - g) * Math.abs(f - h);
        }


        //重叠
        int down = Math.max(a, e);

        int up = Math.min(c, g);

        int left = Math.max(b, f);


        int right = Math.min(d, h);
        return Math.abs(a - c) * Math.abs(b - d) + Math.abs(e - g) * Math.abs(f - h) - Math.abs(up - down) * Math.abs(right - left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
