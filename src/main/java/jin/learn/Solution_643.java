package jin.learn;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_643 {
    public double findMaxAverage(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        Integer max = 0;
        Integer temp = 0;

        for (int i : nums) {
            if (deque.size() < k) {
                deque.add(i);
                temp += i;
                max = temp;
            }else{
                Integer first = deque.pollFirst();
                deque.add(i);
                temp = temp - first + i;
                max = Math.max(temp, max);
            }

        }
        return (double)max/(double)k;
    }

    public static void main(String[] args) {
        double maxAverage = new Solution_643().findMaxAverage(new int[]{1}, 1);
        System.out.println(maxAverage);

    }
}
