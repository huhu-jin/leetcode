//  [573]松鼠模拟

//现在有一棵树，一只松鼠和一些坚果。位置由二维网格的单元格表示。你的目标是找到松鼠收集所有坚果的最小路程，且坚果是一颗接一颗地被放在树下。松鼠一次最多只能携带
//一颗坚果，松鼠可以向上，向下，向左和向右四个方向移动到相邻的单元格。移动次数表示路程。 
//
// 输入 1: 
//
// 输入: 
//高度 : 5
//宽度 : 7
//树的位置 : [2,2]
//松鼠 : [4,4]
//坚果 : [[3,0], [2,5]]
//输出: 12
//解释:
//​​​​​
// 
//
// 注意: 
//
// 
// 所有给定的位置不会重叠。 
// 松鼠一次最多只能携带一颗坚果。 
// 给定的坚果位置没有顺序。 
// 高度和宽度是正整数。 3 <= 高度 * 宽度 <= 10,000。 
// 给定的网格至少包含一颗坚果，唯一的一棵树和一只松鼠。 
// 
// Related Topics 数组 数学 
// 👍 25 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class SquirrelSimulation{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 应用题
    // 除了松鼠第一次拿的坚果，所有的坚果都需要从树的位置出发，拿到坚果后再回到树的位置。也就是说，如果确定了松鼠第一次拿哪个坚果，那么答案就已经确定了
    // 假设 没有松鼠 所有的树到坚果距离 = （sum_dis）
    // ans = sum_dis - distance(tree, first_nut) + distance(squirrel, first_nut)
        //迭代每一个栗子作为第一个 找出短的

        public int getDistance(int[] a, int[] b) {
            return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
        }

        public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
            int ans = Integer.MAX_VALUE;
            int sum_dis = 0;
            for (int[] nut : nuts)
                sum_dis += getDistance(nut, tree) * 2;
            for (int[] first_nut : nuts) {
                int cur = sum_dis - getDistance(first_nut, tree) + getDistance(first_nut, squirrel);
                ans = Math.min(cur, ans);
            }
            return ans;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}