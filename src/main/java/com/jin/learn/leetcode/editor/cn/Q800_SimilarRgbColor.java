//  [800]相似 RGB 颜色

//RGB 颜色 "#AABBCC" 可以简写成 "#ABC" 。 
//
// 
// 例如，"#15c" 其实是 "#1155cc" 的简写。 
// 
//
// 现在，假如我们分别定义两个颜色 "#ABCDEF" 和 "#UVWXYZ"，则他们的相似度可以通过这个表达式 -(AB - UV)^2 - (CD - W
//X)^2 - (EF - YZ)^2 来计算。 
//
// 那么给你一个按 "#ABCDEF" 形式定义的字符串 color 表示 RGB 颜色，请你以字符串形式，返回一个与它相似度最大且可以简写的颜色。（比如，可
//以表示成类似 "#XYZ" 的形式） 
//
// 任何 具有相同的（最大）相似度的答案都会被视为正确答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：color = "#09f166"
//输出："#11ee66"
//解释： 
//因为相似度计算得出 -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -7
//3
//这已经是所有可以简写的颜色中最相似的了
// 
//
// 示例 2： 
//
// 
//输入：color = "#4e3fe1"
//输出："#5544dd"
// 
//
// 
//
// 提示： 
//
// 
// color.length == 7 
// color[0] == '#' 
// 对于任何 i > 0，color[i] 都是一个在范围 ['0', 'f'] 内的 16 进制数 
// 
// Related Topics 数学 字符串 枚举 
// 👍 12 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;


public class Q800_SimilarRgbColor{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)

    // 我们可以发现，颜色中的每一维都是独立的，因此我们只需要分别计算出 color = #ABCDEF 中与 AB，CD 和 EF 相似度最大的颜色即可。
    // 最终的答案为这三个颜色的结合。
    //
    // 对于 AB，我们要在 00 到 ff 中找到一个相似度最大的。在方法一中我们得知，00 到 ff 均为 17 的倍数，因此我们需要找到一个 17 的倍数，
    // 使得其与 AB 的差的绝对值最小。余数>8 向上取, 余数 <8 像下去
    //
class Solution {
        public String similarRGB(String color) {
            return "#" + f(color.substring(1, 3)) + f(color.substring(3, 5)) + f(color.substring(5));
        }

        public String f(String comp) {
            int q = Integer.parseInt(comp, 16);
            q = q / 17 + (q % 17 > 8 ? 1 : 0);
            return String.format("%02x", 17 * q);
        }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}
