package com.nowcoder;

/**
 *
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 *
 * 输入描述：
 * 第一行输入数组元素个数
 * 第二行输入待排序的数组，每个数用空格隔开
 * 第三行输入一个整数0或1。0代表升序排序，1代表降序排序
 *
 * 输出描述：
 * 输出排好序的数字
 *
 * 输入：
 * 8
 * 1 2 4 9 3 55 64 25
 * 0
 * 复制
 * 输出：
 * 1 2 3 4 9 25 55 64
 */
import java.io.*;
import java.util.Arrays;
public class Demo86{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){

            int len = Integer.parseInt(str);
            int arr[] = new int[len];
            String strs[] = br.readLine().trim().split(" ");
            for(int i=0;i<arr.length;i++){
                arr[i] = Integer.parseInt(strs[i]);
            }
            int flag = Integer.parseInt(br.readLine());
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            if(flag==0){
                for(int i=0;i<arr.length;i++){
                    sb.append(arr[i]).append(" ");
                }
            }else if(flag==1){
                for(int i=arr.length-1;i>=0;i--){
                    sb.append(arr[i]).append(" ");
                }
            }
            System.out.println(sb.substring(0,sb.length()-1));
        }


    }
}
