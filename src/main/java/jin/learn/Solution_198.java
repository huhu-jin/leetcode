package jin.learn;

//采用dp算法

// 1 写出递推公式
// 2 列出初值情况
// 3 缓存化
// 4 递推变迭代


import java.util.Arrays;

public class Solution_198 {
    public int rob(int[] num) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : num) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }

}
