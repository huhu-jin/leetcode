package com.jin.learn.lintcode;


import sun.jvm.hotspot.utilities.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给出飞机的起飞和降落时间的列表，用序列 interval 表示. 请计算出天上同时最多有多少架飞机？
 *
 *
 * 输入: [(1, 10), (2, 3), (5, 8), (4, 7)]
 * 输出: 3
 * 解释:
 * 第一架飞机在1时刻起飞, 10时刻降落.
 * 第二架飞机在2时刻起飞, 3时刻降落.
 * 第三架飞机在5时刻起飞, 8时刻降落.
 * 第四架飞机在4时刻起飞, 7时刻降落.
 * 在5时刻到6时刻之间, 天空中有三架飞机.
 *
 *
 * 输入: [(1, 2), (2, 3), (3, 4)]
 * 输出: 1
 * 解释: 降落优先于起飞.
 *
 */
public class CountOfAirplanes {

     class Node {
        public int time;
        public int cost;

        public Node() {
        }
        // 时间，开始时间cost为1，结束时间cost为-1
        public Node(int time, int cost) {
            this.time = time;
            this.cost = cost;
        }
    }
    //先按照时间升序，再按照cost升序排序
     Comparator<Node> cNode = new Comparator<Node>() {
        public int compare(Node o1, Node o2) {
            if(o1.time != o2.time) {
                return o1.time - o2.time;
            }
            return o1.cost - o2.cost; // 先降后升
        }
    };

    public int countOfAirplanes(List<Interval> airplanes) {

        //扫描线数组
        List<Node>room = new ArrayList<>();
        for(int i = 0; i < airplanes.size(); i++) {
            room.add(new Node((int)airplanes.get(i).getLowEndpoint(), 1));
            room.add(new Node((int)airplanes.get(i).getHighEndpoint(), -1));
        }

        //排序
        Collections.sort(room, cNode);
        int ans = 0;
        int tmp = 0;
        for(int i = 0; i < room.size(); i++) {
            tmp += room.get(i).cost;
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}
