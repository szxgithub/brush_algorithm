package com.nowcoder;

import java.util.*;

/**
 *识别有效的IP地址和掩码并进行分类统计
 *
 * 通过部分测试用例
 *
 */
public class Demo8{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int A = 0, B = 0, C = 0, D = 0, E = 0, errorNum =  0, prIp = 0;
        while(in.hasNext()){
            String[] str = in.nextLine().split("~");
            String ip = str[0], mask = str[1];
            //掩码处理
            String[] strs = mask.split("\\.");
            int maskNum = 0;
            //转换为int整型数据
            for(int i = 0; i < 4; ++i){
                int x = Integer.valueOf(strs[i]);
                maskNum |= x<<(8*(3-i));
            }
            //全1全0不合法
            if(maskNum == 0 || maskNum == -1){
                ++errorNum;
                continue;
            }else{
                //把前面的1都移掉
                int tmp = 1 << 31;
                while((maskNum & tmp) == tmp){
                    maskNum <<= 1;
                }
                //如果移掉后不为0，说明不满足掩码格式
                if(maskNum != 0){
                    ++errorNum;
                    continue;
                }
            }
            //处理IP
            String[] sh = ip.split("\\.");
            if(sh.length == 4){
                int first = Integer.valueOf(sh[0]);
                int second = Integer.valueOf(sh[1]);
                if(first != 0 && first != 127){
                    if(first >= 1 && first <= 126){
                        A++;
                        if(first == 10) ++prIp;
                    }
                    if(first >= 128 && first <= 191){
                        B++;
                        if(first == 172 && second >= 16 && second <= 31) ++prIp;
                    }
                    if(first >= 192 && first <= 223){
                        C++;
                        if(first == 192 && second == 168) ++prIp;
                    }
                    if(first >= 224 && first <= 239){
                        D++;
                    }
                    if(first >= 240 && first <= 255){
                        E++;
                    }
                }
            }else{
                ++errorNum;
            }

        }
        System.out.println(A + " " + B + " "+C+" "+D+" "+E+" "+errorNum+" "+prIp);
    }
}