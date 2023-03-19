package od2023.onehundred;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main30 {

    /*
    寻找关键钥匙(密室逃生游戏)

    要求找到符合给定密码K（升序的不重复小写字母组成）的箱子，并给出箱子编号，箱子编号为1-N
    每个箱子都有一个字符串s,字符串由大小写字母，数字，空格组成，需要在这些字符串中找到所有字母，忽略大小写后排列出对应的密码串，并返回匹配密码的箱子序号

    输入：
    第一行为key的字符串
    第二行为箱子boxes，为数组样式，以逗号分割

    输出描述：
        返回对应的箱子编号，如果不存在符合要求的箱子，则返回-1

输入：
abc
s,sdf134 A2c4b
输出：
2

     */

    /*
    逻辑分析  题目不难
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String key = sc.nextLine();
        String[] boxes = sc.nextLine().split(",");

        System.out.println(getResult(key, boxes));
    }

    public static int getResult(String key, String[] boxes) {
        outer:
        for (int i = 0; i < boxes.length; i++) {
            String box = boxes[i];
            if (box.length() < key.length()){
                continue;
            }

            HashSet<Character> set = new HashSet<>();
            for (char c : box.toLowerCase().toCharArray()){
                set.add(c);
            }

            for (int j = 0; j < key.length(); j++) {
                if (!set.contains(key.charAt(j))){
                    continue outer;
                }
            }

            return i + 1;
        }

        return -1;
    }

}
