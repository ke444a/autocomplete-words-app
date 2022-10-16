# Autocomplete Words Application
*Application suggests the options of how to complete the word based on an entered prefix*

### Implementation details

The program performance is based on the development of **Trie Structure (Prefix Tree)**. The algorithm of program's work includes:
- Filling the Trie in with set of words *(used dictionary can be found [here](https://github.com/dwyl/english-words/blob/master/words_alpha.txt))*
- Asking the user to enter the prefix
- Searching in the Trie for the words that begin with the following prefix
- Displaying the result

### Program Execution

<p float="left">
<img src="https://user-images.githubusercontent.com/81090139/196046230-86622209-2f9c-474e-a7d2-0c5c5f2756f4.gif" width="450">
</p>

## Launching the program
- Make sure Maven is [installed](https://maven.apache.org/download.cgi) on your computer
- Run the following command to build the project:
```
  mvn install
```
This also generates JAR file with all the dependencies 
- Run the `main` method in `AutocompleteProgram.java`:
```
  mvn exec:java
```
- Otherwise, run the `main` method in `AutocompleteProgram.java` in your chosen IDE, e.g. `IntelliJ`
