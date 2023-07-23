# Naimuri_Interview_Challenge_AP
Set of requirements
 - Inputs:
	- The program shall request an integer n
	- The program shall only accept an integer value as the first input argument
	- After correctly inputting an integer value into the program it shall request a string of n^2 letters
	- The program shall only accept a string of a n^2 letters (no other characters) either upper or lower case.

- Outputs:
	- The program shall output n words of length n separated by new lines
	- Each word must belong to the dictionary http://norvig.com/ngrams/enable1.txt
	- 
Initial Observations:
- All letters off the diagonal are not unique. So finding odd numbers of letters can help fill the diagonal
- Checks should be done that words exist for all rows/collumns before moving onto filling in the next word
- The problem is symmetric so does not require any 2D arrays

Potentially useful functions:
ReturnAllWordsOfLengthNAndIncludePossibilities: Have member variable of m_AllPossibleWords
ReturnPossibleWords: takes as input p letters (where p<n) and integer n.


Classes
Dictionary class which handles the set of words which are in use for the challenge

