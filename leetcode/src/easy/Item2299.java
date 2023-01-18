package easy;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.regex.Pattern;

public class Item2299 {

    /**
     *
     * 强密码检验器 II
     *
     *
     *
     * */

    /**
     * 测试通过 利用正则表达式
     * @param password
     * @return
     */
    public boolean strongPasswordCheckerII(String  password){
        if (password.length() < 8){
            return false;
        }

        String pattern1 = ".*[a-z]+.*";
        boolean matches1 = Pattern.matches(pattern1, password);
        if (!matches1){
            return false;
        }

        String pattern2 = ".*[A-Z]+.*";
        boolean matches2 = Pattern.matches(pattern2, password);
        if (!matches2){
            return false;
        }

        String pattern3 = ".*[0-9]+.*";
        boolean matches3 = Pattern.matches(pattern3, password);
        if (!matches3){
            return false;
        }

        String pattern4 = ".*[!@#$%^&*()\\-+]+.*";
        boolean matches4 = Pattern.matches(pattern4, password);
        if (!matches4){
            return false;
        }

       for (int i = 0; i<password.length()-1; i++){
           if(password.charAt(i) == password.charAt(i+1)){
              return false;
           }else {
               continue;
           }
       }

        return true;
    }

    public static void main(String[] args) {

        Item2299 item2299 = new Item2299();
        String password = "-Aa1a1a1";

        boolean b = item2299.strongPasswordCheckerII(password);
        System.out.println(b);

    }

}
