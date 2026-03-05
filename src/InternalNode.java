
public class InternalNode implements Node{
    private Node[] kids;
    public InternalNode(Node flyweight) {
        kids = new Node[5];
        for (int i = 0; i < 5; i++) {
            kids[i] = flyweight;
        }
        
    }
    
    
    public Node insert(String s) {
        int ind = indexOfChar(s.charAt(0));
        kids[ind] = kids[ind].insert(s.substring(1));
        return this;
    }


    public Node remove(String s) {
        int ind = indexOfChar(s.charAt(0));
        kids[ind] = kids[ind].remove(s.substring(1));
        return this;
    }


    public String print() {
        String res = "";
        for (int i = 0; i < 5; i++) {
            res += kids[i].print();
        }
        return res;
    }


    public boolean search(String s) {
        int ind = indexOfChar(s.charAt(0));
        return kids[ind].search(s.substring(1));
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
    
}
