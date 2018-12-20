package jin.learn;


// 没通过
public class Solution_191 {

     public int hammingWeight(int n) {
         String s = Integer.toBinaryString(n);
         return (int) s.chars().filter(i -> i==49).count();
     }

    public static void main(String[] args) {
        int i = new Solution_191().hammingWeight(3);
        System.out.println(i);
    }

}