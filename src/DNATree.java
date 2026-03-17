
/**
 * Implement a DNA Tree
 *
 * @author Vishana Baskaran and Sital Paudel
 * @version 3/13/26
 */
public class DNATree {
    private Node root;

    /**
     * Create a new DNATree object.
     */
    public DNATree() {
        root = LeafNode.EMPTY_LEAF;
    }


    /**
     * insert a node with a given sequence into the tree
     * 
     * @param s
     *            The sequence to insert
     */
    public void insert(String s) {
        root = root.insert(s + "$");
    }


    /**
     * Search if a node containing a given string is in the tree
     * 
     * @param s
     *            The sequence to search for
     * @return true or false for the string being present
     */
    public boolean searchCheck(String s) {
        return root.searchExact(s + "$", 0);
    }


    /**
     * Search if a node containing a given string is in the tree
     * 
     * @param s
     *            The sequence to search for
     * @return the string output
     */
    public String search(String s) {
        int[] nodes = { 0 };
        String output = root.search(s, 0, nodes);
        if (output.isEmpty()) {
            output = "No sequence found\n";
        }
        output += "# of nodes visited: " + nodes[0];
        return output;
    }


    /**
     * remove a node with a specifc sequence from the tree
     * 
     * @param s
     *            The sequence to remove
     */
    public void remove(String s) {
        root = root.remove(s + "$", 0);
    }


    /**
     * print a basic/default display of nodes in a tree
     * 
     * @return a String displaying the tree dump
     */
    public String print() {
        return "tree dump:\n" + root.print(0);
    }


    /**
     * print a display of nodes in a tree and their lengths
     * 
     * @return a String displaying the tree dump
     */
    public String printLengths() {
        return "tree dump with lengths:\n" + root.printLengths(0);
    }


    /**
     * print a display of nodes in a tree and their stats
     * 
     * @return a String displaying the tree dump
     */
    public String printStats() {
        return "tree dump with stats:\n" + root.printStats(0);
    }
}
