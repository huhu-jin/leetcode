package jin.learn;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Solution_819 {
    public String mostCommonWord(String paragraph, String[] banned) {

//        String[] s = paragraph.replaceAll(",|\\.","").split(" ");
//        Set<String> set = new HashSet<>(Arrays.asList(banned));
//        Map<String, Integer> ret = new HashMap<>();
//        for (String word : s) {
//            if (!set.contains(word.toLowerCase())) {
//            ret.put(word.toLowerCase(), Optional.ofNullable(ret.get(word.toLowerCase())).orElse(0) + 1);
//            }
//        }
//        int max = 0;
//        String w = "";
//
//        for (Map.Entry<String, Integer> entry : ret.entrySet()) {
//            if (entry.getValue() > max) {
//                max = entry.getValue();
//                w = entry.getKey();
//            }
//        }
//
//        return w;

        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = paragraph.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
        for (String w : words) if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();

    }



    public static void main(String[] args) {
        String s = new Solution_819().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
        System.out.println(s);
    }


}
