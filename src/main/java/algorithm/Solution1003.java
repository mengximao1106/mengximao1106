package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Solution1003 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(res, root.left);
        dfs(res, root.right);
        res.add(root.val);
    }


}
