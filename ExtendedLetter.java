/**
 * @author Yosra Alim
 * Date: July 12th, 2023
 * 
 */




/**
 * The ExtendedLetter class extends the functionality of the Letter class.
 */
class ExtendedLetter extends Letter {
    private String content;
    private int family;
    private boolean related;
    public static final int SINGLETON = -1;

    
    
    /**
     * Constructs an ExtendedLetter object with the specified content.
     *
     * @param s the content of the letter
     */
    public ExtendedLetter(String s) {
        super(' ');
        content = s;
        family = SINGLETON;
        related = false;
    }

    
    
    /**
     * Constructs an ExtendedLetter object with the specified content and family.
     *
     * @param s   the content of the letter
     * @param fam the family of the letter
     */
    public ExtendedLetter(String s, int fam) {
        super(' ');
        content = s;
        family = fam;
        related = false;
    }

    
    
    /**
     * Checks if this ExtendedLetter is equal to another object.
     *
     * @param other the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    public boolean equals(Object other) {
        if (!(other instanceof ExtendedLetter))
            return false;
        ExtendedLetter otherLetter = (ExtendedLetter) other;
        if (otherLetter.family == this.family)
            this.related = true;
        return this.content.equals(otherLetter.content);
    }

    
    
    /**
     * Returns the string representation of the letter.
     * If the letter is unused and related, it is represented as ".<content>.".
     *
     * @return the string representation of the letter
     */
    public String toString() {
        if (isUnused() && related) {
            return "." + content + ".";
        } else {
            return this.decorator() + this.content + this.decorator();
        }
    }

    
    
    /**
     * Converts arrays of content strings and family codes to an array of Letter objects.
     *
     * @param content the array of content strings
     * @param codes   the array of family codes
     * @return the array of Letter objects
     */
    public static Letter[] fromStrings(String[] content, int[] codes) {
        Letter[] letters = new Letter[content.length];
        for (int i = 0; i < content.length; i++) {
            if (codes != null)
                letters[i] = new ExtendedLetter(content[i], codes[i]);
            else
                letters[i] = new ExtendedLetter(content[i]);
        }
        return letters;
    }
}


