package jin.learn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution_703 {

    // 超时了
    public static class KthLargest1 {

        private List<Integer> content;
        private int rank;

        public KthLargest1(int k, int[] nums) {
            this.content = Arrays.stream(nums).boxed().sorted((i, j) -> j - i).collect(Collectors.toCollection(LinkedList::new));
            this.rank = k;
        }

        public int add(int val) {
            insert(val);
            return this.content.get(content.size() < rank ? content.size() - 1 : this.rank - 1);
        }

        private void insert(int val) {
            if (content.size() == 0 || content.get(content.size() - 1) > val) {
                content.add(val);
                return;
            } else if (val > content.get(0)) {
                content.add(0, val);
                return;
            }

            // 改成二分查找
            int start = 0;
            int end = content.size() - 1;
            //差一位退出
            while (start + 1 < end) {
                int mid = (start + end) >>> 1;
                if (content.get(mid) <= val) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            content.add(end, val);
        }
    }


    // java 优先队列的实现
    // 固定长度
    // 最小的排在前面
    public static class KthLargest2 {
        final PriorityQueue<Integer> q;
        final int k;

        public KthLargest2(int k, int[] a) {
            this.k = k;
            q = new PriorityQueue<>(k);
            for (int n : a)
                add(n);
        }

        public int add(int n) {
            if (q.size() < k)
                q.offer(n);
            else if (q.peek() < n) {
                q.poll();
                q.offer(n);
            }
            return q.peek();
        }
    }






    public static void main(String[] args) {
//        KthLargest kthLargest = new KthLargest(3, new int[]{1, 2, 5, 9, 6, 7});
//        System.out.println(kthLargest.add(11));
//        System.out.println(kthLargest.add(10));
//        System.out.println(kthLargest.add(10));
//        System.out.println(kthLargest.add(-2));
//        System.out.println(kthLargest.add(4));
//        System.out.println(kthLargest.add(4));
//        System.out.println(kthLargest.add(9));
//        System.out.println("11111111111111111");

    }
}
