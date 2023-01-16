package 替换空格;

public class Main {
	public String replaceSpace(StringBuffer str){
		String res = str.toString();
		res = res.replace(" ", "%20");
		return res;
	}
}
