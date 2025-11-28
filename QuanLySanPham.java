import java.util.*;

public class QuanLySanPham {
    private List<SanPham> dsSanPham;

    public QuanLySanPham() {
        dsSanPham = new ArrayList<>();
    }

    public boolean themSanPham(SanPham sp) {
        // Kiểm tra số lượng > 0
        if (sp.getSoLuong() <= 0) {
            System.out.println("So luong phai lon hon 0");
            return false;
        }

        // Kiểm tra giá cơ bản > giá nhập
        if (sp.getGiaCoBan() <= sp.getGiaNhap()) {
            System.out.println("Gia co ban phai lon hon gia nhap");
            return false;
        }

        // Kiểm tra trùng mã
        if (timSanPham(sp.getMaSP()) != null) {
            System.out.println("Ma san pham da ton tai");
            return false;
        }

        return dsSanPham.add(sp);
    }

    public boolean xoaSanPham(String maSP) {
        SanPham sp = timSanPham(maSP);
        if (sp != null) {
            dsSanPham.remove(sp);
            return true;
        }
        return false;
    }

    public SanPham timSanPham(String maSP) {
        for (SanPham sp : dsSanPham) {
            if (sp.getMaSP().equalsIgnoreCase(maSP)) {
                return sp;
            }
        }
        return null;
    }

    public boolean capNhatTonKho(String maSP, long soLuong) {
        if (soLuong <= 0) {
            System.out.println("So luong phai lon hon 0!");
            return false;
        }

        SanPham sp = timSanPham(maSP);
        if (sp != null) {
            sp.setSoLuong((int) soLuong);
            return true;
        }
        return false;
    }

    public List<SanPham> getDsSanPham() {
        return dsSanPham;
    }

    public boolean capNhatSoLuong(String maSP, int soLuongMoi) {
        if (soLuongMoi <= 0) {
            System.out.println("So luong phai lon hon 0!");
            return false;
        }

        SanPham sp = timSanPham(maSP);
        if (sp != null) {
            sp.setSoLuong(soLuongMoi);
            return true;
        }
        return false;
    }

    public boolean capNhatThongTinSanPham(String ma, String tenMoi, String moTaMoi, double giaCoBanMoi) {
        SanPham sp = timSanPham(ma);
        if (sp != null) {

            // Kiểm tra giá cơ bản mới > giá nhập
            if (giaCoBanMoi <= sp.getGiaNhap()) {
                System.out.println("Gia co ban moi phai lon hon gia nhap!");
                return false;
            }

            sp.setTenSP(tenMoi);
            sp.setMoTa(moTaMoi);
            sp.setGiaCoBan(giaCoBanMoi);

            return true;
        }
        return false;
    }

    public void hienThiDanhSach() {
        for (SanPham sp : dsSanPham) {
            System.out.println(sp);
        }
    }

    public void sapXepTheoGiaBanGiamDan() {
        dsSanPham.sort((a, b) -> Double.compare(b.getGiaCoBan(), a.getGiaCoBan()));
    }

    public double tinhTongGiaTriKho() {
        double tong = 0;
        for (SanPham sp : dsSanPham) {
            tong += sp.tinhGiaBan() * sp.getSoLuong();
        }
        return tong;
    }
}
