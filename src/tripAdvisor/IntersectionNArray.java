package tripAdvisor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class IntersectionNArray implements Iterable<Integer> {
	
	// HashSet, O(n^2) time, O(n) space
	public static List<Integer> findIntersection(List<List<Integer>> nums) {
		Set<Integer> set = new HashSet<Integer>();		
		for (int i : nums.get(0)) {
			set.add(i);
		}
		for (int j = 1; j < nums.size(); j++) {
			Set<Integer> miniSet = new HashSet<Integer>();
			List<Integer> temp = nums.get(j);
			for (Integer i : temp) {
				if (set.contains(i)) {
					miniSet.add(i);
				}
			}
			set = miniSet;
		}
		return new ArrayList<Integer>(set);
	}
	
	public Iterator<Integer> iterator() {
		Iterator<Integer> it = new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
			
		};
		return it;
	}
	
	public static void main(String[] args) {
		Integer[] nums1 = {1, 2, 3, 4, 5};
		Integer[] nums2 = {7, 8, 2, 3, 5};
		Integer[] nums3 = {1, 2, 4, 3};
		List<List<Integer>> nums = new ArrayList<List<Integer>>();
		List<Integer> l1 = Arrays.asList(nums1);
		List<Integer> l2 = Arrays.asList(nums2);
		List<Integer> l3 = Arrays.asList(nums3);
		nums.add(l1);
		nums.add(l2);
		nums.add(l3);
		System.out.println(findIntersection(nums)); // 2 3
		
		
	}	
}
