
public class InternalNode implements Node {
    public Node[] kids;

    public InternalNode(Node flyweight) {
        kids = new Node[5];
        for (int i = 0; i < 5; i++) {
            kids[i] = flyweight;
        }

    }


    public Node insert(String s) {
        int ind = indexOfChar(s.charAt(0));

        if (s.length() == 1) {
            kids[ind] = kids[ind].insert(s);
        }
        else {
            kids[ind] = kids[ind].insert(s.substring(1));
        }
        return this;
    }


    public Node remove(String s) {
        int ind = indexOfChar(s.charAt(0));
        kids[ind] = kids[ind].remove(s.substring(1));
        return this;
    }


    public boolean search(String s) {
        int ind = indexOfChar(s.charAt(0));

        if (s.length() == 1) {
            return kids[ind].search(s);
        }

        return kids[ind].search(s.substring(1));

    }


    public String search(String s, int d, int[] nodes) {
        nodes[0]++;
        if (d == s.length()) {
            String res = "";
            for (Node n:kids) {
                res += n.search(s, d, nodes);
            }
            return res;
        }
        int index = indexOfChar(s.charAt(d));

        return kids[index].search(s, d + 1, nodes);

    }


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


    public String print(int d) {
        String res = " ".repeat(d) + "I\n";
        for (Node n : kids) {
            res += n.print(d + 1);
        }
        return res;
    }


    public String printLengths(int d) {
        String res = " ".repeat(d) + "I\n";
        for (Node n : kids) {
            res += n.printLengths(d + 1);
        }
        return res;
    }


    public String printStats(int d) {
        String res = " ".repeat(d) + "I\n";
        for (Node n : kids) {
            res += n.printStats(d + 1);
        }
        return res;
    }
}
