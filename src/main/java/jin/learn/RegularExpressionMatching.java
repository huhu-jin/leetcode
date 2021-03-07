package jin.learn;

import org.testng.annotations.Test;

/**
 * dp[j][i]表示，pattern字符串的子串(0,j)是否和目标字符串的子串(0,i)匹配
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;

        //定义状态
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //初始状态赋值
        dp[0][0] = true;
        for(int i=1; i<=s.length(); i++)
            dp[i][0] = false;
        for(int j=1; j<=p.length(); j++)
            if(p.charAt(j-1) == '*' && dp[0][j-2])
                dp[0][j] = true;

        //利用初始状态值 以及 转移方程 求解未知状态值， 直到最终状态
        for(int i=1; i<=s.length(); i++){
            for(int j=1; j<=p.length(); j++){
                //case 1
                if(p.charAt(j-1) == s.charAt(i-1))
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '.')
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*'){
                    if(p.charAt(j-2) != s.charAt(i-1) && p.charAt(j-2) != '.')
                        dp[i][j] = dp[i][j-2];
                    else
                        dp[i][j] = (dp[i][j-1] || dp[i-1][j] || dp[i][j-2]);
                }else
                    dp[i][j] = false;
            }
        }
        return dp[s.length()][p.length()];
    }

    @Test
    public void testOne(){
        boolean aaaabbb = new RegularExpressionMatching().isMatch("aaaabbb", "a*b*");
    }


}
