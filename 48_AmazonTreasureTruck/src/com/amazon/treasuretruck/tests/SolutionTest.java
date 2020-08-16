package com.amazon.treasuretruck.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.amazon.treasuretruck.model.Solution;


class SolutionTest {
	Solution solution;

	@BeforeEach
	void setUp() throws Exception {
		solution = new Solution();
	}

	@Test
	void testNumberAmazonTreasureTrucks1() {
		int rows = 5;
		int column = 4;
		List<List<Integer>> grid = new ArrayList<>();
		grid.add(Arrays.asList(1, 1, 0, 0));
		grid.add(Arrays.asList(0, 0, 1, 0));
		grid.add(Arrays.asList(0, 0, 0, 0));
		grid.add(Arrays.asList(1, 0, 1, 1));
		grid.add(Arrays.asList(1, 1, 1, 1));
		assertEquals(3, solution.numberAmazonTreasureTrucks(rows, column, grid));
	}
	
	@Test
	void testNumberAmazonTreasureTrucks2() {
		int rows = 5;
		int column = 4;
		List<List<Integer>> grid = new ArrayList<>();
		grid.add(Arrays.asList(1, 0, 1, 1));
		grid.add(Arrays.asList(0, 0, 1, 0));
		grid.add(Arrays.asList(0, 1, 0, 0));
		grid.add(Arrays.asList(1, 0, 1, 1));
		grid.add(Arrays.asList(1, 1, 0, 1));
		assertEquals(5, solution.numberAmazonTreasureTrucks(rows, column, grid));
	}
	
	@Test
	void testNumberAmazonTreasureTrucks3() {
		int rows = 3;
		int column = 4;
		List<List<Integer>> grid = new ArrayList<>();
		grid.add(Arrays.asList(1, 0, 1, 0));
		grid.add(Arrays.asList(0, 0, 1, 0));
		grid.add(Arrays.asList(0, 1, 1, 1));
		
		assertEquals(2, solution.numberAmazonTreasureTrucks(rows, column, grid));
	}

}
