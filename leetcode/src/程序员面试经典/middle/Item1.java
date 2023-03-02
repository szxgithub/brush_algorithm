package 程序员面试经典.middle;

public class Item1 {

    /*
    二进制数转字符串
    给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。
    如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。

    提示：
        32位包括输出中的 "0." 这两位。
        题目保证输入用例的小数位数最多只有 6 位

     */

    /*
    十进制小鼠转换为二进制小数，主要利用小数部分乘2后，取整数部分，直至小数点后为0
     */
    public String printBin(double num){
        String ans = "0.";
        while (num != 0){
            num *= 2;
            if (num >= 1){
                ans += "1";
                num -= 1;
            }else {
                ans += "0";
            }
            if (ans.length() > 32){
                return "ERROR";
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Item1 main1 = new Item1();
        double num = 0.625;
        String s = main1.printBin(num);
        System.out.println(s);
    }

}
