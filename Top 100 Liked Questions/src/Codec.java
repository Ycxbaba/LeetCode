import java.net.Socket;

/**
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 */
public class Codec {

	public static void main(String[] args) {
		Codec codec = new Codec();
		TreeNode deserialize = codec.deserialize("1,2,3,null,null,4,5");
	}

	public String serialize(TreeNode root) {
		if(root == null)return "null";
		StringBuffer stringBuffer = new StringBuffer();
		pre(root,stringBuffer);
		stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
		return stringBuffer.toString();
	}

	private void pre(TreeNode root , StringBuffer stringBuffer){
		if(root == null){
			stringBuffer.append("null");
			stringBuffer.append(",");
			return;
		}
		stringBuffer.append(root.val);
		stringBuffer.append(",");
		pre(root.left,stringBuffer);
		pre(root.right,stringBuffer);
	}

	public TreeNode deserialize(String data) {
		String[] strings = data.split(",");
		return dePre(strings);
	}

	int index = 0;

	private TreeNode dePre(String[] strings){
		if(index == strings.length)return null;
		String s = strings[index];
		index ++;
		if (s.equals("null")) {
			return null;
		}
		TreeNode node = new TreeNode(Integer.parseInt(s));
		node.left = dePre(strings);
		node.right = dePre(strings);

		return node;
	}

	private static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}
