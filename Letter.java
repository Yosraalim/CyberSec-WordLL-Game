/**
 * @author Yosra Alim
 * Date: July 12th, 2023
 * 
 */





/**
 * The Letter class represents a single letter in a word.
 */
class Letter {
    private char letter;
    private int label;
    public static final int UNSET = 0;
    public static final int UNUSED = 1;
    public static final int USED = 2;
    public static final int CORRECT = 3;

    
    
    /**
     * Constructs a Letter object with the specified character.
     *
     * @param c the character representing the letter
     */
    public Letter(char c) {
        letter = c;
        label = UNSET;
    }

    
    
    /**
     * Checks if this Letter is equal to another object.
     *
     * @param otherObject the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof Letter))
            return false;
        Letter otherLetter = (Letter) otherObject;
        return this.letter == otherLetter.letter;
    }

    
    
    /**
     * Returns a decorator for the letter based on its label.
     *
     * @return the decorator string
     */
    public String decorator() {
        if (label == USED)
            return "+";
        else if (label == UNUSED)
            return "-";
        else if (label == CORRECT)
            return "!";
        else
            return " ";
    }

    
    
    /**
     * Returns the string representation of the letter with decorators.
     *
     * @return the string representation of the letter
     */
    public String toString() {
        return decorator() + letter + decorator();
    }

    
    
    
    /**
     * Sets the letter as unused.
     */
    public void setUnused() {
        label = UNUSED;
    }

    
    
    
    /**
     * Sets the letter as used.
     */
    public void setUsed() {
        label = USED;
    }

    
    
    
    /**
     * Sets the letter as correct.
     */
    public void setCorrect() {
        label = CORRECT;
    }

    
    
    /**
     * Checks if the letter is unused.
     *
     * @return true if the letter is unused, false otherwise
     */
    public boolean isUnused() {
        return label == UNUSED;
    }

    
    
    
    /**
     * Converts a string to an array of Letter objects.
     *
     * @param s the string to convert
     * @return the array of Letter objects
     */
    public static Letter[] fromString(String s) {
        Letter[] letters = new Letter[s.length()];
        for (int i = 0; i < s.length(); i++) {
            letters[i] = new Letter(s.charAt(i));
        }
        return letters;
    }
}





