
public class LeafNode implements Node {
    public static final LeafNode EMPTY_LEAF = new LeafNode(null);
    String info;

    public LeafNode(String s) {
        this.info = s;
    }


    public Node insert(String s) {
        if (this == EMPTY_LEAF) {
            return new LeafNode(s);
        }
        if (info.equals(s)) {
            return this;
        }
        InternalNode newNode = new InternalNode(EMPTY_LEAF);
        int i1 = newNode.indexOfChar(info.charAt(0));
        int i2 = newNode.indexOfChar(s.charAt(0));
        if (i1 != i2) {
            newNode.kids[i1] = new LeafNode(info.substring(1));
            newNode.kids[i2] = new LeafNode(s.substring(1));      
        } else {
            newNode.kids[i1] = new LeafNode(info.substring(1)).insert(s.substring(1));
        }


        return newNode;
    }


    public Node remove(String s) {
        if (info != null && info.equals(s)) {
            return EMPTY_LEAF;
        }
        return this;
    }


    public boolean search(String s) {
        if (info == null) {
            return false;
        }
        return info.equals(s);
    }


    public String print(int d) {
        if (info == null) {
            return " ".repeat(d) + "E\n";
        }
        return " ".repeat(d) + info + "\n";
    }


    public String printLengths(int d) {
        if (info == null) {
            return " ".repeat(d) + "E\n";
        }
        return " ".repeat(d) + info + " " + info.length() + "\n";
    }


    public String printStats(int d) {
        if (info == null) {
            return " ".repeat(d) + "E\n";
        }
        int A = 0;
        int C = 0;
        int G = 0;
        int T = 0;
        for (char c : info.toCharArray()) {
            if (c == 'A') {
                A++;
            }
            if (c == 'C') {
                C++;
            }
            if (c == 'G') {
                G++;
            }
            if (c == 'T') {
                T++;
            }
        }
        int l = info.length();
        String output = String.format("%s%s A:%.2f C:%.2f G:.2f T:%.2f\n", " "
            .repeat(d), info, A * 100.0 / l, C * 100.0 / l, G * 100.0 / l, T
                * 100.0 / l);

        return output;
    }
}
