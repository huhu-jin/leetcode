package com.jin.learn.huawei;

import org.testng.annotations.Test;
import org.testng.util.Strings;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 有一个考古学家发现一个石碑，但是很可惜，发现时其已经断成多段，原地发现n个断口整齐的石碑碎片。为了破解石碑内容希望有程序能帮忙计算复原后的石碑文字组合数，你能帮忙吗？
 * 输入描述
 * 第一行输入n,n表示石碑碎片的个数。
 * 第二行依次输入石碑碎片上的文字内容s,共有n组。
 * 输出描述
 * 输出石碑文字的组合（按照升序排列），行末无多余空格
 * 用例
 * 输入 3 abc
 * abc acb bac bca cab cha
 *
 * 输入3 aba
 * aab aba baa
 * 题目解析
 * 本题其实就是
 * 上面这篇博客提供了一种去重计数后求全排列的方案。
 * 这里我介绍另一种方案，即树层去重。
 * 如果我们将输入的数组进行排序，比如[aba]升序后为[a,a,b]
 * 那么此时求全排列，必然会有如下过程：
 */
public class Q2_Archaeologist {


    public List<String> solution(int n, List<Character> items) {
        LinkedList<String> ans = new LinkedList<>();
        if (n == 0) return ans;

        items.sort(Character::compareTo);


        boolean[] used = new boolean[items.size()];

        dfs(items, 0, n, used, new LinkedList<>(), ans);
        return  ans;

    }

    private void dfs(List<Character> items, int depth, int targetSize, boolean[] used, LinkedList<Character> paths, LinkedList<String> ans) {
        if (depth == targetSize) {
            ans.add(paths.toString());
        }


        for (int i = 0; i < items.size(); i++) {
            if (!used[i]) {

                if (i > 0 && items.get(i) == items.get(i-1) && used[i - 1] == false) {
                    continue;
                }

                used[i] = true;

                paths.add(items.get(i));

                dfs(items, depth + 1, targetSize, used, paths, ans);

                used[i] = false;
                paths.removeLast();


            }



        }



    }


    @Test
    public void testCase(){
        Q2_Archaeologist instance = new Q2_Archaeologist();





    }
}
