import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTestStringModification1 {

    @Test
    void testModificationAllDigitsPresent() {
        StringBuilder result = StringProcessor.stringModification1("123");
        assertEquals("одиндватри", result.toString());
    }

    @Test
    void testModificationPartialDigits() {
        StringBuilder result1 = StringProcessor.stringModification1("12");
        assertEquals("одиндва", result1.toString());

        StringBuilder result2 = StringProcessor.stringModification1("3");
        assertEquals("три", result2.toString());
    }

    @Test
    void testModificationNoTargetDigits() {
        StringBuilder result = StringProcessor.stringModification1("hello 456");
        assertEquals("hello 456", result.toString());
    }

    @Test
    void testModificationMultipleSameDigits() {
        StringBuilder result = StringProcessor.stringModification1("11");
        assertEquals("одинодин", result.toString());
    }
}