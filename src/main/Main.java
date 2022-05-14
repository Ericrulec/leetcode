package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import code.ArraysAndHashing;

public class Main {
	
	public static void main(String[] args) {
		ArraysAndHashing test = new ArraysAndHashing();
		int[] nums = {1,2,3,5};
		int[] nums2 = {7,14};
		int target = 8;
		int target2 = 300;
		int[] result = test.twoSum(nums,target);
		System.out.println("twoSum with nums: "+Arrays.toString(nums)+", and target "+target+"\nResult: "+Arrays.toString(result));
		
		
		Map<Integer, Boolean> map = new HashMap<>();
		System.out.println("canSum with nums: "+Arrays.toString(nums)+", and target "+target+"\nResult: "+test.canSum(target,nums,map));
		Map<Integer, Boolean> map2 = new HashMap<>();
		System.out.println("canSum with nums: "+Arrays.toString(nums2)+", and target "+300+"\nResult: "+test.canSum(300,nums2,map2));
//		Map<Integer, int[]> map3 = new HashMap<>();
//		System.out.println("canSum with nums: "+Arrays.toString(nums2)+", and target "+300+"\nResult: "+test.howSum(300,nums2,map3));
	}
}
