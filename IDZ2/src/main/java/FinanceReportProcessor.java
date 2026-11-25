public class FinanceReportProcessor {

    public static FinanceReport getPaymentsBySurname(FinanceReport report, char letter) {
        Payment[] temp = new Payment[report.getPaymentCount()];
        int count = 0;
        for (int i = 0; i < report.getPaymentCount(); i++) {
            Payment payment = report.getPayment(i);
            String fullName = payment.getFullName().trim();
            if (!fullName.isEmpty() &&
                    Character.toLowerCase(fullName.charAt(0))
                            == Character.toLowerCase(letter)) {

                temp[count] = payment;
                count++;
            }
        }
        Payment[] result = new Payment[count];

        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return new FinanceReport(result, report.getFullName(), report.getDay(), report.getMonth(), report.getYear());
    }

    public static FinanceReport getPaymentsLessThan(FinanceReport report, int amount) {
        Payment[] temp = new Payment[report.getPaymentCount()];
        int count = 0;
        for (int i = 0; i < report.getPaymentCount(); i++) {
            Payment payment = report.getPayment(i);

            if (payment.getPayment() < amount) {
                temp[count] = payment;
                count++;
            }
        }

        Payment[] result = new Payment[count];

        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return new FinanceReport(result, report.getFullName(), report.getDay(), report.getMonth(), report.getYear());
    }
}
