package ≈≈–ÚÀ„∑®;

import java.util.Arrays;

public class TestSort {
	public static void main(String[] args) {
		int[] arr1 = {56,18,6,3,97,66,8,26,88,30,99,93};
		SortUtils.quickSort(arr1, 0, arr1.length-1);
		System.out.println(Arrays.toString(arr1));
	}
}
