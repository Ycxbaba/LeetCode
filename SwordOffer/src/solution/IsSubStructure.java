package solution;

import bean.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsSubStructure {
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		if(B == null || A == null)return false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(A);
		while (!queue.isEmpty()){
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				if(poll.val == B.val && dfs(poll,B)){
					return true;
				}
				if(poll.left != null)queue.offer(poll.left);
				if(poll.right != null)queue.offer(poll.right);
			}

		}
		return false;
	}

	public boolean isSubStructureBest(TreeNode A, TreeNode B) {
		return (A != null && B != null) && (dfs(A,B) || isSubStructureBest(A.left,B) || isSubStructureBest(A.right,B));
	}

	private boolean dfs(TreeNode a, TreeNode b) {
		if(b == null)return true;
		if(a == null || a.val != b.val)return false;
		return dfs(a.left,b.left) && dfs(a.right,b.right);
	}

	public static void main(String[] args) {
		IsSubStructure isSubStructure = new IsSubStructure();
		TreeNode A = new TreeNode(3);
		A.left = new TreeNode(4);
		A.right = new TreeNode(5);
		A.left.left = new TreeNode(1);
		A.left.right = new TreeNode(2);
		TreeNode B = new TreeNode(4);
		B.left = new TreeNode(1);
		System.out.println(isSubStructure.isSubStructure(A, B));
	}
}
