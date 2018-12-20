package jin.learn;

import java.util.LinkedList;
import java.util.List;

public class Solution_119 {

    private List<Integer> init = new LinkedList<>();

    {
        init.add(1);
    }

    public List<Integer> getRow(int rowIndex) {
        while (rowIndex > 1) {
            LinkedList<Integer> nextRow = new LinkedList<>();
            nextRow.add(1);
            for (int i = 0; i < init.size(); i++) {
                if (i == init.size() - 1) {
                    nextRow.add(1);
                }else {
                    nextRow.add(init.get(i) + init.get(i + 1));
                }
            }
            rowIndex--;
            init = nextRow;
        }
        return init;
    }

    public static void main(String[] args) {
        Solution_119 solution_119 = new Solution_119();

        System.out.println(solution_119.getRow(5));

    }

}
