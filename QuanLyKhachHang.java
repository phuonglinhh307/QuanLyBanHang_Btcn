import java.util.*;

public class QuanLyKhachHang implements IReadWrite {
    private List<KhachHang> dsKhachHang = new ArrayList<>();

    public boolean themKhachHang(KhachHang kh) { 
        return dsKhachHang.add(kh); }

    public boolean xoaKhachHang(String maKH) {
        return dsKhachHang.removeIf(kh -> kh.getMaKH().equalsIgnoreCase(maKH));
    }

    public KhachHang timKhachHang(String maKH) {
        for (KhachHang kh : dsKhachHang)
            if (kh.getMaKH().equalsIgnoreCase(maKH)) return kh;
        return null;
    }
    
   public void hienThiDanhSach() {
        for (KhachHang khachHang : dsKhachHang) {
            System.out.println(khachHang);
        }
    }
    @Override
    public void readDataFile(String fileName) {}
    @Override
    public void writeDataFile(String fileName) {}
}