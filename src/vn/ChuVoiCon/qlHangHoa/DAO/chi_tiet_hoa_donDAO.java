package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_hoa_don;
import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_san_pham;
import vn.ChuVoiCon.qlHangHoa.DLL.hoa_don;

public class chi_tiet_hoa_donDAO extends Connect {
	private final String ma_hoa_don = "ma_hoa_don";
	private final String id_sp = "id_sp";
	private final String don_gia = "don_gia";
	private final String so_luong = "so_luong";

	protected chi_tiet_hoa_don convertData(ResultSet rs) throws SQLException {
		chi_tiet_hoa_don r = new chi_tiet_hoa_don();
		r.setMa_hoa_don(rs.getLong(ma_hoa_don));
		r.setId_sp(rs.getString(id_sp));
		r.setSo_luong(rs.getInt(so_luong));
		r.setDon_gia(rs.getDouble(don_gia));
		chi_tiet_san_pham sp = new chi_tiet_san_pham();
		sp.setId_sp(r.getId_sp());
		sp.setTen_sp(rs.getString("ten_sp"));
		sp.setDon_vi_tinh(rs.getString("donvitinh"));
		return r;
	}
	protected chi_tiet_hoa_don convertData(ResultSet rs,hoa_don data) throws SQLException {
		chi_tiet_hoa_don r = convertData(rs);
		r.setHoa_don(data);
		return r;
	}
	
	public ArrayList<chi_tiet_hoa_don> getHD(hoa_don data) throws SQLException {
		String sqlQuery = "SELECT cthd.*,sp.ten_sp";
		sqlQuery += " FROM chi_tiet_hoa_don cthd INNER JOIN chi_tiet_san_pham sp on cthd.id_sp = sp.id_sp";
		sqlQuery += " WHERE cthd.ma_hoa_don = ?";
		PreparedStatement ptsm = getPreparedStatement(sqlQuery);
		ptsm.setLong(1, data.getMa_hoa_don());
		ResultSet rs = ptsm.executeQuery();
		ArrayList<chi_tiet_hoa_don> r = new ArrayList<chi_tiet_hoa_don>();
		while (rs.next()) {
			r.add(convertData(rs,data));
		}
		rs.close();
		ptsm.close();
		return r;
	}

	public int Insert(chi_tiet_hoa_don data) throws SQLException {
		String sqlQuery = "INSERT INTO chi_tiet_hoa_don(ma_hoa_don,id_sp,so_luong,don_gia) VALUES(?,?,?,?)";
		PreparedStatement ptsm = getPreparedStatement(sqlQuery);
		ptsm.setLong(1, data.getMa_hoa_don());
		ptsm.setString(2, data.getId_sp());
		ptsm.setInt(3, data.getSo_luong());
		ptsm.setDouble(4, data.getDon_gia());
		int r = ptsm.executeUpdate();
		ptsm.close();
		return r;
	}

}
