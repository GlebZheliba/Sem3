import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FinanceReportProcessorTests {

    private FinanceReport createReport() {
        Payment[] payments = {new Payment("Иванов Иван Иванович", 10, 5, 2025, 15000),
                new Payment("Петров Петр Петрович", 15, 6, 2025, 5000),
                new Payment("Ильин Илья Ильич", 20, 7, 2025, 30000),
                new Payment("Сидоров Сидор Сидорович", 25, 8, 2025, 2000)};

        return new FinanceReport(
                payments, "Составитель", 1, 11, 2025
        );
    }

    @Test
    void testGetPaymentsBySurname() {
        FinanceReport report = createReport();
        FinanceReport result = FinanceReportProcessor.getPaymentsBySurname(report, 'И');
        assertEquals(2, result.getPaymentCount());
        assertEquals("Иванов Иван Иванович", result.getPayment(0).getFullName());
        assertEquals("Ильин Илья Ильич", result.getPayment(1).getFullName());
    }

    @Test
    void testGetPaymentsBySurnameCaseInsensitive() {
        FinanceReport report = createReport();
        FinanceReport result = FinanceReportProcessor.getPaymentsBySurname(report, 'и');
        assertEquals(2, result.getPaymentCount());
    }

    @Test
    void testGetPaymentsBySurnameNoMatches() {
        FinanceReport report = createReport();
        FinanceReport result = FinanceReportProcessor.getPaymentsBySurname(report, 'А');
        assertEquals(0, result.getPaymentCount());
    }

    @Test
    void testGetPaymentsLessThan() {
        FinanceReport report = createReport();
        FinanceReport result = FinanceReportProcessor.getPaymentsLessThan(report, 10000);
        assertEquals(2, result.getPaymentCount());
        assertEquals(5000, result.getPayment(0).getPayment());
        assertEquals(2000, result.getPayment(1).getPayment());
    }

    @Test
    void testGetPaymentsLessThanNoMatches() {
        FinanceReport report = createReport();
        FinanceReport result = FinanceReportProcessor.getPaymentsLessThan(report, 1000);
        assertEquals(0, result.getPaymentCount());
    }

    @Test
    void testGetPaymentsLessThanAllPayments() {
        FinanceReport report = createReport();
        FinanceReport result = FinanceReportProcessor.getPaymentsLessThan(report, 100000);
        assertEquals(4, result.getPaymentCount());
    }

    @Test
    void testOriginalReportNotChanged() {
        FinanceReport report = createReport();
        FinanceReportProcessor.getPaymentsLessThan(report, 10000);
        assertEquals(4, report.getPaymentCount());
    }
}
