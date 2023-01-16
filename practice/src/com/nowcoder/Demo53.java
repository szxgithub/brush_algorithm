package com.nowcoder;

/**
 * 配置文件恢复
 *
 * 有6条配置命令，它们执行的结果分别是：
 *
 * 输入：
 * reset
 * reset board
 * board add
 * board delet
 * reboot backplane
 * backplane abort
 * 复制
 * 输出：
 * reset what
 * board fault
 * where to add
 * no board at all
 * impossible
 * install first
 */
import java.io.*;
import java.util.*;
public class Demo53 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        HashMap <String, String> HMp = new HashMap<>();
        HMp.put("reset", "reset what");
        HMp.put("reset board", "board fault");
        HMp.put("board add", "where to add");
        HMp.put("board delete", "no board at all");
        HMp.put("reboot backplane", "impossible");
        HMp.put("backplane abort", "install first");

        String input=br.readLine();

        while(null!=input){
            if(HMp.containsKey(input)){
                System.out.println(HMp.get(input));
            }
            else{
                System.out.println("unknown command");
            }

            input=br.readLine();
        }

    }
}

/*


 */