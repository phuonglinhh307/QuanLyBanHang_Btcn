class SanPhamNoiDia extends SanPham {
    private double thueVAT; 

    public SanPhamNoiDia() { super(); }

    public SanPhamNoiDia(String maSP, String tenSP, double giaNhap, double giaCoBan, int soLuong,
                         String donViTinh, String moTa, double thueVAT) {
        super(maSP, tenSP, giaNhap, giaCoBan, soLuong, donViTinh, moTa);
        this.thueVAT = thueVAT;
    }

    public double getThueVAT() { 
        return thueVAT; }
    public void setThueVAT(double thueVAT) { 
        this.thueVAT = thueVAT; }

    @Override
    public double tinhGiaBan() {
        return getGiaCoBan() * (1 + thueVAT/100.0);
    }

    @Override
    public double apDungKhuyenMai(double phanTram) {
        return tinhGiaBan() * (1 - phanTram/100.0);
    }

    @Override
    public String toString() {
        return "[NoiDia] " + super.toString() + String.format(" | VAT: %.1f%% | Gia ban: %,.0f", thueVAT, tinhGiaBan());
    }
}