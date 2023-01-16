package 华为;

import java.util.Scanner;

public class Main16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            Integer num = sc.nextInt();
            String str = Integer.toBinaryString(num);
            int cout = 0;
            for(int i = 0;i<str.length();i++){
                if(str.charAt(i) == '1'){
                    cout++;
                }
            }
            System.out.println(cout);
        }
    }

    public void count(int n){
        int cout = 0;
        while(n>0){
            if((n&1) > 0){
                cout++;
            }
            n = n>>1;
        }
        System.out.println(cout);
    }
}
