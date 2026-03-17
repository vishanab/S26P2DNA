import student.TestCase;

/**
 * @author Vishana Baskaran and Sital Paudel
 * @version 3/13/26
 *          Test class for LeafNode
 */
public class LeafNodeTest extends TestCase {
    private LeafNode emptyLeaf;

    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        emptyLeaf = LeafNode.EMPTY_LEAF;
    }


    /**
     * Testing mutations in leaf node's search 
     */
    public void testLeafNodeSearchMutations() {
        LeafNode leaf = new LeafNode("ACGT$");
        assertFalse(emptyLeaf.search("ACGT$"));
        assertFalse(emptyLeaf.search(""));
        assertTrue(leaf.search(""));
        assertFalse(leaf.search("TTTT$"));
    }

}
