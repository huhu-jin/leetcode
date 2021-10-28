//  [1213]三个有序数组的交集

//给出三个均为 严格递增排列 的整数数组 arr1，arr2 和 arr3。 
//
// 返回一个由 仅 在这三个数组中 同时出现 的整数所构成的有序数组。 
//
// 
//
// 示例： 
//
// 输入: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
//输出: [1,5]
//解释: 只有 1 和 5 同时在这三个数组中出现.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length, arr3.length <= 1000 
// 1 <= arr1[i], arr2[i], arr3[i] <= 2000 
// 
// Related Topics 数组 哈希表 二分查找 计数 
// 👍 28 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class IntersectionOfThreeSortedArrays{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 考察api使用
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {

        LinkedList<Integer> list1 = new LinkedList<>();
        for (int i : arr1) {
            list1.add(i);
        }

        LinkedList<Integer> list2 = new LinkedList<>();
        for (int i : arr2) {
            list2.add(i);
        }
        LinkedList<Integer> list3 = new LinkedList<>();
        for (int i : arr3) {
            list3.add(i);
        }

        list1.retainAll(list2);
        list1.retainAll(list3);

        return list1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}