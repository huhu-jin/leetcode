//  [901]股票价格跨度

//编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。 
//
// 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。 
//
// 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
// 
//
// 
//
// 示例： 
//
// 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[10
//0],[80],[60],[70],[60],[75],[85]]
//输出：[null,1,1,1,2,1,4,6]
//解释：
//首先，初始化 S = StockSpanner()，然后：
//S.next(100) 被调用并返回 1，
//S.next(80) 被调用并返回 1，
//S.next(60) 被调用并返回 1，
//S.next(70) 被调用并返回 2，
//S.next(60) 被调用并返回 1，
//S.next(75) 被调用并返回 4，
//S.next(85) 被调用并返回 6。
//
//注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
//(包括今天的价格 75) 小于或等于今天的价格。
// 
//
// 
//
// 提示： 
//
// 
// 调用 StockSpanner.next(int price) 时，将有 1 <= price <= 10^5。 
// 每个测试用例最多可以调用 10000 次 StockSpanner.next。 
// 在所有测试用例中，最多调用 150000 次 StockSpanner.next。 
// 此问题的总时间限制减少了 50%。 
// 
// Related Topics 栈 设计 数据流 单调栈 👍 177 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;


public class Q901_OnlineStockSpan{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class StockSpanner {

        // 1.  要连续 -->
        // 比如 x, 3, 5 这样 增的. 直接去掉 3, 并3前面的连续值 加到 5 上(因为4的话 被断掉了, 6的话看5就好了)
        // 比如 x, 5,3 这样 递减的. 那个就 直接push. 因为不知道新的是多少 .
        // 2. <=价格日志
        private Deque<Integer> priceStack;
        private Deque<Integer> countStack;


    public StockSpanner() {
        this.priceStack = new LinkedList<>();
        this.countStack = new LinkedList<>();
    }
    
    public int next(int price) {
        int count =1;
        while (!priceStack.isEmpty() && price >=priceStack.peek()) { // price = stack's top ==>也要 累加
            priceStack.pop();
            count += countStack.pop();
        }
        priceStack.push(price);
        countStack.push(count);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
