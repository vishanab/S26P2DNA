
public interface Node {
    Node insert(String s);

    Node insert(String s, int depth);

    Node remove(String s, int depth);
    
    boolean search(String search);
    
    boolean searchExact(String s, int depth);

    
    String search(String s, int d, int[] nodes);

    String print(int d);
    
    String printLengths(int d);
    
    String printStats(int d);

}
