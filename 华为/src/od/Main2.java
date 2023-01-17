package od;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.omg.PortableInterceptor.SUCCESSFUL;

import java.util.Scanner;

public class Main2 {

    /**
     *
     * 寻找相同字串
     *
     * 给你两个字符串t和p 要求从t中找到一个和p相同的连续子串，并输出该字符串第一个字符的下标
     *
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            String t = sc.nextLine();
            String p = sc.nextLine();

            if (t.length() > 1000000){
                System.out.println("NO");
            }

            if (t.length() < p.length() && p.length() > 10000){
                System.out.println("NO");
            }

            int i = t.indexOf(p);
            if (i == -1){
                System.out.println("NO");
            }else {
                System.out.println(i + 1);
            }

        }

    }


}
