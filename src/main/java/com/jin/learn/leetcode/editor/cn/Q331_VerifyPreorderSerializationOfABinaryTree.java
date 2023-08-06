
//序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。 
//
//      _9_
//    /   \
//   3     2
//  / \   / \
// 4   1  #  6
/// \ / \   / \
//# # # #   # #
// 
//
// 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。 
//
// 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。 
//
// 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。 
//
// 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。 
//
// 示例 1: 
//
// 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
//输出: true 
//
// 示例 2: 
//
// 输入: "1,#"
//输出: false
// 
//
// 示例 3: 
//
// 输入: "9,#,#,1"
//输出: false 
// Related Topics 栈 
// 👍 281 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Stack;


// 窍门就是遇到num,#,# 这个说明这是一个叶子节点
// 那么移除这个叶子节点,将num,#,#替换为#
// 如果成功 一直移除直达根节点 说明是 二叉树

// 然后就是用栈实现了 依次压人 遇到 num,#,# 就pop后 在push#
// 最后栈为'#'就是对的
public class Q331_VerifyPreorderSerializationOfABinaryTree {
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSerialization(String preorder) {
        if("".equals(preorder) ) return false;
        Stack<String> stack = new Stack<>();
        for (String c : preorder.split(",")) {
            if ("#".equals(c)) {
                while (stack.size()>1 && "#".equals(stack.peek()) && !"#".equals(stack.elementAt(stack.size()-2))) {
                    stack.pop();
                    stack.pop();
                }
            }
            stack.push(c);
        }
        return stack.size()==1 && "#".equals(stack.peek());

    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Assert.assertFalse(new Solution().isValidSerialization("1,#,#,#,#"));
        Assert.assertTrue(new Solution().isValidSerialization("8,#,5,#,2,5,#,7,9,#,8,#,#,#,#"));
        Assert.assertTrue(new Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
  
}