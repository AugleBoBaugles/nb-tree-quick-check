import java.util.List;
import java.util.Map;

public class NbQuickCheck {

  /**
   * Performs a pre-order traversal of the tree, printing each node on a separate line.
   * Does nothing if the root is not present in the tree.
   *
   * @param tree the tree represented as a map of parent nodes to child lists
   * @param root the root node to start traversal from
   */
  public static void preOrder(Map<Integer, List<Integer>> tree, int root) {
    if(!tree.containsKey(root)) {
      return;
    }

    
    /* {1: [2, 3]}, 
     * {2: [4]},
     * {3: [5]},
     * {4: null}
     * {5: null}
    */

    System.out.println(root);

    List<Integer> children = tree.get(root);

    if (children == null){
      return;
    }

    for (var child: children){
      preOrder(tree, child);
    }
    
  }

  /**
   * Returns the minimum value in the tree.
   * Returns Integer.MAX_VALUE if the root is null.
   *
   * @param root the root node of the tree
   * @return the minimum value in the tree or Integer.MAX_VALUE if root is null
   */
  public static int minVal(Node<Integer> root) {
    if (root == null) return Integer.MAX_VALUE;

    return minVal(root, Integer.MAX_VALUE);
  }
  
  public static int minVal(Node<Integer> root, int minVal){
    // base case
    if (root.value < minVal) minVal = root.value;

    if (root.children == null) return minVal;

    for (var child : root.children){
      minVal = minVal(child, minVal);
    }


    return minVal;

  }
}
