public class QLMuonSach {
    private BanDoc banDoc;
    private Sach[] sach;
    private int[] soLuong;
    private int soLuongSach;

    public QLMuonSach(BanDoc banDoc) {
        this.banDoc = banDoc;
        this.sach = new Sach[5];
        this.soLuong = new int[5];
        this.soLuongSach = 0;
    }

    public BanDoc getBanDoc() {
        return banDoc;
    }

    public int getTongSoLuongSach() {
        int total = 0;
        for (int i = 0; i < soLuongSach; i++) {
            total += soLuong[i];
        }
        return total;
    }

    public boolean muonSach(Sach sach, int soLuongMuon) {
        if (soLuongSach >= 5 || soLuongMuon > 3) return false;
        for (int i = 0; i < soLuongSach; i++) {
            if (this.sach[i].getMaSach() == sach.getMaSach()) {
                this.soLuong[i] += soLuongMuon;
                return true;
            }
        }
        this.sach[soLuongSach] = sach;
        this.soLuong[soLuongSach] = soLuongMuon;
        soLuongSach++;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(banDoc.getHoTen() + " mượn các sách: ");
        for (int i = 0; i < soLuongSach; i++) {
            result.append("\n\t" + sach[i].getTenSach() + " - " + soLuong[i] + " cuốn");
        }
        return result.toString();
    }
}
