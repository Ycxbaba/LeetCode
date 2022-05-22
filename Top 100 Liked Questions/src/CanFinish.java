import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/course-schedule/
 */
public class CanFinish {
	public static void main(String[] args) {

	}
	List<List<Integer>> edges;
	int[] visited;
	boolean valid = true;

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<List<Integer>>();
		for (int i = 0; i < numCourses; ++i) {
			edges.add(new ArrayList<Integer>());
		}
		visited = new int[numCourses];
		for (int[] info : prerequisites) {
			edges.get(info[1]).add(info[0]);
		}
		for (int i = 0; i < numCourses && valid; ++i) {
			if (visited[i] == 0) {
				dfs(i);
			}
		}
		return valid;
	}

	public void dfs(int u) {
		visited[u] = 1;
		for (int v: edges.get(u)) {
			if (visited[v] == 0) {
				dfs(v);
				if (!valid) {
					return;
				}
			} else if (visited[v] == 1) {
				valid = false;
				return;
			}
		}
		visited[u] = 2;
	}

	public boolean canFinish_self(int numCourses, int[][] prerequisites) {
		edges = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			//初始化
			edges.add(new ArrayList<>());
		}
		for (int[] prerequisite : prerequisites) {
			//放入数据
			edges.get(prerequisite[0]).add(prerequisite[1]);
		}
		visited = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			//未搜索到过
			if(visited[i] == 0){
				dfs_self(i);
			}
		}
		return valid;
	}

	public void dfs_self(int u) {
		//将当前状态设置为 1 正在搜索
		visited[u] = 1;
		for (Integer v : edges.get(u)) {
			//没有搜到过 状态为0
			if(visited[v] == 0){
				dfs_self(v);
				//dfs过程中发现了环，没必要继续执行，直接返回
				if(!valid){
					return;
				}
			}else if(visited[v] == 1){
				//搜到正在处于搜索状态的，说明形成了环，不符合要求，置成false,返回
				valid = false;
				return;
			}
		}
		//已经搜索完成了，没有发现环，状态为 2
		visited[u] = 2;
	}

}
