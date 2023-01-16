package com.nowcoder;

/**
 * MP3光标位置
 *
 * 输入描述：
 * 输入说明：
 * 1 输入歌曲数量
 * 2 输入命令 U或者D
 *
 * 本题含有多组输入数据！
 *
 * 输出描述：
 * 输出说明
 * 1 输出当前列表
 * 2 输出当前选中歌曲
 *
 */
import java.util.Scanner;

public class Demo51 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());//
            int pos = 1;
            int posNum = 1;
            String s = in.nextLine();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='U'){
                    posNum--;
                    if(n>4){
                        if(pos!=1){
                            pos--;
                        }
                        if(posNum<1){//特殊反页
                            posNum=n;
                            pos=4;
                        }
                    }else{
                        pos--;
                        if(posNum<1){
                            posNum=n;
                            pos=n;
                        }
                    }
                }else{
                    posNum++;
                    if(n>4){
                        if(pos!=4){
                            pos++;
                        }
                    }else{
                        pos++;
                    }
                    if(posNum>n){//特殊反页
                        posNum=1;
                        pos=1;
                    }
                }
            }
            int[] nums = new int[4];
            if(n<=4){
                for(int i=1;i<n;i++){
                    System.out.print(i + " ");
                }
                System.out.println(n);
                System.out.println(posNum);
            }else{
                switch(pos){
                    case 1:
                        nums[0] = posNum;
                        nums[1] = posNum + 1;
                        nums[2] = posNum + 2;
                        nums[3] = posNum + 3;
                        break;
                    case 2:
                        nums[0] = posNum - 1;
                        nums[1] = posNum;
                        nums[2] = posNum + 1;
                        nums[3] = posNum + 2;
                        break;
                    case 3:
                        nums[0] = posNum - 2;
                        nums[1] = posNum - 1;
                        nums[2] = posNum;
                        nums[3] = posNum + 1;
                        break;
                    case 4:
                        nums[0] = posNum - 3;
                        nums[1] = posNum - 2;
                        nums[2] = posNum - 1;
                        nums[3] = posNum;
                        break;
                }
                for(int i=0;i<3;i++){
                    System.out.print(nums[i] + " ");
                }
                System.out.println(nums[3]);
                System.out.println(posNum);
            }
        }
    }
}

