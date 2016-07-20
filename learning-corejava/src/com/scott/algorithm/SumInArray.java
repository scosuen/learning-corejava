package com.scott.algorithm;

import java.awt.Insets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.print.attribute.ResolutionSyntax;

/**
 * ����������Ԫ����ӵ���ָ�������������
 * @author Ying
 *
 */
public class SumInArray {
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[]{2, 3, 5, 6, 7};
		
		test1(arr, 8);
//		test2(arr, 8);
	}
	
	public static void test1 (Integer[] arr, Integer sum) {
		HashSet<Integer> intSet = new HashSet<Integer>(Arrays.asList(arr));
		Iterator<Integer> ite = intSet.iterator();
		
		Set<Integer> result = new HashSet<Integer>();
		
		while (ite.hasNext()) {
			Integer i = ite.next();
			if (intSet.contains(sum - i)) {
				System.out.println("x:" + i + ", y:" + (sum - i));
				result.add(i);
				result.add(Integer.valueOf(sum - i));
			}
		}
		
		System.out.println(result);
	}
	
	public static void test2 (Integer[] arr, Integer sum) {
		for (int i = 0 ; i < arr.length ; i ++) {
			for (int j = i + 1 ; j < arr.length ; j ++) {
				if (sum == arr[i] + arr[j])
					System.out.println("x:" + arr[i] + ", y:" + arr[j]);
			}
		}
	}

}
