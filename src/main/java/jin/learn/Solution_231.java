package jin.learn;


public class Solution_231 {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        while (n != 0) {
            if (n == 2 || n == 1) {
                return true;
            } else if ((n & 1) == 1) {
                return false;
            } else {
                n = n >>> 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean powerOfTwo = new Solution_231().isPowerOfTwo(4);
        System.out.println(powerOfTwo);

    }

}

