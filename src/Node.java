
public interface Node {
    Node insert(String s, int depth);


    Node remove(String s);
    
    int search(String s, int depth, String res);

    String print(int d);
    
    String printLengths(int d);
    
    String printStats(int d);

}
