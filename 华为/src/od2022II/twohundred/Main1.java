package od2022II.twohundred;

import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {

    /*

    简易内存池

    REQUEST 和 RELEASE 其格式为 REQUEST=请求的内存大小 表示请求分配指定大小内存

    如果分配成功，返回分配到的内存首地址
    如果内存不足，或指定的大小为零则输出error

    题目链接 https://www.nowcoder.com/discuss/456582286696288256?sourceSSR=search

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        String[] strs = new String[N];

        for (int i = 0; i<N; i++){
            strs[i] = sc.nextLine();
        }

        String[][] cmds = new String[N][2];
        for (int i = 0; i<cmds.length; i++){
            cmds[i] = strs[i].split("=");
        }

        getResult(N,cmds);

    }

    private static void getResult(int n, String[][] cmds) {

        LinkedList<Integer[]> used = new LinkedList<>();
        used.add(new Integer[]{100,101});

        for (String[] cmd : cmds){
            String key = cmd[0];
            String val = cmd[1];

            if ("REQUEST".equals(key)){
                int size = Integer.valueOf(val);
                int start = 0;
                boolean flag = true;

                for (int i = 0; i<used.size(); i++){
                    int end = start + size - 1;
                    Integer[] range = {start,end};
                    if (!hasIntersection(used.get(i),range)){
                        used.add(i,range);
                        flag = false;
                        System.out.println(start);
                        break;
                    }else {
                        start = used.get(i)[1] + 1;
                    }
                }

                if (flag){
                    System.out.println("error");
                }
            }else {
                int addr = Integer.valueOf(val);
                boolean flag = true;
                for (int i = 0; i<used.size(); i++){
                    if (used.get(i)[0] == addr){
                        used.remove(i);
                        flag = false;
                        break;
                    }
                }

                if (flag){
                    System.out.println("error");
                }
            }

        }

    }

    /*
    判断两个区间是否存在交集
     */
    public static boolean hasIntersection(Integer[] range1, Integer[] range2){
        int s1 = range1[0];
        int e1 = range1[1];

        int s2 = range2[0];
        int e2 = range2[1];

        if (s1 == s2){
            return true;
        }else if (s1 < s2){
            return e1 >= s2;
        }else {
            return e2 >= s1;
        }
    }

}
