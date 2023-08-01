package com.jin.learn.huawei;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 题目描述
 * 某通信网络中有N个网络结点，用1到N进行标识。
 * 网络中的结点互联互通，且结点之间的消息传递有时延，相连结点的时延均为一个时间单位。
 * 现给定网络结点的连接关系link]={u,v},其中u和v表示网络结点。
 * 当指定一个结点向其他结点进行广播，所有被广播结点收到消息后都会在原路径上回复一条响应消息，请计算发送结点至少需要等待几个时间单位才能收到所有被广播结点的响应消息。
 * 注：
 * 1.N的取值范围为[1,100]；
 * 2.连接关系link的长度不超过3000，且1<=uv<=N;
 * 3.网络中任意结点间均是可达的；
 * 输入描述
 * 输入的第一行为两个正整数，分别表示网络结点的个数N,以及时延列表的长度T
 * 接下来的T行输入，表示结点间的连接关系列表；
 * 最后一行的输入为一个正整数，表示指定的广播结点序号；
 * 输出描述
 * 输出一个整数，表示发送结点接收到所有响应消息至少需要等待的时长。
 * 用例
 * 57
 * 14
 * 21
 * 23
 * 24
 * 34
 * 35
 * 45
 * 2
 * 输出
 * 4结点2到5的最小时延为2，到剩余结点的最小时延均为1，所以至说明少要等待2*2=4s
 */
public class Q1_MostResponse {

    public static int[] dijkstra(int[][] graph, int startNode) {
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNode] = 0;

        // 优先队列，按照距离从小到大排序
        PriorityQueue<NodeDistance> priorityQueue = new PriorityQueue<>((i,j)->i.distance-j.distance);

        priorityQueue.add(new NodeDistance(startNode, 0));

        while (!priorityQueue.isEmpty()) {
            NodeDistance current = priorityQueue.poll();
            int currentNode = current.node;
            int currentDistance = current.distance;

            for (int neighbor = 0; neighbor < graph[currentNode].length; neighbor++) {
                int edgeWeight = graph[currentNode][neighbor];
                if (edgeWeight > 0) { // 如果存在边连接当前节点与邻居节点
                    int totalDistance = currentDistance + edgeWeight;
                    if (totalDistance < dist[neighbor]) { // 和原来的比较
                        dist[neighbor] = totalDistance;
                        priorityQueue.add(new NodeDistance(neighbor, totalDistance));
                    }
                }
            }
        }

        return dist;
    }

    static class NodeDistance  {
        int node;
        int distance;

        public NodeDistance(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 7, -1, 3, -1},
                {7, 0, 4, 2, 6},
                {-1, 4, 0, -1, 5},
                {3, 2, -1, 0, -1},
                {-1, 6, 5, -1, 0}
        };
        int startNode = 0;

        int[] shortestDistances = dijkstra(graph, startNode);

        // 输出起始节点到其他节点的最短距离
        System.out.println("起始节点到其他节点的最短距离：");
        for (int i = 0; i < shortestDistances.length; i++) {
            System.out.println("节点 " + i + ": " + shortestDistances[i]);
        }
    }


}
