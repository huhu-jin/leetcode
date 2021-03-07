package jin.learn;


import org.testng.annotations.Test;

public class FindMedianSortedArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int k = (n1 + n2 + 1) / 2;
        int l = 0;
        int r = n1;

        // 核心代码 在于如何二分
        while (l < r) {
            int m1 =(r + l) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1])
                l = m1 + 1;
            else
                r = m1;
        }

        int m1 = l;
        int m2 = k - l;

        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                          m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);

        if ((n1 + n2) % 2 == 1)
            return c1;

        int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1],
                          m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);

        return (c1 + c2) * 0.5;

    }

    @Test
    public void testOne(){
        int[] n1 = new int[]{-1, 1, 3, 5, 7, 9};
        int[] n2 = new int[]{2, 4, 6, 8, 10, 12, 14, 16};

        new FindMedianSortedArrays().findMedianSortedArrays(n1, n2);
    }


    @Test
    public void testWhile(){
        int l = 0;
        int r = 100;
        while (l < r) {
            System.out.println( l+"||"+r);
            int temp = ( l + r) / 2;
            if (1>2)
                l = temp + 1; // l 逐渐变大 接近于100
            else
                r = temp; // r逐渐变小 接近于0
        }

    }

}
