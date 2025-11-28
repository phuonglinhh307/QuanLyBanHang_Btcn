class ChiTietHoaDon {
    private SanPham sanPham;
    private int soLuong;

    public ChiTietHoaDon() {}

    public ChiTietHoaDon(SanPham sanPham, int soLuong) {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }

    public SanPham getSanPham() { 
        return sanPham; }
    public void setSanPham(SanPham sanPham) { 
        this.sanPham = sanPham; }

    public int getSoLuong() { 
        return soLuong; }
    public void setSoLuong(int soLuong) { 
        this.soLuong = soLuong; }

    public double getDonGia() {
        return sanPham.tinhGiaBan(); }

    public double getThanhTien() { 
        return getDonGia() * soLuong; }

    @Override
    public String toString() {
        return String.format("%s | SL: %d | Don gia: %,.0f | Thanh tien: %,.0f",
                sanPham.getTenSP(), soLuong, getDonGia(), getThanhTien());
    }
}