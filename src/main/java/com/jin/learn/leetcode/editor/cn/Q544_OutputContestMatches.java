//  [544]输出比赛匹配对

//在 NBA 季后赛中，我们总是安排较强的队伍对战较弱的队伍，例如用排名第 1 的队伍和第 n 的队伍对决，这是一个可以让比赛更加有趣的好策略。现在，给你 n
// 支队伍，你需要以字符串格式输出它们的 最终 比赛配对。 
//
// n 支队伍按从 1 到 n 的正整数格式给出，分别代表它们的初始排名（排名 1 最强，排名 n 最弱）。我们用括号（'(', ')'）和逗号（','）来表
//示匹配对——括号（'(', ')'）表示匹配，逗号（','）来用于分割。 在每一轮的匹配过程中，你都需要遵循将强队与弱队配对的原则。 
//
// 
//
// 示例 1： 
//
// 输入: 2
//输出: (1,2)
//解析: 
//初始地，我们有队1和队2两支队伍，按照1，2排列。
//因此 用 '(', ')' 和 ','来将队1和队2进行配对，得到最终答案。
// 
//
// 示例 2： 
//
// 输入: 4
//输出: ((1,4),(2,3))
//解析: 
//在第一轮，我们将队伍1和4配对，2和3配对，以满足将强队和弱队搭配的效果。得到(1,4),(2,3).
//在第二轮，(1,4) 和 (2,3) 的赢家需要进行比赛以确定最终赢家，因此需要再在外面加一层括号。
//于是最终答案是((1,4),(2,3))。
// 
//
// 示例 3： 
//
// 输入: 8
//输出: (((1,8),(4,5)),((2,7),(3,6)))
//解析: 
//第一轮: (1,8),(2,7),(3,6),(4,5)
//第二轮: ((1,8),(4,5)),((2,7),(3,6))
//第三轮 (((1,8),(4,5)),((2,7),(3,6)))
//由于第三轮会决出最终胜者，故输出答案为(((1,8),(4,5)),((2,7),(3,6)))。
// 
//
// 
//
// 注意: 
//
// 
// n 的范围是 [2, 212]. 
// 保证 n 可以写成 2k 的形式，其中 k 是正整数。 
// 
//
// 
// Related Topics 递归 字符串 模拟 
// 👍 35 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;


public class Q544_OutputContestMatches{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 关键 是如何翻转
    // 后半部分折叠过来
    // https://leetcode-cn.com/problems/output-contest-matches/solution/jiang-hou-ban-duan-zhi-jie-bai-guo-lai-c-7pm6/
    public String findContestMatch(int n) {
        Deque<String> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add("" + i);
        }
        while (deque.size() >= 2) {
            Deque<String> temp = new LinkedList<>();
            while (!deque.isEmpty()) {
                String merge = "(" + deque.pop() +  ","+ deque.pollLast() + ")";
                temp.add(merge);
            }
            deque = temp;
        }
        return deque.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
