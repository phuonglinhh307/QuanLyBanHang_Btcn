class KhachHang {
    private String maKH;
    private String tenKH;
    private String diaChi;
    private String sdt;
    private String email;

    public KhachHang() {}

    public KhachHang(String maKH, String tenKH, String diaChi, String sdt, String email) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
    }

    public String getMaKH() { 
        return maKH; }
    public void setMaKH(String maKH) { 
        this.maKH = maKH; }

    public String getTenKH() { 
        return tenKH; }
    public void setTenKH(String tenKH) { 
        this.tenKH = tenKH; }

    public String getDiaChi() { 
        return diaChi; }
    public void setDiaChi(String diaChi) { 
        this.diaChi = diaChi; }

    public String getSdt() { 
        return sdt; }
    public void setSdt(String sdt) { 
        this.sdt = sdt; }

    public String getEmail() { 
        return email; }
    public void setEmail(String email) { 
        this.email = email; }

    @Override
    public String toString() {
        return String.format("Ten KH: %s (%s) |SDT: %s |Dia chi: %s", tenKH, maKH, sdt, diaChi);
    }
}