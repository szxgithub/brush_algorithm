package od2023.twohundred;

import java.util.*;

public class Main15 {

    /*

    简单的解压缩算法

    需要实现一种算法，将一组压缩字符串还原成原始字符串
    还原规则如下：
        1、字符后面加数字N，表示重复字符N次
        2、花括号中的字符串加数字N，表示字符串重复N次
        3、字符后加N，花括号后加N，支持任意的嵌套，例如：{A3B1{C}3}3


输入：
{A3B1{C}3}3
输出：
AAABCCCAAABCCCAAABCCC


     */

    /*
    利用数据结构栈 完成该复杂字符串处理
    满分
 */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String string = sc.nextLine();
        String res  = getResult(string);
        System.out.println(res);

    }

    private static String getResult(String str) {
        Stack<String> stack = new Stack<>();
        for (int i= 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c == '{'){
                stack.push("{");
            }else if (c == '}'){
                if (Character.isDigit(str.charAt(i+1))){
                    int p = i+1;
                    while (p < str.length() && Character.isDigit(str.charAt(p))){
                        p++;
                    }
                    int num = Integer.parseInt(str.substring(i+1,p));
                    StringBuilder sb = new StringBuilder();
                    while (!stack.peek().equals("{")){
                        String pop = stack.pop();
                        sb.append(pop);
                    }
                    stack.pop();
                    stack.push(repeat(sb.toString(),num));
                    i = p-1;
                }
            }else if (Character.isAlphabetic(c)){
                if (Character.isDigit(str.charAt(i + 1))){
                    int p = i +1;
                    while (p < str.length() && Character.isDigit(str.charAt(p))){
                        p++;
                    }
                    int num = Integer.parseInt(str.substring(i+1,p));
                    stack.push(repeat(c + "",num));
                    i = p-1;
                }else {
                    stack.push(c+"");
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    private static String repeat(String str, int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<num; i++){
            sb.append(str);
        }
        return sb.toString();
    }




}
