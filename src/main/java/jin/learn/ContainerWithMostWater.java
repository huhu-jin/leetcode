package jin.learn;

import org.junit.Assert;
import org.junit.Test;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length-1;
        while (i < j) {
            res = Math.max((j - i) * Math.min(height[i], height[j]), res);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }


    @Test
    public void testOne(){
        int i = new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        Assert.assertEquals(49, i);

    }

}
