package jin.learn;

// arrays 迭代问题 双指针
// i 迭代,遇到!val,赋值r r前走
// nums[res++] 这个怎么理解  []优先级别大于++
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0) return 0;
        int res =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[res++] = nums[i];
            }
        }
        return res;
    }

    @Test
    public void testOne(){
        int [] input = new int[]{1, 2, 3, 2, 4, 2};
        int i = new RemoveElement().removeElement(input, 2);
        Assert.assertEquals(i, 3);
    }

    @Test
    public void testTwo(){
        int [] input = new int[]{ 3, 2, 2, 3};
        int i = new RemoveElement().removeElement(input, 2);
        Assert.assertEquals(i, 2);
    }



}
