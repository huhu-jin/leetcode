package jin.learn;


public class Solution_724 {
    public int pivotIndex(int[] nums) {
        if(nums.length<3) return -1;
        int mid = nums.length / 2;
        int leftSum = 0;
        int rightSum = 0;
        boolean moveLeft= false;
        boolean moveRight = false;
        for (int i = 0; i < mid; i++) {
            leftSum += nums[i];
        }
        for (int i = mid+1; mid < nums.length; i++) {
            leftSum += nums[i];
        }

        while (!(moveLeft && moveRight)) {
            if (leftSum == rightSum) {
                return mid;
            }else if(leftSum > rightSum){
                moveLeft = true;
                mid--;
                leftSum -= nums[mid];
                rightSum += nums[mid];

            }else if(leftSum < rightSum){
                moveRight = true;
                mid++;
                leftSum += nums[mid];
                rightSum -= nums[mid];
            }
        }
        return -1;
    }
}
