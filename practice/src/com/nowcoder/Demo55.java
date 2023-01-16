package com.nowcoder;

/**
 *
 * 成绩排序
 *
 *描述
 * 查找和排序
 *
 * 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
 * 都按先录入排列在前的规则处理。
 *
 * 例示：
 * jack      70
 * peter     96
 * Tom       70
 * smith     67
 *
 * 从高到低  成绩
 * peter     96
 * jack      70
 * Tom       70
 * smith     67
 *
 * 从低到高
 *
 * smith     67
 *
 * jack      70
 *
 * Tom       70
 * peter     96
 */
import java.io.*;
public class Demo55{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str =null ;
        while((str=br.readLine())!=null) {
            int count = Integer.parseInt(str.trim());
            int flag = Integer.parseInt(br.readLine().trim());
            Stu[] stus=new Stu[count];
            for(int i=0;i<count;i++) {
                String[] ss= br.readLine().trim().split(" ");
                String name=ss[0];
                int score =Integer.parseInt(ss[1]);
                Stu stu=new Stu(name,score);
                stus[i]=stu;
            }
            //sort
            if(flag == 1) {
                for(int i=0;i<count;i++) {
                    for(int j=0;j<count-i-1;j++) {
                        if(stus[j].score>stus[j+1].score) {
                            Stu tmp = stus[j];
                            stus[j] = stus[j+1];
                            stus[j+1] = tmp;
                        }
                    }
                }
            }else if(flag==0) {
                for(int i=0;i<count;i++) {
                    for(int j=0;j<count-i-1;j++) {
                        if(stus[j].score<stus[j+1].score) {
                            Stu tmp = stus[j];
                            stus[j] = stus[j+1];
                            stus[j+1] = tmp;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<count;i++) {
                sb.append(stus[i].name + " ");
                sb.append(stus[i].score);
                if(i!=(count-1)) {
                    sb.append("\n");
                }
            }
            System.out.println(sb.toString());
        }
    }
    private static class Stu{
        String name;
        int score;
        public Stu(String name,int score) {
            this.name=name;
            this.score=score;
        }
    }
}
