import java.util.ArrayList;
import java.util.List;


public class Solution {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result = new ArrayList<>();

        if (N % 2 == 0) {
            return result;
        }

        if (N == 1) {
            result.add(new TreeNode(0));
            return result;
        }

        for (int i = 1; i < N - 1; i += 2) {
            List<TreeNode> leftSubtrees = allPossibleFBT(i);
            List<TreeNode> rightSubtrees = allPossibleFBT(N - 1 - i);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        return result;
    }

    private static void printTree(TreeNode root, int level) {
        if (root == null) {
            return;
        }
    }
}

