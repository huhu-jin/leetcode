package com.jin.learn.template;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {


    public int[] solution(int[][] input, int n) {
        // 构建临接矩阵
        int[][] graph = new int[n][n];

        for (int[] line : input) {
            Arrays.fill(line, -1);
        }

        for (int i = 0; i < n; i++) {
            graph[i][i] = 0;
        }

        // 无向图
        for (int[] item : input) {
            graph[item[0]][item[2]] = item[1];
            graph[item[2]][item[0]] = item[1];
        }


        return dijkstra(graph, 0);

    }


    public int[] dijkstra(int [][] graph, int startNode){
        PriorityQueue<Node> queue = new PriorityQueue<>((i, j) -> i.distance - j.distance);
        queue.add(new Node(0, startNode));

        int[] distance = new int[graph[0].length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startNode]=0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int currentNode = node.num;
            int currentDistance = node.distance;
            if (distance[currentNode] < currentDistance) continue;

            for (int neighbor = 0; neighbor < graph[0].length; neighbor++) {
                int edgeWeight = graph[currentNode][neighbor];
                if (edgeWeight > 0) { // 如果存在边连接当前节点与邻居节点
                    int totalDistance = currentDistance + edgeWeight;
                    if (totalDistance < distance[neighbor]) {
                        distance[neighbor] = totalDistance;
                        queue.add(new Node(neighbor, totalDistance));
                    }
                }
            }

        }
        return distance;


    }


    public static class Node {
        int distance;
        int num;

        public Node(int distance, int num) {
            this.distance = distance;
            this.num = num;
        }

    }


}
