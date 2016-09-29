package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_phieu_nhap;
import vn.ChuVoiCon.qlHangHoa.DLL.phieu_nhap;

public class chi_tiet_phieu_nhapDAO extends Connect {
	
	public ArrayList<chi_tiet_phieu_nhap> getDSPhieu(phieu_nhap a) {
		ArrayList<chi_tiet_phieu_nhap> arrChiTiet = new ArrayList<chi_tiet_phieu_nhap>();
		try {
			PreparedStatement ps = getPreparedStatement("select * from chi_tiet_phieu_nhap WHERE ma_phieu_nhap=?");
			ps.setInt(1, a.getMa_phieu_nhap());
			ResultSet rs = executeQuery(ps);
			while (rs.next()) {
				chi_tiet_phieu_nhap ct = new chi_tiet_phieu_nhap();
				ct.setMa_phieu_nhap(rs.getInt(1));
				ct.setPhieu_nhap(a);
				ct.setMa_san_pham(rs.getString(2));
				ct.setSo_luong(rs.getInt(3));
				ct.setDon_gia(rs.getFloat(4));
				arrChiTiet.add(ct);
			}
			rs.close();
			ps.close();
			return arrChiTiet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
