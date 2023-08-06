//  [212]单词搜索 II

//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 10⁴ 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 673 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// backtracking + tireTree
public class Q212_WordSearchIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
public  class Solution {

    Set<String> ans = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {

        Tire tire = new Tire();
        for (String word : words) {
            tire.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                backtracking(board, i, j, new StringBuilder(), tire.root);
            }
        }
        return new ArrayList<>(ans);
    }

        private void backtracking(char[][] board, int i, int j, StringBuilder builder, Tire.TireNode node) {
            char temp = board[i][j];
            if (temp == '#' || node == null) return;
            if (node.tns[temp - 'a'] != null) {
                //
                if (node.tns[temp - 'a'].end) {
                    StringBuilder stringBuilder = new StringBuilder(builder);
                    stringBuilder.append(temp);
                    ans.add(stringBuilder.toString());
                }

                if (i > 0) {
                    board[i][j] = '#';
                    StringBuilder stringBuilder = new StringBuilder(builder);
                    stringBuilder.append(temp);
                    backtracking(board, i - 1, j, stringBuilder, node.tns[temp - 'a']);
                    board[i][j] = temp;
                }
                if (i + 1 < board.length) {
                    board[i][j] = '#';
                    StringBuilder stringBuilder = new StringBuilder(builder);
                    stringBuilder.append(temp);
                    backtracking(board, i + 1, j, stringBuilder, node.tns[temp - 'a']);
                    board[i][j] = temp;

                }
                if (j > 0) {
                    board[i][j] = '#';
                    StringBuilder stringBuilder = new StringBuilder(builder);
                    stringBuilder.append(temp);
                    backtracking(board, i, j - 1, stringBuilder, node.tns[temp - 'a']);
                    board[i][j] = temp;
                }

                if (j + 1 < board[0].length) {
                    board[i][j] = '#';
                    StringBuilder stringBuilder = new StringBuilder(builder);
                    stringBuilder.append(temp);
                    backtracking(board, i, j + 1, stringBuilder, node.tns[temp - 'a']);
                    board[i][j] = temp;
                }
            }

        }


       public  class Tire {

       public TireNode root = new TireNode();

       public   class TireNode{
            TireNode [] tns = new TireNode [26];
            boolean end;
        }

        public void insert(String word) {
            TireNode p = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (p.tns[index] == null)  p.tns[index] = new TireNode();

                p = p.tns[index];

            }
            p.end = true;
        }



    }



}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }

    @Test
    public void testTireCase(){

        new Solution().findWords(new char[][]{{'a','b'},{'b','b'},{'b','b'}}, new String[]{"ab","abb"});
    }
  
}
