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
        return "Sequence |" + sequence +"| inserted";
    }


    // ----------------------------------------------------------
    /**
     * Remove a DNA string into the database
     * @param sequence The sequence to remove
     * @return The outcomes message string
     */
    public String remove(String sequence) {
        if (sequence == null) {
            return "Bad input: Sequence may not be null\r\n";
        }
        else if (sequence.equals("")) {
            return "Bad input: Sequence may not be empty\n";
        }
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
        if (sequence == null) {
            return "Bad input: Sequence may not be null\r\n";
        }/*
        if (sequence.length() == 0) {
            return "no sequence found\n" + "    of nodes visited 1";
        }*/
        for (int i = 0; i < sequence.length(); i++) {
            char letter = sequence.charAt(i);
            if (letter != 'A' && letter != 'C' && letter != 'G' && letter != 'T') {
                if (i == sequence.length()-1 && letter == '$') {
                    continue;
                }
                else {
                    return "Bad input sequence |"+sequence+"|\r\n";
                }
            }
        }
        return null;
    }
}
