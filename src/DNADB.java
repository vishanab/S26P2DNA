//-------------------------------------------------------------------------

/**
 * The database implementation for this project.
 * This manages the commands for the DNA tree.
 *
 * @author CS3114/5040 Staff
 * @version Spring 2026
 *
 */
public class DNADB implements DNA {
    private DNATree tree;

    // ----------------------------------------------------------
    /**
     * Create a new DNADB object.
     */
    public DNADB()
    {
        tree = new DNATree();
    }


    // ----------------------------------------------------------
    /**
     * Insert a DNA string into the database
     * @param sequence The sequence to insert
     * @return The outcomes message string
     */
    public String insert(String sequence) {
        if (sequence == null) {
            return "Bad input: Sequence may not be null\n";
        }
        else if (sequence.equals("")) {
            return "Bad input: Sequence may not be empty\n";
        }
        boolean alph = true;
        for (int i = 0; i < sequence.length()-1; i++) {
            if (sequence.charAt(i) > sequence.charAt(i+1)) {
                alph = false;
            }
        }
        if (!alph) {
            return "Bad Input Sequence |" + sequence + "|\n";
        }
        return null;
    }


    // ----------------------------------------------------------
    /**
     * Remove a DNA string into the database
     * @param sequence The sequence to remove
     * @return The outcomes message string
     */
    public String remove(String sequence) {
        return null;
    }


    // ----------------------------------------------------------
    /**
     * Print the tree
     * @return the print string
     */
    public String print() {
        return null;
    }


    // ----------------------------------------------------------
    /**
     * Print the stats
     * @return the print string
     */
    public String printLengths() {
        return null;
    }


    // ----------------------------------------------------------
    /**
     * Print the lengths
     * @return the print string
     */
    public String printStats() {
        return null;
    }


    // ----------------------------------------------------------
    /**
     * Search for a given string
     * @param sequence The sequence to search for
     * @return the print string
     */
    public String search(String sequence) {
        return null;
    }
}
