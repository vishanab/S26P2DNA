
public class LeafNode implements Node {
    public static final LeafNode EMPTY_LEAF = new LeafNode(null);
    String info;
    public LeafNode(String s) {
        this.info = s;
    }


    public Node insert(String s) {
        if (info == null) {
            info = s;
            return this;
        }
        else if (info.equals(s)) {
            return this;
        }
        InternalNode newNode = new InternalNode(EMPTY_LEAF);
        newNode.insert(info);
        newNode.insert(s);
        return newNode;
    }


    public Node remove(String s) {
        if (info != null && info.equals(s)) {
            return EMPTY_LEAF;
        }
        return this;
    }


    public String print() {
        if (info == null) {
            return "";
        }
        return info + "\n";
    }


    public boolean search(String s) {
        if (info == null) {
            return false;
        }
        return info.equals(s);
    }
}
