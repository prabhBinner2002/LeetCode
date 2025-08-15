package binaryTrees.assignment;

import java.util.*;

class Solution1 {
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

    private String util(TreeNode root, List<TreeNode> ans, HashMap<String, Integer> map) {
        if (root == null) return "#";

        String left = util(root.left, ans, map);
        String right = util(root.right, ans, map);
        String key = root.val + "," + left + "," + right;

        map.put(key, map.getOrDefault(key, 0) + 1);

        if (map.get(key) == 2) {
            ans.add(root);
        }

        return key;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        util(root, ans, map);
        return ans;
    }
}

class Solution2 {
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

    private int util(TreeNode root, List<TreeNode> ans, HashMap<Integer, Integer> map, HashMap<String, Integer> strToIds, int[] numsIds) {
        if (root == null) return 0;

        int left = util(root.left, ans, map, strToIds, numsIds);
        int right = util(root.right, ans, map, strToIds, numsIds);
        String val = Integer.toString(root.val);

        String curr = "(" + left + ")" + val + "(" + right + ")";

        int currId;

        if (strToIds.containsKey(curr)) {
            currId = strToIds.get(curr);
        } else {
            currId = numsIds[0]++;
            strToIds.put(curr, currId);
        }

        map.put(currId, map.getOrDefault(currId, 0) + 1);

        if (map.get(currId) == 2) {
            ans.add(root);
        }

        return currId;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        HashMap<String, Integer> strToIds = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] numIds = {1};
        util(root, ans, map, strToIds, numIds);
        return ans;
    }
}

// Best Optimized Solution

class Solution3 {
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

    static class Triple {
        private int left, val, right;
        public Triple(int left, int val, int right) {
            this.left = left;
            this.val = val;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Triple)) return false;
            Triple other = (Triple) o;
            return this.left == other.left && this.right == other.right && this.val == other.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, val, right);
        }
    }

    private int uuid = 1;
    private List<TreeNode> ans = new ArrayList<>();
    private HashMap<Triple, Integer> treeToId = new HashMap<>();
    private HashMap<Integer, Integer> map = new HashMap<>();

    private int util(TreeNode root) {
        if (root == null) return 0;

        int left = util(root.left);
        int right = util(root.right);

        Triple key = new Triple(left, root.val, right);

        int id = treeToId.computeIfAbsent(key, k -> uuid++);

        map.put(id, map.getOrDefault(id, 0) + 1);

        if (map.get(id) == 2) {
            ans.add(root);
        }

        return id;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        util(root);
        return ans;
    }
}