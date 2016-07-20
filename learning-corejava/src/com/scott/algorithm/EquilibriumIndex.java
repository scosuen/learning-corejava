package com.scott.algorithm;

/**
 * 数组中有一个或多个平衡点(equilibrium index), 这个点左边的数字相加 等于右边的数字相加(不包含这个数).
 * @author Ying
 *
 */
public class EquilibriumIndex {
	
	public static void main(String[] args) {
		int[] A = new int[]{500, 1, -2, -1, 2};
		solution(A);
	}

	public static int solution(int[] A) {
        for (int i = 0 ; i < A.length; i ++) {
        	int f = 0;
        	int fSum = 0;
        	int r = A.length - 1;
        	int rSum = 0;

        	while (f < i) {
        		fSum += A[f++];
        	}
        	
        	while (r > i) {
        		rSum += A[r--];
        	}
        	
        	if(fSum == rSum) {
        		System.out.println(i);
        		return i;
        	}
        		
        }
        
        return -1;
    }
}
