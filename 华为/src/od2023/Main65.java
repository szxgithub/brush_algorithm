package od2023;


import java.util.*;

public class Main65 {

    /*

    字符串解密

    输入：
    123admyffc79ptaagghi2222smeersst88mnrt
    ssyyfgh
    输出：mnrt

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String str2 = sc.nextLine();
        HashSet<Character> set = new HashSet<>();
        for (int i =0; i<str2.length();i++){
            set.add(str2.charAt(i));
        }
        int num = set.size();

        String ganrao = "0123456789abcdef";

        // list最终存放的是不同字母数量相等的有效字串  最后按字典排序
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        boolean isEffect = false;
        int max = 0;
        for (int i =0; i<str.length(); i++){
            if (ganrao.contains(str.charAt(i) + "")){
                if (isEffect && sb.length() != 0){
                    HashSet<Character> tmpSet = new HashSet<>();
                    for (int j =0; j<sb.length();j++){
                        tmpSet.add(sb.charAt(j));
                    }
                    if (tmpSet.size() <= num){
                        if (tmpSet.size() > max){
                            list.clear();
                        }
                        list.add(sb.toString());
                        sb = new StringBuffer();
                        isEffect = false;
                    }
                }
                continue;
            }

            isEffect = true;
            sb.append(str.charAt(i));
        }

        if (isEffect && sb.length() != 0){
            HashSet<Character> tmpSet = new HashSet<>();
            for (int j =0; j<sb.length();j++){
                tmpSet.add(sb.charAt(j));
            }
            if (tmpSet.size() <= num){
                if (tmpSet.size() > max){
                    list.clear();
                }
                list.add(sb.toString());
            }
        }

        Collections.sort(list);
        if (list.size()== 0){
            System.out.println("Not Found");
        }else {
            System.out.println(list.get(list.size()-1));
        }
    }

}
