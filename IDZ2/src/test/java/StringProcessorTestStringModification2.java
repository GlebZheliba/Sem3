import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTestStringModification2 {

    @Test
    void testModificationEvenLength() {
        StringBuilder input = new StringBuilder("абвг");
        StringBuilder result = StringProcessor.stringModification2(input);
        assertEquals("ав", result.toString());
    }

    @Test
    void testModificationOddLength() {
        StringBuilder input = new StringBuilder("abcde");
        StringBuilder result = StringProcessor.stringModification2(input);
        assertEquals("ace", result.toString());
    }

    @Test
    void testModificationSingleChar() {
        StringBuilder input = new StringBuilder("x");
        StringBuilder result = StringProcessor.stringModification2(input);
        assertEquals("x", result.toString());
    }

    @Test
    void testModificationEmpty() {
        StringBuilder input = new StringBuilder("");
        StringBuilder result = StringProcessor.stringModification2(input);
        assertEquals("", result.toString());
    }
}