package 正则表达式匹配;

public class Main {
	public static boolean match(String str,String pattern){
        if(str==null || pattern==null)
            return false;
        return matchCore(new StringBuilder(str),0,new StringBuilder(pattern),0);
    }
    public static boolean matchCore(StringBuilder str,Integer strIndex,StringBuilder pattern, Integer patternIndex){
        //如果匹配串和模式串都匹配结束
        if(strIndex==str.length() && patternIndex==pattern.length())
            return true;
        if(strIndex!=str.length() && patternIndex==pattern.length())
            return false;
        if(strIndex==str.length() && patternIndex!=pattern.length()) {
            if(patternIndex+1<pattern.length()&&pattern.charAt(patternIndex+1)=='*')
                return matchCore(str,strIndex,pattern,patternIndex+2);
            else
                return false;
        }
        //如果模式串的第二个字符不是*或者已经只剩一个字符了
        if(patternIndex==pattern.length()-1|| pattern.charAt(patternIndex+1)!='*'){
            if(pattern.charAt(patternIndex)=='.' || pattern.charAt(patternIndex)==str.charAt(strIndex))
                return matchCore(str,strIndex+1,pattern,patternIndex+1);
            else
                return false;
        }
        //如果模式串的第二个字符是*
        else{
            if(pattern.charAt(patternIndex)=='.'||pattern.charAt(patternIndex)==str.charAt(strIndex))
                return matchCore(str,strIndex+1,pattern,patternIndex)
                        ||matchCore(str,strIndex+1,pattern,patternIndex+2)
                        ||matchCore(str,strIndex,pattern,patternIndex+2);
            else
                return matchCore(str,strIndex,pattern,patternIndex+2);
        }
    }
}
