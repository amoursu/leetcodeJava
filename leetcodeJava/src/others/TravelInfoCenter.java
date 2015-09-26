package others;

import java.util.*;

public class TravelInfoCenter {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        Graph g = new TravelInfoCenter().new Graph(n);
        for(int i = 0; i < n-1; i++){
        	g.addEdge(scan.nextInt(), scan.nextInt());
        }
        for(int j = 0; j < m; j++){
        	if(scan.nextInt() == 1){
        		g.changeToFestiveCity(scan.nextInt());
        	}else{
        		System.out.println(g.queryByBfs(scan.nextInt()));
        	}
        }
        scan.close();
	}
	
	class Graph{
		//store edges
		private List<Integer>[] arcs;
		//num of vertices
		private int vexnum;
		private boolean[] festive;
		
		@SuppressWarnings("unchecked")
		public Graph(int n){
			this.vexnum = n;
			this.arcs = new List[n];
			this.festive = new boolean[n];
			for(int i = 0;i < n; i++){
					this.arcs[i] = new ArrayList<Integer>();
			}
			this.festive[0] = true;
			for(int i = 1;i < n; i++){
				this.festive[i] = false;
			}
		}
		
		public void changeToFestiveCity(int i){
			this.festive[i -1] = true;
		}
		
		public void addEdge(int i, int j) {
		// TODO Auto-generated method stub
		    if (i == j)
		        return;
		    this.arcs[i-1].add(j-1);
		    this.arcs[j-1].add(i-1);
		}
	    
		public int queryByBfs(int vi){
			if(this.festive[vi-1])
				return 0;
			boolean[] visited = new boolean[vexnum];
			for (int i = 0; i < vexnum; i++) {
				visited[i] = false;
			}
			//use for record deep
			int[] deep = new int[vexnum];
			for(int i = 0; i < vexnum; i++){
				deep[i] = 0;
			}
			Queue<Integer> q = new LinkedList<Integer>();
		    visited[vi-1] = true;
		    q.add(vi-1);
		    while (!q.isEmpty()) {
			    int j = q.remove().intValue();
				for (int k = this.firstAdjVex(j); k >= 0; k = this.nextAdjVex(j, k)) {
				    if (!visited[k]) {
				    	deep[k] = deep[j] + 1;
				        q.add(k);
				        visited[k] = true;
				        if(this.festive[k])
				        	return deep[k];
				    }
				}
		    }
		    
		    return -1;
		}
		
		public int firstAdjVex(int i) {
			for (int j = 0; j < vexnum; j++) {
			    if (arcs[i].contains(j))
			        return j;
			}
			return -1;
	    }
			 
		public int nextAdjVex(int i, int k) {
		    for (int j = k + 1; j < vexnum; j++) {
			    if (arcs[i].contains(j))
			        return j;
			}
			return -1;
		}
	}
}
