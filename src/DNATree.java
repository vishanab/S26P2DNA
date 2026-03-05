
public class DNATree {
    private Node root;

    public DNATree() {
        root = LeafNode.EMPTY_LEAF;
    }
    
    public String search(String s) {
        return "";
    }

    public String print() {
        return root.print(0);
    }


    public String printLengths() {
        return root.printLengths(0);
    }


    public String printStats() {
        return root.printStats(0);
    }
}
