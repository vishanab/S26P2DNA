/**
 * Implement the InternalNode class
 *
 * @author Vishana Baskaran and Sital Paudel
 * @version 3/13/26
 */
public class InternalNode implements Node {
    /**
     * This is a variable that stores children of internal node
     */
    public Node[] kids;

    /**
     * create a new internal node
     * 
     * @param flyweight
     *            The flyweight (empty node)
     */
    public InternalNode(Node flyweight) {
        kids = new Node[5];
        for (int i = 0; i < 5; i++) {
            kids[i] = flyweight;
        }

    }


    /**
     * insert a new node
     * 
     * @param s
     *            The node's sequence
     * @return the node inserted
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
     * @return the node inserted
     */
    public Node insert(String s, int depth) {
        int ind = indexOfChar(s.charAt(depth));
        kids[ind] = kids[ind].insert(s, depth + 1);
        return this;
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
        int ind = indexOfChar(s.charAt(depth));
        kids[ind] = kids[ind].remove(s, depth + 1);
        Node a = null;
        int nEmpt = 0;
        boolean isInternal = false;
        for (Node n : kids) {
            if (n != LeafNode.EMPTY_LEAF) {
                nEmpt++;
                a = n;
                if (n instanceof InternalNode) {
                    isInternal = true;
                }
            }
        }

        if (nEmpt == 0) {
            return LeafNode.EMPTY_LEAF;
        }

        if (nEmpt == 1 && !isInternal) {
            return a;
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
        int ind = indexOfChar(s.charAt(0));
        return kids[ind].search(s.substring(1));

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
        if (depth >= s.length())
            return false;
        int ind = indexOfChar(s.charAt(depth));
        return kids[ind].searchExact(s, depth + 1);
    }


    /**
     * check if a node contains a given sequence
     * 
     * @param s
     *            The node's sequence
     * @param d
     *            the given depth to start with
     * @param nodes
     *            array being used to track the number of nodes checked
     * @return true if sequence found
     */
    public String search(String s, int d, int[] nodes) {
        nodes[0]++;
        if (d == s.length()) {
            String res = "";
            for (Node n : kids) {
                res += n.search(s, d, nodes);
            }
            return res;
        }
        int index = indexOfChar(s.charAt(d));

        return kids[index].search(s, d + 1, nodes);

    }


    /**
     * convert a char into a corresponding number
     * 
     * @param c
     *            The given char
     * @return the integer conversion
     */
    public int indexOfChar(char c) {
        if (c == 'A') {
            return 0;
        }
        else if (c == 'C') {
            return 1;
        }
        else if (c == 'G') {
            return 2;
        }
        else if (c == 'T') {
            return 3;
        }
        else {
            return 4;
        }
    }


    /**
     * find and display node at a specifc depth
     * 
     * @param d
     *            the depth to start at
     * @return a String displaying the information
     */
    public String print(int d) {
        String res = " ".repeat(d) + "I\n";
        for (Node n : kids) {
            res += n.print(d + 1);
        }
        return res;
    }


    /**
     * find the length for a node at a specifc depth
     * 
     * @param d
     *            the depth to start at
     * @return a String displaying the information
     */
    public String printLengths(int d) {
        String res = " ".repeat(d) + "I\n";
        for (Node n : kids) {
            res += n.printLengths(d + 1);
        }
        return res;
    }


    /**
     * find the stats for a node at a specifc depth
     * 
     * @param d
     *            the depth to start at
     * @return a String displaying the information
     */
    public String printStats(int d) {
        String res = " ".repeat(d) + "I\n";
        for (Node n : kids) {
            res += n.printStats(d + 1);
        }
        return res;
    }
}
