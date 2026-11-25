public class FinanceReport {
    private Payment[] payments;
    private String fullName;
    private int day, month, year;

    public FinanceReport() {
        this.payments = new Payment[0];
        this.fullName = "Иванов Иван Иванович";
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    public FinanceReport(Payment[] payments, String fullName, int day, int month, int year) {
        this.payments = payments;
        this.fullName = fullName;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Payment[] getPayments() {
        return payments;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setPayments(Payment[] payments) {
        this.payments = payments;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setReportDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getPaymentCount() {
        return payments.length;
    }

    public Payment getPayment(int i) {
        return payments[i];
    }

    public void setPayment(int i, Payment payment) {
        payments[i] = payment;
    }

    public FinanceReport(FinanceReport other) {
        this.fullName = other.fullName;
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;
        this.payments = new Payment[other.payments.length];
        for (int i = 0; i < other.payments.length; i++) {
            if (other.payments[i] != null) {
                this.payments[i] = new Payment(other.payments[i]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("[Автор: %s, дата: %d.%d.%d, Платежи: [\n", fullName, day, month, year));
        for (Payment payment : payments) {
            int amount = payment.getPayment();
            int rubles = amount / 100;
            int kopecks = amount % 100;
            result.append(String.format(" Плательщик: %s, дата: %d.%d.%d сумма: %d руб. %02d коп.\n", payment.getFullName(),
                    payment.getDay(), payment.getMonth(), payment.getYear(), rubles, kopecks));
        }
        result.append("]]");
        return result.toString();
    }

}
