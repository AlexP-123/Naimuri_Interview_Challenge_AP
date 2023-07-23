
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
 
                // Print the string
                System.out.println(st);

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
