package od;

import java.util.Arrays;
import java.util.Scanner;

public class Main15 {

    /**
     *
     * 斗地主之顺子
     *
     * 输入一组数据，包含2~10，以及J Q K A，不包含大小王。找出牌中的顺子。
     *
     * */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){

            String str = scanner.nextLine();
            String[] strArr = str.split(" ");
            int[] strNum = new int[strArr.length];
            for (int i = 0; i< strArr.length; i++){
                if (strArr[i].equals("J")){
                    strArr[i] = "11";
                }else if (strArr[i].equals("Q")){
                    strArr[i] = "12";
                }else if (strArr[i].equals("K")){
                    strArr[i] = "13";
                }else if (strArr[i].equals("A")){
                    strArr[i] = "14";
                }
                strNum[i] = Integer.parseInt(strArr[i]);
            }

            Arrays.sort(strNum);

            int left = 0, right = 0;

            while (right < strNum.length){

                if (strNum[right] == 2){
                    right++;
                    left++;
                }

                if(strNum[right] - strNum[left] == right - left){
                    right++;
                }else {
                    if (right - left >= 5){
                        int[] res = Arrays.copyOfRange(strNum, left, right);
                        for (int i = 0; i<res.length; i++){
                            if (res[i] == 11){
                                System.out.print("J" + " ");
                            }else if (res[i] == 12){
                                System.out.print("Q" + " ");
                            }else if (res[i] == 13){
                                System.out.print("K" + " ");
                            }else if (res[i] == 14){
                                System.out.print("A" + " ");
                            }else {
                                System.out.print(res[i] + " ");
                            }
                        }
                        System.out.println();
                    }
                    left = right;
                }

            }

        }

    }

}
