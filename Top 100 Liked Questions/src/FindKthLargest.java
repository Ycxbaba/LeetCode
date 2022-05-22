import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/
 */
public class FindKthLargest {

	public int solution1(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	//快速排序变形 使用快速降序排序， 索引为 n 的 0 ~ n-1 一定比 nums[n] 大 那么 n 一定为 第 n + 1 大的数
	//这样做不必在意数值排序顺序 只要知道 在n之前 都是比nums[n]的值就可以了 同时也根据当前n继续来排序
	//  如果当前n = k-1 返回 nums[n]
	//  如果当前n < k-1 我们继续 在 [n + 1,R]排序
	//  如果当前n > k-1 我们继续 在 [L,n - 1]排序
	//  时间复杂度 n 空间复杂度 log n(栈)
	public int solution2(int[] nums, int k) {
		return quickSelect(nums,0,nums.length-1,k-1);
	}

	Random random = new Random();
	//迭代
	public int quickSelect2(int[] a, int l, int r, int index) {
		while (true){
			int q = randomPartition(a,l,r);
			if(q == index){
				return q;
			}else if(q > index){
				r = q-1;
			}else {
				l = q+1;
			}
		}
	}
	//使用递归
	public int quickSelect(int[] a, int l, int r, int index) {
		int q = randomPartition(a,l,r);
		if(q == index){
			return a[q];
		}else {
			return q < index ? quickSelect(a,q+1,r,index) : quickSelect(a,l,q-1,index);
		}
	}

	public int randomPartition(int[] a, int l, int r) {
		int i = random.nextInt(r - l + 1) + l;
		swap(a,i,r);
		return partition(a,l,r);
	}

	public int partition(int[] a, int l, int r) {
		int x = a[r],j = l - 1;
		for (int i = l ; i < r; i++) {
			if(a[i] >= x){
				swap(a,++j,i);
			}
		}
		swap(a,r,j+1);
		return j+1;
	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	//堆排序
	public int solution3(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int num : nums) {
			queue.add(num);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		return queue.peek();
	}

}
