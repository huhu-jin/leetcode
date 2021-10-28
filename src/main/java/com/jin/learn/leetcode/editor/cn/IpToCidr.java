//  [751]IP 到 CIDR

//给定一个起始 IP 地址 ip 和一个我们需要包含的 IP 的数量 n，返回用列表（最小可能的长度）表示的 CIDR块的范围。 
//
// CIDR 块是包含 IP 的字符串，后接斜杠和固定长度。例如：“123.45.67.89/20”。固定长度 “20” 表示在特定的范围中公共前缀位的长度。
// 
//
// 示例 1： 
//
// 输入：ip = "255.0.0.7", n = 10
//输出：["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
//解释：
//转换为二进制时，初始IP地址如下所示（为清晰起见添加了空格）：
//255.0.0.7 -> 11111111 00000000 00000000 00000111
//地址 "255.0.0.7/32" 表示与给定地址有相同的 32 位前缀的所有地址，
//在这里只有这一个地址。
//
//地址 "255.0.0.8/29" 表示与给定地址有相同的 29 位前缀的所有地址：
//255.0.0.8 -> 11111111 00000000 00000000 00001000
//有相同的 29 位前缀的地址如下：
//11111111 00000000 00000000 00001000
//11111111 00000000 00000000 00001001
//11111111 00000000 00000000 00001010
//11111111 00000000 00000000 00001011
//11111111 00000000 00000000 00001100
//11111111 00000000 00000000 00001101
//11111111 00000000 00000000 00001110
//11111111 00000000 00000000 00001111
//
//地址 "255.0.0.16/32" 表示与给定地址有相同的 32 位前缀的所有地址，
//这里只有 11111111 00000000 00000000 00010000。
//
//总之，答案指定了从 255.0.0.7 开始的 10 个 IP 的范围。
//
//有一些其他的表示方法，例如：
//["255.0.0.7/32","255.0.0.8/30", "255.0.0.12/30", "255.0.0.16/32"],
//但是我们的答案是最短可能的答案。
//
//另外请注意以 "255.0.0.7/30" 开始的表示不正确，
//因为其包括了 255.0.0.4 = 11111111 00000000 00000000 00000100 这样的地址，
//超出了需要表示的范围。
// 
//
// 
//
// 注： 
//
// 
// ip 是有效的 IPv4 地址。 
// 每一个隐含地址 ip + x (其中 x < n) 都是有效的 IPv4 地址。 
// n 为整数，范围为 [1, 1000]。 
// 
//
// 
// Related Topics 位运算 字符串 
// 👍 19 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class IpToCidr{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 不会
//        明白了上面的规则，我们才能真正开始将一堆连续ip 转化为 CIDR段的贪心寻找：
//
//        拿当前的起点ip做start
//        想要用的段数少，那我们必须用尽量大的mask
//                通过start末尾0的数量来判断可以使用的mask长度上限
//        mask长度上限同时还受剩余ip数 n 的影响，因为我们不能包含多余的ip
//        用它们组成可以组成的最大 CIDR
//        根据组成的CIDR段中的ip数量将n缩小，把start改为CIDR之后的第一个ip
//        如果n还不为0，重复上述过程。


        public List<String> ipToCIDR (String ip, int n){
            int start = toInt(ip); //将ip转化为整数
            List<String> ans = new ArrayList<>();
            while (n > 0) {
                int trailingZeros = Integer.numberOfTrailingZeros(start);
                int mask = 0,bitsInCIDR = 1;
                //计算mask
                while (bitsInCIDR < n && mask < trailingZeros) {
                    bitsInCIDR <<= 1;
                    mask++;
                }
                if (bitsInCIDR > n) {
                    bitsInCIDR >>= 1;
                    mask--;
                }

                ans.add(toString(start, 32 - mask));
                n -= bitsInCIDR;
                start += (bitsInCIDR);
            }
            return ans;
        }

        private String toString(int number, int range) {
            final int WORD_SIZE = 8;
            StringBuilder buffer = new StringBuilder();
            for (int i = 3; i >= 0; --i) {
                buffer.append(((number >> (i * WORD_SIZE)) & 255));
                buffer.append(".");
            }
            buffer.setLength(buffer.length() - 1);
            buffer.append("/").append(range);
            return buffer.toString();
        }

        private int toInt(String ip) {
            String[] strs = ip.split("\\.");
            int sum = 0;
            for (String str : strs) {
                sum *= 256;
                sum += Integer.parseInt(str);
            }
            return sum;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().ipToCIDR("127.0.0.1", 15);
    }
  
}