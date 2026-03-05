
public class DNATree {
    private Node root;

    public DNATree() {
        root = LeafNode.EMPTY_LEAF;
    }
    public void insert(String s) {
        root = root.insert(s + "$");
    }
    public boolean search(String s) {
        return root.search(s + "$");
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
