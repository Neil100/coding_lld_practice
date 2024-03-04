package com.example.coding;

public class KthSmallestElement {

//      Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public int kthSmallest(TreeNode root, int k) {
        int[] kk = new int[1];
        kk[0] = k;
        return inorderTraversal(root, kk);
    }

    int inorderTraversal(TreeNode root, int[] k) {
          int sol = Integer.MAX_VALUE;
          if(root.left!=null) {
              sol = inorderTraversal(root.left, k);
          }
          if(--k[0]==0) {
                return root.val;
          } else if(k[0]<0) {
              return sol;
          }
          if(root.right!=null) {
              return inorderTraversal(root.right, k);
          }
          return sol;
    }
}
