import java.util.*;

class Solver {
    public static void main(String[] args) {
        Solver s = new Solver();
        s.doit();
    }
    
    public void doit() {

        // Request an integer for the size of the square
        System.out.println("Please enter the size of the square");
        
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);
        while (true){
            try {
                m_n = Integer.parseInt(in.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Try again");
            }
        }

        // Request the letters to be used in the program
        System.out.println("Please enter the letters to be used in the square");

        // Using Scanner for Getting Input from User
        in = new Scanner(System.in);

        String allLetters = in.nextLine();
        int len = allLetters.length();
        if(len != m_n*m_n){
            throw new Error("Incorrect number of letters entered");
        }
        
        for (int i = 0; i < len; i++) {
            // checks whether the character is not a letter
            // if it is not a letter ,it will return false
            char c = allLetters.charAt(i);
            if ((Character.isLetter(c) == false)) {
                throw new Error("Non letter charecter entered");
            }
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

        //m_LetterFreq.forEach((key, value) -> System.out.println(key + ":" + value));
            
        m_dict = new Dictionary(m_n, allLetters);

        if(!fillWordIn()){
            System.out.println("Solution not found");
        }
  
    }

    // recursive function to be called to solve the problem
    boolean fillWordIn(){

        SortedSet<String> possibleWords;

        // On first entry into the recursive function we return the full dictionary
        if(m_solution.isEmpty()){

           possibleWords = m_dict.getAllWords();
        }

        // If the solution is full i.e. there are n correct words in the solution print it out!
        else if (m_solution.size() == m_n) {
            for(String t : m_solution){
                System.out.println(t);
            }
            // code for debugging 
            //m_LetterFreq.forEach((key, value) -> System.out.println(key + ":" + value));
            return true;
        }
        else{
            // Find the letters that will begin the word to be found
            String startingLetters = new String();
            for(int i = 0; i < m_solution.size(); i++){

                startingLetters += m_solution.elementAt(i).charAt(m_solution.size());
            }
            possibleWords = m_dict.getValidWords(startingLetters);
        }

        // Check the chosen word is a possible solution for the given letters
        boolean found = false;
        for(String t : possibleWords){
            // Check that there are enough letters for the word
            boolean valid=true;
            for(int i = 0; i < m_n; ++i){

                // Remove charecters from the map
                char c = t.charAt(i);
                String s = new String();
                s += c;
                Integer value = m_LetterFreq.get(s);
                if(value == 0){
                    valid=false;
                }
                m_LetterFreq.put(s, value-1);
            }

            // Add the word if it is a possible solution
            if (valid) {
                m_solution.add(t);

                // Call the recursive function
                if (fillWordIn()){
                    found = true;
                }

                // the word was incorrect and needs removing from the solution
                m_solution.remove(m_solution.size() - 1);
            }

            // Add characters back to the map
            for(int i = 0; i < m_n; ++i){

                char c = t.charAt(i);
                String s = new String();
                s+=c;
                Integer value = m_LetterFreq.get(s);
                m_LetterFreq.put(s, value+1);
            }
           
            if(found) break;

        }
        return found;
    }

    // Member variables
    private Dictionary m_dict;
    private int m_n;
    private Vector<String> m_solution = new Vector<String>();
    private Map<String, Integer> m_LetterFreq = new TreeMap<String, Integer>();
}
