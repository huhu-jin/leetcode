//  [271]字符串的编码与解码

//请你设计一个算法，可以将一个 字符串列表 编码成为一个 字符串。这个编码后的字符串是可以通过网络进行高效传送的，并且可以在接收端被解码回原来的字符串列表。 
//
//
// 1 号机（发送方）有如下函数： 
//
// string encode(vector<string> strs) {
//  // ... your code
//  return encoded_string;
//} 
//
// 2 号机（接收方）有如下函数： 
//
// vector<string> decode(string s) {
//  //... your code
//  return strs;
//}
// 
//
// 1 号机（发送方）执行： 
//
// string encoded_string = encode(strs);
// 
//
// 2 号机（接收方）执行： 
//
// vector<string> strs2 = decode(encoded_string);
// 
//
// 此时，2 号机（接收方）的 strs2 需要和 1 号机（发送方）的 strs 相同。 
//
// 请你来实现这个 encode 和 decode 方法。 
//
// 注意： 
//
// 
// 因为字符串可能会包含 256 个合法 ascii 字符中的任何字符，所以您的算法必须要能够处理任何可能会出现的字符。 
// 请勿使用 “类成员”、“全局变量” 或 “静态变量” 来存储这些状态，您的编码和解码算法应该是非状态依赖的。 
// 请不要依赖任何方法库，例如 eval 又或者是 serialize 之类的方法。本题的宗旨是需要您自己实现 “编码” 和 “解码” 算法。 
// 
// Related Topics 设计 数组 字符串 
// 👍 53 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Q271_EncodeAndDecodeStrings{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
//     前面 4 个字节表示了编码字符串的长度
// 后面跟这字符串本身
public class Codec {
        // int 转成char 数组存起来
        public String intToString(String s) {
            int x = s.length(); // int 32 位
            char[] chars = new char[4]; // 64位
            for(int i = 3; i >= 0; i--) {
                chars[3 - i] = (char) (x >> (i * 8)); // 8
            }
            return new String(chars);
        }

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for(String s: strs) {
                sb.append(intToString(s));
                sb.append(s);
            }
            return sb.toString();
        }

        // Decodes bytes string to integer
        public int stringToInt(String bytesStr) {
            int result = 0;
            for(char b : bytesStr.toCharArray())
                result = (result << 8) + (int)b;
            return result;
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            int i = 0, n = s.length();
            List<String> output = new ArrayList();
            while (i < n) {
                int length = stringToInt(s.substring(i, i + 4));
                i += 4;
                output.add(s.substring(i, i + length));
                i += length;
            }
            return output;
        }
    }


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        Codec codec = new Codec();
        codec.encode(Arrays.asList("ddddd", "d", "ef"));
    }
  
}
