package 华为;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * 十进制20位数据乘法
 * 
 * 输入：
 * 两个不超过20位都不为0的十进制字符串
 * 
 * 输出：
 * 字符串相乘结果
 * 
 * 
 */
public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger b1 = sc.nextBigInteger();
		BigInteger b2 = sc.nextBigInteger();
		BigInteger b3 = b1.multiply(b2);
		System.out.println(b3);
	}
}
