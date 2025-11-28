import java.util.*;

public class QuanLyHoaDon {
    private List<HoaDon> dsHoaDon;

    public QuanLyHoaDon() {
        dsHoaDon = new ArrayList<>();
    }

    public boolean themHoaDon(HoaDon hd) {
        return dsHoaDon.add(hd);
    }

    public boolean xoaHoaDon(String maHD) {
        for (HoaDon hd : dsHoaDon) {
            if (hd.getMaHD().equalsIgnoreCase(maHD)) {
                dsHoaDon.remove(hd);
                return true;
            }
        }
        return false;
    }
    public HoaDon timHoaDon(String maHD) {
    for (HoaDon hd : dsHoaDon) {
        if (hd.getMaHD().equalsIgnoreCase(maHD)) {
            return hd;
        }
    }
    return null;
}

    public List<HoaDon> getDsHoaDon() {
        return dsHoaDon;
    }

    public void hienThiDanhSach() {
        for (HoaDon hd : dsHoaDon) {
            System.out.println(hd);
        }
    }
}