package practice;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DfsExample {

	static int[][] graph;
	public static void main(String[] args) {
		init();

	}


	public static void dfs(){
		int currentVertex=1;
		Stack<Integer> currentPath = new Stack<>();
		Set<Integer> traversed=new HashSet<>();
		
		currentPath.push(currentVertex);
		traversed.add(currentVertex);
		
		while(!currentPath.empty()){
			currentVertex=currentPath.peek();
			int neighborCount =graph[currentVertex][0];
			
			if (neighborCount > 0) {
				for (int i = 1; i <= neighborCount; i++) {
					int neighbor=graph[currentVertex][i];
					
					if (!traversed.contains(neighbor)) {
						currentPath.push(neighbor);
						traversed.add(neighbor);
					}
					
					graph[currentVertex][0]--;
				}
			}else{
				currentPath.pop();
			}
		}
	}
	
	private static void init() {
		graph=new int[8][8];
		graph[1][0]=1;
		graph[1][1]=2;
		
		graph[2][0]=1;
		graph[2][1]=1;
		graph[2][2]=6;
		graph[2][3]=7;
		
		graph[3][0]=1;
		graph[3][1]=5;
		
		graph[4][0]=1;
		graph[4][1]=7;
		
		graph[5][0]=1;
		graph[5][1]=3;
		graph[5][2]=6;
		
		graph[6][0]=1;
		graph[6][1]=2;
		graph[6][2]=5;
		
		graph[7][0]=1;
		graph[7][1]=2;
		graph[7][2]=4;
		
	}
}
