import java.util.HashMap;

public class TwoSum {

	//暴力搜素
	//空间复杂度 O(1)
	//时间复杂度 O(n*n(n-1)/2) 约 O(n^2)
	public int[] solution1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target){
					return new int[]{i,j};
				}
			}
		}
		return null;
	}

	//hash
	//空间复杂度 O(N)
	//时间复杂度 O(N)
	public int[] solution2(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(target-nums[i])){
				return new int[]{map.get(target-nums[i]),i};
			}
			map.put(nums[i],i);
		}
		return null;
	}

}

