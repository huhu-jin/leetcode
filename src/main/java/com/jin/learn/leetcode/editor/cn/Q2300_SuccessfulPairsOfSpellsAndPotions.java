//  [2300]咒语和药水的成功对数

//给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，其中 spells[i] 表示第 i 个咒语的能量强度，potions[
//j] 表示第 j 瓶药水的能量强度。 
//
// 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。 
//
// 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。 
//
// 
//
// 示例 1： 
//
// 输入：spells = [5,1,3], potions = [1,2,3,4,5], success = 7
//输出：[4,0,3]
//解释：
//- 第 0 个咒语：5 * [1,2,3,4,5] = [5,10,15,20,25] 。总共 4 个成功组合。
//- 第 1 个咒语：1 * [1,2,3,4,5] = [1,2,3,4,5] 。总共 0 个成功组合。
//- 第 2 个咒语：3 * [1,2,3,4,5] = [3,6,9,12,15] 。总共 3 个成功组合。
//所以返回 [4,0,3] 。
// 
//
// 示例 2： 
//
// 输入：spells = [3,1,2], potions = [8,5,8], success = 16
//输出：[2,0,2]
//解释：
//- 第 0 个咒语：3 * [8,5,8] = [24,15,24] 。总共 2 个成功组合。
//- 第 1 个咒语：1 * [8,5,8] = [8,5,8] 。总共 0 个成功组合。
//- 第 2 个咒语：2 * [8,5,8] = [16,10,16] 。总共 2 个成功组合。
//所以返回 [2,0,2] 。
// 
//
// 
//
// 提示： 
//
// 
// n == spells.length 
// m == potions.length 
// 1 <= n, m <= 10⁵ 
// 1 <= spells[i], potions[i] <= 10⁵ 
// 1 <= success <= 10¹⁰ 
// 
//
// Related Topics 数组 双指针 二分查找 排序 👍 29 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;


// 二分查找

//相乘 注意越界
// 二分很 tricky
public class Q2300_SuccessfulPairsOfSpellsAndPotions{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        int[] ans = new int[spells.length];

        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int index = find(potions, spells[i], success);
            if (index == potions.length - 1) {
                if ((long) spells[i] * (long) potions[index] >= success) {
                    ans[i] =1;
                }else {
                    ans[i] = 0;
                }
            }else {
              ans[i] =  potions.length - index;
            }



        }

        return ans;


    }

        private int find(int[] potions, int spell, long success) {

            int l = 0;
            int r = potions.length-1;


            while (l < r) {
                int m = (r - l) / 2 + l;
                if ((long)spell * (long)potions[m] < success) {
                    l = m+1;
                }else if ((long)spell *  (long) potions[m] >= success){
                    r = m;
                }

            }
            return l;
        }



    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().successfulPairs(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{1, 2, 3, 4, 5, 6, 7}, 25);
    }
  
}