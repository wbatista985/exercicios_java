package br.com.bubbleSort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int nums[] = { 3, 5, 2, 4, 7, 1, 0, 6 };
		int aux;
		boolean verificado;

		for (int i = 0; i < nums.length; i++) {
			verificado = true;
			for (int j = 0; j < (nums.length - 1); j++) {
				if (nums[j] > nums[j + 1]) {
					aux = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = aux;
					verificado = false;
				}
			}
			if (verificado) {
				break;
			}
		}
		
		System.out.print(Arrays.toString(nums));
	}
}
