//  [剑指 Offer 12]矩阵中的路径

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 'ABCCED'（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'AB
//CCED'
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [['a','b'],['c','d']], word = 'abcd'
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 337 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.RET;
import org.testng.Assert;
import org.testng.annotations.Test;

// 关键点是将走过的路径标记为'/0'
public class JuZhenZhongDeLuJingLcof{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length;j++) {
               boolean ret = nestPath(board, word, 0, i, j);
               if(ret) return true;
            }
        }
        return false;
    }

        private boolean nestPath(char[][] board, String word, int pos, int i, int j) {
            if(pos>=word.length()) return true;
            if(i<0 || i > board.length-1 || j<0 || j>board[i].length-1) return false;
            if (board[i][j] == word.charAt(pos)) {
                board[i][j]='\0'; // 关键
                boolean ret = nestPath(board,word,pos+1,i,j+1) || nestPath(board,word,pos+1,i+1,j)
                        || nestPath(board,word,pos+1,i-1,j) || nestPath(board,word,pos+1,i,j-1);
                board[i][j]= word.charAt(pos); //关键
                return  ret;
            }
            return false;
        }



    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Assert.assertTrue(new Solution().exist(new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}}, "AAB"));
        Assert.assertTrue(new Solution().exist(new char[][]{{'A'}}, "A"));
        Assert.assertTrue(new Solution().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));

    }
  
}