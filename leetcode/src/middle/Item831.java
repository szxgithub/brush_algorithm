package middle;

import java.util.Arrays;

public class Item831 {

    /*
    隐藏个人信息
     */

    public String maskPII(String s) {

        if (s.indexOf("@") == -1){
            String replace = s.replace("(", "")
                    .replace(")", "")
                    .replace("+", "")
                    .replace("-", "")
                    .replace(" ", "");
            StringBuilder sb = new StringBuilder();
            int length = replace.length();
            int index = 0;
            if (length == 11){
                sb.append("+*");
                index = 1;
            }else if (length == 12){
                sb.append("+**");
                index = 2;
            }else if (length == 13){
                sb.append("+***");
                index = 3;
            }
            if (index > 0){
                sb.append("-");
            }

            char[] chars = replace.substring(index).toCharArray();
            for (int i = 0; i < chars.length; i++){
                if (i > chars.length - 4){
                    sb.append(chars[i]);
                }else if (i==0 || i%3 != 0){
                    sb.append("*");
                }else if (i==chars.length-4){
                    sb.append("-" + chars[i]);
                }else{
                    sb.append("-" + "*");
                }
            }
            return sb.toString();
        }else {

            String tmp = s.toLowerCase();

            String name = tmp.substring(0, tmp.indexOf("@"));
            String newName = name.substring(0, 1) + "*****" + name.substring(name.length() - 1);

            String res = newName + tmp.substring(tmp.indexOf("@"));
            return res;
        }

    }

    public static void main(String[] args) {

        Item831 item831 = new Item831();
        String s = "86-(10)12345678";
        String s1 = item831.maskPII(s);
        System.out.println(s1);
    }

}
