package jin.learn;

import org.junit.Test;

// 判断该数字是否是回文数字
// 方法该数字掉头,然后和原来是否相等.


public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x<0 || (x!=0 && x%10==0))
            return false;
        int res = 0;
        while(x>res){
            res = res*10 + x%10;
            x = x/10;
        }
        return (x==res || x==res/10);
    }

    @Test
    public void testOne(){
        boolean palindrome = new PalindromeNumber().isPalindrome(123321);
    }
}
