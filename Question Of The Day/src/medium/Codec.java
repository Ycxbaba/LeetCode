package medium;

import java.util.ArrayList;

/**
 * https://leetcode.cn/problems/serialize-and-deserialize-bst/
 */
public class Codec {
	public static void main(String[] args) {
		Codec codec = new Codec();
		String s = "2,1,3";
		TreeNode treeNode = codec.deserialize(s);
		String serialize = codec.serialize(treeNode);
		System.out.println("ok");
	}

	//序列化
	public String serialize(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		// head(root,list);
		after(root,list);
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			ans.append(list.get(i));
			if(i != list.size()-1)ans.append(",");
		}
		return ans.toString();
	}
	//采取前序遍历
	private void head(TreeNode root,ArrayList<Integer> list){
		if(root == null){
			return ;
		}
		list.add(root.val);
		head(root.left,list);
		head(root.right,list);
	}
	//后续遍历
	private void after(TreeNode root,ArrayList<Integer> list){
		if(root != null){
			after(root.left,list);
			after(root.right,list);
			list.add(root.val);
		}
	}

	//反序列化
	public TreeNode deserialize(String data) {
		if(data.length() == 0)return null;
		String[] strings = data.split(",");
		// return bfs(0,strings.length-1,strings);
		return bfs2(0,strings.length-1,strings);
	}
	//利用搜索二叉树特性重建
	private TreeNode bfs(int left,int right,String[] strings){
		if(left > right)return null;
		int mid = left + 1;
		int val = Integer.parseInt(strings[left]);
		TreeNode treeNode = new TreeNode(val);
		while (mid <= right && Integer.parseInt(strings[mid]) <= val)mid++;
		//构建左子树
		treeNode.left = bfs(left+1,mid-1,strings);
		//构建右子树
		treeNode.right = bfs(mid,right,strings);
		return treeNode;
	}

	private TreeNode bfs2(int left,int right,String[] strings){
		if (left > right)return null;
		int mid = right -1;
		int val = Integer.parseInt(strings[right]);
		TreeNode treeNode = new TreeNode(val);
		while (mid >= left && val <= Integer.parseInt(strings[mid]))mid--;
		treeNode.right = bfs2(mid+1,right-1,strings);
		treeNode.left = bfs2(left,mid,strings);
		return treeNode;
	}
	private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
	}
}
