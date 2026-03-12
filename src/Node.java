
public interface Node {
    Node insert(String s);


    Node remove(String s);
    
    boolean search(String search);
    
    String search(String s, int d, int[] nodes);

    String print(int d);
    
    String printLengths(int d);
    
    String printStats(int d);

}
