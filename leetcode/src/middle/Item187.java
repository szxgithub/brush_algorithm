package middle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Item187 {

    /*
    重复的DNA序列

    给定一个表示DNA序列的字符串s，返回所有在DNA分子中出现不止一次的长度为10的序列，你可以按任意顺序返回答案

     */


    /*
    暴力解法，通过率100%
     */
    public List<String> findRepeatedDnaSequences(String s){

        HashSet<String> set = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i< s.length(); i++){
            if (i + 10 <= s.length()){
                String substring = s.substring(i, i + 10);
                if (!set.contains(substring)){
                    set.add(substring);
                }else {
                    res.add(substring);
                }
            }
        }

        List<String> collect = res.stream().collect(Collectors.toList());
        return collect;
    }

    /*
    滑动窗口解法

    滑动窗口的时间复杂度为O(N)，添加子串substring()方法需要O(L)的复杂度，但一般情况下 substring 方法不会调用很多次
    可以说这个算法一般情况下的平均时间复杂度是 O(N)，极端情况下的时间复杂度会退化成 O(NL)s's

     */
    public List<String> findRepeatedDnaSequences2(String s) {

        // 将字符串转化为四进制的数字数组
        int[] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++){
            switch (s.charAt(i)){
                case 'A':
                    nums[i] = 0;
                    break;
                case 'G':
                    nums[i] = 1;
                    break;
                case 'C':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;
            }
        }

        // 记录重复出现的哈希值
        HashSet<Integer> seen = new HashSet<>();
        // 记录重复出现的字符串结果
        HashSet<String> res = new HashSet<>();

        int L = 10;

        int R = 4;

        int RL = (int)Math.pow(R,L-1);

        // 维护滑动窗口内字符串的hash值
        int windowHash = 0;

        int left = 0, right = 0;
        while (right < s.length()){

            // 扩大窗口，移入字符，并维护窗口内的哈希值
            windowHash = R*windowHash + nums[right];
            right++;

            if (right - left == L){
                if (seen.contains(windowHash )){
                    // 找到一个重复字符串
                    res.add(s.substring(left,right));
                }else {
                    seen.add(windowHash);
                }

                // 缩小窗口，移出字符，并维护窗口的哈希值
                windowHash =  windowHash - nums[left]*RL;
                left++;
            }
        }

        return new LinkedList<>(res);

    }

    public static void main(String[] args) {

        Item187 item187 = new Item187();
        // String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        String s = "AAAAAAAAAAAAA";
        List<String> repeatedDnaSequences = item187.findRepeatedDnaSequences(s);
        System.out.println(repeatedDnaSequences);

    }

}
