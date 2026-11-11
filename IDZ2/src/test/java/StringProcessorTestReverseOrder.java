import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTestReverseOrder {

    @Test
    void testReverseMultipleWords() {
        StringBuilder result = StringProcessor.reverseOrder("hello world");
        assertEquals("world hello", result.toString());
    }

    @Test
    void testReverseSingleWord() {
        StringBuilder result = StringProcessor.reverseOrder("java");
        assertEquals("java", result.toString());
    }

    @Test
    void testReverseWithMultipleSpaces() {
        // Три пробела между словами должны остаться тремя пробелами
        StringBuilder result = StringProcessor.reverseOrder("one   two");
        assertEquals("two   one", result.toString());
    }

    @Test
    void testReverseEmptyString() {
        StringBuilder result = StringProcessor.reverseOrder("");
        assertEquals("", result.toString());
    }

    @Test
    void testReverseWithSpacesAtBounds() {
        StringBuilder result = StringProcessor.reverseOrder(" привет мир ");
        assertEquals(" мир привет ", result.toString());
    }
}