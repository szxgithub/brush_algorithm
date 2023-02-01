package od2023;

import java.util.*;

public class Main1 {

    /*

    简单的压缩算法



     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String string = sc.nextLine();

        int len = string.length();
        Deque<String> strDeque = new ArrayDeque<>();
        String tempStr = "";    //字符串
        boolean isHasBraces = false;    //是否有大括号需要处理
        for(int i=0; i<len; i++){
            char c = string.charAt(i);
            if(c == '{'){       //遇到左括号
                if(isHasBraces){    //先判断是否有大括号需要处理
                    handleBraces( tempStr, strDeque);
                    isHasBraces = false;
                }else if(!tempStr.isEmpty()){
                    strDeque.addLast(handle(tempStr));
                }
                strDeque.addLast(String.valueOf(c));
                tempStr = "";
            }else if(c == '}'){
                strDeque.addLast(tempStr);
                if(isHasBraces){
                    handleBraces( strDeque.pollLast(), strDeque);
                }else {
                    strDeque.addLast(handle(strDeque.pollLast()));
                }
                isHasBraces = true;
                tempStr = "";
            }else {
                if(isHasBraces && Character.isLetter(c)){
                    handleBraces( tempStr, strDeque);
                    isHasBraces = false;
                    tempStr = "";
                }
                tempStr += c;
            }
            if(i == len - 1){   //最后一个字符
                if(isHasBraces){
                    handleBraces( tempStr, strDeque);
                }else {
                    strDeque.addLast(handle(tempStr));
                }
            }
        }

        String res = "";
        while (strDeque.size() != 0){
            res += strDeque.pollFirst();
        }

        System.out.println(res);
    }

    /**
     * 获取大括号里面的字符串
     * @param strDeque
     * @return
     */
    public static String getBraces(Deque<String> strDeque){

        List<String> list = new ArrayList<>();
        while (!strDeque.peekLast().equals("{")){   //直至碰到下一个左括号
            list.add(strDeque.pollLast());
        }
        strDeque.pollLast();    //左括号也需要删除
        Collections.reverse(list);  //因为是从尾部开始找的所以需要翻转

        String res = "";
        for(String s : list){
            res += s;
        }

        return res;
    }

    /**
     * 处理大括号里面的内容
     * @param tempStr       括号外的数字
     * @param strDeque      字符串队列
     */
    public static void handleBraces(String tempStr, Deque<String> strDeque){

        int num = Integer.valueOf(tempStr);
        String temp = "";
        String strInBraces = getBraces(strDeque);
        for(int j=0; j<num; j++){
            temp += strInBraces;
        }
        strDeque.addLast(temp);
    }

    /**
     * 处理连续的字符串
     * @param str
     * @return
     */
    public static String handle(String str){

        int len = str.length();

        String res = "";
        String tempStr = "";    //字符串
        String tempNum = "";    //数字字符串（处理多位数）
        for(int i=0; i<len; i++){
            char c = str.charAt(i);
            if(Character.isDigit(c)){   //此时是数字
                tempNum += c;   //是数字直接进行拼接
            }else {     //此时是字母
                if(!tempNum.isEmpty()){     //数字字符串不为空说明需要处理
                    int num = Integer.valueOf(tempNum);     //字符重复的次数
                    for(int j=0; j<num; j++){
                        res += tempStr;     //重复多少次就拼接多少次
                    }
                    tempStr = "";   //处理完需要置空以免影响下一个字符的统计
                    tempNum = "";   //数字一样置空
                }
                tempStr += c;   //字符拼接
            }
            if(i == len - 1){   //不能忘了处理最后一位
                if(!tempNum.isEmpty()){     //数字字符串不为空时处理
                    int num = Integer.valueOf(tempNum);
                    for(int j=0; j<num; j++){
                        res += tempStr;
                    }
                }else {
                    res += tempStr;     //为空时直接拼接字符串（处理单字符串的情况）
                }
            }
        }

        return res;
    }



}
