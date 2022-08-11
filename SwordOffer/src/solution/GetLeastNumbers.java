package solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
 */
public class GetLeastNumbers {
	public int[] getLeastNumbers(int[] arr, int k) {
		Arrays.sort(arr);
		return Arrays.copyOf(arr,k);
	}

	public int[] getLeastNumbers2(int[] arr, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
		for (int i = 0; i < k; i++) {
			queue.offer(arr[i]);
		}
		for (int i = k; i < arr.length; i++) {
			if(queue.peek() > arr[i]){
				queue.poll();
				queue.offer(arr[i]);
			}
		}
		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = queue.poll();
		}
		return ans;
	}
	/**
	 *  public int[] getLeastNumbers3(int[] arr, int k) {
	 * 		randomizedSelected(arr, 0, arr.length - 1, k);
	 * 		int[] vec = new int[k];
	 * 		for (int i = 0; i < k; ++i) {
	 * 			vec[i] = arr[i];
	 *                }
	 * 		return vec;
	 * 	}
	 *
	 * 	private void randomizedSelected(int[] arr, int l, int r, int k) {
	 * 		if (l >= r) {
	 * 			return;
	 *        }
	 * 		int pos = randomizedPartition(arr, l, r);
	 * 		int num = pos - l + 1;
	 * 		if (k == num) {
	 * 			return;
	 *        } else if (k < num) {
	 * 			randomizedSelected(arr, l, pos - 1, k);
	 *        } else {
	 * 			randomizedSelected(arr, pos + 1, r, k - num);
	 *        }
	 *    }
	 *
	 * 	// 基于随机的划分
	 * 	private int randomizedPartition(int[] nums, int l, int r) {
	 * 		int i = new Random().nextInt(r - l + 1) + l;
	 * 		swap(nums, r, i);
	 * 		return partition(nums, l, r);
	 *    }
	 *
	 * 	private int partition(int[] nums, int l, int r) {
	 * 		int pivot = nums[r];
	 * 		int i = l - 1;
	 * 		for (int j = l; j <= r - 1; ++j) {
	 * 			if (nums[j] <= pivot) {
	 * 				i = i + 1;
	 * 				swap(nums, i, j);
	 *            }
	 *        }
	 * 		swap(nums, i + 1, r);
	 * 		return i + 1;
	 *    }
	 */

	// arr = [0,3,2,1], k = 1
	// arr = [0,3,1,2], k = 1
	// 自己实现一个
	public int[] getLeastNumbers3(int[] arr, int k) {
		randomizedSelected(arr,0,arr.length - 1,k);
		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = arr[i];
		}
		return ans;
	}

	private void randomizedSelected(int[] arr, int l, int r, int k) {
		if(l >= r)return;
		int pos = randomizedPartition(arr, l, r);
		int k1 = pos - l + 1;
		if(k1 == k){
			return;
		}else if(k1 < k){
			randomizedSelected(arr,pos + 1,r,k - k1);
		}else {
			randomizedSelected(arr,l,pos - 1,k);
		}
	}

	private int randomizedPartition(int[] nums, int l, int r){
		int random = new Random().nextInt(r - l + 1) + l;
		swap(nums,random,r);
		return partition(nums,l,r);
	}

	private int partition(int[] nums, int l, int r) {
		int norm = nums[r];
		int index = l;
		for (int i = l; i < r; i++) {
			if(norm >= nums[i]){
				swap(nums,index,i);
				index ++;
			}
		}
		swap(nums,index,r);
		return index;
	}
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
