//  [536]从字符串生成二叉树

//你需要从一个包括括号和整数的字符串构建一棵二叉树。 
//
// 输入的字符串代表一棵二叉树。它包括整数和随后的 0 ，1 或 2 对括号。整数代表根的值，一对括号内表示同样结构的子树。 
//
// 若存在左子结点，则从左子结点开始构建。 
//
// 
//
// 示例： 
//
// 输入："4(2(3)(1))(6(5))"
//输出：返回代表下列二叉树的根节点:
//
//       4
//     /   \
//    2     6
//   / \   / 
//  3   1 5   
// 
//
// 
//
// 提示： 
//
// 
// 输入字符串中只包含 '(', ')', '-' 和 '0' ~ '9' 
// 空树由 "" 而非"()"表示。 
// 
//
// 
// Related Topics 树 深度优先搜索 字符串 二叉树 
// 👍 67 👎 0


package com.jin.learn.leetcode.editor.cn;

import com.jin.learn.leetcode.editor.cn.common.TreeNode;
import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;


public class ConstructBinaryTreeFromString{
  
  
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
    //主要负数
    // 分割技巧
    // if(s.charAt(right) == '(') count++;
    // if(s.charAt(right) == ')') count--;
    public TreeNode str2tree1(String s) {
        if ("".equals(s)) return null;
        int i=0;
        int val=0;
        boolean flag=true;

        for (; i < s.length(); i++) {
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                val = val*10 +  s.charAt(i)-48;
            }else if (s.charAt(i)=='-'){
                flag =false;
            }else {
                break;
            }
        }
        TreeNode root = new TreeNode(flag?val:-val);

        TreeNode leftNode =null;
        int left = i;
        int right = left;
        int count =0;
        for (; right < s.length(); right++) {
            if(s.charAt(right) == '(') count++;
            if(s.charAt(right) == ')') count--;
            if(count==0){
                leftNode = str2tree(s.substring(left+1, right));
                 break;
            }
        }

        TreeNode rightNode =null;
        right++;
        left = right;
        for (; right < s.length(); right++) {
            if(s.charAt(right) == '(') count++;
            if(s.charAt(right) == ')') count--;
            if(count==0){
                rightNode = str2tree(s.substring(left+1, right));
            }
        }

        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    // 利用栈
    // ) 出栈
    public TreeNode str2tree(String s) {
        if ("".equals(s)) return null;
        Stack<TreeNode> stack = new Stack<>();
        boolean flag = true;
        int val=0;
        for(int i = 0; i < s.length();){
            if (s.charAt(i) == ')') {
                stack.pop(); i++;
            }else if(s.charAt(i) == '(')  {
                i++;
            } else if(s.charAt(i) == '-') {
                flag = false; i++;
            }else{
                while (i < s.length() && s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                    val = val*10 + s.charAt(i)-48;
                    i++;
                }
                TreeNode treeNode = new TreeNode(flag ? val : -val);
                flag = true; val = 0;
                if (!stack.isEmpty()) {
                    TreeNode father = stack.peek();
                    if (father.left == null) father.left = treeNode;
                    else father.right = treeNode;
                }
                stack.push(treeNode);
            }
        }
        // 最后留下一个
        return stack.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        TreeNode treeNode = new Solution().str2tree("4");
        System.out.println(11);
    }
  
}