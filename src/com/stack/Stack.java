package com.stack;

public class Stack {

	public int largestRectangleArea(int[] heights) {

		java.util.Stack<Integer> stack = new java.util.Stack<>();
		int max = 0;
		int i=0;
		
		while(i<heights.length) {
			if (stack.empty() || heights[i] > heights[stack.peek()]) {
				stack.push(i++);
			} else if(heights[i] < heights[stack.peek()]){
				while (!stack.empty() && heights[i] < heights[stack.peek()]) {
					int breadth = stack.pop();
					int area = heights[breadth]  * (stack.empty() ? i : i - stack.peek() - 1);
					max = Math.max(area, max);
					System.out.println(heights[breadth]);
				}
			}
		}
		while (!stack.empty()) {
			int breadth = stack.pop();
			int area = heights[breadth] * (stack.empty() ? heights.length : heights.length - stack.peek() - 1);
			max = Math.max(area, max);
			System.out.println(heights[breadth]);
		}
		return max;
	}
}
