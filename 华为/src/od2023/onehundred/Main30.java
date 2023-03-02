package od2023.onehundred;

import java.util.Arrays;
import java.util.Scanner;

public class Main30 {

    /*
    寻找关键钥匙(密室逃生游戏)

    要求找到符合给定密码K（升序的不重复小写字母组成）的箱子，并给出箱子编号，箱子编号为1-N
    每个箱子都有一个字符串s,字符串由大小写字母，数字，标点，空格组成，需要在这些字符串中找到所有字母，忽略大小写后排列出对应的密码串，并返回匹配密码的箱子序号

    输入：
    第一行为key的字符串
    第二行为箱子boxes，为数组样式，以逗号分割


     */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String key = sc.nextLine();
        String[] boxes = sc.nextLine().split(" ");

        int res = -1;
        for(int i=0; i<boxes.length; i++){
            String box = boxes[i];
            String temp = "";
            for(int j=0; j<box.length(); j++){
                char c = box.charAt(j);
                if(Character.isUpperCase(c)){
                    temp +=  Character.toLowerCase(c);  //大写转化为小写
                }else if(Character.isLowerCase(c)){
                    temp += c;
                }
            }
            char[] tempArr = temp.toCharArray();    //转换为数组
            Arrays.sort(tempArr);   //进行升序排序
            if(String.valueOf(tempArr).equals(key)){
                res = i + 1;
                break;
            }
        }

        System.out.println(res);
    }

}
