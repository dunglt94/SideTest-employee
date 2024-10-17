public abstract class NhanVien {
    private int employeeCode;
    private String fullName;
    private int age;
    private String phoneNumber;
    private String email;

    public NhanVien() {}
    public NhanVien(int employeeCode,String fullName, int age, String phoneNumber, String email) {
        this.employeeCode = employeeCode;
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract int getNetSalary();

    @Override
    public String toString() {
        return "Mã nhân viên: " + employeeCode +
                ", Họ và tên: " + fullName +
                ", Tuổi: " + age +
                ", Số điện thoại: " + phoneNumber +
                ", Email: " + email
                ;
    }
}
