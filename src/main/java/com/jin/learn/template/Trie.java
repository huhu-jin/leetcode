package com.jin.learn.template;

class Trie {
    // 这个定义比较关键
    public  class TrieNode {
        public boolean isEnd;
        public TrieNode[] next = new TrieNode[26];// 用位置来表示值


    }

    private final TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            TrieNode node = temp.next[c - 'a'] ;
            if (node == null) {
                temp.next[c - 'a'] = new TrieNode();
            }
            temp = temp.next[c - 'a'];
        }
        temp.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            temp =temp.next[c - 'a'];
            if (temp == null) {
                return false;
            }
        }
        return temp.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
      TrieNode temp = root;
        for (char c : prefix.toCharArray()) {
            temp =temp.next[c - 'a'];
            if (temp == null) {
                return false;
            }
        }
        return true;
    }
}
