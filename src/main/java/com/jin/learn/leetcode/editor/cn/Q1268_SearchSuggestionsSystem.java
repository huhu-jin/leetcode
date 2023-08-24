//  [1268]搜索推荐系统

//给你一个产品数组 products 和一个字符串 searchWord ，products 数组中每个产品都是一个字符串。 
//
// 请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，推荐 products 数组中前缀与 searchWord 相同的最多三个产品
//。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。 
//
// 请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。 
//
// 
//
// 示例 1： 
//
// 输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord 
//= "mouse"
//输出：[
//["mobile","moneypot","monitor"],
//["mobile","moneypot","monitor"],
//["mouse","mousepad"],
//["mouse","mousepad"],
//["mouse","mousepad"]
//]
//解释：按字典序排序后的产品列表是 ["mobile","moneypot","monitor","mouse","mousepad"]
//输入 m 和 mo，由于所有产品的前缀都相同，所以系统返回字典序最小的三个产品 ["mobile","moneypot","monitor"]
//输入 mou， mous 和 mouse 后系统都返回 ["mouse","mousepad"]
// 
//
// 示例 2： 
//
// 输入：products = ["havana"], searchWord = "havana"
//输出：[["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
// 
//
// 示例 3： 
//
// 输入：products = ["bags","baggage","banner","box","cloths"], searchWord = 
//"bags"
//输出：[["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"]
//,["bags"]]
// 
//
// 示例 4： 
//
// 输入：products = ["havana"], searchWord = "tatiana"
//输出：[[],[],[],[],[],[],[]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= products.length <= 1000 
// 1 <= Σ products[i].length <= 2 * 10^4 
// products[i] 中所有的字符都是小写英文字母。 
// 1 <= searchWord.length <= 1000 
// searchWord 中所有字符都是小写英文字母。 
// 
//
// Related Topics 字典树 数组 字符串 二分查找 排序 堆（优先队列） 👍 154 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.util.*;
import java.util.stream.Collectors;


public class Q1268_SearchSuggestionsSystem{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        class TrieNode {
            public static final int num = 26;
            TrieNode[] next;
            boolean isEnd;
            PriorityQueue<String> queue;

            public TrieNode() {
                next = new TrieNode[num];
                queue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
            }
        }

        private static final int size = 3;
        private TrieNode root;

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
                node.queue.offer(word);
            }
            node.isEnd = true;
        }

        public List<List<String>> startWith(String word) {
            TrieNode node = root;
            List<List<String>> ans = new ArrayList<>();
            boolean exist = true;
            for (char c : word.toCharArray()) {
                if (!exist || node.next[c - 'a'] == null) {
                    exist = false;
                    ans.add(new ArrayList<>());
                    continue;
                }
                node = node.next[c - 'a'];
                List<String> tmp = new ArrayList<>();
                while(!node.queue.isEmpty()) {
                    tmp.add(node.queue.poll());
                }
                Collections.reverse(tmp);
                ans.add(tmp.stream().limit(size).collect(Collectors.toList()));
            }
            return ans;
        }
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {

            root = new TrieNode();
            for (String s : products)
                insert(s);
            return startWith(searchWord);
        }


}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        List<List<String>> mo = new Solution().suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mo");

    }
  
}