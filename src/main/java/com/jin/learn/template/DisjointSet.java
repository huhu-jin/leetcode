package com.jin.learn.template;


import java.util.Arrays;

// 并查集
public class DisjointSet {

    int[] parent;
    int [] rank; // 层数
    public DisjointSet(int n) {
        parent = new int[n];
        Arrays.fill(parent, -1);
        rank = new int[n];

    }

    //换祖宗  index2的祖宗 = index1的祖宗
    public boolean union(int x, int y) {

       int x_root = find_root(x);
       int y_root = find_root(y);

       if (x_root == y_root) return false; // 说明 already connected

        // 合并 会变成链 引入rank
        if (rank[y_root] > rank[x_root]) {
            parent[x_root] = y_root;  // rank小的 当页节点
        }else if(rank[y_root] < rank[x_root]){
            parent[y_root] = x_root ;
        }else {
            parent[x_root] = y_root;
            rank[y_root]++;
        }
       return true;
    }


    // 找祖宗
    public int find_root(int index) {
        if (parent[index] != -1) {
            parent[index] = find_root(parent[index]);
        }
        return index;
    }
}
