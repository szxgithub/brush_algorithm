package 字符流中第一个不重复的字符;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	
	//存放字符和其出现的次数
	HashMap<Character,Integer> map = new HashMap<>();
	
	//存放字符
	ArrayList<Character> list = new ArrayList<>();
	
	public void Insert(char ch){
		//判断map中是否已经包含要插入的字符，如果已经包含则将其次数+1
		if(map.containsKey(ch)){
			map.put(ch, map.get(ch)+1);	//map.get(ch)是根据key得到value的值
		}else{
			map.put(ch, 1);	//如果map中还没有包含，则把ch放入map中，并将其值设为1
		}
		list.add(ch);	//将ch放入list中，便于根据list中保存的ch到map中去查询出现的次数
	}
	
	public char FirstAppearingOnce(){
		char ch ='#';
		for(int i=0;i<list.size();i++){
			if(map.get(list.get(i))==1){
				ch = list.get(i);
				break;
			}
		}
		return ch;
	}
}
