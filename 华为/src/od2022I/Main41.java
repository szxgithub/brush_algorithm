package od2022I;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main41 {

    /**
     *
     * 仿LISP运算
     *
     * 输入
     * (div 12 (sub 45 45))
     * 输出
     * error
     *
     *
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");

        Deque<String> op = new ArrayDeque<>();

        Deque<Integer> nums = new ArrayDeque<>();

        boolean isE = false;

        for (int i = 0; i < s.length; i++){
            if (s[i].contains("a")){
                op.push("+");
            }else if (s[i].contains("b")){
                op.push("-");
            }else if (s[i].contains("m")){
                op.push("*");
            }else if (s[i].contains("v")){
                op.push("/");
            }else if (s[i].contains(")")){
                // 包含）表示开始进行计算
                String temp = "";
                for (int j = 0; j <s[i].length(); j++){
                    if (s[i].charAt(j) == ')'){
                        if (temp.length() != 0){
                            nums.push(Integer.parseInt(temp));
                            temp = "";
                        }
                        int b = nums.pop();
                        int a = nums.pop();
                        String fuhao = op.pop();
                        if (fuhao == "/" && b == 0){
                            isE = true;
                            break;
                        }else {
                            nums.push(jisuan(a,b,fuhao));
                        }
                    }else {
                        temp += s[i].charAt(j);
                    }
                }
            }else {
                nums.push(Integer.parseInt(s[i]));
            }
            if (isE){
                break;
            }
        }

        if (isE){
            System.out.println("error");
        }else {
            System.out.println(nums.peek());
        }
    }

    public static int jisuan(int a, int b, String f){
        switch (f){
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return Math.floorDiv(a,b);
        }
        return 0;
    }

}
