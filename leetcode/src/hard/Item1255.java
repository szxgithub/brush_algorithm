package hard;

import com.sun.org.apache.bcel.internal.generic.I2F;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Item1255 {

    /*

    得分最高的单词集合

     */

    private String[] words;
    private int[] score, left = new int[26];
    private int ans;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.words = words;
        this.score = score;
        for (char c : letters) ++left[c - 'a'];
        dfs(words.length - 1, 0);
        return ans;
    }

    /**
     * 从前i个单词中继续选择， 当前得分为total
     * @param i
     * @param total
     */
    private void dfs(int i, int total) {
        if (i < 0) { // base case
            ans = Math.max(ans, total);
            return;
        }

        // 不选 words[i]
        dfs(i - 1, total);

        // 选 words[i]
        char[] s = words[i].toCharArray();
        boolean ok = true;
        for (char c : s) {
            if (left[c - 'a']-- == 0)
                ok = false; // 剩余字母不足
            total += score[c - 'a']; // 累加得分
        }

        if (ok)
            dfs(i - 1, total);

        // 恢复现场
        for (char c : s)
            ++left[c - 'a'];
    }

    public static void main(String[] args) {

        Item1255 item1255 = new Item1255();
        String[] words = {"dog","cat","dad","good"};
        char[] letters = {'a','a','c','d','d','d','g','o','o'};
        int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        int i = item1255.maxScoreWords(words, letters, score);
        System.out.println(i);

    }

}
