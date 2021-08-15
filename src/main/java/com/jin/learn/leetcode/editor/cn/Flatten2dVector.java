//  [251]展开二维向量

//请设计并实现一个能够展开二维向量的迭代器。该迭代器需要支持 next 和 hasNext 两种操作。 
//
// 
//
// 示例： 
//
// 
//Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
//
//iterator.next(); // 返回 1
//iterator.next(); // 返回 2
//iterator.next(); // 返回 3
//iterator.hasNext(); // 返回 true
//iterator.hasNext(); // 返回 true
//iterator.next(); // 返回 4
//iterator.hasNext(); // 返回 false
// 
//
// 
//
// 注意： 
//
// 
// 请记得 重置 在 Vector2D 中声明的类变量（静态变量），因为类变量会 在多个测试用例中保持不变，影响判题准确。请 查阅 这里。 
// 你可以假定 next() 的调用总是合法的，即当 next() 被调用时，二维向量总是存在至少一个后续元素。 
// 
//
// 
//
// 进阶：尝试在代码中仅使用 C++ 提供的迭代器 或 Java 提供的迭代器。 
// Related Topics 设计 数组 双指针 迭代器 
// 👍 41 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.NoSuchElementException;


public class Flatten2dVector{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Vector2D {
        private int[][] vector;
        private int inner = 0;
        private int outer = 0;

        public Vector2D(int[][] v) {
            vector = v;
        }

        // 这个移动 很关键 像个指针 像一个指针一样
        // 边界条件 很好判断
        private void advanceToNext() {
            while (outer < vector.length && inner == vector[outer].length) {
                inner = 0;
                outer++;
            }
        }

        public int next() {
            advanceToNext();
            return vector[outer][inner++];
        }

        public boolean hasNext() {
            advanceToNext();
            return outer < vector.length;
        }

    }
/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){

        Vector2D vector2D = new Vector2D(new int[][]{{1, 2, 3}, {4}});
        int next = vector2D.next();
         next = vector2D.next();
         next = vector2D.next();
        vector2D.hasNext();
        next = vector2D.next();
          vector2D.hasNext();
        System.out.println('1');
    }
  
}