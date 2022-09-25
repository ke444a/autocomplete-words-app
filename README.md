# Autocomplete Words Application
*Application suggests the options of how to complete the word basing on an entered prefix*

### Implementation details

The app's performance is based on the development of **Trie Structure (Prefix Tree)**. The algorithm of program's work includes:
- Filling the Trie in with set of words *(used dictionary can be found [here](https://github.com/dwyl/english-words/blob/master/words_alpha.txt))*
- Requesting the user to enter the prefix
- Searching in the Trie for the words that begin with the following prefix
- Displaying the result

### Performance of the program

<p float="left">
<img src="https://user-images.githubusercontent.com/81090139/185733624-dd5af047-b0d2-40e5-a6f8-8e730f902172.png" width="450">
<img src="https://user-images.githubusercontent.com/81090139/185733686-1f4200f3-1475-43bf-bb24-b777e3288eb4.png" width="450">
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