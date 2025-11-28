class SanPhamNhapKhau extends SanPham {
    private double thueNhapKhau; 
    private double phiVanChuyen;
    private String nuocNhap;

    public SanPhamNhapKhau() { super();}

    public SanPhamNhapKhau(String maSP, String tenSP, double giaNhap, double giaCoBan, int soLuong,
                           String donViTinh, String moTa, double thueNhapKhau, double phiVanChuyen, String nuocNhap) {
        super(maSP, tenSP, giaNhap, giaCoBan, soLuong, donViTinh, moTa);
        this.thueNhapKhau = thueNhapKhau;
        this.phiVanChuyen = phiVanChuyen;
        this.nuocNhap = nuocNhap;
    }

    public double getThueNhapKhau() { 
        return thueNhapKhau; }
    public void setThueNhapKhau(double thueNhapKhau) { 
        this.thueNhapKhau = thueNhapKhau; }

    public double getPhiVanChuyen() { 
        return phiVanChuyen; }
    public void setPhiVanChuyen(double phiVanChuyen) { 
        this.phiVanChuyen = phiVanChuyen; }

    public String getNuocNhap() { 
        return nuocNhap; }
    public void setNuocNhap(String nuocNhap) { 
        this.nuocNhap = nuocNhap; }

    @Override
    public double tinhGiaBan() {
        return getGiaCoBan() * (1 + thueNhapKhau/100.0) + phiVanChuyen;
    }

    @Override
    public double apDungKhuyenMai(double phanTram) {
        return tinhGiaBan() * (1 - phanTram/100.0);
    }

    @Override
    public String toString() {
        return "[NhapKhau] " + super.toString() + String.format(" | Thue: %.1f%% | Phi van chuyen: %,.0f | Nhap tai: %s | Gia ban: %,.0f",
                thueNhapKhau, phiVanChuyen, nuocNhap, tinhGiaBan());
    }
}