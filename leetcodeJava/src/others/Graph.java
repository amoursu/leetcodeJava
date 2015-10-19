package others;

import java.util.*;

public class Graph {
     
	public static void main(String[] args) {
	    //  	   A
		//       /   \
		//      B     C
		//     / \   / \
		//    D   E  F  G
		//     \ /
		//      H
		Graph g = new Graph(8);
		Character[] vertices = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
		g.addVertex(vertices);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(3, 7);
		g.addEdge(4, 7);
	    g.addEdge(2, 5);
		g.addEdge(2, 6);
		System.out.println("深度优先遍历：");
		g.dfs_recursion();
		System.out.println();

		System.out.println("广度优先遍历：");
		g.bfs();
		System.out.println();

	    System.out.println("深度优先遍历非递归：");
		g.dfs_iteration();
		System.out.println();
	}


	private Object[] vertices;
	//store edges
	private int[][] arcs;
	//num of vertices
	private int vexnum;
	private boolean[] visited;
	
	public Graph(int n){
		this.vexnum = n;
		this.vertices = new Object[n];
		this.visited = new boolean[n];
		this.arcs = new int[n][n];
		for(int i = 0;i < n; i++){
			for(int j = 0;j < n; j++){
				this.arcs[i][j] = 0;
			}
		}
	}
	
	public void addVertex(Object[] obj){
		this.vertices = obj;
	}
	
	public void addEdge(int i, int j) {
	    if (i == j)
	        return;
	    this.arcs[i][j] = 1;
	    this.arcs[j][i] = 1;
	}
    
	//深度优先遍历
	public void dfs_recursion(){
		for (int i = 0; i < vexnum; i++) {
			visited[i] = false;
		}
		for(int i = 0; i < vexnum; i++){
			if(!visited[i])
				_dfs(i);
		}
	}
	
	private void _dfs(int i){
		visited[i] = true;
		visit(i);
		for(int j = this.firstAdjVex(i);j >= 0;j = this.nextAdjVex(i, j)){
			if(!visited[j])
				_dfs(j);
		}
	}
	
	//深度优先遍历
	public void dfs_iteration(){
		for (int i = 0; i < vexnum; i++) {
			visited[i] = false;
		}
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0; i < vexnum; i++){
			if(!visited[i]){
				s.add(i);
				visited[i] = true;
				while(!s.isEmpty()){
					int j = s.pop().intValue();
					visit(j);
					for (int k = this.lastAdjVex(j); k >= 0; k = this.lastAdjVex(j, k)) {
				        if (!visited[k]) {
						    s.add(k);
						    visited[k] = true;
					    }
				    }
			    }
			}
		}
	}
	
	// 最后一个
	public int lastAdjVex(int i) {
	    for (int j = vexnum - 1; j >= 0; j--) {
	        if (arcs[i][j] > 0)
	            return j;
	    }
	    return -1;
	 }

	 // 上一个
	 public int lastAdjVex(int i, int k) {
	     for (int j = k - 1; j >= 0; j--) {
	         if (arcs[i][j] > 0)
	             return j;
	     }
	     return -1;
	 }
	
	//广度优先遍历
	public void bfs(){
		for (int i = 0; i < vexnum; i++) {
			visited[i] = false;
		}
		Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < vexnum;i++){
		    if(!visited[i]){
			    q.add(i);
			    visited[i] = true;
			    visit(i);
	            while (!q.isEmpty()) {
		            int j = q.remove().intValue();
			        for (int k = this.firstAdjVex(j); k >= 0; k = this.nextAdjVex(j, k)) {
			            if (!visited[k]) {
    			            q.add(k);
	    		            visited[k] = true;
                            visit(k);
			            }
			        }
	            }
		    }
        }
	}
	
	//查找下一个节点
	public int firstAdjVex(int i) {
		for (int j = 0; j < vexnum; j++) {
		    if (arcs[i][j]>0)
		        return j;
		}
		return -1;
    }
		 
	public int nextAdjVex(int i, int k) {
	    for (int j = k + 1; j < vexnum; j++) {
		    if (arcs[i][j]>0)
		        return j;
		}
		return -1;
	}

	private void visit(int i) {
        System.out.print(vertices[i] + " ");
    }
}
