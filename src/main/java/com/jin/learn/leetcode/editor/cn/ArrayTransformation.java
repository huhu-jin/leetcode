//  [1243]数组变换

//首先，给你一个初始数组 arr。然后，每天你都要根据前一天的数组生成一个新的数组。 
//
// 第 i 天所生成的数组，是由你对第 i-1 天的数组进行如下操作所得的： 
//
// 
// 假如一个元素小于它的左右邻居，那么该元素自增 1。 
// 假如一个元素大于它的左右邻居，那么该元素自减 1。 
// 首、尾元素 永不 改变。 
// 
//
// 过些时日，你会发现数组将会不再发生变化，请返回最终所得到的数组。 
//
// 
//
// 示例 1： 
//
// 输入：[6,2,3,4]
//输出：[6,3,3,4]
//解释：
//第一天，数组从 [6,2,3,4] 变为 [6,3,3,4]。
//无法再对该数组进行更多操作。
// 
//
// 示例 2： 
//
// 输入：[1,6,3,4,3,5]
//输出：[1,4,4,4,4,5]
//解释：
//第一天，数组从 [1,6,3,4,3,5] 变为 [1,5,4,3,4,5]。
//第二天，数组从 [1,5,4,3,4,5] 变为 [1,4,4,4,4,5]。
//无法再对该数组进行更多操作。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 100 
// 1 <= arr[i] <= 100 
// 
// Related Topics 数组 模拟 
// 👍 15 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


import java.util.LinkedList;
import java.util.List;


public class ArrayTransformation{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)

    // 主要是看懂
    // 一次变一排
class Solution {
        public List<Integer> transformArray(int[] arr) {
            boolean flag = true;
            while(flag){
                flag =false;
                int[] temp = new int[arr.length];
                temp[0] = arr[0];
                temp[arr.length-1] = arr[arr.length-1];
                for(int i =1; i< arr.length-1;i ++) {
                    if(arr[i]<arr[i-1] && arr[i]<arr[i+1]){
                        temp[i] = arr[i]+1;
                        flag=true;
                    }else if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                        temp[i] = arr[i]-1;
                        flag=true;
                    }else {
                        temp[i] = arr[i];
                    }
                }
                arr = temp;
            }


            LinkedList<Integer> ans = new LinkedList<>();
            for (int i : arr) {
                ans.add(i);
            }
            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().transformArray(new int[]{6,2,3,4});

        
    }
  
}