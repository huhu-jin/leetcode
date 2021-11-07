//  [364]加权嵌套序列和 II

//给一个嵌套整数序列，请你返回每个数字在序列中的加权和，它们的权重由它们的深度决定。 
//
// 序列中的每一个元素要么是一个整数，要么是一个序列（这个序列中的每个元素也同样是整数或序列）。 
//
// 与 前一个问题 不同的是，前一题的权重按照从根到叶逐一增加，而本题的权重从叶到根逐一增加。 
//
// 也就是说，在本题中，叶子的权重为1，而根拥有最大的权重。 
//
// 示例 1: 
//
// 输入: [[1,1],2,[1,1]]
//输出: 8 
//解释: 四个 1 在深度为 1 的位置， 一个 2 在深度为 2 的位置。
// 
//
// 示例 2: 
//
// 输入: [1,[4,[6]]]
//输出: 17 
//解释: 一个 1 在深度为 3 的位置， 一个 4 在深度为 2 的位置，一个 6 在深度为 1 的位置。 1*3 + 4*2 + 6*1 = 17。
// 
// Related Topics 栈 深度优先搜索 广度优先搜索 
// 👍 67 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.NestedInteger;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class NestedListWeightSumIi{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Integer> list=new ArrayList<>();
        int result=0;
        dfs(nestedList,list,0);

        for (int i=0;i<list.size();i++){
            result+=list.get(i)*(list.size()-i);
        }
        return result;
    }

    public void dfs(List<NestedInteger> nestedList,List<Integer> list,int depth){
        if (nestedList==null){
            return;
        }

        for (int i=0;i<nestedList.size();i++){
            if (nestedList.get(i).isInteger()){
                while (list.size()<=depth){
                    list.add(0);
                }
                list.set(depth,list.get(depth)+nestedList.get(i).getInteger());
            }
            else{
                dfs(nestedList.get(i).getList(),list,depth+1);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Solution solution = new Solution();
    }
  
}