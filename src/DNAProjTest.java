import student.TestCase;

/**
 * @author CS3114/5040 staff
 * @version Spring 2026
 * Test class for DNAProj
 */
public class DNAProjTest extends TestCase {
    private DNA it;

    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        it = new DNADB();
    }

    /**
     * Test output formatting
     */
    public void testSampleInput() {
        assertFuzzyEquals(
            "Sequence |ACGT| inserted",
            it.insert("ACGT"));
        assertFuzzyEquals(
            "Sequence |ACGT| already exists",
            it.insert("ACGT"));
        assertFuzzyEquals(
            "Sequence |ACGT| removed",
            it.remove("ACGT"));
        assertFuzzyEquals(
            "Sequence |AAAA| inserted",
            it.insert("AAAA"));
        assertFuzzyEquals(
            "Sequence |AA| inserted",
            it.insert("AA"));
        assertFuzzyEquals(
            "Sequence |ACG| does not exist",
            it.remove("ACG"));
        assertFuzzyEquals(
            "tree dump:\r\n"
            + "I\r\n"
            + "  I\r\n"
            + "    I\r\n"
            + "      AAAA\r\n"
            + "      E\r\n"
            + "      E\r\n"
            + "      E\r\n"
            + "      AA\r\n"
            + "    E\r\n"
            + "    E\r\n"
            + "    E\r\n"
            + "    E\r\n"
            + "  E\r\n"
            + "  E\r\n"
            + "  E\r\n"
            + "  E",
            it.print());

        assertFuzzyEquals(
            "tree dump with lengths:\r\n"
            + "I\r\n"
            + "  I\r\n"
            + "    I\r\n"
            + "      AAAA 4\r\n"
            + "      E\r\n"
            + "      E\r\n"
            + "      E\r\n"
            + "      AA 2\r\n"
            + "    E\r\n"
            + "    E\r\n"
            + "    E\r\n"
            + "    E\r\n"
            + "  E\r\n"
            + "  E\r\n"
            + "  E\r\n"
            + "  E",
            it.printLengths());
        assertFuzzyEquals(
            "tree dump with stats:\r\n"
            + "I\r\n"
            + "  I\r\n"
            + "    I\r\n"
            + "      AAAA A:100.00 C:0.00 G:0.00 T:0.00\r\n"
            + "      E\r\n"
            + "      E\r\n"
            + "      E\r\n"
            + "      AA A:100.00 C:0.00 G:0.00 T:0.00\r\n"
            + "    E\r\n"
            + "    E\r\n"
            + "    E\r\n"
            + "    E\r\n"
            + "  E\r\n"
            + "  E\r\n"
            + "  E\r\n"
            + "  E",
            it.printStats());
        assertFuzzyEquals(
            "AAAA\r\n"
            + "# of nodes visited: 4",
            it.search("AAAA$"));
        assertFuzzyEquals(
            "AAAA\r\n"
            + "AA\r\n"
            + "# of nodes visited: 8",
            it.search("AA"));
        assertFuzzyEquals(
            "No sequence found\r\n"
            + "# of nodes visited: 3",
            it.search("ACGT$"));
            
    }


    /**
     * Example tests for bad input error formatting
     */
    public void testBadInput() {
        assertFuzzyEquals("testBadInput",
            "Bad input: Sequence may not be null\r\n", it.insert(null));
        assertFuzzyEquals("testBadInput",
            "Bad input: Sequence may not be empty\r\n", it.insert(""));
        assertFuzzyEquals("testBadInput", "Bad Input Sequence |AXA|\r\n", it
            .insert("AXA"));
        assertFuzzyEquals("testBadInput", "Bad Input Sequence |A A|\r\n", it
            .insert("A A"));
        assertFuzzyEquals("testBadInput", "Bad Input Sequence |A |\r\n", it
            .insert("A "));
        assertFuzzyEquals("testBadInput", "Bad Input Sequence |A$|\r\n", it
            .insert("A$"));
        assertFuzzyEquals("testBadInput", "Bad input sequence |A$A|\r\n", it
            .search("A$A"));
        assertFuzzyEquals("no sequence found\n" + "    of nodes visited 1", it
            .search(""));
    }


    /**
    * Example tests for bad input error formatting
    *      
    */
    public void testBadExtra() {
        assertFuzzyEquals("testBadInput",
            "Bad input: Sequence may not be null\r\n",
            it.remove(null));
        assertFuzzyEquals("testBadInput",
            "Bad input: Sequence may not be empty\r\n",
            it.remove(""));
        assertFuzzyEquals("Bad input: Sequence may not be null\r\n",
            it.search(null));
        assertFuzzyEquals("no sequence found\n"
            + "    of nodes visited 1",
            it.search(""));
        assertFuzzyEquals("testBadInput",
            "Bad input sequence |CNA|\r\n",
            it.search("CNA"));
        assertFuzzyEquals("testBadInput",
            "Bad input sequence |ABCD|\r\n",
            it.search("ABCD"));
        assertFuzzyEquals("testBadInput",
            "Bad input sequence |123|\r\n",
            it.search("123"));
        assertFuzzyEquals("testBadInput",
            "Bad input sequence |B|\r\n",
            it.search("B")); 
        assertFuzzyEquals("Bad Input Sequence |CBA|\r\n",
            it.insert("CBA"));
        assertFuzzyEquals(
            "Sequence |ACGT| inserted", it.insert("ACGT")); 
        assertFuzzyEquals("testBadInput",
            "Bad input sequence |CNA|\r\n",
            it.search("CNA"));
        assertFuzzyEquals("testBadInput",
            "Bad input sequence |ABCD|\r\n",
            it.remove("ABCD"));
        assertFuzzyEquals("testBadInput",
            "Bad input sequence |123|\r\n",
            it.remove("123"));
        assertFuzzyEquals("testBadInput",
            "Bad input sequence |B|\r\n",
            it.remove("B")); 
        assertFuzzyEquals("Bad Input Sequence |CBA|\r\n",
            it.remove("CBA"));
        assertFuzzyEquals(
            "Sequence |ACGT| removed",
            it.remove("ACGT"));
    }
    
    
    /**
     * tests for basic insert method
     */
    public void testInsertBasic() {
        assertFuzzyEquals(
            "Sequence |ACGT| inserted",
            it.insert("ACGT"));

        assertFuzzyEquals(
            "Sequence |ACGT| already exists",
            it.insert("ACGT"));

        assertFuzzyEquals(
            "Sequence |AAAA| inserted",
            it.insert("AAAA"));

        assertFuzzyEquals(
            "Sequence |AA| inserted",
            it.insert("AA"));
    }
    
    
    /**
     * tests for duplicate issues when inserting
     */
    public void testInsertDuplicate() {

        assertFuzzyEquals(
            "Sequence |ACGT| inserted",
            it.insert("ACGT"));

        assertFuzzyEquals(
            "Sequence |ACGT| already exists",
            it.insert("ACGT"));
    }
    
    /**
     * tests for inserting with prefix long first
     */
    public void testInsertPrefixLongFirst() {

        assertFuzzyEquals(
            "Sequence |AAAA| inserted",
            it.insert("AAAA"));

        assertFuzzyEquals(
            "Sequence |AA| inserted",
            it.insert("AA"));
    }
    
    /**
     * tests for inserting with prefix short first
     */
    public void testInsertPrefixShortFirst() {

        assertFuzzyEquals(
            "Sequence |AA| inserted",
            it.insert("AA"));

        assertFuzzyEquals(
            "Sequence |AAAA| inserted",
            it.insert("AAAA"));
    }
    
    /**
     * tests for inserting with each variation of first letter
     */
    public void testInsertDifferentFirstLetter() {

        assertFuzzyEquals(
            "Sequence |AAAA| inserted",
            it.insert("AAAA"));

        assertFuzzyEquals(
            "Sequence |CCCC| inserted",
            it.insert("CCCC"));

        assertFuzzyEquals(
            "Sequence |GGGG| inserted",
            it.insert("GGGG"));

        assertFuzzyEquals(
            "Sequence |TTTT| inserted",
            it.insert("TTTT"));
    }
    /**
     * tests for inserting with same prefix
     */
    public void testInsertSharedPrefix() {

        assertFuzzyEquals(
            "Sequence |AAAAC| inserted",
            it.insert("AAAAC"));

        assertFuzzyEquals(
            "Sequence |AAAAG| inserted",
            it.insert("AAAAG"));

        assertFuzzyEquals(
            "Sequence |AAAAT| inserted",
            it.insert("AAAAT"));
    }
    
    public void testInsertSplitEarly() {

        assertFuzzyEquals(
            "Sequence |ACGT| inserted",
            it.insert("ACGT"));

        assertFuzzyEquals(
            "Sequence |AGGT| inserted",
            it.insert("AGGT"));
    }
    
    /**
     * tests for inserting invalid characters
     */
    public void testInsertInvalidCharacters() {

        assertFuzzyEquals(
            "Bad Input Sequence |AXT|\n",
            it.insert("AXT"));
    }
    
    /**
     * tests for inserting null sequence
     */
    public void testInsertNull() {

        assertFuzzyEquals(
            "Bad input: Sequence may not be null\n",
            it.insert(null));
    }
    
    /**
     * tests for inserting empty string
     */
    public void testInsertEmpty() {

        assertFuzzyEquals(
            "Bad input: Sequence may not be empty\n",
            it.insert(""));
    }
    
    /**
     * tests if printed tree includes inserted nodes
     */
    public void testInsertTreeStructure() {

        it.insert("A");
        it.insert("AA");

        String tree = it.print();

        assertTrue(tree.contains("A"));
        assertTrue(tree.contains("AA"));
    }
    
    /**
     * tests if deep nodes can be inserted (without duplicate issues)
     */
    public void testInsertDeepPrefixStress() {

        it.insert("A");
        it.insert("AA");
        it.insert("AAA");
        it.insert("AAAA");
        it.insert("AAAAA");

        assertFuzzyEquals(
            "Sequence |AAAAA| already exists",
            it.insert("AAAAA"));
    }
    /**
     * basic tests for searching
     */
    public void testSearchBasic() {

        it.insert("ACGT");

        assertFuzzyEquals(
            "acgt\n"
            + "    of nodes visited 1",
            it.search("ACGT"));
    }
    /**
     * tests for searching for a nonexistent node
     */
    public void testSearchNotFound() {

        it.insert("ACGT");

        assertFuzzyEquals(
            "no sequence found\n"
            + "    of nodes visited 1",
            it.search("AAAA"));
    }
    /**
     * tests if duplicate nodes can be inserted
     */
    public void testDuplicateA() {

        assertFuzzyEquals(
            "Sequence |A| inserted",
            it.insert("A"));

        assertFuzzyEquals(
            "Sequence |A| already exists",
            it.insert("A"));
    }
    /**
     * tests if duplicate nodes can be inserted (hard)
     */
    public void testExtremeDuplicates() {

        assertFuzzyEquals(
            "Sequence |A| inserted",
            it.insert("A"));

        assertFuzzyEquals(
            "Sequence |AA| inserted",
            it.insert("AA"));

        assertFuzzyEquals(
            "Sequence |AAA| inserted",
            it.insert("AAA"));

        assertFuzzyEquals(
            "Sequence |AAAA| inserted",
            it.insert("AAAA"));

        assertFuzzyEquals(
            "Sequence |AAAAA| inserted",
            it.insert("AAAAA"));

        assertFuzzyEquals(
            "Sequence |AAAAAA| inserted",
            it.insert("AAAAAA"));

        assertFuzzyEquals(
            "Sequence |AAAAAAA| inserted",
            it.insert("AAAAAAA"));

        // duplicate deep prefix
        assertFuzzyEquals(
            "Sequence |AAAAAAA| already exists",
            it.insert("AAAAAAA"));

        // duplicate mid prefix
        assertFuzzyEquals(
            "Sequence |AAAA| already exists",
            it.insert("AAAA"));

        // duplicate short prefix
        assertFuzzyEquals(
            "Sequence |A| already exists",
            it.insert("A"));

        // duplicate after deep tree already built
        assertFuzzyEquals(
            "Sequence |AAAAAA| already exists",
            it.insert("AAAAAA"));

        // duplicate long chain
        assertFuzzyEquals(
            "Sequence |AAA| already exists",
            it.insert("AAA"));
    }
    /**
     * tests inserting and removing one node
     */
    public void testRemoveSingle() {

        assertFuzzyEquals(
            "Sequence |ACGT| inserted",
            it.insert("ACGT"));

        assertFuzzyEquals(
            "Sequence |ACGT| removed",
            it.remove("ACGT"));

        assertFuzzyEquals(
            "tree dump:\nE",
            it.print());
    }
    /**
     * tests for removing a nonexistent node
     */
    public void testRemoveNotFound() {

        it.insert("ACGT");

        assertFuzzyEquals(
            "Sequence |AAAA| does not exist",
            it.remove("AAAA"));
    }
    /**
     * tests removing node correctly when nodes share a prefix
     */
    public void testRemoveSharedPrefix() {

        it.insert("AAAA");
        it.insert("AAAT");

        assertFuzzyEquals(
            "Sequence |AAAA| removed",
            it.remove("AAAA"));

        String tree = it.print();

        assertTrue(tree.contains("AAAT"));
        assertFalse(tree.contains("AAAA"));
    }
    
    /**
     * tests removing node deep in a tree
     */
    public void testRemoveDeepNode() {

        it.insert("AAAA");
        it.insert("AAAAG");

        assertFuzzyEquals(
            "Sequence |AAAAG| removed",
            it.remove("AAAAG"));

        String tree = it.print();

        assertTrue(tree.contains("AAAA"));
        assertFalse(tree.contains("AAAAG"));
    }
    
    /**
     * tests removing node when tree structure changes
     */
    public void testRemoveCollapse() {

        it.insert("AAAA");
        it.insert("AA");

        assertFuzzyEquals(
            "Sequence |AAAA| removed",
            it.remove("AAAA"));

        String tree = it.print();

        assertTrue(tree.contains("AA"));
        assertFalse(tree.contains("AAAA"));
    }
    /**
     * tests removing multiple nodes
     */
    public void testRemoveMultiple() {

        it.insert("AAAA");
        it.insert("CCCC");
        it.insert("GGGG");
        it.insert("TTTT");

        assertFuzzyEquals(
            "Sequence |CCCC| removed",
            it.remove("CCCC"));

        assertFuzzyEquals(
            "Sequence |GGGG| removed",
            it.remove("GGGG"));

        String tree = it.print();

        assertTrue(tree.contains("AAAA"));
        assertTrue(tree.contains("TTTT"));
        assertFalse(tree.contains("CCCC"));
        assertFalse(tree.contains("GGGG"));
    }
    /**
     * tests searching for a sequence after removing it
     */
    public void testSearchAfterRemove() {

        it.insert("AAAA");
        it.insert("AAAT");

        it.remove("AAAA");

        String result = it.search("AA");

        assertFalse(result.contains("AAAA"));
        assertTrue(result.contains("AAAT"));
    }
    /**
     * tests removing root
     */
    public void testRemoveRootCollapse() {

        it.insert("AAAA");
        it.insert("AA");

        it.remove("AAAA");
        it.remove("AA");

        assertFuzzyEquals(
            "tree dump:\nE",
            it.print());
    }
    
    public void testLeafSearchNullInfo() {
        LeafNode empty = LeafNode.EMPTY_LEAF;
        assertFalse(empty.search("ACGT$"));
    }

    public void testLeafSearchEmptyString() {
        LeafNode leaf = new LeafNode("ACGT$");
        assertTrue(leaf.search(""));
    }

    public void testLeafSearchExactMatch() {
        LeafNode leaf = new LeafNode("ACGT$");
        assertTrue(leaf.search("ACGT$"));
    }

    public void testLeafSearchSuffixMatch() {
        LeafNode leaf = new LeafNode("ACGT$");
        assertTrue(leaf.search("GT$"));
    }

    public void testLeafSearchNoMatch() {
        LeafNode leaf = new LeafNode("ACGT$");
        assertFalse(leaf.search("AAAA$"));
    }

    public void testLeafSearchNullInfoEmptyString() {
        LeafNode empty = LeafNode.EMPTY_LEAF;
        assertFalse(empty.search(""));
    }

    public void testLeafSearchPrefixNotSuffix() {
        LeafNode leaf = new LeafNode("ACGT$");
        assertFalse(leaf.search("AC$"));
    }
    public void testSearchEmptyStringRoutesToTree() {
        it.insert("ACGT");
        it.insert("AAAA");
        String result = it.search("");
        assertTrue(result.contains("ACGT"));
        assertTrue(result.contains("AAAA"));
    }
    public void testRemoveCollapseWithInternalChild() {
        it.insert("AAAA");
        it.insert("AAAT");
        it.insert("AAAC");
        it.remove("AAAA");
        String tree = it.print();
        assertTrue(tree.contains("I"));
        assertTrue(tree.contains("AAAT"));
        assertTrue(tree.contains("AAAC"));
    }

    public void testRemoveNoCollapseWhenInternalExists() {
        it.insert("AAAA");
        it.insert("AAAT");
        it.remove("AAAT");
        String tree = it.print();
        assertFalse(tree.contains("E\nE\nE\nE"));
        assertTrue(tree.contains("AAAA"));
    }

    public void testRemoveAllLeavesReturnsEmpty() {
        it.insert("ACGT");
        it.remove("ACGT");
        assertFuzzyEquals("tree dump:\nE", it.print());
    }

    public void testRemoveCollapsesToSingleLeaf() {
        it.insert("AAAA");
        it.insert("AAAT");
        it.remove("AAAT");
        String tree = it.print();
        assertTrue(tree.contains("AAAA"));
        assertFalse(tree.contains("I\n  E"));
    }

    public void testRemoveCollapseHappensWhenNoInternal() {
        it.insert("ACGT");
        it.insert("ACGG");
        it.remove("ACGG");
        String tree = it.print();
        assertTrue(tree.contains("ACGT"));
        assertFalse(tree.contains("ACGT\nE"));
    }

    public void testRemoveNoCollapseWhenMultipleLeaves() {
        it.insert("AAAA");
        it.insert("AAAT");
        it.insert("AAAC");
        it.remove("AAAA");
        String tree = it.print();
        assertTrue(tree.contains("AAAT"));
        assertTrue(tree.contains("AAAC"));
        assertTrue(tree.contains("I")); 
    }
    /**
     * tests index of char method
     */
    public void testIndexOfCharMutations() {
        it.insert("AAAA");
        it.insert("CCCC");
        String tree = it.print();
        assertTrue(tree.indexOf("AAAA") < tree.indexOf("CCCC"));
        it.insert("GGGG");
        it.insert("TTTT");
        tree = it.print();
        assertTrue(tree.indexOf("AAAA") < tree.indexOf("CCCC"));
        assertTrue(tree.indexOf("CCCC") < tree.indexOf("GGGG"));
        assertTrue(tree.indexOf("GGGG") < tree.indexOf("TTTT"));
        assertFuzzyEquals(
            "Sequence |GGGG| already exists",
            it.insert("GGGG"));
        assertFuzzyEquals(
            "Sequence |TTTT| already exists",
            it.insert("TTTT"));
    }
    
}
