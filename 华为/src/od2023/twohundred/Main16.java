package od2023.twohundred;


import java.util.*;

public class Main16 {

    /*

    字符串解密
    两个字符串string1和string2
    string1由小写字母和数字字符组成，而加扰字符串由0-9，a-f组成 ，string1有0个或多个有效子串,被加扰子串隔开
    string2是一个参考字符串，由小写字母a-z组成
    需要在string1字符串里找到一个有效子串，同时满足下面两个条件：
        1、这个有效子串里不同字母的数量不超过且最接近string2里不同字母的数量
        2、是所有子串里字典序最大的一个
    如果没有合适，输出 "Not Found"

输入：
123admyffc79ptaagghi2222smeersst88mnrt
ssyyfgh
输出：mnrt

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        HashSet<Character> set = new HashSet<>();
        for (int i =0; i<str2.length();i++){
            set.add(str2.charAt(i));
        }

        //str2不同字母的数量
        int num = set.size();

        String ganrao = "0123456789abcdef";

        // list最终存放的是不同字母数量相等的有效字串  最后按字典排序
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        boolean isEffect = false;
        int max = 0;
        for (int i =0; i<str1.length(); i++){
            if (ganrao.contains(str1.charAt(i) + "")){
                if (isEffect && sb.length() != 0){
                    HashSet<Character> tmpSet = new HashSet<>();
                    for (int j =0; j<sb.length();j++){
                        tmpSet.add(sb.charAt(j));
                    }

                    //str1子串不同字母的数量小于str2不同字母的数量
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
            sb.append(str1.charAt(i));
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

    /*
    利用正则表达式
     */
    public String getResult(String str1, String str2){
        // 可以匹配至少由一个数字、或 a-f的字母组成的字符串
        String reg = "[0-9a-f]+";

        // 有效字符串数组
        String[] valids = str1.split(reg);

        // 获取参考字符串不同字母的数量
        int count = getDistinctCount(str2);

        // 遍历过筛选出不同字母数量的小于等于 “参考字符串不同字母数量的字符串”
        String[] ans = Arrays.stream(valids).filter(value -> !"".equals(value) && getDistinctCount(value) <= count).toArray(String[]::new);

        if (ans.length == 0){
            return "Not Found";
        }

        // 先按长度降序，再按字典降序
        Arrays.sort(ans,(a,b)->{
            int c1 = getDistinctCount(a);
            int c2 = getDistinctCount(b);
            return c1 != c2 ? c2 - c1 : b.compareTo(a);
        });

        return ans[0];

    }

    /**
     * 获取字符串不同字母的数量
     * @param str2
     * @return
     */
    private int getDistinctCount(String str2) {
        HashSet<Character> set = new HashSet<>();
        for (char c : str2.toCharArray()){
            set.add(c);
        }
        return set.size();
    }

}
