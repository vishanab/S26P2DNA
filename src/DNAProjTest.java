import student.TestCase;

/**
 * @author CS3114/5040 staff
 * @version Spring 2026
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
        /*
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
            */
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
    public void testInsertDuplicate() {

        assertFuzzyEquals(
            "Sequence |ACGT| inserted",
            it.insert("ACGT"));

        assertFuzzyEquals(
            "Sequence |ACGT| already exists",
            it.insert("ACGT"));
    }
    public void testInsertPrefixLongFirst() {

        assertFuzzyEquals(
            "Sequence |AAAA| inserted",
            it.insert("AAAA"));

        assertFuzzyEquals(
            "Sequence |AA| inserted",
            it.insert("AA"));
    }
    public void testInsertPrefixShortFirst() {

        assertFuzzyEquals(
            "Sequence |AA| inserted",
            it.insert("AA"));

        assertFuzzyEquals(
            "Sequence |AAAA| inserted",
            it.insert("AAAA"));
    }
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
    public void testInsertMany() {

        it.insert("AAAA");
        it.insert("AAAT");
        it.insert("AAAG");
        it.insert("AAAC");

        assertFuzzyEquals(
            "Sequence |AAAA| already exists",
            it.insert("AAAA"));
    }
    public void testInsertInvalidCharacters() {

        assertFuzzyEquals(
            "Bad Input Sequence |AXT|\n",
            it.insert("AXT"));
    }
    public void testInsertNull() {

        assertFuzzyEquals(
            "Bad input: Sequence may not be null\n",
            it.insert(null));
    }
    public void testInsertEmpty() {

        assertFuzzyEquals(
            "Bad input: Sequence may not be empty\n",
            it.insert(""));
    }
    public void testInsertTreeStructure() {

        it.insert("A");
        it.insert("AA");

        String tree = it.print();

        assertTrue(tree.contains("A"));
        assertTrue(tree.contains("AA"));
    }
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
    public void testSearchBasic() {

        it.insert("ACGT");

        assertFuzzyEquals(
            "Sequence |ACGT| found",
            it.search("ACGT"));
    }
    public void testSearchNotFound() {

        it.insert("ACGT");

        assertFuzzyEquals(
            "Sequence |AAAA| not found",
            it.search("AAAA"));
    }
    public void testSearchPrefix() {

        it.insert("AAAA");
        it.insert("AA");

        assertFuzzyEquals(
            "Sequence |AA| found",
            it.search("AA"));
    }
    public void testSearchDeepPrefix() {

        it.insert("AAAA");
        it.insert("AAA");

        assertFuzzyEquals(
            "Sequence |AAA| found",
            it.search("AAA"));
    }
    public void testSearchBeforeInsert() {

        assertFuzzyEquals(
            "Sequence |ACGT| not found",
            it.search("ACGT"));
    }
    public void testSearchPrefixEdge() {

        it.insert("AAAA");
        it.insert("AA");

        assertFuzzyEquals(
            "Sequence |AA| found",
            it.search("AA"));

        assertFuzzyEquals(
            "Sequence |AAAA| found",
            it.search("AAAA"));
    }
}
