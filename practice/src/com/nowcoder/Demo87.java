package com.nowcoder;

/**
 * 字符统计
 *
 * 描述
 * 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。
 *
 * 输入描述：
 * 一个只包含小写英文字母和数字的字符串。
 *
 * 输出描述：
 * 一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Demo87{
    public static void main(String[] args)
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        try{
            while((str=br.readLine())!=null)
            {
                System.out.println(count(str).toString());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static StringBuilder count(String str)
    {
        char[] strArray=str.toCharArray();
        int[] chArray=new int[129];
        //字符对应ascll码值下标元素自增来统计数量
        for(char i:strArray)
            chArray[(int)i]++;
        int max=0;
        //找出字符数量最多的ascll码值
        for(int i=0;i<chArray.length;i++)
            if(max<chArray[i])
                max=chArray[i];
        StringBuilder sb=new StringBuilder();
        //按数量从大到小添加到可变字符序列sb
        while(max!=0)
        {
            for(int i=0;i<chArray.length;i++)
                if(chArray[i]==max)
                    sb.append((char)i);
            max--;
        }
        return sb;
    }
}

