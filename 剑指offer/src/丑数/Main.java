package 丑数;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 基本思路
　　根据丑数的定义，丑数应该是另一个丑数乘以2、3或者5的结果（1除外）。因此我们可以创建一个集合，
里面的数字是排好序的丑数，每一个丑数都是前面的丑数乘以2、3或者5得到的。

这种思路的关键是在于怎么保证集合里面的丑数是排好序的。假设集合中已经有若干个丑数排好序后放在集合中，
并且把已有最大的丑数记做M，我们接下来分析如何生成下一个丑数。
该丑数肯定是前面某一个丑数乘以2、3或者5的结果，我们首先考虑把已有的丑数乘以2、3和5，
然后通过比较三个数的大小，找出三个树中最小的丑数存入集合。为了避免重复，
如果最小的丑数等于乘以2的结果，i2++；如果最小的丑数等于乘以3的结果，i3++;
如果最小的丑数等于乘以5的结果，i5++（i2、i3和i5是集合的索引且初值为0，首先集合存入1）。
这样得到的丑数在集合中是按照从小到大排序的。
 */
public class Main {
	/**
	 * 
	 * @param index
	 * @return
	 */
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //输入数据
            int index = sc.nextInt();
            int result = getUglyNumber(index);

            System.out.println(result);
        }
    }
	
	private static int getUglyNumber(int index){
		if(index<=0){
			return 0;
		}
		//存放丑数
		List<Integer> list = new ArrayList<>();
		list.add(1);
		int i2 =0, i3 = 0, i5=0;
		while(list.size()<index){
			
			int num2 = list.get(i2)*2;
			int num3 = list.get(i3)*3;
			int num5 = list.get(i5)*5;
			
			//找出最小的丑数，保证是按照从小到大的顺序排列
			int min = Math.min(num2, Math.min(num3, num5));
			list.add(min);
			
			//保证最小的数不重复
			if(min==num2){
				i2++;
			}
			
			if(min==num3){
				i3++;
			}
			
			if(min==num5){
				i5++;
			}
			
		}
		
		//返回第N个丑数
		return list.get(list.size()-1);
	}
}
