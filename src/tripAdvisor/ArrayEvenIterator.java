package tripAdvisor;

public class ArrayEvenIterator {
	int[] nums;
	int index;
	
	public ArrayEvenIterator(int[] nums) {
		this.nums = nums;
		this.index = 0;
	}
	
	public boolean hasNext() {
		return index < nums.length;
	}
	
	public int next() {
		if (!hasNext()) {
			return -1;
		}
		while ((nums[index] & 1) != 0) {
			index++;
		}
		return nums[index++];
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 7, 8};
		ArrayEvenIterator iterator = new ArrayEvenIterator(nums);
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " "); // 2 4 8
		}
	}	
}
