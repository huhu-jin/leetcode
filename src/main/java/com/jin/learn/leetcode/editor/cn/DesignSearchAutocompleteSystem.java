//  [642]设计搜索自动补全系统

//为搜索引擎设计一个搜索自动补全系统。用户会输入一条语句（最少包含一个字母，以特殊字符 '#' 结尾）。除 '#' 以外用户输入的每个字符，返回历史中热度前三
//并以当前输入部分为前缀的句子。下面是详细规则： 
//
// 
// 一条句子的热度定义为历史上用户输入这个句子的总次数。 
// 返回前三的句子需要按照热度从高到低排序（第一个是最热门的）。如果有多条热度相同的句子，请按照 ASCII 码的顺序输出（ASCII 码越小排名越前）。 
// 如果满足条件的句子个数少于 3，将它们全部输出。 
// 如果输入了特殊字符，意味着句子结束了，请返回一个空集合。 
// 
//
// 你的工作是实现以下功能： 
//
// 构造函数： 
//
// AutocompleteSystem(String[] sentences, int[] times): 这是构造函数，输入的是历史数据。 Sentenc
//es 是之前输入过的所有句子，Times 是每条句子输入的次数，你的系统需要记录这些历史信息。 
//
// 现在，用户输入一条新的句子，下面的函数会提供用户输入的下一个字符： 
//
// List<String> input(char c): 其中 c 是用户输入的下一个字符。字符只会是小写英文字母（'a' 到 'z' ），空格（' '）和
//特殊字符（'#'）。输出历史热度前三的具有相同前缀的句子。 
//
// 
//
// 样例 ： 
//操作 ： AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"],
// [5,3,2,2]) 
//系统记录下所有的句子和出现的次数： 
//"i love you" : 5 次 
//"island" : 3 次 
//"ironman" : 2 次 
//"i love leetcode" : 2 次 
//现在，用户开始新的键入： 
//
// 
//输入 ： input('i') 
//输出 ： ["i love you", "island","i love leetcode"] 
//解释 ： 
//有四个句子含有前缀 "i"。其中 "ironman" 和 "i love leetcode" 有相同的热度，由于 ' ' 的 ASCII 码是 32 而 '
//r' 的 ASCII 码是 114，所以 "i love leetcode" 在 "ironman" 前面。同时我们只输出前三的句子，所以 "ironman" 
//被舍弃。 
// 
//输入 ： input(' ') 
//输出 ： ["i love you","i love leetcode"] 
//解释: 
//只有两个句子含有前缀 "i "。 
// 
//输入 ： input('a') 
//输出 ： [] 
//解释 ： 
//没有句子有前缀 "i a"。 
// 
//输入 ： input('#') 
//输出 ： [] 
//解释 ： 
//
// 用户输入结束，"i a" 被存到系统中，后面的输入被认为是下一次搜索。 
//
// 
//
// 注释 ： 
//
// 
// 输入的句子以字母开头，以 '#' 结尾，两个字母之间最多只会出现一个空格。 
// 即将搜索的句子总数不会超过 100。每条句子的长度（包括已经搜索的和即将搜索的）也不会超过 100。 
// 即使只有一个字母，输出的时候请使用双引号而不是单引号。 
// 请记住清零 AutocompleteSystem 类中的变量，因为静态变量、类变量会在多组测试数据中保存之前结果。详情请看这里。 
// 
//
// 
// Related Topics 设计 字典树 字符串 数据流 
// 👍 98 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DesignSearchAutocompleteSystem{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
    public class AutocompleteSystem {
        class Node {
            Node(String st, int t) {
                sentence = st;
                times = t;
            }
            String sentence;
            int times;
        }
        class Trie {
            int times;
            Trie[] branches = new Trie[27];
        }
        public int int_(char c) {
            return c == ' ' ? 26 : c - 'a';
        }
        public void insert(Trie t, String s, int times) {
            for (int i = 0; i < s.length(); i++) {
                if (t.branches[int_(s.charAt(i))] == null)
                    t.branches[int_(s.charAt(i))] = new Trie();
                t = t.branches[int_(s.charAt(i))];
            }
            t.times += times;
        }
        public List < Node > lookup(Trie t, String s) {
            List< Node > list = new ArrayList < > ();
            for (int i = 0; i < s.length(); i++) {
                if (t.branches[int_(s.charAt(i))] == null)
                    return new ArrayList< Node >();
                t = t.branches[int_(s.charAt(i))];
            }
            traverse(s, t, list);
            return list;
        }
        public void traverse(String s, Trie t, List < Node > list) {
            if (t.times > 0)
                list.add(new Node(s, t.times));
            for (char i = 'a'; i <= 'z'; i++) {
                if (t.branches[i - 'a'] != null)
                    traverse(s + i, t.branches[i - 'a'], list);
            }
            if (t.branches[26] != null)
                traverse(s + ' ', t.branches[26], list);
        }
        Trie root;
        public AutocompleteSystem(String[] sentences, int[] times) {
            root = new Trie();
            for (int i = 0; i < sentences.length; i++) {
                insert(root, sentences[i], times[i]);
            }
        }
        String cur_sent = "";
        public List < String > input(char c) {
            List < String > res = new ArrayList < > ();
            if (c == '#') {
                insert(root, cur_sent, 1);
                cur_sent = "";
            } else {
                cur_sent += c;
                List < Node > list = lookup(root, cur_sent);
                Collections.sort(list, (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
                for (int i = 0; i < Math.min(3, list.size()); i++)
                    res.add(list.get(i).sentence);
            }
            return res;
        }
    }


/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        
    }
  
}