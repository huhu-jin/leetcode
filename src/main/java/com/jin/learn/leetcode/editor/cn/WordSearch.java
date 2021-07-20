//  [79]单词搜索

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 
// 👍 959 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class WordSearch{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 典型回溯
    public boolean exist(char[][] board, String word) {
        if(word == null || word.isEmpty()) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backTracking(board, i, j, 0, word)) return true;
            }
        }
        return false;
    }

        private boolean backTracking(char[][] board, int i, int j, int p, String word) {
            if (p == word.length()) {
                return true;
            }
            if (i < 0 ||  i >= board.length || j < 0 || j >=board[0].length) {
                return false;
            }
            boolean res = false;
            if (board[i][j] == word.charAt(p++)) {
                char tmp = board[i][j];
                board[i][j] = '\0';
                res = backTracking(board, i - 1, j, p, word) || backTracking(board, i + 1, j, p, word)
                        || backTracking(board, i, j - 1, p, word ) || backTracking(board, i, j + 1, p, word);
                board[i][j] = tmp;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}