import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class QuanLyBanHang {
    private QuanLySanPham dsSanPham;
    private QuanLyKhachHang dsKhachHang;
    private QuanLyHoaDon dsHoaDon;

    public QuanLyBanHang() {
        dsSanPham = new QuanLySanPham();
        dsKhachHang = new QuanLyKhachHang();
        dsHoaDon = new QuanLyHoaDon();
    }

    public HoaDon lapHoaDon(String maHD, String ngayLap, String maKH) {
        KhachHang kh = dsKhachHang.timKhachHang(maKH);
        if (kh == null) {
            System.out.println("Khong tim thay KH co ma: " + maKH);
            return null;
        }

        Date date;
        try {
            if (ngayLap == null || ngayLap.trim().isEmpty()) {
                date = new Date();
            } else {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(ngayLap);
            }

            LocalDate today = LocalDate.now();
            LocalDate ngayHD = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if (ngayHD.isAfter(today)) {
                System.out.println("Ngay LHD khong duoc lon hon hien tai!");
                return null;
            }

            HoaDon hd = new HoaDon(maHD, date, kh);
            dsHoaDon.themHoaDon(hd);
            System.out.println("Lap hoa don thanh cong!");
            return hd;

        } catch (ParseException e) {
            System.out.println("Sai dinh dang ngay!(yyyy-MM-dd)");
            return null;
        }
    }

    public void hienThiTatCaThongTin() {
        System.out.println("---- DANH SACH SAN PHAM ----");
        dsSanPham.hienThiDanhSach();

        System.out.println("---- DANH SACH KHACH HANG ----");
        dsKhachHang.hienThiDanhSach();

        System.out.println("---- DANH SACH HOA DON ----");
        dsHoaDon.hienThiDanhSach();
    }
    public QuanLySanPham getQlSP() { return dsSanPham; }
    public QuanLyKhachHang getQlKH() { return dsKhachHang; }
    public QuanLyHoaDon getQlHD() { return dsHoaDon; }
}