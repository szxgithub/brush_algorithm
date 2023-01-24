package com.nowcoder;

public class KMPTest {

    /**
     * 暴力匹配 字符串s1 字符串s2 查找s2在s1中的位置
     *
     * @param s1
     * @param s2
     * @return
     */
    public int violentMatch(String s1, String s2) {

        int s1Len = s1.length();
        int s2Len = s2.length();

        int i = 0;
        int j = 0;
        while (i < s1Len && j < s2Len){

            if (s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else{
                i = i - j + 1;
                j = 0;
            }

        }

        if (j == s2Len){
            return (i-j);
        }else {
            return (-1);
        }

    }

}
