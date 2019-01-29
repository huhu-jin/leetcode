package jin.learn;

// 数学方法 解决
// 平方数 = 1+3+5+7+9 ...
public class Solution_367 {

    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
