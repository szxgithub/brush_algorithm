package 翻转单词序列;

public class Main {
	public String ReverseSentence(String str){
		if(str==null || !str.contains(" "))
			return str;
		String[] split = str.split(" ");
		StringBuilder sb = new StringBuilder();
		
		for(int i=split.length-1;i>=0;i--){
			if(i!=split.length-1){
				 sb.append(" ");
			}
			sb.append(split[i]);
		}
		if(sb.length()==0)
			sb.append(str);
		return sb.toString();
	}
}





