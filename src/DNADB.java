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
        for (int i = 0; i < sequence.length(); i++) {
            char letter = sequence.charAt(i);
            if (letter != 'A' && letter != 'C' && letter != 'G' && letter != 'T') {
                return "Bad Input Sequence |" + sequence + "|\n";
            }
        }
        if (tree.searchCheck(sequence)) {
            return "Sequence |" + sequence +"| already exists";
        }
        tree.insert(sequence);
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
        for (int i = 0; i < sequence.length(); i++) {
            char letter = sequence.charAt(i);
            if (letter != 'A' && letter != 'C' && letter != 'G' && letter != 'T') {
                return "Bad Input Sequence |" + sequence + "|\n";
            }
        }
        if (!tree.searchCheck(sequence)) {
            return "Sequence |" + sequence +"| does not exist";
        }
        tree.remove(sequence);
        return "Sequence |" + sequence +"| removed";
    }


    // ----------------------------------------------------------
    /**
     * Print the tree
     * @return the print string
     */
    public String print() {
        return tree.print();
    }


    // ----------------------------------------------------------
    /**
     * Print the stats
     * @return the print string
     */
    public String printLengths() {
        return tree.printLengths();
    }


    // ----------------------------------------------------------
    /**
     * Print the lengths
     * @return the print string
     */
    public String printStats() {
        return tree.printStats();
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
        }
        if (sequence.equals("")) {
            return "no sequence found\n" + "    of nodes visited 1";
        }
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
        /*
        boolean found = tree.searchCheck(sequence);
        if(!found) {
            return "Sequence |" + sequence + "| found";
        }*/
        //return "Sequence |" + sequence + "| not found";
        return tree.search(sequence);
    }
}
