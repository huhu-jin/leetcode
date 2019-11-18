package jin.learn;

/**
 * 1 防止翻转越界 -2(32)~2(32)-1
 * 2 特定反转方法
 *
 */

public class ReverseInteger {

    public int reverse(int x) {

        long res=0;

        while (x != 0) {
            res=res*10+x%10;
            x = x/10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }
}
