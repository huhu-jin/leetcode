package jin.learn;


import java.util.LinkedList;

//题目没有看懂

public class Solution_026 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int length = 1;
        int currentValue = nums[0];
        for (int i : nums) {
            if (i != currentValue) {
                length++;
                currentValue = i;
            }

        }
        return length;
    }

    public static void main(String[] args) {

        int i = new Solution_026().removeDuplicates(new int[]{0, 0, 1});

        i = new Solution_026().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});

        i = new Solution_026().removeDuplicates(new int[]{1, 2, 3});

        System.out.println(i);




    }
}
