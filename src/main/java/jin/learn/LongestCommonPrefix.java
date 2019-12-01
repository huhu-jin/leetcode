package jin.learn;
// 14
// 最长公共 pre的串

import org.junit.Test;

// 以第一个 String 作为模板
// 然后逐个比较是否是 子串
// 如果不是 模板减1
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0) // indexOf()是否在里面
                pre = pre.substring(0,pre.length()-1); // pre字符串变短
            i++;
        }
        return pre;
    }


    @Test
    public void testOne(){
        String[] input = new String[]{"abcd", "abdf"};

        String s = new LongestCommonPrefix().longestCommonPrefix(input);
        System.out.println(s);

    }
}
