//  [531]孤独像素 I

//给定一幅黑白像素组成的图像, 计算黑色孤独像素的数量。 
//
// 图像由一个由‘B’和‘W’组成二维字符数组表示, ‘B’和‘W’分别代表黑色像素和白色像素。 
//
// 黑色孤独像素指的是在同一行和同一列不存在其他黑色像素的黑色像素。 
//
// 示例: 
//
// 输入: 
//[['W', 'W', 'B'],
// ['W', 'B', 'W'],
// ['B', 'W', 'W']]
//
//输出: 3
//解析: 全部三个'B'都是黑色孤独像素。
// 
//
// 
//
// 注意: 
//
// 
// 输入二维数组行和列的范围是 [1,500]。 
// 
//
// 
// Related Topics 数组 哈希表 矩阵 
// 👍 30 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;


public class Q531_LonelyPixelI{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 预处理法
         // https://leetcode-cn.com/problems/lonely-pixel-i/solution/gu-du-xiang-su-i-by-leetcode-solution/
        public int findLonelyPixel(char[][] picture) {
            int[] row = new int[picture.length];
            int[] col = new int[picture[0].length];
            for(int i = 0;i < picture.length;i++){
                for(int j = 0;j < picture[0].length;j++){
                    if(picture[i][j] == 'B'){
                        row[i]++;
                        col[j]++;
                    }
                }
            }
            //再次遍历，如果当前元素为'B'且当前行和列只有1个
            int ans = 0;
            for(int i = 0;i < picture.length;i++){
                for(int j = 0;j < picture[0].length;j++){
                    if(picture[i][j] == 'B' && row[i] == 1 && col[j] == 1){
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().findLonelyPixel(new char[][]{{'w','w','B'},{'w','B','W'},{'B','w','w'}});
    }
  
}
