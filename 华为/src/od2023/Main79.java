package od2023;

import java.util.HashMap;
import java.util.Scanner;

public class Main79 {

    /*

    货币单位换算

    输入：
    2
    20CNY53fen
    53HKD87cents
    输出：
    6432

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        String[] strs = new String[N];
        for (int i = 0; i<strs.length; i++){
            strs[i] = sc.nextLine();
        }

        HashMap<Character,Double> map = new HashMap<>();
        map.put('C',100d);
        map.put('H',10000/123d);
        map.put('J',10000/1825d);
        map.put('E',10000/14d);
        map.put('G',10000/12d);
        map.put('f',1d);
        map.put('c',100/123d);
        map.put('s',100/1825d);
        map.put('e',100/14d);
        map.put('p',100/12d);

        double sum = 0;
        for (int i =0; i<strs.length; i++){
            String str = strs[i];
            String num = "";
            for (int j = 0; j<str.length(); j++){
                char c = str.charAt(j);
                if (c == 'C'){
                    j = j + 3;
                }else if (c == 'H'){
                    j = j + 3;
                }else if (c == 'J'){
                    j = j + 3;
                }else if (c == 'E'){
                    j = j + 3;
                }else if (c == 'G'){
                    j = j + 3;
                }else if (c == 'f'){
                    j = j + 3;
                }else if (c == 'c'){
                    j = j + 5;
                }else if (c == 's'){
                    j = j + 3;
                }else if (c == 'e'){
                    j = j + 9;
                }else if (c == 'p'){
                    j = j + 5;
                }else if (Character.isDigit(c)){
                    num += c;
                    continue;
                }

                j--;
                Double fen = map.get(c);
                sum += Integer.parseInt(num) *fen;
                num = "";

            }
        }

        // 每一行计算结果为double，汇总后，再保留整数
        System.out.println((int)sum);

    }

}
