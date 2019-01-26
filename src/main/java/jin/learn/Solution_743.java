package jin.learn;




import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


// DijKstra
// http://wiki.jikexueyuan.com/project/easy-learn-algorithm/dijkstra.html

public class Solution_743 {
    public int networkDelayTime(int[][] times, int N, int K) {

        Set<Integer> nodeSet = new HashSet<>();

        // 准备阶段
        for (int i = 0; i < times.length; i++) {
            nodeSet.add(times[i][0]);

        }
        nodeSet.remove(N);

        Map<Integer, Integer> nodeDis = getMinDistance(times, N);
        Integer minDistanceKey = getMinvalue(nodeDis);
        nodeSet.remove(minDistanceKey);

        while (!nodeSet.isEmpty()) {
            Map<Integer, Integer> tempDis = getMinDistance(times, minDistanceKey);

            for (Map.Entry<Integer,Integer> entry : tempDis.entrySet()) {
                if (nodeSet.contains(entry.getKey()) && (entry.getValue() + nodeDis.get(entry.getKey())) < nodeDis.getOrDefault(entry.getKey(),Integer.MAX_VALUE)) {
                    nodeDis.put(entry.getKey(), entry.getValue() + nodeDis.get(entry.getKey()));
                }
            }
            nodeDis.remove(minDistanceKey);
            minDistanceKey = minColletcionValue(nodeDis, nodeSet);
        }

        return nodeDis.get(K);

    }

    private Integer minColletcionValue(Map<Integer, Integer> nodeDis, Set<Integer> nodeSet) {
        Integer key = nodeSet.iterator().next();
        Integer value = Integer.MAX_VALUE;

        Iterator<Integer> iterator = nodeSet.iterator();

        while (iterator.hasNext()) {

            Integer next = iterator.next();
            if (nodeDis.get(next) < value) {

                value = nodeDis.get(next);
                key = next;
            }
        }
        return key;
    }

    // 获得N点 到 各个点之间的距离
    private Map<Integer, Integer> getMinDistance(int[][] times, int N) {
        HashMap<Integer, Integer> ret = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            if (N == times[i][0]) {
                ret.put(times[i][1], times[i][2]);
            } else if (N == times[i][1]) {
                ret.put(times[i][0], times[i][2]);
            }
        }

        return ret;
    }

    // 获得最短路径
    private Integer getMinvalue(Map<Integer, Integer> map) {
        return Collections.min(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }


    public static void main(String[] args) {

    }
}
