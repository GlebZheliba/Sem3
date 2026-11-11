import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTestCountInsertion {

    @Test
    void testCountInsertionSuccess() {
        int result = StringProcessor.countInsertion("бананас", "на");
        assertEquals(2, result);
    }

    @Test
    void testCountInsertionNotFound() {
        int result = StringProcessor.countInsertion("apple", "xyz");
        assertEquals(0, result);
    }

    @Test
    void testCountInsertionThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {StringProcessor.countInsertion("hello", "");});
        assertThrows(IllegalArgumentException.class, () -> {StringProcessor.countInsertion("hello", null);});
    }
}