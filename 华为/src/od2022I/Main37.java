package od2022I;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main37 {

    /**
     *
     * 关联子串
     *
     * 输入：
     * abc efghicabiii
     * 输出：
     * 5
     *
     * */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");

        String str1 = strings[0];
        String str2 = strings[1];
        int n1 = str1.length();
        int n2 = str2.length();
        int index = -1;

        for(int i=0;i<=n2-n1;i++){
            if(isFMatch(str1,str2.substring(i,i+n1))){  //将字符串2进行字符串1长度的切割
                index = i;
                break;
            }
        }

        System.out.println(index);

    }

    public static boolean isFMatch(String str1,String str2){

        int count = 0;
        int len = str1.length();
        List<Character> list = new ArrayList<>();
        for(int i=0;i<len;i++){
            list.add(str2.charAt(i));   //将需要匹配的字符串转换成列表
        }

        for(int i=0;i<len;i++){
            for(int j=0;j<list.size();j++){
                if(str1.charAt(i)==list.get(j)){    //如果此字符串匹配成功
                    list.remove(j); //移除此字符串
                    count++;    //匹配成功次数加1
                    break;
                }
            }
        }

        if(count==len){ //如果匹配次数等于字符串长度则成功
            return true;
        }

        return false;
    }

}
