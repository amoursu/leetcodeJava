package easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along 
 * the longest path from the root node down to the farthest leaf node.
 * @author zhouyan
 *
 */
public class P104_MaximumDepthOfBinaryTree {
    public int maxDepth_recursion(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth_recursion(root.left), maxDepth_recursion(root.right))+1;
    }
    
    //BFS+Queue
    public int maxDepth_iteration_BFS(TreeNode root) {
    	if(root == null)return 0;
    	int depth = 0;
    	Queue<TreeNode> level = new LinkedList<TreeNode>();
    	level.offer(root);
    	while(!level.isEmpty()){
    		depth ++;
    		int n = level.size();
    		for(int i = 0; i < n;i++){
    			TreeNode cur = level.poll();
    			if(cur.left!=null) level.offer(cur.left);
    			if(cur.right!=null) level.offer(cur.right);
    		}
    	}
    	return depth;
    }
    
    //建立两个栈，一个用来记录节点，一个用来记录节点对应的深度
    //DFS+Stack
    public int maxDepth_iteration_DFS(TreeNode root) {
    	int max = 0;
    	if(root == null) return 0;
    	Stack<TreeNode> path = new Stack<TreeNode>();
    	Stack<Integer> depth = new Stack<Integer>();
    	path.push(root);
    	depth.push(1);
    	while(!path.isEmpty()){
    		TreeNode cur = path.pop();
    		int curDepth = depth.pop();
    		if(cur.left==null && cur.right==null)
    			max = Math.max(max, curDepth);
    		else{
    			if(cur.left!=null){
    				path.push(cur.left);
    				depth.push(curDepth+1);
    			}
    			if(cur.right!=null){
    				path.push(cur.right);
    				depth.push(curDepth+1);
    			}
    		}
    	}
    	
    	return max;
    }
}
