import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PaymentTests {

    @Test
    void testDefaultConstructor() {
        Payment payment = new Payment();

        assertEquals("Иванов Иван Иванович", payment.getFullName());
        assertEquals(1, payment.getDay());
        assertEquals(1, payment.getMonth());
        assertEquals(2000, payment.getYear());
        assertEquals(0, payment.getPayment());
    }

    @Test
    void testConstructorWithParameters() {
        Payment payment = new Payment(
                "Петров Петр Петрович", 15, 5, 2025, 15000
        );

        assertEquals("Петров Петр Петрович", payment.getFullName());
        assertEquals(15, payment.getDay());
        assertEquals(5, payment.getMonth());
        assertEquals(2025, payment.getYear());
        assertEquals(15000, payment.getPayment());
    }

    @Test
    void testSetFullName() {
        Payment payment = new Payment();
        payment.setFullName("Сидоров Сидор Сидорович");
        assertEquals("Сидоров Сидор Сидорович", payment.getFullName());
    }

    @Test
    void testSetDay() {
        Payment payment = new Payment();
        payment.setDay(20);
        assertEquals(20, payment.getDay());
    }

    @Test
    void testSetMonth() {
        Payment payment = new Payment();
        payment.setMonth(12);
        assertEquals(12, payment.getMonth());
    }

    @Test
    void testSetYear() {
        Payment payment = new Payment();
        payment.setYear(2026);
        assertEquals(2026, payment.getYear());
    }

    @Test
    void testSetPayment() {
        Payment payment = new Payment();
        payment.setPayment(25000);
        assertEquals(25000, payment.getPayment());
    }

    @Test
    void testSetPaymentDate() {
        Payment payment = new Payment();
        payment.setPaymentDate(10, 8, 2024);
        assertEquals(10, payment.getDay());
        assertEquals(8, payment.getMonth());
        assertEquals(2024, payment.getYear());
    }

    @Test
    void testEquals() {
        Payment payment1 = new Payment("Иванов Иван Иванович", 10, 5, 2025, 10000);
        Payment payment2 = new Payment("Иванов Иван Иванович", 10, 5, 2025, 10000);
        assertEquals(payment1, payment2);
    }

    @Test
    void testEqualsSameObject() {
        Payment payment = new Payment();
        assertEquals(payment, payment);
    }

    @Test
    void testNotEquals() {
        Payment payment1 = new Payment("Иванов Иван Иванович", 10, 5, 2025, 10000);
        Payment payment2 = new Payment("Петров Петр Петрович", 10, 5, 2025, 10000);
        assertNotEquals(payment1, payment2);
    }

    @Test
    void testEqualsWithNull() {
        Payment payment = new Payment();
        assertNotEquals(payment, null);
    }

    @Test
    void testEqualsWithDifferentClass() {
        Payment payment = new Payment();
        assertNotEquals(payment, "Payment");
    }

    @Test
    void testHashCode() {
        Payment payment1 = new Payment("Иванов Иван Иванович", 10, 5, 2025, 10000);
        Payment payment2 = new Payment("Иванов Иван Иванович", 10, 5, 2025, 10000);
        assertEquals(payment1.hashCode(), payment2.hashCode());
    }

    @Test
    void testToString() {
        Payment payment = new Payment("Иванов Иван Иванович", 10, 5, 2025, 10000);
        String result = payment.toString();
        assertTrue(result.contains("Иванов Иван Иванович"));
        assertTrue(result.contains("10.5.2025"));
        assertTrue(result.contains("10000"));
    }
}
