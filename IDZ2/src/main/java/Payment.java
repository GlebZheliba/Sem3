import java.util.Objects;

public class Payment {
    private String fullName;
    private int day, month, year, payment;

    public Payment() {
        this.fullName = "Иванов Иван Иванович";
        this.day = 1;
        this.month = 1;
        this.year = 2000;
        this.payment = 0;
    }

    public Payment(String fullName, int day, int month, int year, int payment) {
        this.fullName = fullName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.payment = payment;
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

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public void setPaymentDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
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

    public int getPayment() {
        return payment;
    }

    public Payment(Payment other) {
        this.fullName = other.fullName;
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;
        this.payment = other.payment;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Payment other = (Payment) object;

        return Objects.equals(fullName, other.fullName) && day == other.day && month == other.month && year == other.year && payment == other.payment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, day, month, year, payment);
    }

    @Override
    public String toString() {
        return "Payment{" + "fullName='" + fullName + '\'' + ", date=" + day + "." + month + "." + year + ", payment=" + payment + " копеек" + '}';
    }
}
