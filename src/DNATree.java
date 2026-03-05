
public class DNATree {
    private Node root;

    public DNATree() {
        root = LeafNode.EMPTY_LEAF;
    }
    public void insert(String s) {
        root = root.insert(s + "$", 0);
    }
    public String search(String s) {
        String res = "";
        int vis = root.search(s, 0, res);
        if (res.length() == 0) {
            return "No sequence found\n# of nodes visited: " + vis;
        }
        return res.toString() + "# of nodes visited: " + vis;
    }
    public void remove(String s) {
        root = root.remove(s + "$");
    }
    public String print() {
        return "tree dump:\n"+root.print(0);
    }


    public String printLengths() {
        return "tree dump with lengths:\n" + root.printLengths(0);
    }


    public String printStats() {
        return "tree dump with stats:\n"+ root.printStats(0);
    }
}
