package 把数组排成最小的数;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//参考博客: https://blog.csdn.net/qq_27703417/article/details/70948904
//给定一个int数组，按照某种规则排序，使得排序过后的数组组成的字符串的值最小；根据引入的ArrayList包提示使用集合排序
public class Main {
	
	public static String PrintMinNumber(int[] numbers){
		//特殊输入
        if(numbers==null||numbers.length<=0) return "";
        
      //先将int数组转化成为String类型的list或者array，这里使用集合
        ArrayList<String> list=new ArrayList<String>();
        for(int i=0;i<numbers.length;i++){
            list.add(numbers[i]+"");
        }
        
      //使用自定义的比较器进行排序
        Collections.sort(list,new MyComparator());
        
        //排好序之后的数组集合就是需要的值最小的数组，将其拼接之后返回即可
        String result="";
        for(int i=0;i<list.size();i++){
            result+=list.get(i);
        }
        return result;

	}
}

class MyComparator implements Comparator<String>{
    @Override     //大写O
    public int compare(String s1,String s2){			//注意：Comparator接口中的方法是compare()方法
        String c1=s1+s2;
        String c2=s2+s1;
        return c1.compareTo(c2);		//注意:String实现Comparable接口，实现的是compareTo()
    }
}

