package od2023.twohundred;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main23 {

    /*
    去除多余空格
    去除文本多余空格，但是不去除配对单引号之间的多余空格，给出关键词的起始和结束下标，去除多余空格后更新下标

    条件约束：
        不考虑关键词起始和结束为空格的场景
         如果有单引号，必定成对出现
         单词的开始和结束下标保证涵盖一个完整的单词，中间不会有多余的空格



    输入：
    Life is painting a  picture, not doing 'a sum'.
    8 15,20 26,43 45
    输出：
    Life is painting a picture, not doing 'a sum'.
    [8,15][19,25][42,44]

    //todo

     */


    /*
    逻辑分析题
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String string = sc.nextLine().trim();   //去除首位空格
        String[] strings = sc.nextLine().split(",");

        List<String> wordsList = new ArrayList<>();     //单词集合
        List<int[]> zuobiaoList = new ArrayList<>();    //坐标集合
        int lettersCount = 0;   //单词字符的总个数（用来计算坐标的）
        boolean isInBrackets = false;   //是否在引号内
        int indexWord = 0;      //字符串索引
        int indexZuobiao = 0;   //坐标索引
        boolean isOver = false;     //是否遍历完成
        String temp = "";

        while (!isOver){

            String[] indexs = strings[indexZuobiao].split(" ");
            int startIndex = Integer.parseInt(indexs[0]);   //开始坐标
            int enbIndex = Integer.parseInt(indexs[1]);     //末尾坐标
            if(indexZuobiao < strings.length - 1) indexZuobiao ++;

            int newStartIndex;      //新的起始位置
            int newEndIndex;        //新的末尾位置

            for(int j=indexWord; j<string.length(); j++){

                char c = string.charAt(j);      //当前字符
                if(c == ' '){
                    if(isInBrackets){
                        temp += c;  //在引号内空格需要拼接
                        continue;
                    }
                    if(temp != ""){
                        lettersCount += temp.length();  //计算总字符串长度
                        wordsList.add(temp);    //作为单词直接加入集合
                        temp = "";      //temp用完需要置空
                    }
                }else if(c == '\''){
                    isInBrackets = !isInBrackets;   //在引号内切换
                    temp += c;      //引号也需要拼接
                }else {
                    temp += c;      //其他情况直接拼接
                }

                if(j == string.length() - 1){   //遍历到最后一个字符，说明遍历完成了
                    if(temp != "") wordsList.add(temp);     //最后一个字符串也需要
                    isOver = true;
                }

                if(j == startIndex){    //需要统计坐标了
                    //新起始坐标=单词个数（相当于空格个数）+字符串总长度+（如果引号内还需要temp的长度-1）
                    newStartIndex = wordsList.size() + lettersCount + (isInBrackets ? temp.length() - 1 : 0);
                    //新终点坐标=单词长度+新的起始坐标
                    newEndIndex = enbIndex - startIndex + newStartIndex;
                    zuobiaoList.add(new int[]{newStartIndex, newEndIndex});
                    indexWord = j + 1;  //字符串索引更新
                    break;
                }
            }
        }

        String res = "";
        for(String s : wordsList){
            res += s + " ";
        }

        System.out.println(res.substring(0, res.length()-1));
        String resIndex = "";
        for(int[] ints : zuobiaoList){
            resIndex += "[" + ints[0] + "," + ints[1] + "]";
        }

        System.out.println(resIndex);
    }


}
