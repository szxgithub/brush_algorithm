package ����ݹ�����2;

//��ת��
//���ǰ�"cba" ��Ϊ "abc"�ķ�ת��
//����һ�������
public class A {
	public static void main(String[] args) {
		System.out.println(reverseString("abcdef"));
	}
	
	public static String reverseString(String x){
		if(x==null || x.length()<2){
			return x;
		}
		return reverseString(x.substring(1))+x.charAt(0);
	}
}
