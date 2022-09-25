package com.kecha.myapp;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AutocompleteProgramTest {
    AutocompleteProgram program = new AutocompleteProgram();

    @Test
    public void checkWithDefaultInput() {
        String textInput = "nu";
        List<String> result = program.displaySearchResult(textInput);
        for (String element : result) {
            assertTrue(element.startsWith(textInput));
        }
    }

    @Test
    public void checkWithNonExistingWord() {
        String textInput = "dasdasg";
        List<String> result = program.displaySearchResult(textInput);
        assertTrue(result.isEmpty());
    }

    @Test
    public void checkWithCapitals() {
        String textInput = "FED";
        List<String> result = program.displaySearchResult(textInput);
        for (String element : result) {
            assertTrue(element.startsWith(textInput.toLowerCase()));
        }
    }

    @Test
    public void checkWithEmptySpacesAtBeginning() {
        String textInput = "  in";
        List<String> result = program.displaySearchResult(textInput);
        for (String element : result) {
            assertTrue(element.startsWith(textInput.trim()));
        }
    }

    @Test
    public void checkWithNoInput() {
        String textInput = "";
        List<String> result = program.displaySearchResult(textInput);
        assertTrue(result.isEmpty());
    }
}
