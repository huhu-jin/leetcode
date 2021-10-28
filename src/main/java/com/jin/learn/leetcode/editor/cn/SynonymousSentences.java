//  [1258]近义词句子

//给你一个近义词表 synonyms 和一个句子 text ， synonyms 表中是一些近义词对 ，你可以将句子 text 中每个单词用它的近义词来替换。
// 
//
// 请你找出所有用近义词替换后的句子，按 字典序排序 后返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：
//synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]],
//text = "I am happy today but was sad yesterday"
//输出：
//["I am cheerful today but was sad yesterday",
//"I am cheerful today but was sorrow yesterday",
//"I am happy today but was sad yesterday",
//"I am happy today but was sorrow yesterday",
//"I am joy today but was sad yesterday",
//"I am joy today but was sorrow yesterday"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= synonyms.length <= 10 
// synonyms[i].length == 2 
// synonyms[0] != synonyms[1] 
// 所有单词仅包含英文字母，且长度最多为 10 。 
// text 最多包含 10 个单词，且单词间用单个空格分隔开。 
// 
// Related Topics 并查集 数组 哈希表 字符串 回溯 
// 👍 22 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.*;


public class SynonymousSentences{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        Map<String, String> parent = new HashMap<>();

        Map<String, HashSet<String>> map = new HashMap<>();

        TreeSet<String> set = new TreeSet<>();

        public List<String> generateSentences(List<List<String>> synonyms, String text) {
            for(List<String> s: synonyms)
                union(s.get(0), s.get(1));

            for(List<String> s: synonyms){
                String p = find(s.get(0));
                map.computeIfAbsent(p, i -> new HashSet<>()).add(s.get(0));
                map.computeIfAbsent(p, i -> new HashSet<>()).add(s.get(1));
            }

            String[] arr = text.split(" ");
            dfs(arr, 0, "");
            return new ArrayList<>(set);
        }

        public void dfs(String[] arr, int index, String s) {
            if(index == arr.length) {
                set.add(s.trim());
                return;
            }
            if(!parent.containsKey(arr[index]))
                dfs(arr, index + 1, s + " " + arr[index]);
            else {
                String p1 = find(arr[index]); // 找 最后一个 就是分组分key
                HashSet<String> temp = map.get(p1);
                for(String t: temp)
                    dfs(arr, index + 1, s + " " + t);
            }
        }



        public void union(String s1, String s2) {
            String s11 = find(s1);
            String s22 = find(s2);
            parent.put(s11, s22);
        }

        // 不相等 一直find
        public String find(String s) {
            if(!parent.containsKey(s))
                parent.put(s, s);
            if(parent.get(s) != s)
                parent.put(s, find(parent.get(s)));
            return parent.get(s);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        new Solution().generateSentences(Arrays.asList(Arrays.asList("happy", "joy"), Arrays.asList("sad", "sorrow"), Arrays.asList("cheerful", "joy"),Arrays.asList("I", "You")),"I am happy today but was sad yesterday");
    }
  
}