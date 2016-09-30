package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_hoa_don;
import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_phieu_nhap;
import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_san_pham;
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
	
	public ArrayList<chi_tiet_san_pham> getDSSP() {
		ArrayList<chi_tiet_san_pham> arrChiTiet = new ArrayList<chi_tiet_san_pham>();
		try {
			PreparedStatement ps = getPreparedStatement("select * from chi_tiet_san_pham");
			ResultSet rs = executeQuery(ps);
			while (rs.next()) {
				chi_tiet_san_pham ct = new chi_tiet_san_pham();
				ct.setId_sp(rs.getString(1));
				ct.setId_loai(rs.getString(2));
				ct.setId_ncc(rs.getString(3));
				ct.setTen_sp(rs.getString(4));
				ct.setNoi_dung(rs.getString(5));
				ct.setBao_hanh(rs.getInt(6));
				ct.setDon_vi_tinh(rs.getString(7));
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
	
	protected chi_tiet_phieu_nhap convertData(ResultSet rs) throws SQLException {
		chi_tiet_phieu_nhap r = new chi_tiet_phieu_nhap();
		r.setMa_phieu_nhap(rs.getInt("ma_phieu_nhap"));
		r.setMa_san_pham(rs.getString("id_sp"));
		r.setSo_luong(rs.getInt("so_luong"));
		r.setDon_gia(rs.getDouble("don_gia"));
		return r;
	}
	
	protected chi_tiet_phieu_nhap convertData(ResultSet rs,phieu_nhap data) throws SQLException {
		chi_tiet_phieu_nhap r = convertData(rs);
		r.setPhieu_nhap(data);
		return r;
	}
	
	public ArrayList<chi_tiet_phieu_nhap> getHD(phieu_nhap data) throws SQLException {
		String sqlQuery = "SELECT ctpn.*,sp.ten_sp,sp.don_vi_tinh"
		+ " FROM chi_tiet_phieu_nhap ctpn INNER JOIN chi_tiet_san_pham sp on ctpn.id_sp = sp.id_sp"
		+ " WHERE ctpn.ma_phieu_nhap = ?";
		PreparedStatement ptsm = getPreparedStatement(sqlQuery);
		ptsm.setInt(1, data.getMa_phieu_nhap());
		ResultSet rs = ptsm.executeQuery();
		ArrayList<chi_tiet_phieu_nhap> r = new ArrayList<chi_tiet_phieu_nhap>();
		while (rs.next()) {
			chi_tiet_phieu_nhap t = convertData(rs,data);

			chi_tiet_san_pham sp = new chi_tiet_san_pham();
			sp.setId_sp(t.getMa_san_pham());
			sp.setTen_sp(rs.getString("ten_sp"));
			sp.setDon_vi_tinh(rs.getString("don_vi_tinh"));
			t.setCtsp(sp);
			
			r.add(t);
		}
		rs.close();
		ptsm.close();
		return r;
	}
	
	public int Insert(chi_tiet_phieu_nhap data) throws SQLException {
		String sqlQuery = "INSERT INTO chi_tiet_phieu_nhap(ma_phieu_nhap,id_sp,so_luong,don_gia) VALUES(?,?,?,?)";
		PreparedStatement ptsm = getPreparedStatement(sqlQuery);
		ptsm.setInt(1, data.getMa_phieu_nhap());
		ptsm.setString(2, data.getMa_san_pham());
		ptsm.setInt(3, data.getSo_luong());
		ptsm.setDouble(4, data.getDon_gia());
		int r = ptsm.executeUpdate();
		ptsm.close();
		return r;
	}
	
	
}
