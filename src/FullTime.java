import java.text.NumberFormat;
import java.util.Locale;

public class FullTime extends NhanVien {
    private int baseSalary;
    private int bonus;
    private int fine;

    public FullTime() {}

    public FullTime(int baseSalary, int bonus, int fine) {}

    public FullTime(int employeeCode, String fullName, int age,
                    String phoneNumber, String email, int baseSalary, int bonus, int fine) {
        super(employeeCode, fullName, age, phoneNumber, email);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.fine = fine;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    @Override
    public int getNetSalary() {
        return baseSalary + bonus - fine;
    }

    @Override
    public String toString() {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.GERMANY);
        String formattedNumber  = numberFormat.format(this.getNetSalary());
        return super.toString() +
                ", Tiền lương: " + formattedNumber;
    }
}
