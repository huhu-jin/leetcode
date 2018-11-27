package jin.learn;


import java.util.LinkedList;

public class Solution_020 {
    public boolean isValid(String s) {
        if(s ==null) return false;
        if(s.equals("")) return true;
        LinkedList<String> stack = new LinkedList<>();
        for (String i : s.split("")) {
            if (!stack.isEmpty()) {
                String element = stack.getLast();
                if (ispair(element, i)) {
                    stack.removeLast();
                } else {
                    stack.add(i);
                }
            } else {
                stack.add(i);
            }

        }
        return stack.isEmpty() ? true : false;
    }

    private boolean ispair(String element, String i) {
        if (element.equals("(") && i.equals(")")) return true;
        if (element.equals("[") && i.equals("]")) return true;
        if (element.equals("{") && i.equals("}")) return true;
        return false;
    }

    public static void main(String[] args) {
        Solution_020 solution_020 = new Solution_020();
        solution_020.isValid("");
        System.out.println();
    }
}
