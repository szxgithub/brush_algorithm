package com.nowcoder;

/*

兄弟单词
 */
import java.util.*;

/**
 * @authore:
 * @data: 2021/10/13
 * @Description:
 */
/**
 * 功能描述: <br>
 * @Param: 输入：
 * 6 cab ad abcd cba abc bca abc 1
 * 复制
 * 输出：
 * 3
 * bca
 * 复制
 * 说明：
 * abc的兄弟单词有cab cba bca，所以输出3
 * 经字典序排列后，变为bca cab cba，所以第1个字典序兄弟单词为bca
 * @Return:
 * @Author: guokun
 * @Date: 2021/10/13 14:18
 */
import java.util.*;

public class Demo17{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = in.nextInt();
            List<String> datas = new ArrayList();
            for(int i = 0 ; i < num ; i++){
                datas.add(in.next());
            }
            String x = in.next();
            char[] xs = x.toCharArray();//取反
            int index = in.nextInt();
            Collections.sort(datas);
            int count = 0;
            String k = "";
            for(String str : datas){
                if(x.equals(str) || x.length() != str.length()){
                    continue; //字符串一样 和 长度不一样的跳过
                }
                char[] strs = str.toCharArray();
                Arrays.sort(xs);
                Arrays.sort(strs);
                if(!Arrays.equals(strs,xs)){
                    continue;//升序排序不相等，跳过
                }
                count += 1; // 满足条件的累加
                if (count == index) {
                    k = str;//第K个兄弟单词
                }
            }
            System.out.println(count);
            System.out.println(k);
        }
    }
}


