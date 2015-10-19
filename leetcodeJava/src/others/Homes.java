package others;

import java.util.Stack;
public class Homes 
{
	
	public static void main(String[] args){
		int grid[][] = {{0,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,0}};
		System.out.println(countHomes(grid));
	}
    public static int countHomes(int grid[][])
    {
        if(grid == null || grid.length == 0 || grid[0].length == 0) 
            return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        Stack<Integer> rowStack = new Stack<Integer>();
    	Stack<Integer> colStack = new Stack<Integer>();
    	int x,y;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] == 1) {
                	rowStack.clear();
                	colStack.clear();
                	rowStack.push(i);
                	colStack.push(j);
                	while(!rowStack.isEmpty()){
                		x = rowStack.pop();
                		y = colStack.pop();
                		grid[x][y] = 0;
                		if(x > 0 && grid[x-1][y] == 1) {
                			rowStack.push(x-1);
                			colStack.push(y);
                        }
                        if(x < grid.length - 1 && grid[x+1][y] == 1) {
                        	rowStack.push(x+1);
                			colStack.push(y);
                        }
                        if(y > 0 && grid[x][y-1] == 1) {
                        	rowStack.push(x);
                			colStack.push(y-1);
                        }
                        if(y < grid[0].length - 1 && grid[x][y+1] == 1) {
                        	rowStack.push(x);
                			colStack.push(y+1);
                        }
                	}
                    count++;
                }
            }
        }
        return count;
    }
}