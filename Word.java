/**
 * @author Yosra Alim
 * Date: July 12th, 2023
 * 
 */




/**
 * The Word class represents a word composed of letters.
 */
class Word {
    private LinearNode<Letter> firstLetter;

    
    
    /**
     * Constructs a Word object from an array of Letter objects.
     *
     * @param letters the array of Letter objects
     */
    public Word(Letter[] letters) {
        firstLetter = new LinearNode<>(letters[0]);
        LinearNode<Letter> current = firstLetter;
        for (int i = 1; i < letters.length; i++) {
            LinearNode<Letter> newNode = new LinearNode<>(letters[i]);
            current.setNext(newNode);
            current = newNode;
        }
    }

    
    
    /**
     * Returns the string representation of the word.
     *
     * @return the string representation of the word
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("Word: ");
        LinearNode<Letter> current = firstLetter;
        while (current != null) {
            sb.append(current.getElement()).append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }

    
    
    /**
     * Labels the word by comparing it with another word.
     *
     * @param mystery the word to compare with
     * @return true if the words are identical, false otherwise
     */
    public boolean labelWord(Word mystery) {
        LinearNode<Letter> current1 = firstLetter;
        LinearNode<Letter> current2 = mystery.firstLetter;
        
        String current2_string = mystery.toString().substring(7);
        boolean identical = true;
        
        

        while (current1 != null ) {
            Letter letter1 = current1.getElement();
            if (current2 != null) {
            	Letter letter2 = current2.getElement();
                
                if (letter1.equals(letter2)) {
                	letter1.setCorrect();
                } else if (current2_string.contains( letter1.toString().substring(1,2))) {
                	letter1.setUsed();
                	identical = false;
                } else {
                	letter1.setUnused();
                    identical = false;
                }

                current1 = current1.getNext();
                current2 = current2.getNext();
            } else {

                if (current2_string.contains( letter1.toString().substring(1,2))) {
                	letter1.setUsed();
                	identical = false;
                } else {
                	letter1.setUnused();
                    identical = false;
                }

                current1 = current1.getNext();
            }
        }

        return identical;
    }
}



