//  [742]二叉树最近的叶节点

//给定一个 每个结点的值互不相同 的二叉树，和一个目标值 k，找出树中与目标值 k 最近的叶结点。 
//
// 这里，与叶结点 最近 表示在二叉树中到达该叶节点需要行进的边数与到达其它叶结点相比最少。而且，当一个结点没有孩子结点时称其为叶结点。 
//
// 在下面的例子中，输入的树以逐行的平铺形式表示。实际上的有根树 root 将以TreeNode对象的形式给出。 
//
// 示例 1： 
//
// 输入：
//root = [1, 3, 2], k = 1
//二叉树图示：
//          1
//         / \
//        3   2
//
//输出： 2 (或 3)
//
//解释： 2 和 3 都是距离目标 1 最近的叶节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：
//root = [1], k = 1
//输出：1
//
//解释： 最近的叶节点是根结点自身。
// 
//
// 
//
// 示例 3： 
//
// 输入：
//root = [1,2,3,4,null,null,null,5,null,6], k = 2
//二叉树图示：
//             1
//            / \
//           2   3
//          /
//         4
//        /
//       5
//      /
//     6
//
//输出：3
//解释： 值为 3（而不是值为 6）的叶节点是距离结点 2 的最近结点。
// 
//
// 
//
// 注： 
//
// 
// root 表示的二叉树最少有 1 个结点且最多有 1000 个结点。 
// 每个结点都有一个唯一的 node.val ，范围为 [1, 1000]。 
// 给定的二叉树中有某个结点使得 node.val == k。 
// 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 73 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.leetcode.editor.cn.common.TreeNode;
import org.testng.annotations.Test;

import java.util.*;


public class ClosestLeafInABinaryTree{
  
  
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
    // 方法一：转换成图

//    public int findClosestLeaf(TreeNode root, int k) {
//        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
//        dfs(graph, root, null);
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        Set<TreeNode> seen = new HashSet<>();
//
//        for (TreeNode node: graph.keySet()) {
//            if (node != null && node.val == k) {
//                queue.add(node);
//                seen.add(node);
//            }
//        }
//
//        // 图遍历
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node != null) {
//                if (graph.get(node).size() <= 1)
//                    return node.val;
//                for (TreeNode nei: graph.get(node)) {
//                    if (!seen.contains(nei)) {
//                        seen.add(nei);
//                        queue.add(nei);
//                    }
//                }
//            }
//        }
//
//        throw null;
//    }
//
//    public void dfs(Map<TreeNode, List<TreeNode>> graph, TreeNode node, TreeNode parent) {
//        if (node != null) {
//            if (!graph.containsKey(node)) graph.put(node, new LinkedList<TreeNode>());
//            if (!graph.containsKey(parent)) graph.put(parent, new LinkedList<TreeNode>());
//            graph.get(node).add(parent);
//            graph.get(parent).add(node);
//            dfs(graph, node.left, node);
//            dfs(graph, node.right, node);
//        }
//    }


//遍历找到k值的所有父节点
// 判断所有父节点 最近叶子是否是 答案

List<TreeNode> path;
    Map<TreeNode, LeafResult> annotation;

    public int findClosestLeaf(TreeNode root, int k) {
        path = new ArrayList();
        annotation = new HashMap();

        dfs(root, k);

        int distanceFromTarget = path.size() - 1;
        int dist = Integer.MAX_VALUE;
        TreeNode leaf = null;
        for (TreeNode node: path) {
            LeafResult lr = closestLeaf(node);
            if (lr.dist + distanceFromTarget < dist) {
                dist = lr.dist + distanceFromTarget;
                leaf = lr.node;
            }
            distanceFromTarget--;
        }
        return leaf.val;
    }

    public boolean dfs(TreeNode node, int k) {
        if (node == null) {
            return false;
        } else if (node.val == k) {
            path.add(node);
            return true;
        } else {
            path.add(node);
            boolean ans = dfs(node.left, k);
            if (ans) return true;
            ans = dfs(node.right, k);
            if (ans) return true;
            path.remove(path.size() - 1);
            return false;
        }
    }

    public LeafResult closestLeaf(TreeNode root) {
        if (root == null) {
            return new LeafResult(null, Integer.MAX_VALUE);
        } else if (root.left == null && root.right == null) {
            return new LeafResult(root, 0);
        } else if (annotation.containsKey(root)) {
            return annotation.get(root);
        } else {
            LeafResult r1 = closestLeaf(root.left);
            LeafResult r2 = closestLeaf(root.right);
            LeafResult ans = new LeafResult(r1.dist < r2.dist ? r1.node : r2.node,
                    Math.min(r1.dist, r2.dist) + 1);
            annotation.put(root, ans);
            return ans;
        }
    }

    class LeafResult {
        TreeNode node;
        int dist;
        LeafResult(TreeNode n, int d) {
            node = n;
            dist = d;
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}