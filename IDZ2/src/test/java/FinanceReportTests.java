import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FinanceReportTests {

    @Test
    void testDefaultConstructor() {
        FinanceReport report = new FinanceReport();
        assertEquals(0, report.getPaymentCount());
        assertEquals("Иванов Иван Иванович", report.getFullName());
        assertEquals(1, report.getDay());
        assertEquals(1, report.getMonth());
        assertEquals(2000, report.getYear());
    }

    @Test
    void testConstructorWithParameters() {
        Payment[] payments = {new Payment("Петров Петр Петрович", 10, 5, 2025, 10000),
                new Payment("Сидоров Сидор Сидорович", 15, 6, 2025, 20000)};

        FinanceReport report = new FinanceReport(payments, "Иванов Иван Иванович", 20, 7, 2025);
        assertEquals(2, report.getPaymentCount());
        assertEquals("Иванов Иван Иванович", report.getFullName());
        assertEquals(20, report.getDay());
        assertEquals(7, report.getMonth());
        assertEquals(2025, report.getYear());
    }

    @Test
    void testGetPaymentCount() {
        Payment[] payments = {new Payment(), new Payment(), new Payment()};
        FinanceReport report = new FinanceReport(payments, "Иванов Иван Иванович", 1, 1, 2025);
        assertEquals(3, report.getPaymentCount());
    }

    @Test
    void testGetPayment() {
        Payment payment = new Payment("Петров Петр Петрович", 10, 5, 2025, 15000);
        Payment[] payments = {payment};
        FinanceReport report = new FinanceReport(payments, "Иванов Иван Иванович", 1, 1, 2025);
        assertEquals(payment, report.getPayment(0));
    }

    @Test
    void testSetPayment() {
        Payment[] payments = {new Payment()};
        FinanceReport report = new FinanceReport(payments, "Иванов Иван Иванович", 1, 1, 2025);
        Payment newPayment = new Payment("Сидоров Сидор Сидорович", 15, 8, 2025, 30000);
        report.setPayment(0, newPayment);
        assertEquals(newPayment, report.getPayment(0));
    }

    @Test
    void testSetFullName() {
        FinanceReport report = new FinanceReport();
        report.setFullName("Петров Петр Петрович");
        assertEquals("Петров Петр Петрович", report.getFullName());
    }

    @Test
    void testSetReportDate() {
        FinanceReport report = new FinanceReport();
        report.setReportDate(15, 10, 2026);
        assertEquals(15, report.getDay());
        assertEquals(10, report.getMonth());
        assertEquals(2026, report.getYear());
    }

    @Test
    void testSetPayments() {
        FinanceReport report = new FinanceReport();
        Payment[] payments = {new Payment(), new Payment()};
        report.setPayments(payments);
        assertEquals(2, report.getPaymentCount());
    }

    @Test
    void testToString() {
        FinanceReport report = new FinanceReport(new Payment[2], "Иванов Иван Иванович", 10, 5, 2025);
        String result = report.toString();
        assertTrue(result.contains("Иванов Иван Иванович"));
        assertTrue(result.contains("10.5.2025"));
        assertTrue(result.contains("2"));
    }


    @Test
    void testToStringWithPayments() {
        Payment[] payments = {new Payment("Иванов Иван Иванович", 10, 5, 2025, 15275),
                new Payment("Петров Петр Петрович", 15, 6, 2025, 500)};
        FinanceReport report = new FinanceReport(payments, "Составитель отчета", 1, 11, 2025);
        String result = report.toString();
        assertTrue(result.contains("[Автор: Составитель отчета, дата: 1.11.2025, Платежи: ["));
        assertTrue(result.contains("Плательщик: Иванов Иван Иванович, дата: 10.5.2025 сумма: 152 руб. 75 коп."));
        assertTrue(result.contains("Плательщик: Петров Петр Петрович, дата: 15.6.2025 сумма: 5 руб. 00 коп."));
        assertTrue(result.endsWith("]]"));
    }

    @Test
    void testToStringEmptyPayments() {
        FinanceReport report = new FinanceReport(new Payment[0], "Иванов Иван Иванович", 1, 1, 2025);
        String result = report.toString();
        assertEquals("[Автор: Иванов Иван Иванович, дата: 1.1.2025, Платежи: [\n]]", result);
    }


    @Test
    void testCopyConstructor() {
        Payment[] payments = {new Payment("Иванов Иван Иванович", 10, 5, 2025, 15000),
                new Payment("Петров Петр Петрович", 15, 6, 2025, 20000)};
        FinanceReport original = new FinanceReport(payments, "Составитель", 1, 11, 2025);
        FinanceReport copy = new FinanceReport(original);
        assertEquals(original.getFullName(), copy.getFullName());
        assertEquals(original.getDay(), copy.getDay());
        assertEquals(original.getMonth(), copy.getMonth());
        assertEquals(original.getYear(), copy.getYear());
        assertEquals(original.getPaymentCount(), copy.getPaymentCount());
        assertEquals(original.getPayment(0), copy.getPayment(0));
        assertEquals(original.getPayment(1), copy.getPayment(1));
    }

    @Test
    void testCopyConstructorIndependentPayments() {
        Payment[] payments = {new Payment("Иванов Иван Иванович", 10, 5, 2025, 15000)};
        FinanceReport original = new FinanceReport(payments, "Составитель", 1, 11, 2025);
        FinanceReport copy = new FinanceReport(original);
        original.getPayment(0).setPayment(50000);
        assertEquals(15000, copy.getPayment(0).getPayment());
    }

    @Test
    void testCopyConstructorIndependentArrays() {
        Payment[] payments = {new Payment("Иванов Иван Иванович", 10, 5, 2025, 15000)};
        FinanceReport original = new FinanceReport(payments, "Составитель", 1, 11, 2025);
        FinanceReport copy = new FinanceReport(original);
        original.setPayment(0, new Payment());
        assertEquals("Иванов Иван Иванович", copy.getPayment(0).getFullName());
    }

    @Test
    void testCopyConstructorIndependentFullName() {
        FinanceReport original = new FinanceReport(new Payment[0], "Иванов Иван Иванович", 1, 1, 2025);
        FinanceReport copy = new FinanceReport(original);
        original.setFullName("Петров Петр Петрович");
        assertEquals("Иванов Иван Иванович", copy.getFullName());
    }

}
