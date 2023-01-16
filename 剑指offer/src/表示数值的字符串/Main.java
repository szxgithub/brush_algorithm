package 表示数值的字符串;

public class Main {
	/**
     * 利用正则表达式
     * [\\+\\-]?                    正或负符号出现与否
     * \\d*                         整数部分是否出现，如-.34 或 +3.34均符合
     * (\\.\\d+)?                   如果出现小数点，那么小数点后面必须有数字；否则一起不出现
     * ([eE][\\+\\-]?\\d+)?         如果存在指数部分，那么e或E肯定出现，+或-可以不出现，紧接着必须跟着整数；或者整个部分都不出现
     *
     * @param str
     * @return
     */
	public boolean isNumberic(char[] str){
		return new String(str).matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
	}
	
}
