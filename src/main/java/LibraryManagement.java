import java.util.Scanner;

public class LibraryManagement {
    private static BanDoc[] banDocs = new BanDoc[100];
    private static Sach[] sachs = new Sach[100];
    private static QLMuonSach[] qlMuonSachs = new QLMuonSach[100];
    private static int banDocCount = 0;
    private static int sachCount = 0;
    private static int qlMuonSachCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Nhập danh sách đầu sách mới.");
            System.out.println("2. Nhập danh sách bạn đọc mới.");
            System.out.println("3. Lập bảng quản lý mượn sách.");
            System.out.println("4. Sắp xếp danh sách quản lý mượn sách.");
            System.out.println("5. Tìm kiếm và hiển thị danh sách mượn sách theo tên bạn đọc.");
            System.out.println("0. Thoát.");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    nhapSachMoi();
                    inDanhSachSach();
                    break;
                case 2:
                    nhapBanDocMoi();
                    inDanhSachBanDoc();
                    break;
                case 3:
                    lapBangQLMuonSach();
                    inDanhSachQLMuonSach();
                    break;
                case 4:
                    sapXepQLMuonSach();
                    inDanhSachQLMuonSach();
                    break;
                case 5:
                    timKiemTheoTenBanDoc();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void nhapSachMoi() {
        System.out.println("Nhập số lượng sách mới:");
        int soLuongSachMoi = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < soLuongSachMoi; i++) {
            System.out.println("Nhập thông tin sách " + (i + 1));
            System.out.print("Tên sách: ");
            String tenSach = scanner.nextLine();
            System.out.print("Tác giả: ");
            String tacGia = scanner.nextLine();
            System.out.print("Chuyên ngành: ");
            String chuyenNganh = scanner.nextLine();
            System.out.print("Năm xuất bản: ");
            int namXuatBan = Integer.parseInt(scanner.nextLine());
            sachs[sachCount++] = new Sach(tenSach, tacGia, chuyenNganh, namXuatBan);
        }
    }

    private static void inDanhSachSach() {
        System.out.println("Danh sách các đầu sách:");
        for (int i = 0; i < sachCount; i++) {
            System.out.println(sachs[i]);
        }
    }

    private static void nhapBanDocMoi() {
        System.out.println("Nhập số lượng bạn đọc mới:");
        int soLuongBanDocMoi = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < soLuongBanDocMoi; i++) {
            System.out.println("Nhập thông tin bạn đọc " + (i + 1));
            System.out.print("Họ tên: ");
            String hoTen = scanner.nextLine();
            System.out.print("Địa chỉ: ");
            String diaChi = scanner.nextLine();
            System.out.print("SĐT: ");
            String sdt = scanner.nextLine();
            System.out.print("Loại bạn đọc (sinh viên, học viên cao học, giáo viên): ");
            String loaiBanDoc = scanner.nextLine();
            banDocs[banDocCount++] = new BanDoc(hoTen, diaChi, sdt, loaiBanDoc);
        }
    }

    private static void inDanhSachBanDoc() {
        System.out.println("Danh sách bạn đọc:");
        for (int i = 0; i < banDocCount; i++) {
            System.out.println(banDocs[i]);
        }
    }

    private static void lapBangQLMuonSach() {
        System.out.println("Nhập mã bạn đọc:");
        int maBanDoc = Integer.parseInt(scanner.nextLine());
        BanDoc banDoc = null;
        for (int i = 0; i < banDocCount; i++) {
            if (banDocs[i].getMaBanDoc() == maBanDoc) {
                banDoc = banDocs[i];
                break;
            }
        }
        if (banDoc == null) {
            System.out.println("Không tìm thấy bạn đọc!");
            return;
        }
        QLMuonSach qlMuonSach = new QLMuonSach(banDoc);
        while (true) {
            System.out.println("Nhập mã sách muốn mượn (0 để kết thúc):");
            int maSach = Integer.parseInt(scanner.nextLine());
            if (maSach == 0) break;
            Sach sach = null;
            for (int i = 0; i < sachCount; i++) {
                if (sachs[i].getMaSach() == maSach) {
                    sach = sachs[i];
                    break;
                }
            }
            if (sach == null) {
                System.out.println("Không tìm thấy sách!");
                continue;
            }
            System.out.print("Nhập số lượng mượn: ");
            int soLuongMuon = Integer.parseInt(scanner.nextLine());
            if (!qlMuonSach.muonSach(sach, soLuongMuon)) {
                System.out.println("Không thể mượn số lượng sách này!");
            }
        }
        qlMuonSachs[qlMuonSachCount++] = qlMuonSach;
    }

    private static void inDanhSachQLMuonSach() {
        System.out.println("Danh sách quản lý mượn sách:");
        for (int i = 0; i < qlMuonSachCount; i++) {
            System.out.println(qlMuonSachs[i]);
        }
    }

    private static void sapXepQLMuonSach() {
        System.out.println("1. Sắp xếp theo tên bạn đọc");
        System.out.println("2. Sắp xếp theo số lượng cuốn sách được mượn (giảm dần)");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            for (int i = 0; i < qlMuonSachCount - 1; i++) {
                for (int j = i + 1; j < qlMuonSachCount; j++) {
                    if (qlMuonSachs[i].getBanDoc().getHoTen().compareTo(qlMuonSachs[j].getBanDoc().getHoTen()) > 0) {
                        QLMuonSach temp = qlMuonSachs[i];
                        qlMuonSachs[i] = qlMuonSachs[j];
                        qlMuonSachs[j] = temp;
                    }
                }
            }
        } else if (choice == 2) {
            for (int i = 0; i < qlMuonSachCount - 1; i++) {
                for (int j = i + 1; j < qlMuonSachCount; j++) {
                    if (qlMuonSachs[i].getTongSoLuongSach() < qlMuonSachs[j].getTongSoLuongSach()) {
                        QLMuonSach temp = qlMuonSachs[i];
                        qlMuonSachs[i] = qlMuonSachs[j];
                        qlMuonSachs[j] = temp;
                    }
                }
            }
        } else {
            System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    private static void timKiemTheoTenBanDoc() {
        System.out.println("Nhập tên bạn đọc cần tìm:");
        String tenBanDoc = scanner.nextLine();
        for (int i = 0; i < qlMuonSachCount; i++) {
            if (qlMuonSachs[i].getBanDoc().getHoTen().equalsIgnoreCase(tenBanDoc)) {
                System.out.println(qlMuonSachs[i]);
            }
        }
    }
}
