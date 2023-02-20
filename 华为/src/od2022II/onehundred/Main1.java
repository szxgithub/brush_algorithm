package od2022II.onehundred;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    /*

    考勤信息

    公司用一个字符串来表示员工的出勤信息
    absent 缺勤
    late 迟到
    leaveearly: 早退
    present 正常上班

    输入：
    2
    present
    present absent present present leaveearly present absent
    输出：
    true
    false


     */

    /*
    逻辑分析题
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String[] strs = new String[n];
        for (int i =0; i <n; i++){
            strs[i] = sc.nextLine();
        }

        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i <strs.length; i++){
            String[] s = strs[i].split(" ");
            int absent = 0;
            for (int j = 0; j<s.length; j++){
                if ("absent".equals(s[j])){
                    absent++;
                    if (absent > 1){
                        res.add(false);
                        break;
                    }
                }else if ("late".equals(s[j]) && "late".equals(s[j+1])){
                    res.add(false);
                    break;
                }else if ("leaveearly".equals(s[j]) && "leaveearly".equals(s[j+1])){
                    res.add(false);
                    break;
                }else if (s.length - j >= 7){
                    int unnormal = 0;
                    for (int k = j; k<j+7 && k < s.length; k++){
                        if ("absent".equals(s[k]) || "late".equals(s[k]) || "leaveearly".equals(s[k])){
                            unnormal++;
                        }
                    }
                    if (unnormal > 3){
                        res.add(false);
                        break;
                    }
                }
            }
            if (res.size() != i+1){
                res.add(true);
            }
        }

        for (boolean bool : res){
            System.out.println(bool);
        }

    }

}
