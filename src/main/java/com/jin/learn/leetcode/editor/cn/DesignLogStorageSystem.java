//  [635]设计日志存储系统

//你将获得多条日志，每条日志都有唯一的 id 和 timestamp ，timestamp 是形如 Year:Month:Day:Hour:Minute:Se
//cond 的字符串，2017:01:01:23:59:59 ，所有值域都是零填充的十进制数。 
//
// 实现 LogSystem 类： 
//
// 
// LogSystem() 初始化 LogSystem 对象 
// void put(int id, string timestamp) 给定日志的 id 和 timestamp ，将这个日志存入你的存储系统中。 
// int[] retrieve(string start, string end, string granularity) 返回在给定时间区间 [start
//, end] （包含两端）内的所有日志的 id 。start 、end 和 timestamp 的格式相同，granularity 表示考虑的时间粒度（例如，精
//确到 Day、Minute 等）。例如 start = "2017:01:01:23:59:59"、end = "2017:01:02:23:59:59" 且 
//granularity = "Day" 意味着需要查找从 Jan. 1st 2017 到 Jan. 2nd 2017 范围内的日志，可以忽略日志的 Hour、M
//inute 和 Second 。 
// 
// 
//
// 示例： 
//
// 
//输入：
//["LogSystem", "put", "put", "put", "retrieve", "retrieve"]
//[[], [1, "2017:01:01:23:59:59"], [2, "2017:01:01:22:59:59"], [3, "2016:01:01:0
//0:00:00"], ["2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year"], ["2016:01:01:
//01:01:01", "2017:01:01:23:00:00", "Hour"]]
//输出：
//[null, null, null, null, [3, 2, 1], [2, 1]]
//
//解释：
//LogSystem logSystem = new LogSystem();
//logSystem.put(1, "2017:01:01:23:59:59");
//logSystem.put(2, "2017:01:01:22:59:59");
//logSystem.put(3, "2016:01:01:00:00:00");
//
//// 返回 [3,2,1]，返回从 2016 年到 2017 年所有的日志。
//logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year");
//
//// 返回 [2,1]，返回从 Jan. 1, 2016 01:XX:XX 到 Jan. 1, 2017 23:XX:XX 之间的所有日志
//// 不返回日志 3 因为记录时间 Jan. 1, 2016 00:00:00 超过范围的起始时间
//logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour");
// 
//
// 
//
// 提示： 
//
// 
// 1 <= id <= 500 
// 2000 <= Year <= 2017 
// 1 <= Month <= 12 
// 1 <= Day <= 31 
// 0 <= Hour <= 23 
// 0 <= Minute, Second <= 59 
// granularity 是这些值 ["Year", "Month", "Day", "Hour", "Minute", "Second"] 之一 
// 最多调用 500 次 put 和 retrieve 
// 
// Related Topics 设计 哈希表 字符串 有序集合 
// 👍 42 👎 0


package com.jin.learn.leetcode.editor.cn;

import org.testng.annotations.Test;

import java.util.*;


public class DesignLogStorageSystem{
  
  
    //leetcode submit region begin(Prohibit modification and deletion)

    // 基本思想是把 时间戳转化为int 存入 treemap中
    // 利用treemap的有序性
    public class LogSystem {
        TreeMap< Long, Integer > map;
        public LogSystem() {
            map = new TreeMap <> ();
        }

        public void put(int id, String timestamp) {
            int[] st = Arrays.stream(timestamp.split(":")).mapToInt(Integer::parseInt).toArray();
            map.put(convert(st), id);
        }

        public long convert(int[] st) {
            st[1] = st[1] - (st[1] == 0 ? 0 : 1);
            st[2] = st[2] - (st[2] == 0 ? 0 : 1);
            return (st[0] - 1999L) * (31 * 12) * 24 * 60 * 60 + st[1] * 31 * 24 * 60 * 60 + st[2] * 24 * 60 * 60 + st[3] * 60 * 60 + st[4] * 60 + st[5];
        }

        public List < Integer > retrieve(String s, String e, String gra) {
            ArrayList< Integer > res = new ArrayList();
            long start = granularity(s, gra, false);
            long end = granularity(e, gra, true);
            for (long key: map.tailMap(start).keySet()) {
                if (key >= start && key < end)
                    res.add(map.get(key));
            }
            return res;
        }

        HashMap< String, Integer > h = new HashMap();
        {
            h.put("Year", 0);
            h.put("Month", 1);
            h.put("Day", 2);
            h.put("Hour", 3);
            h.put("Minute", 4);
            h.put("Second", 5);
        }


        public long granularity(String s, String gra, boolean end) {
            String[] res = new String[] {"1999", "00", "00", "00", "00", "00"};

            String[] st = s.split(":");
            for (int i = 0; i <= h.get(gra); i++) {
                res[i] = st[i];
            }
            int[] t = Arrays.stream(res).mapToInt(Integer::parseInt).toArray();
            if (end)
                t[h.get(gra)]++;
            return convert(t);
        }
    }



/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */
//leetcode submit region end(Prohibit modification and deletion)

    
    @Test
    public void testCase(){
        LogSystem logSystem = new LogSystem();
        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:02:23:59:59");
        logSystem.put(3, "2017:01:03:23:59:59");
        logSystem.put(4, "2017:01:04:23:59:59");
        logSystem.put(5, "2017:01:05:23:59:59");
        logSystem.retrieve("2017:01:01:23:59:59", "2017:02:01:23:59:59", "Day");
    }
  
}