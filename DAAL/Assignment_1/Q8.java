package DAAL.Assignment_1;

import java.util.Scanner;

public class Q8 {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        int rank;
        TreeNode(int val){
            this.rank = 0;
            this.val = val;
        }
    }

    private TreeNode build(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }

        if(val == root.val){
            root.rank++;
            return root;
        }

        if(val < root.val){
            root.rank++;
            root.left = build(root.left, val);
        }
        else{
            root.right = build(root.right, val);
        }

        return root;
    }

    private void rank(TreeNode root, int val){
        if(root == null){
            return;
        }

        if(root.val == val){
            System.out.println(root.rank);
            return ;
        }

        if(val <= root.val){
            rank(root.left, val);
        }
        else{
            rank(root.right,val);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Q8 obj = new Q8();

        TreeNode root = null;

        for(int i = 0;i < n;i++){
            int val = scn.nextInt();

            root = obj.build(root, val);
        }
        scn.close();

        obj.rank(root, 5);
    }
}