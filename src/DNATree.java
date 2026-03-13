
public class DNATree {
    private Node root;

    public DNATree() {
        root = LeafNode.EMPTY_LEAF;
    }


    public void insert(String s) {
        root = root.insert(s + "$");
    }


    public boolean searchCheck(String s) {
        return root.searchExact(s + "$", 0);
    }


    public String search(String s) {
        /*
        if (!s.endsWith("$")) {
            s = s + "$";
        }*/

        int[] nodes = { 0 };
        String output = root.search(s, 0, nodes);
        if (output.isEmpty()) {
            output = "No sequence found\n";
        }
        output += "# of nodes visited: " + nodes[0];
        return output;
    }


    public void remove(String s) {
        root = root.remove(s + "$");
    }


    public String print() {
        return "tree dump:\n" + root.print(0);
    }


    public String printLengths() {
        return "tree dump with lengths:\n" + root.printLengths(0);
    }


    public String printStats() {
        return "tree dump with stats:\n" + root.printStats(0);
    }
}
