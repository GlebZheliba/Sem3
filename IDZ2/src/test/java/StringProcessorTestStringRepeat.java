import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTestStringRepeat {

    @Test
    void testStringRepeatSuccess() {
        StringBuilder result = StringProcessor.stringRepeat("abc", 3);
        assertEquals("abcabcabc", result.toString());
    }

    @Test
    void testStringRepeatZeroTimes() {
        StringBuilder result = StringProcessor.stringRepeat("hello", 0);
        assertEquals("", result.toString());
    }

    @Test
    void testStringRepeatThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {StringProcessor.stringRepeat("test", -5);});
        assertEquals("The argument couldn't be less than zero.", exception.getMessage());
    }
}