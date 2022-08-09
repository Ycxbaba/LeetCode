package solution;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 */
public class LevelOrder3 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if(root == null)return ans;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.addFirst(root);
		boolean flag = true;
		while (!queue.isEmpty()){
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode poll = flag ? queue.removeFirst() : queue.removeLast();
				list.add(poll.val);

				if(flag){
					if(poll.left != null){
						queue.addLast(poll.left);
					}
					if(poll.right != null){
						queue.addLast(poll.right);
					}
				}else {
					if(poll.right != null){
						queue.addFirst(poll.right);
					}
					if(poll.left != null){
						queue.addFirst(poll.left);
					}
				}
			}
			flag = !flag;
			ans.add(list);
		}
		return ans;
	}
}
