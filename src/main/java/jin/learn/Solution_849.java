package jin.learn;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

// 没通过
public class Solution_849 {
   public int maxDistToClosest(int[] seats) {
       int index = 0;
       int lengh =-1;
       for (int i = 0; i < seats.length; i++) {
           if (seats[i] == 0) {
               int leftDistance = findLeftDistance(i,seats);
               int rightDistance = findRightDistance(i,seats);
               int min = Math.min(leftDistance, rightDistance);
               if (min > lengh) {
                   index = i;
                   lengh = min;
               }
           }
       }
       return index;
    }

    private int findRightDistance(int index, int[] seats) {
       int i;
        for ( i = index; i < seats.length; i++) {
            if (seats[i] != 0) {
                break;
            }
        }
        if(i==seats.length&&seats[i-1]==0) return Integer.MAX_VALUE;
        return i-index;
    }

    private int findLeftDistance(int index, int[] seats) {
       int i;
        for (i = index; i >= 0; i--) {
            if (seats[i] != 0) {
                break;
            }
        }
        if(i==-1&&seats[0]==0) return Integer.MAX_VALUE;
        return index - i;
    }

    public static void main(String[] args) {

        int i = new Solution_849().maxDistToClosest(new int[]{1, 0, 0, 1, 0, 0, 0, 0, 0, 0,0});
        System.out.println(i);


    }

}