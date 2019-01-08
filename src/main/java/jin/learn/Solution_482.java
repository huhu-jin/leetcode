package jin.learn;

import java.util.List;
import java.util.stream.Collectors;

public class Solution_482 {

    public String licenseKeyFormatting(String S, int K) {
        List<Character> l = S.chars().filter(i->i!='-').mapToObj(i ->{
            if(i>=97) return (char)(i-32);
            return (char) i;
                }
        ).collect(Collectors.toList());
        int first = l.size() % K;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < l.size(); i++) {
            if (first != 0 && first == i) {
                sb.append("-");
            }else {
                if ((i - first) % K == 0 && i!=0) {
                    sb.append("-");
                }
            }
            sb.append(l.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_482().licenseKeyFormatting("5F3Z-2e-9-w",3));
    }

}
