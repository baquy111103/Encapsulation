public class Sach {
    private static int currentId = 10000;
    private int maSach;
    private String tenSach;
    private String tacGia;
    private String chuyenNganh;
    private int namXuatBan;

    public Sach(String tenSach, String tacGia, String chuyenNganh, int namXuatBan) {
        this.maSach = currentId++;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
        this.namXuatBan = namXuatBan;
    }

    public int getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    @Override
    public String toString() {
        return maSach + " - " + tenSach + " - " + tacGia + " - " + chuyenNganh + " - " + namXuatBan;
    }
}
