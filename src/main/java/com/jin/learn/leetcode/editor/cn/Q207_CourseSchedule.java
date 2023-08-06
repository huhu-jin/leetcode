//  [207]课程表

//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 105 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 881 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;


public class Q207_CourseSchedule{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 有向图
    // 入度 指向自己
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        // 构建邻接表
        for (int[] pre : prerequisites) {
            List<Integer> orDefault = adj.getOrDefault(pre[0], new LinkedList<>());
            orDefault.add(pre[1]);
            adj.put(pre[0], orDefault);
        }

        // 没有依赖条件的( 即入度为0) 加入queue
        for (int i = 0; i < numCourses; i++) {
            List<Integer> integers = adj.get(i);
            if (integers == null || integers.isEmpty()) {
                queue.add(i);
            }
        }

        // 迭代
        while (!queue.isEmpty()) {
            Integer i = queue.poll();
            numCourses--;

            adj = adj.entrySet().stream().peek(k -> {
                k.getValue().remove(i);
                if (k.getValue().size() == 0) {
                    queue.add(k.getKey());
                }
            }).filter(k -> !k.getValue().isEmpty()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        }
        return numCourses <= 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase() {

        new Solution().canFinish(2, new int[][]{{1, 0}});

    }
  
}
