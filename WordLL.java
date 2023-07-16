/**
 * @author Yosra Alim
 * Date: July 12th, 2023
 * 
 * 
 * 
 */



class WordLL {
    private Word mysteryWord;
    private LinearNode<Word> history;

    
    
    /**
     * Constructs a WordLL object with the given mystery word.
     *
     * @param mystery the mystery word to be guessed
     */
    public WordLL(Word mystery) {
        mysteryWord = mystery;
        history = null;
    }

    
    
    /**
     * Tries a word by comparing it with the mystery word and updating the label of each letter.
     * Adds the guessed word to the front of the history.
     *
     * @param guess the word to be tried
     * @return true if the guess is identical to the mystery word, false otherwise
     */
    public boolean tryWord(Word guess) {
        guess.labelWord(mysteryWord);

        LinearNode<Word> newNode = new LinearNode<>(guess);
        newNode.setNext(history);
        history = newNode;

        return guess.labelWord(mysteryWord);
    }

    
    
    /**
     * Generates a string representation of the word guessing history.
     *
     * @return the string representation of the history
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinearNode<Word> current = history;
        while (current != null) {
            sb.append(current.getElement()).append("\n");
            current = current.getNext();
        }
        return sb.toString();
    }
}




