package �����㷨;

import java.util.Arrays;

/*
 * ϣ��������һ�ֲ����������Ǽ򵥲������򾭹��Ľ�֮���һ������Ч�İ汾
 * Ҳ��Ϊ��С��������ͬʱ���㷨�ǳ���O(n2���ĵ�һ���㷨֮һ��
 * 
 * ϣ�������ǰѼ�¼���±��һ���������飬��ÿ��ʹ��ֱ�Ӳ��������㷨���������������𽥼��٣�ÿ������Ĺؼ�������Խ�࣬
 * ����������1ʱ�������ļ�ǡ���ֳ�һ�飬�㷨��ֹ
 */
public class ϣ������ {
	
	public static void main(String[] args) {
		int[] arr1 = {56,18,6,3,97,66,8,26,88,30,99,93};
		String st = Arrays.toString(ShellSort(arr1));
		System.out.println(st);
	}
	
	public static int[] ShellSort(int[] array){
		int len = array.length;
		int temp, gap = len/2;
		
		while(gap>0){
			for(int i=gap;i<len;i++){
				temp = array[i];
				int preIndex = i-gap;
				while(preIndex>=0 && array[preIndex]>temp){
					array[preIndex+gap] = array[preIndex];
					preIndex -= gap;
				}
				array[preIndex+gap] = temp;
			}
			gap/= 2;
		}
		
		return array;
	}
}
