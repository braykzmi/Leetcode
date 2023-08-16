
class Solution {
    private int preIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        return buildTreeHelper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preIndex++]);

        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == node.val) {
                inIndex = i;
                break;
            }
        }

        node.left = buildTreeHelper(preorder, inorder, inStart, inIndex - 1);
        node.right = buildTreeHelper(preorder, inorder, inIndex + 1, inEnd);

        return node;
    }
}
