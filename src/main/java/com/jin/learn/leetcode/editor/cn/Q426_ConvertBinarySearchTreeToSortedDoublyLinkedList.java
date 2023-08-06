//  [426]将二叉搜索树转化为排序的双向链表

//将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 。 
//
// 对于双向循环列表，你可以将左右孩子指针作为双向循环链表的前驱和后继指针，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。 
//
// 特别地，我们希望可以 就地 完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中最小元素的指针。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [4,2,5,1,3] 
//
//
//输出：[1,2,3,4,5]
//
//解释：下图显示了转化后的二叉搜索树，实线表示后继关系，虚线表示前驱关系。
//
// 
//
// 示例 2： 
//
// 
//输入：root = [2,1,3]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
//解释：输入是空树，所以输出也是空链表。
// 
//
// 示例 4： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// -1000 <= Node.val <= 1000 
// Node.left.val < Node.val < Node.right.val 
// Node.val 的所有值都是独一无二的 
// 0 <= Number of Nodes <= 2000 
// 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 链表 二叉树 双向链表 
// 👍 124 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.Node;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class Q426_ConvertBinarySearchTreeToSortedDoublyLinkedList{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 用来保存中序遍历结果的列表
        private List<Node> nodes;

        public Node treeToDoublyList(Node root) {
            nodes = new ArrayList<>();
            // 如果这个树就是空的，那么直接返回就好了
            if (root == null) return null;
            // 中序遍历
            inorder(root);
            // 虚拟头部节点，方便定位返回的头节点，以及用来拼接双向链表当前位置的 curr 节点
            Node dummyHead = new Node(0), curr = dummyHead;
            // 构建双向链表
            for (Node node : nodes) {
                curr.right = node;
                node.left = curr;
                curr = node;
            }
            // 需要把最后的节点和头部节点连接到一起
            dummyHead.right.left = curr;
            curr.right = dummyHead.right;
            return dummyHead.right;
        }

        // 中序遍历
        private void inorder(Node root) {
            if (root == null) return;
            inorder(root.left);
            nodes.add(root);
            inorder(root.right);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Node node = new Node(1);
        new Solution().treeToDoublyList(node);
    }
  
}
