package od2023.onehundred;

import java.util.Scanner;

public class Main45 {

    /*
        查找重复代码
        重复代码查找方法：以字符串形式给定两行代码，找出两行代码中的“最长公共子串”
        如果不存在，则返回空字符串

输入：
private_void_method
public_void_method
输出：_void_method
     */

    /*
    暴力搜索
    比较两个字符串的长短
    使用双层for循环截取短字符串，并判断是否为长字符串的子串，没有的话，输出空字符串
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        String minStr = str1.length() >= str2.length() ? str2 : str1;
        String maxStr = minStr.equals(str2) ? str1 : str2;

        String res = "";
        int max = Integer.MIN_VALUE;
        for (int i =0; i < minStr.length(); i++){
            for (int j = i+1;  j<=minStr.length(); j++){
                String substring = minStr.substring(i, j);
                if (maxStr.contains(substring) && substring.length() > max){
                    max = substring.length();
                    res = substring;
                }
            }
        }

        System.out.println(res);
    }

    /*
    双指针
    满分答案
     */
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String resut = "";
        int start = 0;
        int end = 1;
        while (end <= str2.length()){
            String substring = str2.substring(start, end);
            if (str1.contains(substring)){
                resut = substring;
            }else {
                start++;
            }
            end++;
        }
        System.out.println(resut);
    }

    /*
    也可以用动态规划解决

    dp[i][j]表示str1 0-i范围 和 str2 0-j范围的公共子串的长度

    dp[i][0] = 0;
    dp[0][j] = 0;
    if(str1[i] == str2[j])
        dp[i][j] = dp[i-1][j-1] + 1
    else
        dp[i][j] = 0

     */
    public static String getResult(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n][m];
        int max= 0;
        String ans = "";

        for (int i = 1; i<=n; i++){
            for (int j = 1;j<= m; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if (dp[i][j] > max){
                        max = dp[i][j];
                        ans = str1.substring(i-max,i);
                    }
                }else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }

}
