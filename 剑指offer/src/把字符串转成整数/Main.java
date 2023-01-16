package 把字符串转成整数;

public class Main {
	
	public static int StrToInt(String str){
		if(str.length()==0 || str==null){
			return 0;
		}
		char[] strs = str.toCharArray();
		for(int i=0;i<strs.length;i++){
			if((strs[i]=='+' || strs[i]=='-')&& i==0){
				continue;
			}
			if("0123456789".contains(strs[i]+"")){
				continue;
			}else{
				return 0;
			}
		}
		
		StringBuilder chs = new StringBuilder();
		if(strs[0]=='+'){
			if(strs.length==1){
				return 0;
			}
			for(int i=1;i<strs.length;i++){
				chs = chs.append(strs[i]);
			}
			return Integer.parseInt(chs.toString());
		}else{
			if(strs[0]=='-' && strs.length==1){
				return 0;
			}
			for(int i=0;i<strs.length;i++){
				chs = chs.append(strs[i]);
			}
			return Integer.parseInt(chs.toString());
		}
		
	}
	
	public static void main(String[] args) {
		//int res = StrToInt("+2147483647");
		//int res = StrToInt("-123");
		//int res = StrToInt("+");
		int res = StrToInt("-");
		System.out.println(res);
	}
	
}
