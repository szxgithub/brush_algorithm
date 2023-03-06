package od2023.twohundred;

import java.util.*;

public class Main15 {

    /*

    简单的解压缩算法

    需要实现一种算法，将一组压缩字符串还原成原始字符串
    还原规则如下：
        1、字符后面加数字N，表示重复字符N次
        2、花括号中的字符串加数字N，表示字符串重复N次
        3、字符后加N，花括号后加N，支持任意的嵌套，例如：{A3B1{C}3}3


    输入：
    {A3B1{C}3}3
    输出：
    AAABCCCAAABCCCAAABCCC


     */

    public static void main2(String[] args) {

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

    /*
        利用数据结构栈 完成该复杂字符串处理

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(getResult(str));
    }

    public static String getResult(String str) {
        LinkedList<String> stack = new LinkedList<>();
        // idxs记录 { 出现的索引位置
        LinkedList<Integer> idxs = new LinkedList<>();
        StringBuilder repeat = new StringBuilder();
        str += " ";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') { // 如果压栈遇到数字
                // 如果出现A13,或者{ABC}99这种情况，我们需要把多位数解析出来
                repeat.append(c);
                continue;
            }

            if (repeat.length() > 0) {
                int n = Integer.parseInt(repeat.toString());
                repeat = new StringBuilder();
                if ("}".equals(stack.getLast())) { // 如果此时栈顶是 } , 则需要将{,} 中间的内容整体重复repeat次
                    int left = idxs.removeLast();
                    stack.remove(left); // 去掉 {
                    stack.removeLast(); // 去掉 }
                    updateStack(stack, left, n); // 将 {,} 中间部分重复 repeat次后重新压栈
                } else { // 如果此时栈顶不是 }，则只需要将栈顶元素重复repeat次即可。
                    updateStack(stack, stack.size() - 1, n);
                }
            }

            // 记录 { 出现的索引位置
            if (c == '{') {
                idxs.addLast(stack.size());
            }

            // 数字外的字符都压入栈中，其中{,}需要再重复操作时删除
            stack.addLast(c + "");
        }

        StringBuilder sb = new StringBuilder();
        for (String c : stack) {
            sb.append(c);
        }
        return sb.toString().trim();
    }

    // 将stack，从left索引开始到最后的内容，弹栈，并整体重复repeat次后，再重新压入栈
    public static void updateStack(LinkedList<String> stack, int left, int repeat) {
        int count = stack.size() - left;

        // frag用于存储弹栈数据
        String[] frag = new String[count];

        while (count-- > 0) {
            frag[count] = stack.removeLast();
        }

        // 由于重复的是弹栈内容的整体，而不是每个，因此需要将弹栈内容合并
        StringBuilder sb = new StringBuilder();
        for (String s : frag) {
            sb.append(s);
        }

        // 将弹栈内容合并后重复repeat次，再重新压入栈中
        String fragment = sb.toString();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < repeat; i++) {
            ans.append(fragment);
        }

        stack.addLast(ans.toString());
    }



}
