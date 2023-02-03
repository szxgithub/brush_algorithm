package od2023;

import java.util.*;

public class Main34 {
    /*

    寻找密码

    输入：b eredderd bw bww bwwl bwwlm bwwln
    输出：bwwln

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] s = str.split(" ");

        List<String> list = new ArrayList<>();
        for (int i = 0; i<s.length; i++){
            String tmp = s[i];
            while (tmp.length() > 0){
                tmp = tmp.substring(0, tmp.length() - 1);
                if (!tmp.isEmpty()){
                    for (int j = 0; j != i && j < s.length; j++){
                        if (s[j].contains(tmp)){
                            list.add(s[i]);
                        }
                    }
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.get(list.size()-1));

    }


    public static void main2(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strs = sc.nextLine().split(" ");

        List<String> list = new ArrayList<>();
        for(int i=0; i<strs.length; i++){
            list.add(strs[i]);      //将字符数组转化为list，方便使用contains函数
        }

        // 按照长度大小升序排序
        Collections.sort(list , (a,b) -> {
            return a.length() - b.length();
        });
        String res = "";
        for(int i=list.size()-1; i>=0; i--){
            String str = list.get(i);
            boolean isTrue = true;
            for(int j=str.length()-1; j>0; j--){
                if(list.contains(str.substring(0, j))){
                    continue;
                }else {
                    isTrue = false;
                    break;
                }
            }
            if(isTrue){
                res = str;
                break;
            }
        }

        System.out.println(res);
    }


}
