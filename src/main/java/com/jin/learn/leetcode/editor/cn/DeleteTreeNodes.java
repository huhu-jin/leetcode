//  [1273]删除树节点

//给你一棵以节点 0 为根节点的树，定义如下： 
//
// 
// 节点的总数为 nodes 个； 
// 第 i 个节点的值为 value[i] ； 
// 第 i 个节点的父节点是 parent[i] 。 
// 
//
// 请你删除节点值之和为 0 的每一棵子树。 
//
// 在完成所有删除之后，返回树中剩余节点的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-1]
//输出：2
// 
//
// 示例 2： 
//
// 输入：nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-2]
//输出：6
// 
//
// 示例 3： 
//
// 输入：nodes = 5, parent = [-1,0,1,0,0], value = [-672,441,18,728,378]
//输出：5
// 
//
// 示例 4： 
//
// 输入：nodes = 5, parent = [-1,0,0,1,1], value = [-686,-842,616,-739,-746]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nodes <= 10^4 
// parent.length == nodes 
// 0 <= parent[i] <= nodes - 1 
// parent[0] == -1 表示节点 0 是树的根。 
// value.length == nodes 
// -10^5 <= value[i] <= 10^5 
// 题目输入数据 保证 是一棵 有效的树 。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 26 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.LinkedList;


public class DeleteTreeNodes{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int removed = 0;
    // 递归
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        dfs(0, parent, value);
        return nodes-removed;
    }

        private int[] dfs(int i, int[] parent, int[] value) {

            int cur = value[i];

            LinkedList<Integer> temp = new LinkedList<>();
            for (int j = 1; j < parent.length; j++) {
                if (parent[j] == i) {
                    temp.add(j);
                }
            }
            int sum =0;
            int count = 0;
            for (int k : temp) {
                int[] dfs = dfs(k, parent, value);
                sum += dfs[0];
                count += dfs[1];
            }

            if (cur + sum ==0) {
                removed += count + 1;
                return new int[]{0, 0};
            }

            return new int[]{cur+sum, count+1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
    }
  
}