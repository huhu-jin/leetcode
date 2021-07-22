//  [146]LRU 缓存机制

//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 105 
// 最多调用 2 * 105 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 1504 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.*;


public class LruCache{


    //leetcode submit region begin(Prohibit modification and deletion)
    // 双向链表+ hashMap head tail节点
    // get 很简单 需要 unlink appendTail
    // put 分新旧 ,新的 直接appendTail. 旧的 unlink appendTail
    class LRUCache {

        public class Node{
            public int value;
            public int key;
            public Node pre;
            public Node next;
            public Node(int key, int value) {
                this.value = value;
                this.key = key;
            }
        }

        private Node head;
        private Node tail;
        Map<Integer, Node> map = new HashMap <>();
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) return -1;
            // 刷新
            unLinkNode(node);
            appendTail(node);
            return node.value;
        }

        // put时候,移除最旧的
        public void put(int key, int value) {
            Node node = map.get(key);
            if (node == null) {
                // 新节点
                node = new Node(key, value);
                map.put(key, node);
                if (map.size() > capacity) {
                    map.remove(head.next.key);
                    unLinkNode(head.next);
                }
            }else {
                // 老节点
                node.value = value;
                unLinkNode(node);
            }

            appendTail(node);
        }


        private void unLinkNode(Node node){
            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.next = null;
            node.pre = null;
        }

        private void appendTail(Node node) {
            tail.pre.next = node;
            node.pre = tail.pre;

            node.next = tail;
            tail.pre = node;

        }

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        LRUCache lruCache = new LRUCache(1);
        lruCache.get(1);
        lruCache.put(1,1);
        lruCache.get(2);

        lruCache.put(2,2);
        lruCache.get(2);
        lruCache.get(3);


        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.get(4);
        lruCache.get(3);
        lruCache.get(2);
        lruCache.get(1);
        lruCache.put(5, 5);
        lruCache.get(1);
        lruCache.get(2);
        lruCache.get(3);
        lruCache.get(4);
        lruCache.get(5);


    }
  
}