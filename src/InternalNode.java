
public class InternalNode implements Node{
    public Node[] kids;
    public InternalNode(Node flyweight) {
        kids = new Node[5];
        for (int i = 0; i < 5; i++) {
            kids[i] = flyweight;
        }
        
    }
    
    
    public Node insert(String s, int depth) {
        int ind = indexOfChar(s.charAt(depth));
        kids[ind] = kids[ind].insert(s, depth + 1);
        return this;
    }


    public Node remove(String s) {
        int ind = indexOfChar(s.charAt(0));
        kids[ind] = kids[ind].remove(s.substring(1));
        return this;
    }



    public int search(String s, int depth, String res) {
        int nV = 1; 
        if (depth < s.length()) {
            char c = s.charAt(depth);
            int ind = indexOfChar(c);
            nV += kids[ind].search(s, depth + 1, res);
        } else {
            for (Node kid : kids) {
                nV += kid.search(s, depth, res);
            }
        }
        return nV;
    }
    
    public int indexOfChar(char c) {
        if (c == 'A') {
            return 0;
        } else if (c == 'C') {
            return 1;
        } else if (c == 'G') {
            return 2;
        } else if (c == 'T') {
            return 3;
        } else {
            return 4;
        }
    }

    public String print(int d) {
        String res = " ".repeat(d)+"I\n";
        for (Node n : kids) {
            res += n.print(d+1);
        }
        return res;
    }
    public String printLengths(int d) {
        String res = " ".repeat(d)+"I\n";
        for (Node n : kids) {
            res += n.printLengths(d+1);
        }
        return res;
    }
    public String printStats(int d) {
        String res = " ".repeat(d)+"I\n";
        for (Node n : kids) {
            res += n.printStats(d+1);
        }
        return res;
    }
}
