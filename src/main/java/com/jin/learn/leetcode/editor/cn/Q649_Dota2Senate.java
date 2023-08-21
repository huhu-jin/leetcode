//  [649]Dota2 参议院

//Dota2 的世界里有两个阵营：Radiant（天辉）和 Dire（夜魇） 
//
// Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议
//员都可以行使两项权利中的 一 项： 
//
// 
// 禁止一名参议员的权利：参议员可以让另一位参议员在这一轮和随后的几轮中丧失 所有的权利 。 
// 宣布胜利：如果参议员发现有权利投票的参议员都是 同一个阵营的 ，他可以宣布胜利并决定在游戏中的有关变化。 
// 
//
// 给你一个字符串 senate 代表每个参议员的阵营。字母 'R' 和 'D'分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参
//议员，给定字符串的大小将是 n。 
//
// 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。 
//
// 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 "Radiant" 
//或 "Dire" 。 
//
// 
//
// 示例 1： 
//
// 
//输入：senate = "RD"
//输出："Radiant"
//解释：
//第 1 轮时，第一个参议员来自 Radiant 阵营，他可以使用第一项权利让第二个参议员失去所有权利。
//这一轮中，第二个参议员将会被跳过，因为他的权利被禁止了。
//第 2 轮时，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人。
// 
//
// 示例 2： 
//
// 
//输入：senate = "RDD"
//输出："Dire"
//解释：
//第 1 轮时，第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利。
//这一轮中，第二个来自 Dire 阵营的参议员会将被跳过，因为他的权利被禁止了。
//这一轮中，第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利。
//因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利
// 
//
// 
//
// 提示： 
//
// 
// n == senate.length 
// 1 <= n <= 10⁴ 
// senate[i] 为 'R' 或 'D' 
// 
//
// Related Topics 贪心 队列 字符串 👍 306 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 这道题 题意太绕了，我举一个更形象的例子给大家捋顺一下。
 *
 * 例如输入"RRDDD"，执行过程应该是什么样呢？
 *
 * 第一轮：senate[0]的R消灭senate[2]的D，senate[1]的R消灭senate[3]的D，senate[4]的D消灭senate[0]的R，此时剩下"RD"，第一轮结束！
 * 第二轮：senate[0]的R消灭senate[1]的D，第二轮结束
 * 第三轮：只有R了，R胜利
 *
 * 用队列模拟就可以了
 */
public class Q649_Dota2Senate{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> RQueue = new LinkedList<>();
        Queue<Integer> DQueue = new LinkedList<>();

        for (int i=0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                RQueue.add(i);
            } else {
                DQueue.add(i);
            }
        }

        while (!RQueue.isEmpty() && !DQueue.isEmpty()) {
            int rIndex = RQueue.poll();
            int DIndex = DQueue.poll();

            if (rIndex < DIndex) {
                RQueue.add(rIndex + senate.length());// RDD 的例子, 第一轮的D 优先于 第二轮的R
            } else {
                DQueue.add(DIndex + senate.length());
            }

        }


        return !RQueue.isEmpty() ? "Radiant" : "Dire";



    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}