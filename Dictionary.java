
// Importing input output classes
import java.io.*;
import java.util.*;

class Dictionary {
    
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
                    System.out.println(st);
                }
                }
            }
        }
        catch (FileNotFoundException e) {
        }
        catch (IOException e) {
        }
    }
  

    private Vector<String> m_dict;
    private int m_noLetters;
}
