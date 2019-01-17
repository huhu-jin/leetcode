package jin.learn;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;


// 看不懂题目
public class Solution_501 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] findMode(TreeNode root) {
        if (root == null) return null;
        LinkedList<TreeNode> contain = new LinkedList<>();
        contain.add(root);
        HashMap<Integer, Integer> ret = new HashMap<>();
        while (!contain.isEmpty()) {
            TreeNode temp = contain.pollFirst();
            ret.put(temp.val, ret.getOrDefault(temp.val, 0) + 1);
            if (temp.left != null) contain.add(temp.left);
            if (temp.right != null) contain.add(temp.right);
        }
        int abc = Collections.max(ret.entrySet(), Map.Entry.comparingByValue()).getKey();
        return new int[]{abc};
    }

    static class KeyHolder {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("I am over from key");
            super.finalize();
        }
    }

    static class ValueHolder {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("I am over from value");
            super.finalize();
        }
    }


    public static void main(String[] args) {
        KeyHolder key1 = new KeyHolder();
        ValueHolder value1 = new ValueHolder();
        KeyHolder key2 = new KeyHolder();
        ValueHolder value2 = new ValueHolder();
        WeakHashMap<KeyHolder, ValueHolder> map = new WeakHashMap<>();
        map.put(key1, value1);
        map.put(key2, value2);
        key1 = null;
        value1 = null;
        System.gc();
        System.out.println("ssss");
    }

}