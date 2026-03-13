
public class LeafNode implements Node {
    public static final LeafNode EMPTY_LEAF = new LeafNode(null);
    String info;

    public LeafNode(String s) {
        this.info = s;
    }

    public Node insert(String s) {
        return insert(s, 0);
    }
    
    public Node insert(String s, int depth) {
        if (this == EMPTY_LEAF) {
            return new LeafNode(s);
        }
        if (info.equals(s)) {
            return this;
        }

        InternalNode root = new InternalNode(EMPTY_LEAF);
        InternalNode current = root;

        int d = depth;
        while (d < info.length() - 1 && d < s.length() - 1 &&
            info.charAt(d) == s.charAt(d)) {
            int idx = current.indexOfChar(info.charAt(d));
            InternalNode next = new InternalNode(EMPTY_LEAF);
            current.kids[idx] = next;
            current = next;
            d++;
        }

        char c1 = info.charAt(d);
        char c2 = s.charAt(d);

        current.kids[current.indexOfChar(c1)] = new LeafNode(info);
        current.kids[current.indexOfChar(c2)] = new LeafNode(s);

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
        if (s.length() == 0) {
            return true;
        }
        return info.endsWith(s);
    }
    
    public boolean searchExact(String s, int depth) {
        return info != null && info.equals(s);
    }
    
    public String search(String s, int d, int[] nodes) {
        nodes[0]++;
        if (info == null) {
            return "";
        }
        String seq = info.replace("$", "");
        String prefix = s.replace("$", "");
        if(seq.startsWith(prefix)) {
            return seq + "\n";
        }
        return "";
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
