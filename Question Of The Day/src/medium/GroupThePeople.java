package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/
 */
public class GroupThePeople {
	public List<List<Integer>> groupThePeople(int[] groupSizes) {
		List<List<Integer>> list = new ArrayList<>();
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		for (int i = 0; i < groupSizes.length; i++) {
			List<Integer> group = map.computeIfAbsent(groupSizes[i], k -> new ArrayList<>());
			group.add(i);
			if(group.size() == groupSizes[i]){
				list.add(new ArrayList<>(group));
				group.clear();
			}
		}
		return list;
	}

	public static void main(String[] args) {
		GroupThePeople people = new GroupThePeople();
		people.groupThePeople(new int[]{
				3,3,3,3,3,1,3});
	}
}
