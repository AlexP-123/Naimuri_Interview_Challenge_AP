# Naimuri_Interview_Challenge_AP
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
		- getValidWords: 

