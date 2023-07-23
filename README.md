# Naimuri_Interview_Challenge_AP

Running the program:
With the repository downloaded use the following command line prompt and follow the instructions (First inputing the number of words and second the list of letters in the solution):

javac *.java && java Solver

Set of requirements:
 - Inputs:
	- The program shall request an integer n
	- The program shall only accept an integer value as the first input argument
	- After correctly inputting an integer value into the program it shall request a string of n^2 letters
	- The program shall only accept a string of a n^2 letters (no other characters) either upper or lower case.

- Outputs:
	- The program shall output n words of length n separated by new lines
	- Each word must belong to the dictionary http://norvig.com/ngrams/enable1.txt
 
Initial Observations:
- All letters off the diagonal are not unique. So finding odd numbers of letters can help fill the diagonal
- Checks should be done that words exist for all rows/collumns before moving onto filling in the next word
- The problem is symmetric so does not require any 2D arrays

Classes:
- DictionaryClass:
	- Handles the set of words which are in use for the challenge
   	- Member variables:
   	  	- m_dict: A TreeSet used for storing all words which are of the correct length and letter set
   	- Member functions:
  		- Constructor: Forms the member variable m_dict which should be a vastly reduced dictionary. It takes two input arguments, first the number of letters in the word (an integer) and second the set of letters in the word must consist of (a string).
   		- incrimentString: Incriments the final character of the string so that an upper bound to the words to sifted to can be found. It takes a string as an input argument and returns a string.
   	   	- getValidWords: Returns a list of valid words given a string of starting charecters. Takes a string as an input argument and returns a SortedSet of strings.
		- getAllWords: Returns a list of all the words which are valid for the problem
- LetterManager:
  	- Handles the letters which are available to use whilst the solver is ongoing
  	- Member variables:
  	  	- m_n: The length of the words to be filled
  	  	- m_LetterFreq: A histogram (map of key= letter and value= frequency of said letter) of the frequency of each available letter, it is updated as the solution is attempted
  	- Member functions:
  	  	- Constructor: Creates the histogram
  	  	- removeLetters: takes a string as input argument and returns a boolean value which states if the attempted word exceeded the set of remaining letters available and removes the letters of the string from the histogram.
  	  	- addLetters: Takes as input a string and adds the letters back to the histogram.
- Solver:
  	- Solves the problem
  	- Member variables:
  	  	- m_dict: a local copy of the Dictionary class
  	  	- m_LetterManager: a local copy of the LetterManager class
  	  	- m_n: The number of words
  	  	- m_solution: Vector of strings which holds the ongoing solution
  	- Member functions:
  		- Constructor: calls the function doIt which runs the solver
  	   	- doit: Solves the problem, asks the user for the number of words and the letters which form the solution. It then calls the recrsive solver
  	   	- fillWordIn: Recursive function which runs through possible the list of possible words and gradually fills in the square. It returns a boolean value indicating if the problem was solved and prints the solution to the terminal if a solution was found.

