package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_hoa_don;
import vn.ChuVoiCon.qlHangHoa.DLL.hoa_don;

public class chi_tiet_hoa_donDAO extends Connect {
	// Collum sql
	private final String ma_hoa_don = "ma_hoa_don";
	private final String IDHangHoa = "IDHangHoa";
	private final String don_gia = "don_gia";
	private final String so_luong = "so_luong";
	// Proc
	private final String procGetHD = "chi_tiet_hoa_donGetHD(?)";
	private final String procInsert = "chi_tiet_hoa_donInsert(?,?,?,?)";

	protected chi_tiet_hoa_don convertData(ResultSet rs) throws SQLException {
		chi_tiet_hoa_don r = new chi_tiet_hoa_don();
		r.setMa_hoa_don(rs.getLong(ma_hoa_don));
		r.setIDHangHoa(rs.getString(IDHangHoa));
		r.setSo_luong(rs.getInt(so_luong));
		r.setDon_gia(rs.getDouble(don_gia));
		return r;
	}
	protected chi_tiet_hoa_don convertData(ResultSet rs,hoa_don data) throws SQLException {
		chi_tiet_hoa_don r = convertData(rs);
		r.setHoa_don(data);
		return r;
	}
	
	public ArrayList<chi_tiet_hoa_don> getHD(hoa_don data) throws SQLException {
		CallableStatement cstm = getCallableStatement(procGetHD);
		cstm.setLong(ma_hoa_don, data.getMa_hoa_don());
		ResultSet rs = cstm.executeQuery();
		ArrayList<chi_tiet_hoa_don> r = new ArrayList<chi_tiet_hoa_don>();
		while (rs.next()) {
			r.add(convertData(rs,data));
		}
		rs.close();
		cstm.close();
		return r;
	}

	public int Insert(chi_tiet_hoa_don data) throws SQLException {
		CallableStatement cstm = getCallableStatement(procInsert);
		cstm.setLong(ma_hoa_don, data.getMa_hoa_don());
		cstm.setString(IDHangHoa, data.getIDHangHoa());
		cstm.setInt(so_luong, data.getSo_luong());
		cstm.setDouble(don_gia, data.getDon_gia());
		int r = cstm.executeUpdate();
		cstm.close();
		return r;
	}

}
