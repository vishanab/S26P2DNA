
public interface Node {
    /**
     * insert a new node
     * 
     * @param s
     *            The node's sequence
     * @return the root/node added
     */
    Node insert(String s);


    /**
     * insert a new node
     * 
     * @param s
     *            The node's sequence
     * @param depth
     *            the given depth to start with
     * @return the root/node added
     */
    Node insert(String s, int depth);


    /**
     * remove a node
     * 
     * @param s
     *            The node's sequence
     * @param depth
     *            the given depth to start with
     * @return the removed node
     */
    Node remove(String s, int depth);


    /**
     * check if a node contains a given sequence
     * 
     * @param search
     *            The given sequence
     * @return true if sequence found
     */
    boolean search(String search);


    /**
     * check if a node contains a given sequence
     * 
     * @param s
     *            The node's sequence
     * @param depth
     *            the given depth to start with
     * @return true if sequence found
     */
    boolean searchExact(String s, int depth);


    /**
     * check if a node contains a given sequence
     * 
     * @param s
     *            The node's given sequence
     * @param d
     *            the given depth to start with
     * @param nodes
     *            array being used to track the number of nodes checked
     * @return true if sequence found
     */
    String search(String s, int d, int[] nodes);


    /**
     * find and display node at a specifc depth
     * 
     * @param d
     *            the depth to start at
     * @return a String displaying the information
     */
    String print(int d);


    /**
     * find the length for a node at a specifc depth
     * 
     * @param d
     *            the depth to start at
     * @return a String displaying the information
     */
    String printLengths(int d);


    /**
     * find the stats for a node at a specifc depth
     * 
     * @param d
     *            the depth to start at
     * @return a String displaying the information
     */
    String printStats(int d);

}
