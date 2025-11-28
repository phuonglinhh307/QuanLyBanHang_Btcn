import java.util.*;
import java.text.SimpleDateFormat;

public class HoaDon {
    private String maHD;
    private Date ngayLap;
    private KhachHang khachHang;
    private List<ChiTietHoaDon> dsChiTiet;


    public HoaDon() {
        dsChiTiet = new ArrayList<>();
    }

    public HoaDon(String maHD, Date ngayLap, KhachHang khachHang) {
        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.khachHang = khachHang;
        this.dsChiTiet = new ArrayList<>();
    }

    public String getMaHD() { 
        return maHD; }
    public void setMaHD(String maHD) { 
        this.maHD = maHD; }

    public Date getNgayLap() { 
        return ngayLap; }
    public void setNgayLap(Date ngayLap) { 
        this.ngayLap = ngayLap; }

    public KhachHang getKhachHang() { 
        return khachHang; }
    public void setKhachHang(KhachHang khachHang) { 
        this.khachHang = khachHang; }

    public List<ChiTietHoaDon> getDsChiTiet() { 
        return dsChiTiet; }

    public void themChiTiet(SanPham sp, int soLuong) {
        dsChiTiet.add(new ChiTietHoaDon(sp, soLuong));
    }

    public boolean xoaChiTietTheoMaSP(String maSP) {
        return dsChiTiet.removeIf(ct -> ct.getSanPham().getMaSP().equalsIgnoreCase(maSP));
    }

    public double tinhTongTien() {
        double tong = 0;
        for (ChiTietHoaDon ct : dsChiTiet)
            tong += ct.getThanhTien();
        return tong;
    }

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("HD: %s | Ngay: %s | KH: %s\n",
                maHD, df.format(ngayLap), khachHang));
        for (ChiTietHoaDon ct : dsChiTiet)
            sb.append("  - ").append(ct).append("\n");
        sb.append(String.format("Tong: %,.0f VND", tinhTongTien()));
        return sb.toString();
    }
}
