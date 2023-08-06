//  [314]二叉树的垂直遍历

//给你一个二叉树的根结点，返回其结点按 垂直方向（从上到下，逐列）遍历的结果。 
//
// 如果两个结点在同一行和列，那么顺序则为 从左到右。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[9],[3,15],[20],[7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [3,9,8,4,0,1,7]
//输出：[[4],[9],[3,0,1],[8],[7]]
// 
//
// 示例 3： 
//
// 
//输入：root = [3,9,8,4,0,1,7,null,null,null,2,5]
//输出：[[4],[9,5],[3,0,1],[8,2],[7]]
// 
//
// 示例 4： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 
// 👍 114 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;

import java.util.*;


public class Q314_BinaryTreeVerticalOrderTraversal{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        // 必须bfs 不能dfs 靠近root优先
        // treeMap key 位置 左子树－1 右子树 +1
        // bfs 不能像dfs 通过入参传递参数 posMap 保存位置
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Map<TreeNode, Integer > posMap = new HashMap<>();
        public List<List<Integer>> verticalOrder(TreeNode root) {
            if(root == null) return new ArrayList<>();
            bfs(root);
            return new ArrayList<>(map.values());
        }


        private void bfs(TreeNode root) {
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            posMap.put(root, 0);
            while (!deque.isEmpty()) {
                TreeNode tem = deque.pollFirst();
                int pos = posMap.get(tem);
                map.computeIfAbsent(pos, i -> new LinkedList<>()).add(tem.val);
                if (tem.left != null) {
                    deque.add(tem.left);
                    posMap.put(tem.left, pos - 1);
                }
                if (tem.right != null) {
                    deque.add(tem.right);
                    posMap.put(tem.right, pos + 1);
                }
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode17 = new TreeNode(17);
        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode17;
        new Solution().verticalOrder(treeNode3);
    }
  
}
