
public class LeafNode implements Node {
    public static final LeafNode EMPTY_LEAF = new LeafNode(null);
    String info;

    public LeafNode(String s) {
        this.info = s;
    }


    public Node insert(String s, int depth) {
        if (this == EMPTY_LEAF) {
            return new LeafNode(s);
        }

        if (s.length() == 0) {
            return this;
        }

        if (info.equals(s)) {
            return this;
        }

        InternalNode newNode = new InternalNode(EMPTY_LEAF);
        newNode.insert(this.info, depth);
        newNode.insert(s, depth);
        return newNode;
        
    }


    public Node remove(String s) {
        if (info != null && info.equals(s)) {
            return EMPTY_LEAF;
        }
        return this;
    }


    public int search(String s, int depth, String res) {
        if (this == EMPTY_LEAF) {
            return 1;
        }
        String cI = info.replace("$", "");
        String cS = s.replace("$", "");
        
        if (cI.startsWith(cS)) {
            res += cI + "\n";
        }
        return 1;
    }


    public String print(int d) {
        if (info == null) {
            return " ".repeat(d) + "E\n";
        }
        String s = info.replace("$", "");
        return " ".repeat(d) + s + "\n";
    }


    public String printLengths(int d) {
        if (info == null) {
            return " ".repeat(d) + "E\n";
        }
        String s = info.replace("$", "");
        return " ".repeat(d) + s + " " + s.length() + "\n";
    }


    public String printStats(int d) {
        if (info == null) {
            return " ".repeat(d) + "E\n";
        }
        String s = info.replace("$", "");
        int A = 0;
        int C = 0;
        int G = 0;
        int T = 0;
        for (char c : s.toCharArray()) {
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
        int l = s.length();
        String output = String.format("%s%s A:%.2f C:%.2f G:%.2f T:%.2f\n", " "
            .repeat(d), s, A * 100.0 / l, C * 100.0 / l, G * 100.0 / l, T
                * 100.0 / l);

        return output;
    }
}
