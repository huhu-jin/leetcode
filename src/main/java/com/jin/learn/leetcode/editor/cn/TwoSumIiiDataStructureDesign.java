//  [170]两数之和 III - 数据结构设计

//设计一个接收整数流的数据结构，该数据结构支持检查是否存在两数之和等于特定值。 
//
// 实现 TwoSum 类： 
//
// 
// TwoSum() 使用空数组初始化 TwoSum 对象 
// void add(int number) 向数据结构添加一个数 number 
// boolean find(int value) 寻找数据结构中是否存在一对整数，使得两数之和与给定的值相等。如果存在，返回 true ；否则，返回 fal
//se 。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["TwoSum", "add", "add", "add", "find", "find"]
//[[], [1], [3], [5], [4], [7]]
//输出：
//[null, null, null, null, true, false]
//
//解释：
//TwoSum twoSum = new TwoSum();
//twoSum.add(1);   // [] --> [1]
//twoSum.add(3);   // [1] --> [1,3]
//twoSum.add(5);   // [1,3] --> [1,3,5]
//twoSum.find(4);  // 1 + 3 = 4，返回 true
//twoSum.find(7);  // 没有两个整数加起来等于 7 ，返回 false 
//
// 
//
// 提示： 
//
// 
// -105 <= number <= 105 
// -231 <= value <= 231 - 1 
// 最多调用 5 * 104 次 add 和 find 
// 
// Related Topics 设计 数组 哈希表 双指针 数据流 
// 👍 50 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class TwoSumIiiDataStructureDesign{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class TwoSum {

    private List<Integer> list = new ArrayList<>();

    /** Initialize your data structure here. */
    public TwoSum() {

    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int left = 0;
        int right = list.size()-1;
        Integer[] numbers = list.toArray(new Integer[0]);
        Arrays.sort(numbers);
        while(left <right){
            if(numbers[left]+ numbers[right]<value){
                left++;
            }else if(numbers[left]+ numbers[right]>value){
                right--;
            }else {
                return true;
            }
        }
        return false;
    }


}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}