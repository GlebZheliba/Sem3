import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTests {

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

    @Test
    void testModification1AllDigitsPresent() {
        String result = StringProcessor.stringModification1("12341");
        assertEquals("одиндватри4один", result);
    }

    @Test
    void testModification1PartialDigits() {
        String result1 = StringProcessor.stringModification1("12");
        assertEquals("одиндва", result1);

        String result2 = StringProcessor.stringModification1("3");
        assertEquals("три", result2);
    }

    @Test
    void testModification1NoTargetDigits() {
        String result = StringProcessor.stringModification1("hello 456");
        assertEquals("hello 456", result);
    }

    @Test
    void testModification1MultipleSameDigits() {
        String result = StringProcessor.stringModification1("11");
        assertEquals("одинодин", result);
    }

    @Test
    void testModification2EvenLength() {
        StringBuilder input = new StringBuilder("абвг");
        StringBuilder result = StringProcessor.stringModification2(input);
        assertEquals("ав", result.toString());
    }

    @Test
    void testModification2OddLength() {
        StringBuilder input = new StringBuilder("abcde");
        StringBuilder result = StringProcessor.stringModification2(input);
        assertEquals("ace", result.toString());
    }

    @Test
    void testModification2SingleChar() {
        StringBuilder input = new StringBuilder("x");
        StringBuilder result = StringProcessor.stringModification2(input);
        assertEquals("x", result.toString());
    }

    @Test
    void testModification2Empty() {
        StringBuilder input = new StringBuilder("");
        StringBuilder result = StringProcessor.stringModification2(input);
        assertEquals("", result.toString());
    }

    @Test
    void testReverseMultipleWords() {
        StringBuilder result = StringProcessor.reverseOrder("hello d     world   aaa  ");
        assertEquals("aaa world     d   hello  ", result.toString());
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

    @Test
    void testFrom16To10Standard() {
        StringBuilder result = StringProcessor.from16To10("0x0000001A 0xFFFFFFFF");
        assertEquals("26 4294967295", result.toString());
    }

    @Test
    void testFrom16To10Max() {
        StringBuilder result = StringProcessor.from16To10("0xFFFFFFFF");
        assertEquals("4294967295", result.toString());
    }

    @Test
    void testFrom16To10InText() {
        StringBuilder result = StringProcessor.from16To10("Значение равно 0x0000000C в логе");
        assertEquals("Значение равно 12 в логе", result.toString());
    }

    @Test
    void testFrom16To10InvalidChar() {
        StringBuilder result = StringProcessor.from16To10("Ошибка 0x000000G1 в системе");
        assertEquals("Ошибка 0x000000G1 в системе", result.toString());
    }

    @Test
    void testFrom16To10NoMatch() {
        StringBuilder result1 = StringProcessor.from16To10("Обычный текст 123");
        assertEquals("Обычный текст 123", result1.toString());

        StringBuilder result2 = StringProcessor.from16To10("");
        assertEquals("", result2.toString());
    }
}