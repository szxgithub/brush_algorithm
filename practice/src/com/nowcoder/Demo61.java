package com.nowcoder;

/**
 *
 * 参数解析
 *
 * 描述
 * 在命令行输入如下命令：
 *
 * xcopy /s c:\\ d:\\e，
 *
 * 各个参数如下：
 *
 * 参数1：命令字xcopy
 *
 * 参数2：字符串/s
 *
 * 参数3：字符串c:\\
 *
 * 参数4: 字符串d:\\e
 *
 * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Demo61{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nextLine = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList();
        boolean flag = false;
        for (int i = 0; i < nextLine.length(); i++) {
            char c = nextLine.charAt(i);

            if (String.valueOf(c).equals("\"")) {
                flag = flag ? false : true;
                continue;
            }

            if (String.valueOf(c).equals(" ") && !flag) {

                arrayList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            } else {
                stringBuilder.append(c);
            }

        }
        arrayList.add(stringBuilder.toString());
        System.out.println(arrayList.size());
        for (String s : arrayList) {
            System.out.println(s);
        }

    }
}
