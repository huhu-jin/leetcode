//  [379]电话目录管理系统

//设计一个电话目录管理系统，让它支持以下功能： 
//
// 
// get: 分配给用户一个未被使用的电话号码，获取失败请返回 -1 
// check: 检查指定的电话号码是否被使用 
// release: 释放掉一个电话号码，使其能够重新被分配 
// 
//
// 
//
// 示例： 
//
// // 初始化电话目录，包括 3 个电话号码：0，1 和 2。
//PhoneDirectory directory = new PhoneDirectory(3);
//
//// 可以返回任意未分配的号码，这里我们假设它返回 0。
//directory.get();
//
//// 假设，函数返回 1。
//directory.get();
//
//// 号码 2 未分配，所以返回为 true。
//directory.check(2);
//
//// 返回 2，分配后，只剩一个号码未被分配。
//directory.get();
//
//// 此时，号码 2 已经被分配，所以返回 false。
//directory.check(2);
//
//// 释放号码 2，将该号码变回未分配状态。
//directory.release(2);
//
//// 号码 2 现在是未分配状态，所以返回 true。
//directory.check(2);
// 
//
// 
//
// 提示： 
//
// 
// 1 <= maxNumbers <= 10^4 
// 0 <= number < maxNumbers 
// 调用方法的总数处于区间 [0 - 20000] 之内 
// 
// Related Topics 设计 队列 数组 哈希表 链表 
// 👍 26 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.Arrays;


public class Q379_DesignPhoneDirectory{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class PhoneDirectory {
	boolean[] sys;
	int size = 0;

	/**
	 * Initialize your data structure here
	 *
	 * @param maxNumbers - The maximum numbers that can be stored in the phone
	 *                   directory.
	 */
	public PhoneDirectory(int maxNumbers) {
		size = maxNumbers;
		sys = new boolean[size];
		Arrays.fill(sys, true);
	}

	/**
	 * Provide a number which is not assigned to anyone.
	 *
	 * @return - Return an available number. Return -1 if none is available.
	 */
	public int get() {
		for (int i = 0; i < size; i++) {
			if (sys[i]) {
				sys[i] = false;
				return i;
			}
		}
		return -1;
	}

	/** Check if a number is available or not. */
	public boolean check(int number) {
		return sys[number];
	}

	/** Recycle or release a number. */
	public void release(int number) {
		sys[number] = true;
	}
}


/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){

    }
  
}
