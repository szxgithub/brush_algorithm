package od2023;

import javax.crypto.spec.PSource;
import java.util.Scanner;

public class Main71 {

    /*

    获取最大软件版本号


     */

    /*
    复杂的字符串进行处理
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        String[] split1 = str1.split("\\.");
        String[] split2 = str2.split("\\.");

        String res = str1;
        for (int i =0, j = 0; i<split1.length && j <split2.length; i++, j++){
            if (i != split1.length - 1 || j != split2.length -1){
                if (Integer.parseInt(split1[i]) == Integer.parseInt(split2[j])){
                    if (i == split1.length-1 && j != split2.length){
                        res = str2;
                        break;
                    }else if (i != split1.length && j == split2.length){
                        res = str1;
                        break;
                    }
                    continue;
                }else {
                    res = Integer.parseInt(split1[i]) > Integer.parseInt(split2[j]) ? str1 : str2;
                    break;
                }
            }else if (split1[split1.length-1].contains("-") && split2[split2.length-1].contains("-")){
                if (Integer.parseInt(split1[i].charAt(0) + "") == Integer.parseInt(split2[j].charAt(0) + "")){
                    res = split1[i].compareTo(split2[j]) >= 0 ? str1 : str2;
                }else {
                    res = Integer.parseInt(split1[i].charAt(0) + "") > Integer.parseInt(split2[j].charAt(0) + "") ? str1 :str2;
                }
                break;
            }
        }

        System.out.println(res);

    }

}
