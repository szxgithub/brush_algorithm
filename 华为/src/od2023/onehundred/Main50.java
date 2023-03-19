package od2023.onehundred;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main50 {

    /*

    货币单位换算
    若干条多国货币金额，需要转换成人民币分，汇总后输出


输入：
2
20CNY53fen
53HKD87cents
输出：
6432

     */

    /*
    逻辑分析
     */
    public static void main1(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 记录数
        int N = sc.nextInt();
        sc.nextLine();

        String[] strs = new String[N];
        for (int i = 0; i<strs.length; i++){
            strs[i] = sc.nextLine();
        }

        // 存放每种货币与rmb 分的映射关系
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
        // 遍历每种金额记录
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

    /*
    正则表达式解法

    Java提供了Java.util.regx包下面的Pattern 和 Matcher类
    Pattern类提供了静态方法 compile(String regex)
    Matcher类，提供了matcher方法，会返回一个Matcher对象  提供了三个返回boolean值的方法，matches()，lookingAt() find()

     */
    public static int getResult(String[] arr){
        String reg = "(\\d+)((CNY)|(JPY)|(HKD)|(EUR)|(GBP)|(fen)|(cents)|(sen)|(eurocents)|(pence))";
        HashMap<String,Double> exchange = new HashMap<>();
        exchange.put("CNY",100.0);
        exchange.put("JPY",100.0/1825*100);
        exchange.put("HKD",100.0/123*100);
        exchange.put("EUR",100.0/14*100);
        exchange.put("GBP",100.0/12*100);
        exchange.put("fen",1.0);
        exchange.put("cents",100.0/123);
        exchange.put("sen",100.0/1825);
        exchange.put("eurocents",100.0/14);
        exchange.put("pence",100.0/12);

        double ans = 0.0;
        Pattern p = Pattern.compile(reg);

        for (String s: arr){
            Matcher matcher = p.matcher(s);
            while (true){
                if (matcher.find()){
                    Double amount =  Double.parseDouble(matcher.group(1));
                    String unit = matcher.group(2);
                    ans += amount * exchange.get(unit);
                }else {
                    break;
                }
            }
        }

        return (int) ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i<n; i++){
            arr[i] = sc.next();
        }
        int result = getResult(arr);
        System.out.println(result);
    }

}
