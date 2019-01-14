package jin.learn;

public class Solution_038 {

    public String countAndSay(int n) {
        String ret = "1";
        while (n > 1) {
            ret = count(ret);
            n--;
        }
        return ret;
    }

    private String count(String ret) {
        char temp = ret.charAt(0);
        int count = 0;
        String innerRet = "";
        for (char i : ret.toCharArray()) {
            if (i != temp) {
                innerRet = innerRet + count + temp;
                count = 0;
                temp = i;
            }
            count++;
        }
        innerRet = innerRet + count + temp;
        return innerRet;
    }
}
