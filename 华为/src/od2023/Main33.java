package od2023;

import java.util.Arrays;
import java.util.Scanner;

public class Main33 {

    /*
    寻找关键钥匙
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
