package od2022I;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main48{

    /**
     *
     * 英文输入法
     *
     *
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine()
                .replace("'"," ")   //对“'”符号进行空格处理
                .replace(",","")
                .replace(".","")
                .replace("?","")
                .replace("!","")    //对“, . ? !”符号进行删除处理
                .split(" ");    //按照空格进行分割

        Collections.sort(Arrays.asList(strings));   //因为是字典需要进行排序
        String key = sc.nextLine();
        int keyLen = key.length();
        int strLen = strings.length;
        String res = "";

        for(int i=0;i<strLen;i++){
            String s = strings[i];
            if(s.length()>=keyLen && s.substring(0,keyLen).equals(key)){    //匹配的字符串需要判断长度，并进行关键词长度的分割
                if(res.length()!=0){
                    res+=" ";
                }
                res+=s;
            }
        }
        if(res.length()==0){
            res = key;
        }
        System.out.println(res);

    }

}
