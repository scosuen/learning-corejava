package com.scott.algorithm;


/**
 * 一个数组中, 有多个integer, 假设{100, 250, 1000} 有以下情况 
 * (100+250) +((100+250)+1000) = 1700
 * (250+1000) + ((250+1000)+100) = 2600
 * (100+1000) + ((100+1000)+250) = 2450
 * 求最小值 (第一种情况)
 * 
 * @author Ying
 *
 */
public class MinimumSum {
	
	public static void main(String[] args) {
//		int [] a = { 1, 54, 6, 3, 78, 34, 12, 45 };
//		bubbleSort(a);
		
//		for (int i = 0; i < a.length; i++)
//			System.out.println(a[i]);

		int [] A = {1000, 100, 250};
		System.out.println(new MinimumSum().solution(A));
	}
	
	public int solution(int[] A) {
		if (A.length < 2)
			return 0;
		
		bubbleSort(A);
		
		int sum = 0;
		for (int i = 1 ; i < A.length ; i ++) {
			for (int j = 0 ; j <= i ; j ++){
				sum += A[j];
			}
		}
		
		return sum;
    }
	
	public static void bubbleSort(int[] a) {
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

}
