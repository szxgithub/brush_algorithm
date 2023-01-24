package 华为;

import java.util.Scanner;

/**
 *给定字符串，找出最长字串，如果多个，以ascii最小值输出
 * 2020年社招华为机试
 */
public class Main18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            int len = str.length();
            int defaultSubStrLen = 1;
            char[] chArray = str.toCharArray();
            for(int i = 1;i<len;i++){
                if(chArray[i] == chArray[i-defaultSubStrLen]){
                    defaultSubStrLen++;
                }
            }
            System.out.println(defaultSubStrLen);
            int minAscii = 999;
            int index = 0;
            for(int j=0;j<len;j++){
                if(j+defaultSubStrLen > len){
                    break;
                }

//                if((chArray[j]==chArray[j+defaultSubStrLen-1]) && minAscii <= chArray[j]){
//                    index = j;
//                    minAscii = chArray[j];
//                }

                if(chArray[j]==chArray[j+defaultSubStrLen-1]){
                    if(chArray[j] < minAscii){
                        index = j;
                        minAscii = chArray[j];
                    }
                }
            }
            System.out.println(str.substring(index,index+defaultSubStrLen));
        }
    }
}
