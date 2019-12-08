package jin.learn;

import com.sun.media.sound.SoftTuning;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

// 回溯算法(backTrack)
public class LetterCombinationsOfAPhoneNumber {

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList<String>();
        combination("", digits, 0, ret);
        return ret;
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }


    @Test
    public void testOne() {

        List<String> list = new LetterCombinationsOfAPhoneNumber().letterCombinations("2333333333333333333333333");
        System.out.println(list);


    }
}
