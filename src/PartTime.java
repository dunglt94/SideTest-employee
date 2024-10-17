import java.text.NumberFormat;
import java.util.Locale;

public class PartTime extends NhanVien{
    private int workingHours;

    public PartTime() {}

    public PartTime(int workingHours) {}

    public PartTime(int employeeCode, String fullName, int age, String phoneNumber, String email, int workingHours) {
        super(employeeCode, fullName, age, phoneNumber, email);
        this.workingHours = workingHours;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public int getNetSalary() {
        return getWorkingHours() * 100000;
    }

    @Override
    public String toString() {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.GERMANY);
        String formattedNumber  = numberFormat.format(this.getNetSalary());
        return super.toString() +
                ", WorkingHours: " + workingHours +
                ", Tiền lương: " + formattedNumber;
    }
}
