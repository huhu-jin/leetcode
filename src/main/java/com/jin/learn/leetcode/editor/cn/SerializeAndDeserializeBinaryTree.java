//  [297]二叉树的序列化与反序列化

//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 10⁴] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 888 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.common.TreeNode;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class SerializeAndDeserializeBinaryTree{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // 不是满 二叉树 !!!
    // null也入队列, 到4-null,5-null. 为止
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root ==null) return "";
        StringBuilder builder = new StringBuilder();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            TreeNode temp = deque.poll();
            if (temp != null) {
                builder.append(temp.val);
                deque.add(temp.left);
                deque.add(temp.right);
            }else {
                builder.append("n");
            }
            builder.append(",");
        }
        String ans = builder.toString();
        return ans.substring(0,ans.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] split = data.split(",");

        TreeNode root = new TreeNode();
        root.val = Integer.parseInt(split[0]);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int i = 1;
        while (!deque.isEmpty()) {
            TreeNode temp = deque.poll();
            if (!"n".equals(split[i])) {
                temp.left = new TreeNode(Integer.parseInt(split[i]));
                deque.add( temp.left);
            }
            i++;

            if (!"n".equals(split[i])) {
                temp.right = new TreeNode(Integer.parseInt(split[i]));
                deque.add( temp.right);
            }
            i++;

        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Codec codec = new Codec();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left =node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node4.left = node6;
        node4.right = node7;
        codec.deserialize(codec.serialize(node1));
    }
  
}