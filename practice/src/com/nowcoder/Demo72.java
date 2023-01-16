package com.nowcoder;

/**
 *
 * 密码强度等级
 *
 * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
 *
 * 一、密码长度:
 *
 * 5 分: 小于等于4 个字符
 *
 * 10 分: 5 到7 字符
 *
 * 25 分: 大于等于8 个字符
 *
 * 二、字母:
 *
 * 0 分: 没有字母
 *
 * 10 分: 全都是小（大）写字母
 *
 * 20 分: 大小写混合字母
 *
 * 三、数字:
 *
 * 0 分: 没有数字
 *
 * 10 分: 1 个数字
 *
 * 20 分: 大于1 个数字
 *
 * 四、符号:
 *
 * 0 分: 没有符号
 *
 * 10 分: 1 个符号
 *
 * 25 分: 大于1 个符号
 *
 * 五、奖励（只能选符合最多的那一种奖励）:
 *
 * 2 分: 字母和数字
 *
 * 3 分: 字母、数字和符号
 *
 * 5 分: 大小写字母、数字和符号
 *
 * 最后的评分标准:
 *
 * >= 90: 非常安全
 *
 * >= 80: 安全（Secure）
 *
 * >= 70: 非常强
 *
 * >= 60: 强（Strong）
 *
 * >= 50: 一般（Average）
 *
 * >= 25: 弱（Weak）
 *
 * >= 0:  非常弱
 */
import java.util.Scanner;
import java.util.ArrayList;
interface Judge{
    public static String GetPwdSecurityLevel(String pPasswordStr)
    {
        ArrayList<Character> list=new ArrayList<Character>();//密码列表
        //添加元素
        for(int i=0;i<pPasswordStr.length();i++)
            list.add(pPasswordStr.charAt(i));
        //判断长度
        int score=0;
        if(list.size()<=4)
            score+=5;
        else if(list.size()>=5&&list.size()<=7)
            score+=10;
        else
            score+=25;
        //判断字母
        ArrayList<Integer> listCha=new ArrayList<Integer>();
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i)>=65&&list.get(i)<=90)
                listCha.add(1);
            else if(list.get(i)>=97&&list.get(i)<=122)
                listCha.add(2);
        }
        if(listCha.contains(1)&&listCha.contains(2))
            score+=20;
        else if(listCha.contains(1))
            score+=10;
        else if(listCha.contains(2))
            score+=10;
        //判断数字
        int count=0;
        for(int i=0;i<list.size();i++)
            if(list.get(i)>=48&&list.get(i)<=57)
                count++;
        if(count==1)
            score+=10;
        else if(count>1)
            score+=20;
        //判断符号
        int count2=0;
        for(int i=0;i<list.size();i++)
            if(list.get(i)>=32&&list.get(i)<=47||list.get(i)>=58&&list.get(i)<=64||list.get(i)>=91&&list.get(i)<=96||list.get(i)>=123&&list.get(i)<=126)
                count2++;
        if(count2==1)
            score+=10;
        else if(count2>1)
            score+=25;
        //奖励分
        if((listCha.contains(1)&&listCha.contains(2))&&count>=1&&count2>=1)
            score+=5;
        else if((listCha.contains(1)||listCha.contains(2))&&count>=1&&count2>=1)
            score+=3;
        else if((listCha.contains(1)||listCha.contains(2))&&count>=1)
            score+=2;
        //System.out.println(score);
        //返回等级
        if(score>=90)
            return "VERY_SECURE";
        else if(score>=80)
            return "SECURE";
        else if(score>=70)
            return "VERY_STRONG";
        else if(score>=60)
            return "STRONG";
        else if(score>=50)
            return "AVERAGE";
        else if(score>=25)
            return "WEAK";
        else if(score>=0)
            return "VERY_WEAK";
        else
            return null;
    }
}
public class Demo72 implements Judge{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine())
            System.out.println(Judge.GetPwdSecurityLevel(sc.nextLine()));
        sc.close();
    }
}
