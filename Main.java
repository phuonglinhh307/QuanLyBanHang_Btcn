import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static QuanLyBanHang qli = new QuanLyBanHang();

    public static void main(String[] args) {
        Nhap();
        int chon;
        do {
            Menu();
            chon = readInt("Chon: ");
            switch (chon) {
                case 1 -> themSanPham();
                case 2 -> xoaSanPham();
                case 3 -> capNhatSanPham();
                case 4 -> qli.getQlSP().hienThiDanhSach();
                case 5 -> themKhachHang();
                case 6 -> xoaKhachHang();
                case 7 -> qli.getQlKH().hienThiDanhSach();
                case 8 -> lapHoaDon();
                case 9 -> qli.getQlHD().hienThiDanhSach();
                case 10 -> kiemTraTonKho();
                case 11 -> {
                    qli.getQlSP().sapXepTheoGiaBanGiamDan();
                    System.out.println("Da sap xep san pham theo gia ban giam dan");
                }
                case 12 -> {
                    double tong = qli.getQlSP().tinhTongGiaTriKho();
                    System.out.printf("Tong gia tri kho: %,.0f VND%n", tong);
                }
                case 13 -> timKiem();
                case 14 -> qli.hienThiTatCaThongTin();
                case 0 -> System.out.println("Thoat!");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }

    private static void Menu() {
        System.out.println("\n---- QUAN LY BAN HANG ----");
        System.out.println("1. Them san pham (Noi dia / Nhap khau)");
        System.out.println("2. Xoa san pham theo ma");
        System.out.println("3. Cap nhat san pham");
        System.out.println("4. Hien thi ds san pham");
        System.out.println("5. Them khach hang");
        System.out.println("6. Xoa khach hang");
        System.out.println("7. Hien thi ds khach hang");
        System.out.println("8. Lap hoa don");
        System.out.println("9. Hien thi ds hoa don");
        System.out.println("10. Kiem tra ton kho");
        System.out.println("11. Sap xep san pham theo gia ban giam dan");
        System.out.println("12. Tinh tong gia tri kho");
        System.out.println("13. Tim kiem (SP / KH / HD)");
        System.out.println("14. Hien thi toan bo thong tin");
        System.out.println("0. Thoat");
    }
private static void themSanPham() {
    System.out.println("Chon loai: 1.Noi dia  |  2.Nhap khau");
    int loai = readInt("Loai: ");
    String ma = readLine("Ma SP: ");
    String ten = readLine("Ten SP: ");
    double giaNhap = readDouble("Gia nhap: ");
    double giaCoBan = readDouble("Gia co ban: ");
    int sl = readInt("So luong: ");
    String dvt = readLine("Don vi tinh: ");
    String mota = readLine("Mo ta: ");

    boolean ok;

    if (loai == 1) {
        double vat = readDouble("Thue VAT (%): ");
        SanPham sp = new SanPhamNoiDia(ma, ten, giaNhap, giaCoBan, sl, dvt, mota, vat);
        ok = qli.getQlSP().themSanPham(sp);

        if (ok) System.out.println("Da them san pham noi dia");
        else System.out.println("Them san pham that bai!");

    } else if (loai == 2) {
        double thueNK = readDouble("Thue nhap khau (%): ");
        double phi = readDouble("Phi van chuyen: ");
        String nuoc = readLine("Nuoc nhap: ");

        SanPham sp = new SanPhamNhapKhau(ma, ten, giaNhap, giaCoBan, sl, dvt, mota, thueNK, phi, nuoc);
        ok = qli.getQlSP().themSanPham(sp);

        if (ok) System.out.println("Da them san pham nhap khau");
        else System.out.println("Them san pham that bai");

    } else {
        System.out.println("Loai san pham khong hop le");
    }
}


    private static void xoaSanPham() {
        String ma = readLine("Nhap ma SP can xoa: ");
        boolean xoa = qli.getQlSP().xoaSanPham(ma);
        System.out.println(xoa ? "Da xoa san pham." : "Khong tim thay san pham.");
    }

    private static void capNhatSanPham() {
        System.out.println("1. Cap nhat so luong  |  2.Cap nhat thong tin");
        int c = readInt("Chon: ");
        if (c == 1) {
            String ma = readLine("Ma SP: ");
            int sl = readInt("So luong moi: ");
            boolean cn = qli.getQlSP().capNhatSoLuong(ma, sl);
            System.out.println(cn ? "Da cap nhat so luong." : "Khong tim thay san pham.");
        } else if (c == 2) {
            String ma = readLine("Ma SP: ");
            String ten = readLine("Ten moi: ");
            String moTa = readLine("Mo ta moi: ");
            double gia = readDouble("Gia co ban moi: ");
            boolean cn = qli.getQlSP().capNhatThongTinSanPham(ma, ten, moTa, gia);
            System.out.println(cn ? "Da cap nhat thong tin" : "Khong tim thay san pham");
        }
    }
    private static void themKhachHang() {
        String ma = readLine("Ma KH: ");
        String ten = readLine("Ten KH: ");
        String diaChi = readLine("Dia chi: ");
        String sdt = readLine("SDT: ");
        String email = readLine("Email: ");
        KhachHang kh = new KhachHang(ma, ten, diaChi, sdt, email);
        qli.getQlKH().themKhachHang(kh);
        System.out.println("Da them khach hang");
    }

    private static void xoaKhachHang() {
        String ma = readLine("Ma KH can xoa: ");
        boolean xoa = qli.getQlKH().xoaKhachHang(ma);
        System.out.println(xoa ? "Da xoa khach hang" : "Khong tim thay khach hang");
    }

    private static void lapHoaDon() {
        String maHD = readLine("Nhap ma hoa don: ");
        String ngayLap = readLine("Nhap ngay lap: ");
        String maKH = readLine("Ma khach hang: ");

        HoaDon hd = qli.lapHoaDon(maHD, ngayLap, maKH);
        if (hd == null) return;

        while (true) {
            System.out.println("1.Them chi tiet SP  |  2.Xoa chi tiet  |  3.Hoan thanh hoa don");
            int c = readInt("Chon: ");
            if (c == 1) {
                String maSP = readLine("Ma SP: ");
                SanPham sp = qli.getQlSP().timSanPham(maSP);
                if (sp == null) {
                    System.out.println("Khong tim thay san pham");
                    continue;
                }
                int sl = readInt("So luong mua: ");
                if (sp.getSoLuong() < sl) {
                    System.out.println("Khong du hang (hien con " + sp.getSoLuong() + ").");
                    continue;
                }
                hd.themChiTiet(sp, sl);
                sp.dieuChinhSoLuongTangGiam(-sl);
                System.out.println("Da them san pham vao hoa don");
            } else if (c == 2) {
                String maSP = readLine("Ma SP can xoa khoi HD: ");
                boolean xoa = hd.xoaChiTietTheoMaSP(maSP);
                System.out.println(xoa ? "Da xoa chi tiet" : "Khong tim thay chi tiet san pham");
            } else if (c == 3) {
                System.out.println("---- HOAN THANH HOA DON ----");
                System.out.println(hd);
                break;
            } else System.out.println("Lua chon khong hop le");
        }
    }
    private static void timKiem() {
        System.out.println("1.Tim san pham  |  2.Tim khach hang  |  3.Tim hoa don");
        int c = readInt("Chon: ");
        if (c == 1) {
            String ma = readLine("Nhap ma SP: ");
            SanPham sp = qli.getQlSP().timSanPham(ma);
            System.out.println(sp != null ? sp : "Khong tim thay san pham");
        } else if (c == 2) {
            String ma = readLine("Nhap ma KH: ");
            KhachHang kh = qli.getQlKH().timKhachHang(ma);
            System.out.println(kh != null ? kh : "Khong tim thay khach hang");
        } else if (c == 3) {
            String ma = readLine("Nhap ma hoa don: ");
            HoaDon hd = qli.getQlHD().timHoaDon(ma);
            System.out.println(hd != null ? hd : "Khong tim thay hoa don");
        }
    }

    private static void kiemTraTonKho() {
        String maSP = readLine("Ma SP can kiem tra: ");
        SanPham sp = qli.getQlSP().timSanPham(maSP);
        if (sp == null) {
            System.out.println("Khong tim thay san pham");
            return;
        }
        int min = readInt("So luong toi thieu: ");
        boolean kt = sp.kiemTraHangTon(min);
        System.out.println(kt ? "Du hang (ton " + sp.getSoLuong() + ")." : "Thieu hang");
    }

    private static String readLine(String sp) {
        System.out.print(sp);
        return sc.nextLine();
    }

    private static int readInt(String sp ) {
        while (true) {
            try {
                System.out.print(sp);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Nhap so hop le");
            }
        }
    }

    private static double readDouble(String sp) {
        while (true) {
            try {
                System.out.print(sp);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println(" Nhap so hop le");
            }
        }
    }
    private static void Nhap() {
        qli.getQlSP().themSanPham(new SanPhamNoiDia("SP001", "But bi", 2000, 3000, 100, "cai", "Bi muc xanh", 10));
        qli.getQlSP().themSanPham(new SanPhamNhapKhau("SP002", "Tai nghe", 150000, 250000, 30, "cai", "Tai nghe Bluetooth", 5, 20000, "China"));

        qli.getQlKH().themKhachHang(new KhachHang("KH001", "Nguyen Van Anh", "Dak Lak", "0912345678", "anh@gmail.com"));
        qli.getQlKH().themKhachHang(new KhachHang("KH002", "Phan Bao Hanh", "Da Nang", "0987654321", "hanh@gmail.com"));
    }
 
}