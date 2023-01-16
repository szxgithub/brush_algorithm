package 孩子们的游戏;

import java.util.ArrayList;

public class Main {
	public int LastRemaining_Solution(int n,int m){
		/*if(n<1 || m<1)
			return -1;
		int[] array = new int[n];
		int i=-1, step=0, count =n;
		while(count>0){
			i++;
			if(i>=n) i =0;
			if(array[i]==-1) continue;
			step++;
			if(step==m){
				array[i]=-1;
				step =0;
				count--;
			}
		}
		return i;*/
		
		
		
		if(n < 1 || m < 1) return -1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = -1;//n和m均为从0开始，n和m分别为小孩个数和报数大小
        while(list.size() > 1) {
            index = (index + m) % list.size();//每次报数将要删除的数的索引
            list.remove(index);
            index--;
        }
        return list.get(0);
	}
}
