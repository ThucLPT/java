import java.util.Scanner;

import model.GiamDoc;
import model.NhanSu;
import model.NhanVien;
import model.TruongPhong;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static Service service = new Service();

	static void menu() {
		System.out.println("1.Nhap thong tin cong ty");
		System.out.println("2.Phan bo nhan vien vao truong phong");
		System.out.println("3.Them thong tin 1 nhan su");
		System.out.println("4.Xoa thong tin 1 nhan su");
		System.out.println("5.Xuat toan bo nhan su");
		System.out.println("6.Xuat tong luong toan cong ty");
		System.out.println("7.Tim nhan vien co luong cao nhat");
		System.out.println("8.Tim truong phong co nhieu nhan vien nhat");
		System.out.println("9.Sap xep nhan su theo thu tu abc");
		System.out.println("10.Sap xep nhan su theo thu tu luong giam dan");
		System.out.println("11.Tim giam doc co co phan nhieu nhat");
		System.out.println("12.Xuat tong thu nhap cua tung giam doc");
		System.out.println("13.Thoat");
	}

	static void them() {
		System.out.println("1.Nhan vien");
		System.out.println("2.Truong phong");
		System.out.println("3.Giam doc");
		int choice = Integer.parseInt(scanner.nextLine());
		NhanSu nhanSu = null;
		switch (choice) {
		case 1:
			nhanSu = new NhanVien();
			break;
		case 2:
			nhanSu = new TruongPhong();
			break;
		case 3:
			nhanSu = new GiamDoc();
			break;
		}
		service.themNhanSu(nhanSu, scanner);
	}

	public static void main(String[] args) {
		while (true) {
			menu();
			int choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
			case 1:
				service.nhapCongTy(scanner);
				break;
			case 2:
				System.out.print("Ma so cua nhan vien: ");
				String maSoCuaNhanVien = scanner.nextLine();
				System.out.print("Ma so cua truong phong: ");
				String maSoCuaTruongPhong = scanner.nextLine();
				service.phanBoNhanVienVaoTruongPhong(maSoCuaNhanVien, maSoCuaTruongPhong);
				break;
			case 3:
				them();
				break;
			case 4:
				System.out.print("Nhap ma so cua nhan su can xoa: ");
				String maSo = scanner.nextLine();
				service.xoaNhanSu(maSo);
				break;
			case 5:
				service.xuatDanhSachNhanSu(service.getListNs());
				break;
			case 6:
				System.out.println(service.tinhTongLuong());
				break;
			case 7:
				service.xuatNhanSuVoiLuong(service.findNhanVienByLuongMax());
				break;
			case 8:
				service.xuatTruongPhong(service.findTruongPhongBySoNhanVienMax());
				break;
			case 9:
				service.xuatDanhSachNhanSu(service.sortNhanSuByNameAsc());
				break;
			case 10:
				service.xuatDanhSachNhanSuVoiLuong(service.sortNhanSuByLuongDesc());
				break;
			case 11:
				service.xuatGiamDoc(service.findGiamDocByCoPhanMax());
				break;
			case 12:
				service.xuatDanhSachGiamDocVoiThuNhap();
				break;
			case 13:
				return;
			}
		}
	}
}
