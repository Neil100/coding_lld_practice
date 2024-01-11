package com.example.coding;

public class SerializeBinaryTree {

	public class TreeNode {int val;TreeNode left;TreeNode right;TreeNode(int x) { val = x; }}

    // Encodes a tree to a single string.
	   public String serialize(TreeNode root) {
	    	if (root==null)
	    		return "";
	    	StringBuffer sol = inOrderSerialize(root);
	        return sol.toString();
	    }

	    private StringBuffer inOrderSerialize(TreeNode root) {
	    	
	    	StringBuffer str = new StringBuffer(); 
	    	str.append(",");
	    	str.append(root.val);
	    	
	    	if(root.left == null) {
	    		str = str.append(",A");
	    	} else {
	    		str = str.append(inOrderSerialize(root.left));
	    	}
	    	
	    	if(root.right == null) {
	    		str = str.append(",A");
	    	} else {
	    		str = str.append(inOrderSerialize(root.right));
	    	}
	 
			return str;
		}

		// Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	    	String[] tree = data.split(",");
	    	if(data.length()==0)
	    		return null;
	    	
	        int[] index = {1};
	    	return inOrderDeserialize(tree, index);
	    }
	    
	    public TreeNode inOrderDeserialize(String[] data, int[] index) {
	    	TreeNode node = new TreeNode(Integer.parseInt(data[index[0]]));
	    	index[0]++;
	    	if(data[index[0]].equals("A")) {
	    		node.left = null;
	    	} else {
	    		node.left = inOrderDeserialize(data, index);
	    	}
	    	index[0]++;
	    	if(data[index[0]].equals("A")) {
	    		node.right = null;
	    	} else {
	    		node.right = inOrderDeserialize(data, index);
	    	}
	    	
	    	return node;
	    }
}
