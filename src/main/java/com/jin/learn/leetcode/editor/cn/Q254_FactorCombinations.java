//  [254]因子的组合

//整数可以被看作是其因子的乘积。 
//
// 例如： 
//
// 8 = 2 x 2 x 2;
//  = 2 x 4. 
//
// 请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。 
//
// 注意： 
//
// 
// 你可以假定 n 为永远为正数。 
// 因子必须大于 1 并且小于 n。 
// 
//
// 示例 1： 
//
// 输入: 1
//输出: []
// 
//
// 示例 2： 
//
// 输入: 37
//输出: [] 
//
// 示例 3： 
//
// 输入: 12
//输出:
//[
//  [2, 6],
//  [2, 2, 3],
//  [3, 4]
//] 
//
// 示例 4: 
//
// 输入: 32
//输出:
//[
//  [2, 16],
//  [2, 2, 8],
//  [2, 2, 2, 4],
//  [2, 2, 2, 2, 2],
//  [2, 4, 4],
//  [4, 8]
//]
// 
// Related Topics 数组 回溯 
// 👍 84 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;


public class Q254_FactorCombinations{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
     // 回溯 ,难点是如何去重,比如getFactors1.

        // 用start来避免重复
        // 比如n =12;
        // 2->6, 然后6再分解 2 3
        // 3->4 然后 因为是3开始的 4不能再分了 避免 322重复
        public List<List<Integer>> getFactors(int n) {
            return dfs(2,n);
        }

        List<List<Integer>> dfs(int start, int num) {
            if (num == 1) return new ArrayList<>();

            List<List<Integer>> ans = new ArrayList<>();
            for (int mulNum = start; mulNum <= Math.sqrt(num); mulNum++) {
                if (num % mulNum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(mulNum);
                    temp.add(num/mulNum);
                    ans.add(temp);

                    List<List<Integer>> nextLists = dfs(mulNum, num/mulNum);
                    for (List<Integer> nextList : nextLists) {
                        nextList.add(mulNum);
                        ans.add(nextList);
                    }
                }
            }
            return ans;
        }



    HashMap<Integer,List<List<Integer>>> memo = new HashMap<>();

    public List<List<Integer>> getFactors1(int n) {
        return backtracking(n,true);
    }

    private List<List<Integer>> backtracking(int n, boolean isMostOuter){
        List<List<Integer>> arr = new LinkedList<>();
        for (int i = 1;  i <= Math.sqrt(n); i++) {
            if( (n%i) == 0){
                int v = n/i;
                if (v == n && !isMostOuter){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(n);
                    arr.add(temp);
                } else if(v != n) {
                    List<List<Integer>> low;
                    if (memo.containsKey(v)) {
                         low = memo.get(v);
                    } else{
                        low = backtracking(v,false);
                        memo.put(v, low);
                    }
                    for (List<Integer> l : low) {
                        ArrayList<Integer> temp = new ArrayList<>(l);
                        temp.add(i);
                        arr.add(temp);
                    }
                }
            }
        }

        //去重
        HashSet<String> set = new  HashSet<>();
        List<List<Integer>> realAns = new LinkedList<>();
        for (List<Integer> l : arr) {
            StringBuffer stringBuffer = new StringBuffer();
            List<Integer> list = l.stream().sorted().peek(stringBuffer::append).collect(Collectors.toList());
            String key = stringBuffer.toString();
            if (!set.contains(key)) {
                set.add(key);
                realAns.add(list);
            }
        }
        return realAns;
    }



}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){

        List<List<Integer>> factors = new Solution().getFactors(12);
    }
  
}
