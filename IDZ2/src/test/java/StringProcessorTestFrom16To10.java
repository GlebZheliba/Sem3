import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTestFrom16To10 {

    @Test
    void testFrom16To10Standard() {
        StringBuilder result = StringProcessor.from16To10("0x0000001A");
        assertEquals("26", result.toString());
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