// Problem: 11. Container with most water
// An integer array height of length n is given. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.
class Solution {
    public int maxArea(int[] height) {
        if(height.length==0 || height.length==1){       //If there are no lines or there is only one line of a particular height then no water can be stored
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left<right){
            int area = (right-left)*Math.min(height[left],height[right]);     //Calculating the area of water that can be stored between the two lines
            if(area>maxArea){                                                 
                maxArea = area;                                               //If the calculated area is greater than maxArea then the maxArea is the calculated area
            }
            if(height[right]<height[left]){                                   //Move from the smaller height to the next one
                right--;
            }
            else{
                left++;
            }
        }
        //return the maximum area [maximum amount of water a container can store]
        return maxArea;
    }
}
