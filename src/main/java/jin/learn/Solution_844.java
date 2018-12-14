package jin.learn;

public class Solution_844 {
     public boolean backspaceCompare(String S, String T) {
         int s = S.length() - S.replace("#", "").length();
         int t = T.length() - T.replace("#", "").length();
         return s == t;

    }

    public static void main(String[] args) {
        new Solution_844().backspaceCompare("xywrrmp","xywrrmu#p");
    }
}
