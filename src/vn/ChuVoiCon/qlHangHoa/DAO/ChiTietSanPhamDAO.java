package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_san_pham;
import vn.ChuVoiCon.qlHangHoa.DLL.loai_san_pham;

public class ChiTietSanPhamDAO extends Connect {
	public ArrayList<chi_tiet_san_pham> getDSCTSP() {
		ArrayList<chi_tiet_san_pham> arrCTSP = new ArrayList<chi_tiet_san_pham>();
		try {
			PreparedStatement ps = getPreparedStatement("select *,ten_loai from chi_tiet_san_pham ctsp, loai_san_pham lsp where ctsp.id_loai=lsp.id_loai");
			ResultSet rs = executeQuery(ps);
			while (rs.next()) {
				chi_tiet_san_pham ctsp = new chi_tiet_san_pham();
				ctsp.setId_sp(rs.getString("id_sp"));
				ctsp.setId_loai(rs.getString("id_loai"));
				ctsp.setTen_loai(rs.getString("ten_loai"));
				ctsp.setId_ncc(rs.getString("id_ncc"));
				ctsp.setTen_sp(rs.getString("ten_sp"));
				ctsp.setNoi_dung(rs.getString("noi_dung"));
				ctsp.setBao_hanh(rs.getInt("bao_hanh"));
				ctsp.setDon_vi_tinh(rs.getString("don_vi_tinh"));
				ctsp.setDon_gia(rs.getDouble("don_gia"));
				arrCTSP.add(ctsp);
			}
			rs.close();
			ps.close();
			return arrCTSP;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int add(String masp, String maloai, String mancc, String tensp,
			String noidung, int baohanh, String dvt, double dongia) {
		try {
			PreparedStatement ps = getPreparedStatement("INSERT INTO chi_tiet_san_pham VALUE (?,?,?,?,?,?,?,?)");
			ps.setString(1, masp);
			ps.setString(2, maloai);
			ps.setString(3, mancc);
			ps.setString(4, tensp);
			ps.setString(5, noidung);
			ps.setInt(6, baohanh);
			ps.setString(7, dvt);
			ps.setDouble(8, dongia);
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(String masp) {
		try {
			PreparedStatement ps = getPreparedStatement("DELETE FROM chi_tiet_san_pham WHERE id_sp = ?");
			ps.setString(1, masp);
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int edit(String masp, String maloai, String mancc, String tensp,
			String noidung, int baohanh, String dvt, double dongia) {
		try {
			PreparedStatement ps = getPreparedStatement("UPDATE chi_tiet_san_pham SET id_loai = ?,id_ncc=?,ten_sp=?,noi_dung=?,bao_hanh=?,don_vi_tinh=?,don_gia=? WHERE id_sp = ?");
			ps.setString(1, maloai);
			ps.setString(2, mancc);
			ps.setString(3, tensp);
			ps.setString(4, noidung);
			ps.setInt(5, baohanh);
			ps.setString(6, dvt);
			ps.setDouble(7, dongia);
			ps.setString(8, masp);
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
