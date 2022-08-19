package Sort;

import Bitwise.Solution;

import java.util.Arrays;

//十大排序
public class Sort {
	//冒泡排序
	public void bubbleSort(int[] nums){
		int len = nums.length;
		boolean flag = true;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if(nums[j] > nums[j+1]){
					swap(nums,j,j+1);
					flag = false;
				}
			}
			if(flag){
				break;
			}else {
				flag = true;
			}

		}
		System.out.println(Arrays.toString(nums));
	}
	private void swap(int[] nums,int i,int j){
		if(nums[i] == nums[j])return;
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}

	public void selectSort(int[] nums){
		for (int i = 0; i < nums.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < nums.length; j++) {
				if(nums[j] < nums[minIndex]){
					minIndex = j;
				}
			}
			if(i != minIndex){
				swap(nums,i,minIndex);
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	public void insertSort(int[] nums){
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] < nums[i - 1]){
				int num = nums[i];
				int j = i;
				while (j > 0 && nums[j-1] > num){
					nums[j] = nums[j-1];
					j--;
				}
				if(j != i){
					nums[j] = num;
				}
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	public void shellSort(int[] nums){
		for (int step = nums.length >> 1; step >=1; step >>= 1) {
			for (int i = step; i < nums.length; i++) {
				int num = nums[i];
				int j = i - step;
				while (j >= 0 && nums[j] > num){
					nums[j + step] = nums[j];
					j -= step;
				}
				nums[j + step] = num;
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	public void quickSort(int[] nums){
		quickSort(nums,0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}

	private void quickSort(int[] nums,int left,int right){
		if(left < right){
			int mid = partition(nums,left,right);
			quickSort(nums,left,mid-1);
			quickSort(nums,mid+1,right);
		}
	}

	private int partition(int[] nums,int left,int right){
		int base = nums[left];
		int index = left + 1;
		for (int i = index; i <= right; i++) {
			if(nums[i] < base){
				swap(nums,i,index);
				index++;
			}
		}
		swap(nums,left,index - 1);
		return index - 1;
	}
	private void mergeSort(int[] nums){
		nums = mergeSortTrue(nums);
		System.out.println(Arrays.toString(nums));
	}

	private int[] mergeSortTrue(int[] nums){
		if(nums.length <= 1)return nums;
		int mid = nums.length >> 1;
		//分
		int[] left = Arrays.copyOfRange(nums,0,mid);
		int[] right = Arrays.copyOfRange(nums,mid,nums.length);
		//治
		return merge(mergeSortTrue(left),mergeSortTrue(right));

	}
	private int[] merge(int[] left,int[] right){
		int[] nums = new int[left.length + right.length];
		int l = 0;
		int r = 0;
		int index = 0;
		while (l < left.length && r < right.length){
			if (left[l] > right[r]){
				nums[index++] = right[r++];
			}else{
				nums[index++] = left[l++];
			}
		}
		while (l < left.length){
			nums[index++] = left[l++];
		}

		while (r < right.length){
			nums[index++] = right[r++];
		}

		return nums;
	}
	//          5
	//      4       3
	//    2   1   7   8
	public void heapSort(int[] nums){
		int len = nums.length;
		for (int i = len / 2 - 1 ; i >= 0 ; i--) {
			heapily(nums,len,i);
		}
		for (int i = len - 1; i >= 0 ; i--) {
			swap(nums,0,i);
			heapily(nums,--len,0);
		}
		System.out.println(Arrays.toString(nums));

	}

	private void heapily(int[] nums,int len,int index){
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int i = index;
		if(left < len && nums[index] < nums[left]){
			index = left;
		}
		if(right < len && nums[index] < nums[right]){
			index = right;
		}
		if(index != i){
			swap(nums,index,i);
			heapily(nums,len,index);
		}
	}

	public void countSort(int[] nums){
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			if (num > max) max = num;
		}
		int[] map = new int[max + 1];
		int index = 0;
		for (int num : nums) {
			map[num]++;
		}
		for (int i = 0; i < map.length; i++) {
			while (map[i] > 0){
				nums[index++] = i;
				map[i]--;
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	public void bucketSort(int[] nums){
		int bucketSize = 4;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int num : nums) {
			if(num > max)max = num;
			if(num < min)min = num;
		}
		int bucketCount = (max - min) / bucketSize + 1;
		int[][] buckets = new int[bucketCount][0];
		for (int num : nums) {
			int index = (num - min) / bucketSize;
			buckets[index] = arrAppend(buckets[index], num);
		}
		int index = 0;
		for (int[] bucket : buckets) {
			if(bucket.length < 1)continue;
			for (int i = 1; i < bucket.length; i++) {
				int num = bucket[i];
				int j = i;
				while (j > 0 && bucket[j - 1] > num){
					bucket[j] = bucket[j-1];
					j--;
				}
				if(i != j){
					bucket[j] = num;
				}
			}
			for (int num : bucket) {
				nums[index++] = num;
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	private int[] arrAppend(int[] arr, int value) {
		arr = Arrays.copyOf(arr, arr.length + 1);
		arr[arr.length - 1] = value;
		return arr;
	}

	public void radixSort(int[] nums){
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			if(num > max)max = num;
		}
		int len = 0;
		if(max != 0){
			while (max != 0){
				max = max / 10;
				len ++;
			}
		}else {
			len++;
		}
		int mod = 10;
		int dev = 1;
		for (int i = 0; i < len; i++,mod*=10,dev*=10) {
			int[][] buckets = new int[20][0];
			for (int num : nums) {
				int index = (num % mod) / dev + 10;
				buckets[index] = arrAppend(buckets[index], num);
			}
			int pos = 0;
			for (int[] bucket : buckets) {
				for (int num : bucket) {
					nums[pos++] = num;
				}
			}
		}
		System.out.println(Arrays.toString(nums));
	}



	public static void main(String[] args) {
		Sort sort = new Sort();
		int[] nums = {-1,5, 4, 3, -2, 2, 1, 1, 7, 8, 0, 15,105};
		System.out.println(Arrays.toString(nums));
		// sort.bubbleSort(nums);
		// sort.selectSort(nums);
		// sort.insertSort(nums);
		// sort.shellSort(nums);
		// sort.quickSort(nums);
		// sort.mergeSort(nums);
		// sort.heapSort(nums);
		// sort.countSort(nums);
		// sort.bucketSort(nums);
		sort.radixSort(nums);
	}
}
