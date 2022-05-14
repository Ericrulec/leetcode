package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArraysAndHashing {
	
	/** Create a hashset so that we can compare new integers to the hashset
	 *  and if we have seen them before return true.
	 * @param nums
	 * @return 
	 */
	public boolean containsDuplicate(int[] nums) {
		
		Set<Integer> numbers = new HashSet<Integer>();
		for (int num : nums) {
			if (numbers.contains(num)) return true;
			numbers.add(num);
		}
		return false;
	}
	
	public boolean isAnagram(String s, String t) {
		
		if (s.length() != t.length()) return false;
		if (s.equals(t)) return true;
		
		Map<Character, Integer> sMap = new HashMap<>();
		Map<Character, Integer> tMap = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			sMap.merge(s.charAt(i), 1, Integer::sum);
			tMap.merge(t.charAt(i), 1, Integer::sum);
		}
		for (Character c : sMap.keySet()) {
			if(!sMap.get(c).equals(tMap.get(c))) return false;
		}
		return true;
	}
	/** Given an array of integers, return indices of two numbers that
	 *  add up to target.
	 * @param nums
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return new int[]{map.get(nums[i]), i};
			}
			map.put(target - nums[i], i);
		}
		return new int[0];
	}
	/** Given an array of integers, return true if they can sum up to
	 * target.
	 * @param target
	 * @param nums
	 * @param memo
	 * @return
	 */
	public boolean canSum(int target, int[] nums, Map<Integer, Boolean> map) {
		if (map.containsKey(target)) return map.get(target);
		if (target == 0) return true;
		if (target < 0) return false;
		
		for (int num : nums) {
			int remainder = target - num;
			if (canSum(remainder, nums, map)) {
				map.put(target, true);
				return true;
			}
		}
		map.put(target, false);
		return false;
	}
	/** Given an array of numbers, return list of integers that 
	 *  sum up to target.
	 * @param target
	 * @param nums
	 * @param map
	 * @return
	 */
	public int[] howSum(int target, int[] nums, Map<Integer, int[]> map) {
		if (map.containsKey(target)) return map.get(target);
		if (target == 0) return new int[0];
		if (target < 0) return null;
		
		for (int num : nums) {
			int remainder = target - num;
			int[] remainderResult = howSum(remainder, nums, map);
			if (remainderResult != null) {
				map.put(num, remainderResult);
				return map.get(target);
			}
		}
		map.put(target, null);
		return null;
	}
	/** Given an array with strings, return true if we can construct the
	 *  target string with strings in the list.
	 * @param target
	 * @param list
	 * @param map
	 * @return
	 */
	public boolean canConstruct(String target, String[] list, Map<String, Boolean> map) {
		if (map.containsKey(target)) return map.get(target);
		if (target == "") return true;
		for (String word : list) {
			if (target.indexOf(word)==0) {
				String suffix = target.substring(word.length());
				if (canConstruct(suffix, list, map)) {
					map.put(target, true);
					return true;
				}
			}
		}
		map.put(target, false);
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
