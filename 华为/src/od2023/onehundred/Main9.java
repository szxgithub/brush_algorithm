package od2023.onehundred;

import java.util.Scanner;

public class Main9 {

    /*

    字母组合(过滤组合字符串)

    数字0、1、2、3、4、5、6、7、8、9分别关联a~z 26个英文字母

    0 关联 a、b、c
    1 关联 d、e、f
    ...


    输入：
    78
    ux
    输出：
    uw,vw,vx,

     */

    public static StringBuffer res = new StringBuffer();
    public static char[][] digits = {
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r'},
            {'s','t'},
            {'u','v'},
            {'w','x'},
            {'y','z'},
    };
    public static String noContain ="";
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 一串数字字符串  数字不存在重复
        String numStr = sc.nextLine();
        // 屏蔽字符  屏蔽字符不能同时出现
        noContain = sc.nextLine();

        // 按照数字的顺序组合字母字符串
        handle(numStr,0,"");
        System.out.println(res);

    }

    /**
     * 深度优先搜索  这里没有回溯
     *
     * @param numStr  输入的数字字符串
     * @param index   数字字符索引
     * @param temp    字母组合
     */
    private static void handle(String numStr, int index, String temp){
        if (temp.length() == numStr.length()){
            if (isTrue(temp)){
                res.append(temp + ",");
            }
        }else {
            int digitsIndex = numStr.charAt(index) - '0';
            char[] chars = digits[digitsIndex];
            for (int i = 0; i < chars.length; i++){
                handle(numStr,index+1,temp + chars[i]);
            }
        }
    }

    /**
     * 屏蔽字符中的所有字母是否同时出现
     * @param str
     * @return
     */
    public static boolean isTrue(String str){
        for (int i =0; i < noContain.length(); i++){
            String s = String.valueOf(noContain.charAt(i));
            if (!str.contains(s)){
                return true;
            }
        }
        return false;
    }

}
