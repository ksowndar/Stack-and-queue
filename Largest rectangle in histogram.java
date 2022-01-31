Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
  
  
  class Solution {
    public int largestRectangleArea(int[] heights) {
        int area=0,l=heights.length;
        Stack<Integer> stack=new Stack();
        
        for(int i=0;i<=l;i++)
        {
            while(!stack.isEmpty() && (i==l || heights[stack.peek()]>heights[i]))
            {
                int h=heights[stack.pop()];
                int left=stack.isEmpty() ? -1 : stack.peek();
                area=Math.max(area,(i-left-1)*h);
            }
            stack.push(i);
        }
        return area;        
    }
}
