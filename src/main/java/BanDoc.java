public class BanDoc {
    private static int currentId = 10000;
    private int maBanDoc;
    private String hoTen;
    private String diaChi;
    private String sdt;
    private String loaiBanDoc;

    public BanDoc(String hoTen, String diaChi, String sdt, String loaiBanDoc) {
        this.maBanDoc = currentId++;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.loaiBanDoc = loaiBanDoc;
    }

    public int getMaBanDoc() {
        return maBanDoc;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getLoaiBanDoc() {
        return loaiBanDoc;
    }

    @Override
    public String toString() {
        return maBanDoc + " - " + hoTen + " - " + diaChi + " - " + sdt + " - " + loaiBanDoc;
    }
}
