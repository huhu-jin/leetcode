//  [333]最大 BST 子树

//给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，并返回该子树的大小。其中，最大指的是子树节点数最多的。 
//
// 二叉搜索树（BST）中的所有节点都具备以下属性： 
//
// 
// 
// 左子树的值小于其父（根）节点的值。 
// 
// 
// 右子树的值大于其父（根）节点的值。 
// 
// 
//
// 注意: 
//
// 
// 子树必须包含其所有后代。 
// 
//
// 进阶: 
//
// 
// 你能想出 O(n) 时间复杂度的解法吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,15,1,8,null,7]
//输出：3
//解释：本例中最大的 BST 子树是高亮显示的子树。返回值是子树的大小，即 3 。 
//
// 示例 2： 
//
// 
//输入：root = [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树上节点数目的范围是 [0, 104] 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 动态规划 二叉树 
// 👍 105 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;

import java.util.HashMap;


public class Q333_LargestBstSubtree{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int ans = 1 ;
    private TreeNode pre; // 先前的 节点
    private int preLevel; // 先前节点 深度
    HashMap<Integer, Boolean> map = new HashMap<>();

    // dfs map缓存 是否是bst
    //

    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        dfs(root,0);
        return ans;
    }

    private int dfs(TreeNode root, int level) {
        if(root == null) return 0;

        int leftCount = dfs(root.left, level+1);
        // bst不是
        if (pre != null && pre.val >= root.val) {
            if (level > preLevel) {
                map.put(pre.val, false);
            } else {
                map.put(root.val, false);
            }
        }
        pre = root;
        preLevel = level;
        int rightCount = dfs(root.right, level+1);

        // 子树 不是bst  root也不是
        if (root.right != null) {
            Boolean orDefault = map.getOrDefault(root.right.val, true);
            if(!orDefault) map.put(root.val, false);
        }

         if (root.left != null) {
            Boolean orDefault = map.getOrDefault(root.left.val, true);
            if(!orDefault) map.put(root.val, false);
        }

        if (map.getOrDefault(root.val, true)) {
            ans = Math.max(leftCount + rightCount+1, ans);
            return leftCount + rightCount + 1;
        }else {
            return 1;
        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Solution solution = new Solution();
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode21 = new TreeNode(2);
//        TreeNode treeNode7 = new TreeNode(7);
//        TreeNode treeNode22 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode5 = new TreeNode(5);
//        TreeNode treeNode23 = new TreeNode(2);
//        TreeNode treeNode1 = new TreeNode(1);
//
//        treeNode4.left = treeNode21;
//        treeNode4.right = treeNode7;
//        treeNode7.left = treeNode5;
//
//        treeNode21.left = treeNode22;
//        treeNode21.right = treeNode3;
//        treeNode22.left = treeNode23;
//
//        treeNode23.left = treeNode1;
//
//        solution.largestBSTSubtree(treeNode4);

//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode1 = new TreeNode(1);
//
//
//        treeNode3.left = treeNode2;
//        treeNode3.right = treeNode4;
//        treeNode4.left = treeNode1;
//        solution.largestBSTSubtree(treeNode3);

//        TreeNode treeNode5 = new TreeNode(5);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode3 = new TreeNode(3);
//
//        treeNode5.right = treeNode2;
//        treeNode2.left = treeNode1;
//        treeNode1.right = treeNode4;
//        treeNode4.left = treeNode3;
//
//        new Solution().largestBSTSubtree(treeNode5);

        TreeNode treeNode3 = new TreeNode(3);

    }
  
}
