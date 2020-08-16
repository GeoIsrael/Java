package com.amazon.treasuretruck.model;

import java.util.List;

public class Solution {
	public int numberAmazonTreasureTrucks(int rows, int column, List<List<Integer>> grid) {
		int count = 0;                           
		for (int i = 0; i < grid.size(); i++) {         
			for (int j = 0; j < grid.get(i).size(); j++) {
				if (grid.get(i).get(j) == 1) {
					count++;
					findAreaRecursion(i, j, grid);
				}
			}
		}
		return count;
	}

	private void findAreaRecursion(int i, int j, List<List<Integer>> grid) {
		grid.get(i).set(j, -1);                 
		if (j + 1 < grid.get(i).size() && grid.get(i).get(j + 1) == 1) {
			findAreaRecursion(i, j + 1, grid);
		}
		if (j - 1 >= 0 && grid.get(i).get(j - 1) == 1) {
			findAreaRecursion(i, j - 1, grid);
		}
		if (i + 1 < grid.size() && grid.get(i + 1).get(j) == 1) {
			findAreaRecursion(i + 1, j, grid);
		}
		if (i - 1 >= 0 && grid.get(i - 1).get(j) == 1) {
			findAreaRecursion(i - 1, j, grid);
		}

	}  

//	private int[][] convertListToArray(List<List<Integer>> grid) {
//		int[][] arr = new int[grid.size()][grid.get(0).size()];
//		for (int i = 0; i < grid.size(); i++) {
//			for (int j = 0; j < grid.get(i).size(); j++) {
//				arr[i][j] = grid.get(i).get(j);
//			}
//		}
//		return arr;
//	}

}
