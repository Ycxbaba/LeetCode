import javax.swing.tree.TreeNode;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepth {
	public static void main(String[] args) {

	}

	//自己写的 递归  还是有很大差距啊
	int max = 1;
	public int solution(TreeNode root) {
		if(root == null)return 0;
		back(1,root);
		return max;
	}

	private void back(int dept,TreeNode node){
		if(node.left == null && node.right == null){
			max = Math.max(max,dept);
		}
		if(node.left != null) back(dept + 1,node.left);
		if(node.right != null) back(dept + 1,node.right);
	}

	//题解 深度优先搜索
	public int solution2(TreeNode root) {
		return root == null ? 0 : Math.max(solution2(root.left),solution2(root.right)) + 1;
	}
	//题解 广度优先搜索 效率低
	public int solution3(TreeNode root) {
		if(root == null)return 0;
		Queue<TreeNode> dq = new LinkedList<>();
		dq.offer(root);
		int ans = 0;
		while (!dq.isEmpty()){
			int size = dq.size();
			while (size > 0){
				TreeNode pop = dq.poll();
				if(pop.left != null)dq.offer(pop.left);
				if(pop.right != null)dq.offer(pop.right);
				size --;
			}
			ans ++;
		}
		return ans;
	}
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
