public abstract class SanPham implements IGiaBan, IKiemKe {
    private String maSP;
    private String tenSP;
    private double giaNhap;
    private double giaCoBan;
    private int soLuong;
    private String donViTinh;
    private String moTa;

    public SanPham() {}

    public SanPham(String maSP, String tenSP, double giaNhap, double giaCoBan, int soLuong,
                   String donViTinh, String moTa) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaNhap = giaNhap;
        this.giaCoBan = giaCoBan;
        this.soLuong = soLuong;
        this.donViTinh = donViTinh;
        this.moTa = moTa;
    }
    public String getMaSP() { 
        return maSP; }
    public void setMaSP(String maSP) { 
        this.maSP = maSP; }

    public String getTenSP() { 
        return tenSP; }
    public void setTenSP(String tenSP) { 
        this.tenSP = tenSP; }

    public double getGiaNhap() { 
        return giaNhap; }
    public void setGiaNhap(double giaNhap) { 
        this.giaNhap = giaNhap; }

    public double getGiaCoBan() { 
        return giaCoBan; }
    public void setGiaCoBan(double giaCoBan) { 
        this.giaCoBan = giaCoBan; }

    public int getSoLuong() { 
        return soLuong; }
    public void setSoLuong(int soLuong) { 
        this.soLuong = soLuong; }

    public String getDonViTinh() { 
        return donViTinh; }
    public void setDonViTinh(String donViTinh) { 
        this.donViTinh = donViTinh; }

    public String getMoTa() { 
        return moTa; }
    public void setMoTa(String moTa) { 
        this.moTa = moTa; }

    @Override
    public int tinhHangTon() { 
        return soLuong; }

    @Override
    public boolean kiemTraHangTon(int soLuongToiThieu) {
        return soLuong >= soLuongToiThieu;
    }

    @Override
    public void capNhatSoLuong(long soLuongThayDoi) {
        this.soLuong += (int) soLuongThayDoi;
    }

    @Override
    public void dieuChinhSoLuongTangGiam(int soLuongTangGiam) {
        this.soLuong += soLuongTangGiam;
    }

    @Override
    public abstract double tinhGiaBan();

    @Override
    public String toString() {
        return String.format("Ma:%s |Ten sp: %s | Gia co ban: %,.0f | Slg: %d |Mo ta: %s",
                maSP, tenSP, giaCoBan, soLuong, moTa);
    }
}