
// Importing input output classes
import java.io.*;
import java.util.*;

class LetterManager {

    // Constructor to the class which takes the letters used in the problem and creates a histogram of the letter frequencies
    LetterManager(int n, String letters) {

        // The number of letters in use
        m_n = n;
        
        int len = letters.length();
        
        for (int i = 0; i < len; i++) {

            char c = letters.charAt(i);
            String s = new String();
            s += c;
            Integer value = m_LetterFreq.get(s);
            if(value == null){
                m_LetterFreq.put(s, 1);
            }
            else{
                m_LetterFreq.put(s, value + 1);
            }
        }
    }

    // Function to incriment the starting letters of the word
    boolean removeLetters(String possibleWord) {
        // Check that there are enough letters for the word
        boolean valid=true;
        // Check for each letter i
        for(int i = 0; i < m_n; ++i){
            
            // Remove charecters from the map to keep track of the 
            char c = possibleWord.charAt(i);
            String s = new String();
            s += c;
            Integer value = m_LetterFreq.get(s);
            if(value == 0){
                valid=false;
            }
            m_LetterFreq.put(s, value-1);
        }
        return valid;
    }
    
    // Function to return the list of valid words given a set of starting letters
    void addLetters(String incorrectWord) {
        
        // Add letters back to the map
        // Check for each letter i
        for(int i = 0; i < m_n; ++i){

            char c = incorrectWord.charAt(i);
            String s = new String();
            s+=c;
            Integer value = m_LetterFreq.get(s);
            m_LetterFreq.put(s, value+1);
        }
    }
  
    // Member variables
    private int m_n;
    private Map<String, Integer> m_LetterFreq = new TreeMap<String, Integer>();
}
