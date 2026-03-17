/**
 * Implement LeafNode class
 *
 * @author Vishana Baskaran and Sital Paudel
 * @version 3/13/26
 */
public class LeafNode implements Node {
    /**
     * LeafNode represents empty space in a tree
     */
    public static final LeafNode EMPTY_LEAF = new LeafNode(null);
    /**
     * String stores actual DNA sequence in leaf node
     */
    String info;

    /**
     * create a new internal node
     * 
     * @param s
     *            The node's sequence
     */
    public LeafNode(String s) {
        this.info = s;
    }


    /**
     * insert a new node
     * 
     * @param s
     *            The node's sequence
     * @return the root
     */
    public Node insert(String s) {
        return insert(s, 0);
    }


    /**
     * insert a new node
     * 
     * @param s
     *            The node's sequence
     * @param depth
     *            the given depth to start with
     * @return the root
     */
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
        while (d < info.length() - 1 && d < s.length() - 1 && info.charAt(
            d) == s.charAt(d)) {
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


    /**
     * remove a node
     * 
     * @param s
     *            The node's sequence
     * @param depth
     *            the given depth to start with
     * @return the removed node
     */
    public Node remove(String s, int depth) {
        if (info != null && info.equals(s)) {
            return EMPTY_LEAF;
        }
        return this;
    }

    /**
     * check if a node contains a given sequence
     * 
     * @param s
     *            The given sequence
     * @return true if sequence found
     */
    public boolean search(String s) {
        if (info == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        return info.startsWith(s);
    }

    /**
     * check if a node contains a given sequence
     * 
     * @param s
     *            The node's sequence
     * @param depth
     *            the given depth to start with
     * @return true if sequence found
     */
    public boolean searchExact(String s, int depth) {
        return info != null && info.equals(s);
    }

    /**
     * check if a node contains a given sequence
     * 
     * @param s
     *            The node's sequence
     * @param depth
     *            the given depth to start with
     * @param nodes
     *            array being used to track the number of nodes checked
     * @return true if sequence found
     */
    public String search(String s, int d, int[] nodes) {
        nodes[0]++;
        if (info == null) {
            return "";
        }
        String seq = info.replace("$", "");
        String prefix = s.replace("$", "");
        if (seq.startsWith(prefix)) {
            return seq + "\n";
        }
        return "";
    }


    /**
     * find and display node at a specifc depth
     * 
     * @return a String displaying the information
     */
    public String print(int d) {
        if (info == null) {
            return " ".repeat(d) + "E\n";
        }
        String s = info.replace("$", "");
        return " ".repeat(d) + s + "\n";
    }


    /**
     * find the length for a node at a specifc depth
     * 
     * @return a String displaying the information
     */
    public String printLengths(int d) {
        if (info == null) {
            return " ".repeat(d) + "E\n";
        }
        String s = info.replace("$", "");
        return " ".repeat(d) + s + " " + s.length() + "\n";
    }


    /**
     * find the stats for a node at a specifc depth
     * 
     * @return a String displaying the information
     */
    public String printStats(int d) {
        if (info == null) {
            return " ".repeat(d) + "E\n";
        }
        String s = info.replace("$", "");
        int a = 0;
        int c = 0;
        int g = 0;
        int t = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'A') {
                a++;
            }
            if (ch == 'C') {
                c++;
            }
            if (ch == 'G') {
                g++;
            }
            if (ch == 'T') {
                t++;
            }
        }
        int l = s.length();
        String output = String.format("%s%s A:%.2f C:%.2f G:%.2f T:%.2f\n", " "
            .repeat(d), s, a * 100.0 / l, c * 100.0 / l, g * 100.0 / l, t
                * 100.0 / l);

        return output;
    }
}
