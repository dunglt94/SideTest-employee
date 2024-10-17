import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.GERMANY);
        NhanVien nhanVien[] = new NhanVien[6];
        nhanVien[0] = new FullTime(0001,
                "Nguen Van A",
                40,
                "0123456784",
                "nguyenvana@gmail.com",
                20000000,
                4000000,
                0);
        nhanVien[1] = new FullTime(0002,
                "Le Van B",
                24,
                "0987652000",
                "levanb@gmail.com",
                13000000,
                2000000,
                1000000);
        nhanVien[2] = new FullTime(0003,
                "Tran Thi C",
                22,
                "0987882002",
                "tranthic@gmail.com",
                12000000,
                0,
                500000);
        nhanVien[3] = new PartTime(0004,
                "Le Thi D",
                28,
                "0977080996",
                "lethid@gmail.com",
                88);
        nhanVien[4] = new PartTime(0005,
                "Tran Van E",
                30,
                "0936576094",
                "tranvane@gmail.com",
                50);
        nhanVien[5] = new PartTime(0006,
                "Doan Van F",
                33,
                "0981332991",
                "doanvanf@gmail.com",
                60);

//        System.out.println("Danh sách nhân viên: ");
//        printEmployeeList(nhanVien);

        String formattedNumber1  = numberFormat.format(getSumOfSalary(nhanVien));
        System.out.println("Tổng tiền lương của cả công ty: " + formattedNumber1);

        String formattedNumber2  = numberFormat.format(getAverageSalary(nhanVien));
        System.out.println("Tiền lương trung bình của nhân viên cả công ty: " + formattedNumber2);

        System.out.println("Danh sách nhân viên toàn thời gian có mức lương thấp hơn mức lương trung bình: ");
        getListOfFullTimeHasSalaryBelowAverage(nhanVien);

        String formattedNumber3  = numberFormat.format(getSalaryForPartTime(nhanVien));
        System.out.println("Tổng số lương phải trả cho tất cả nhân viên parttime: " + formattedNumber3);

        System.out.println("Danh sách nhân viên fulltime theo thứ tự lương thật từ thấp đến cao: ");
        arrangeFullTimeInAscendingOrderOfSalary(nhanVien);

    }

    private static void printEmployeeList(NhanVien[] nhanVien) {
        for (int i = 0; i < nhanVien.length; i++) {
            System.out.println(nhanVien[i].toString());
        }
    }

    private static int getSumOfSalary(NhanVien[] nhanVien) {
        int sum = 0;
        for (int i = 0; i < nhanVien.length; i++) {
            sum += nhanVien[i].getNetSalary();
        }
        return sum;
    }

    private static int getAverageSalary(NhanVien[] nhanVien) {
        int sum = 0;
        for (int i = 0; i < nhanVien.length; i++) {
            sum += nhanVien[i].getNetSalary();
        }
        return sum / nhanVien.length;
    }

    private static void getListOfFullTimeHasSalaryBelowAverage(NhanVien[] nhanVien) {
        for (int i = 0; i < nhanVien.length; i++) {
            if (nhanVien[i] instanceof FullTime) {
                FullTime fullTime = (FullTime) nhanVien[i];
                if (fullTime.getNetSalary() < getAverageSalary(nhanVien)) {
                    System.out.println(nhanVien[i].toString());
                }
            }
        }
    }

    private static int getSalaryForPartTime(NhanVien[] nhanVien) {
        int sum = 0;
        for (int i = 0; i < nhanVien.length; i++) {
            if (nhanVien[i] instanceof PartTime) {
                PartTime partTime = (PartTime) nhanVien[i];
                sum += partTime.getNetSalary();
            }
        }
        return sum;
    }

    private static void arrangeFullTimeInAscendingOrderOfSalary(NhanVien[] nhanVien) {
        for (int i = 0; i < nhanVien.length - 1; i++) {
            if (nhanVien[i] instanceof FullTime) {
                FullTime fullTime1 = (FullTime) nhanVien[i];
                int index = i;
                for (int j = i + 1; j < nhanVien.length; j++) {
                    if (nhanVien[j] instanceof FullTime) {
                        FullTime fullTime2 = (FullTime) nhanVien[j];
                        if (nhanVien[i].getNetSalary() > nhanVien[j].getNetSalary()) {
                            index = j;
                        }
                    }
                }
                NhanVien temp = nhanVien[index];
                nhanVien[index] = nhanVien[i];
                nhanVien[i] = temp;
                System.out.println(nhanVien[i].toString());
            }
        }
    }
}
