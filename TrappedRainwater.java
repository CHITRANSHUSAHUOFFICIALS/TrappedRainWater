package Array;

import java.util.Arrays;

public class TrappedRainwater {
				
	public static void main(String[] args) {
		int [] height = {4,2,0,6,3,2,5};
		int size = 1;
		int trappedRainwater = trappedRainWater(height,size);
		System.out.println(trappedRainwater);
	}

	private static int trappedRainWater(int[] height,int size) {
		
		//left max height
			int [] leftMax = new int[height.length];
			leftMax[0] = height[0];
			
			for (int i = 1; i < leftMax.length; i++) {
				leftMax[i] = Math.max(height[i],leftMax[i-1]);
			}
			
		//Right max height
			int [] rightMax = new int [height.length];
			rightMax[rightMax.length-1] = height[height.length-1];
			
			for (int i = rightMax.length-2; i >= 0 ; i--) {
				rightMax[i]=Math.max(height[i], rightMax[i+1]);		
			}
			
		//loop
			
			int trappedWater = 0;
			for (int i = 0; i < height.length; i++) {
				
				//waterLevel = min(leftMax,rightMax)
				int waterLevel = Math.min(leftMax[i], rightMax[i]);
				
				//trapped water = (waterLevel - height[i]) * size
				trappedWater = trappedWater + ((waterLevel-height[i])*size);
			}
		
		return trappedWater;
	}
}