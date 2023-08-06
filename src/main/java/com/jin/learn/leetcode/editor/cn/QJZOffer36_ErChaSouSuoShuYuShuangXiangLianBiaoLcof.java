//  [剑指 Offer 36]二叉搜索树与双向链表

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。 
//
// 
//
// 为了让您更好地理解问题，以下面的二叉搜索树为例： 
//
// 
//
// 
//
// 
//
// 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是
//第一个节点。 
//
// 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。 
//
// 
//
// 
//
// 
//
// 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。 
//
// 
//
// 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
//to-sorted-doubly-linked-list/ 
//
// 注意：此题对比原题有改动。 
// Related Topics 栈 树 深度优先搜索 二叉搜索树 链表 二叉树 双向链表 
// 👍 257 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class QJZOffer36_ErChaSouSuoShuYuShuangXiangLianBiaoLcof{
  
  class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
    //leetcode submit region begin(Prohibit modification and deletion)

/* 中序遍历
void dfs(Node root) {
    if(root == null) return;
    dfs(root.left); // 左
    // 处理关系
    System.out.println(root.val); // 根
    dfs(root.right); // 右
}
*/

class Solution {

    private Node pre;
    private Node head;

    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left =pre;
        pre.right =head;
        return head;
    }


    private void dfs(Node cur) {
        if(cur == null) return;
        dfs(cur.left);

        if(pre == null){
            head= cur;
            pre = cur;
        }else{
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }

        dfs(cur.right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node4.left= node2;
        node4.right = node5;
        node2.left = node1;
        node2.right = node3;
        new Solution().treeToDoublyList(node4);

    }
  
}
