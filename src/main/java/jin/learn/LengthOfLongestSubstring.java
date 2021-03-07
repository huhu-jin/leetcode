package jin.learn;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 在提供的字符串(包括!#2})中,查找不重复子串的最大长度
 * 例如: "abcbd" 最长为cbd
 * 首先必须要有一个容器去存储哪些字符串已经有了.
 * 第二 比如 "abcbd" 遇到重复时候,移除a.这样就要记录放入容器中的顺序.如果这样做显然比较复杂
 * 技巧:采用快慢指针,i,j
 * i,j从头开始走,j遇到不同向前走,并记录经历的字符
 * i则是j遇到相同的字符,开始往前走,从记录中移除经历的字符(解决了记录放入容器中的顺序问题).遇到该重复字符停下.
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int ret = 0;
        int i = 0;
        int j = 0;
        int[] note = new int[128];
        if (s == null) return 0;

        while (j < s.length()) {
            if (note[(s.charAt(j))] == 1) {
                ret = Math.max(ret, j - i);
                note[(s.charAt(i))] = 0;
                i++;
            } else {
                note[(s.charAt(j))] = 1;
                j++;
            }
        }
        return Math.max(ret, j - i);
    }


    @Test
    public void oneTest() {
        int i = new LengthOfLongestSubstring().lengthOfLongestSubstring(" ");
        Assert.assertEquals(1, i);
    }

    @Test
    public void twoTest() {
        int i = new LengthOfLongestSubstring().lengthOfLongestSubstring("au");
        Assert.assertEquals(2, i);
    }

    @Test
    public void threeTest() {
        int i = new LengthOfLongestSubstring().lengthOfLongestSubstring("dvdf");
        Assert.assertEquals(3, i);
    }

    @Test
    public void fourTest() {
        int i = new LengthOfLongestSubstring().lengthOfLongestSubstring("abcdddbd");
        Assert.assertEquals(4, i);
    }
}
