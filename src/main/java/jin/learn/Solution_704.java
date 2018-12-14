package jin.learn;

public class Solution_704 {
     public int search(int[] nums, int target) {
         if(nums==null ||nums.length==0) return -1;
         int start=0;
         int end = nums.length-1;
         while (start <= end) {
             int mid = (start+end)>>>1;
             if(nums[mid]==target){
                 return mid;
             } else if (nums[mid] > target) {
                 end=mid-1;
             }else{
                 start=mid+1;
             }

         }
         return -1;
    }

    public static void main(String[] args) {
        int search = new Solution_704().search(new int[]{-1,0},
0);
        System.out.println(search);

    }

}
