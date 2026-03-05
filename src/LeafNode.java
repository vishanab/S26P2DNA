
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
        String a = info;
        String b = s;

        InternalNode root = new InternalNode(EMPTY_LEAF);
        InternalNode current = root;

        int depth = 0;

        while (depth < a.length() && depth < b.length()
            && a.charAt(depth) == b.charAt(depth)) {

            int idx = current.indexOfChar(a.charAt(depth));
            InternalNode next = new InternalNode(EMPTY_LEAF);
            current.kids[idx] = next;
            current = next;
            depth++;
        }

        int i1 = current.indexOfChar(a.charAt(depth));
        int i2 = current.indexOfChar(b.charAt(depth));

        current.kids[i1] = new LeafNode(a);
        current.kids[i2] = new LeafNode(b);

        return root;
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
