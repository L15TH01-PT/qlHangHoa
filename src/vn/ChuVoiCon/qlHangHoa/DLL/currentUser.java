package vn.ChuVoiCon.qlHangHoa.DLL;

import javax.swing.JFrame;

import vn.ChuVoiCon.qlHangHoa.UI.FormDangNhap;

public class currentUser {
	private static NhanVien nv;

	public static NhanVien getNv() {
		return nv;
	}

	public static void setNv(NhanVien nv) {
		currentUser.nv = nv;
	}
	
}
