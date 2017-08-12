package tripAdvisor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionTwoArray {
	
	// HashSet, O(n) time, O(n) space
	public static List<Integer> findIntersection(int[] nums1, int[] nums2) {
		List<Integer> res = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		for (int i : nums1) {
			set.add(i);
		}
		for (int i : nums2) {
			if (set.contains(i)) {
				res.add(i);
			}
		}
		return res;
	}
	
	// sort + binary search, O(nlogn) time, O(1) space
	public static List<Integer> findIntersection2(int[] nums1, int[] nums2) {
		List<Integer> res = new ArrayList<Integer>();
		Arrays.sort(nums1);
		for (int i : nums2) {
			if (binarySearch(nums1, i)) {
				res.add(i);
			}
		}
		return res;
	}
	
	private static boolean binarySearch(int[] nums, int i) {
		int left = 0;
		int right = nums.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == i) {
				return true;
			} else if (nums[mid] < i) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return nums[left] == i || nums[right] == i;
	}
	
	// unit test
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 4, 5};
		int[] nums2 = {7, 8, 2, 3, 5};
		System.out.println(findIntersection(nums1, nums2)); // 2 3 5
	}
}
