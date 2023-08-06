//  [281]锯齿迭代器

//给出两个一维的向量，请你实现一个迭代器，交替返回它们中间的元素。 
//
// 示例: 
//
// 输入:
//v1 = [1,2]
//v2 = [3,4,5,6] 
//
//输出: [1,3,2,4,5,6]
//
//解析: 通过连续调用 next 函数直到 hasNext 函数返回 false，
//     next 函数返回值的次序应依次为: [1,3,2,4,5,6]。 
//
// 拓展：假如给你 k 个一维向量呢？你的代码在这种情况下的扩展性又会如何呢? 
//
// 拓展声明： 
// “锯齿” 顺序对于 k > 2 的情况定义可能会有些歧义。所以，假如你觉得 “锯齿” 这个表述不妥，也可以认为这是一种 “循环”。例如： 
//
// 输入:
//[1,2,3]
//[4,5,6,7]
//[8,9]
//
//输出: [1,4,8,2,5,9,3,6,7].
// 
// Related Topics 设计 队列 数组 迭代器 
// 👍 44 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.List;




    //leetcode submit region begin(Prohibit modification and deletion)
public class Q281_ZigzagIterator {

    private List<Integer> v1;
    private List<Integer> v2;
    private int p = 0;
    private int q = 0;



    public Q281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 =v1;
        this.v2 =v2;
    }

    public int next() {
        if ((p + q) % 2 == 0) {
            if (p < v1.size()) {
                return v1.get(p++);
            }
            return v2.get(q++);
        }else {
            if (q < v2.size()) {
                return v2.get(q++);
            }
            return v1.get(p++);
        }

    }

    public boolean hasNext() {
       return q+p< v1.size()+ v2.size() ;
    }

/**
 * Your Q281_ZigzagIterator object will be instantiated and called as such:
 * Q281_ZigzagIterator i = new Q281_ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */

    }
//leetcode submit region end(Prohibit modification and deletion)

    

