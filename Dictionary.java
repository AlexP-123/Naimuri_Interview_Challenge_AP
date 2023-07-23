
// Importing input output classes
import java.io.*;
import java.util.*;

class Dictionary {

    // Constructor to the class which loads in the whole dictionary and reuces it to the set of valid words for the problem
    Dictionary(int n, String letters) {

        try {
            // File path to dictionary is passed as parameter
            File file = new File(
                                 "./enable1.txt");
 
            // Creating an object of BufferedReader class
            BufferedReader br
                = new BufferedReader(new FileReader(file));
 
            // Declaring a string variable
            String st;
            // Condition holds true till
            // there is character in a string
            while ((st = br.readLine()) != null){

                if(st.length() == n){
                    boolean charInWord = true;
                    for (int i = 0; i < n; i++) {
                        boolean charInLetters = false;
                        for(int j = 0; j<letters.length(); j++){
                            if((st.charAt(i) == letters.charAt(j))){
                                charInLetters = true;
                                break;
                            }
                        }
                        if(! charInLetters){
                            charInWord = false;
                            break;
                        }
                    }
                // Print the string if it matches the criteria
                if(charInWord){
                    m_dict.add(st);
                }
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Dictionary enable1.txt not found, please download to the folder");
        }
        catch (IOException e) {
            System.out.println("problem reading the file");
        }
    }

    // Function to incriment the starting letters of the word
    private static String incrementString(final String startingLetters) {
        final StringBuilder sb = new StringBuilder(startingLetters);

        // Increment the last character and return the result:
        sb.setCharAt(sb.length() - 1, (char) (sb.charAt(sb.length() - 1) + 1));
        return sb.toString();
    }
    
    // Function to return the list of valid words given a set of starting letters
    SortedSet<String> getValidWords(String startingWith){
    final String endpoint = incrementString(startingWith);

        return m_dict.subSet(startingWith, endpoint);
    }
  
    // Member variables
    private TreeSet<String> m_dict = new TreeSet<String>();
    private int m_noLetters;
}
