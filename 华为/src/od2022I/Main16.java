package od2022I;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main16 {

    /**
     *
     * 字符串分割
     *
     * 将字符串分割成一些字串，使的每个子串的ASCII值的和均为水仙花数
     * （水仙花数，一个三位数，每个数字的立方和等于该数字本身）
     *
     * 若分割不成功，则返回0
     * 若分割成功且分割结果不唯一 ，则返回-1
     * 若分割成功且分割结果唯一，则返回分割后的字串的数目
     *
     * f3@d5a8
     * -1
     *
     * AXdddF
     * 2
     *
     */

    public static void main(String[] args) {

        // 创建扫描器 从标准输入流里面接受数据 (可以从文件、输入流 、字符串中解析出基本类型值和字符串值)
        // 使用时，hasNextXxx 最好与 nexXxx相同
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){

            String str = sc.nextLine();

            if (str.length() > 200){
                System.out.println(0);
                return;
            }

            // 保存每一种结果的子串的数量
            List<Integer> list = new ArrayList<>();

            dfs(str,0,0,list);

            if (list.size() == 0){
                System.out.println(0);
            }else if (list.size() > 1){
                System.out.println(-1);
            }else {
                System.out.println(list.get(0));
            }
        }

    }

    /**
     *
     * 回溯
     *
     * @param s
     * @param start 子串起始下标
     * @param depth 递归深度，当前子串个数
     * @param list
     */
    private static void dfs(String s, int start, int depth, List<Integer> list){
        // 到达字符串末尾是一个有效解
        if (start == s.length()){
            list.add(depth);
            return;
        }
        for (int end = start + 1; end <= s.length(); end++){

            String substring = s.substring(start, end);
            int sum = calculateSum(substring);
            // 当前子串有效，才向下递归
            if (isFlowerNumer(sum)){
                dfs(s,end,depth+1,list);
            }
        }
    }

    private static int calculateSum(String substring) {
        int sum = 0;
        for (char c : substring.toCharArray()){
            sum += c;
        }
        return sum;
    }

    private static boolean isFlowerNumer(int count) {

        int g = count%100%10;
        int s = count%100/10;
        int b = count/100;

        int v = (int)(Math.pow(g, 3) + Math.pow(s, 3) + Math.pow(b, 3));
        if (v == count){
            return true;
        }
        return false;
    }

}
