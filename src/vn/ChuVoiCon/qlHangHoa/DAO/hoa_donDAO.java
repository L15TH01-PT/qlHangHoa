package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DLL.hoa_don;

public class hoa_donDAO extends baseDAO<hoa_don, Long> {
	//Collum sql
	private final String ma_hoa_don = "ma_hoa_don";
	private final String ngay_lap = "ngay_lap";
	private final String ten_khach_hang = "ten_khach_hang";
	private final String id_nv = "id_nv";
	private final String ghi_chu = "ghi_chu";
	private final String ngay_huy = "ngay_huy";
	//Proc
	private final String procGetAll = "ngay_huy";
	private final String procGetAllNV = String.format("(:%1s)", id_nv);
	private final String procGetData = String.format("(:%1s)", ma_hoa_don);
	private final String procInsert = String.format("(:%1s)", ma_hoa_don);
	private final String procUpdate = String.format("(:%1s)", ma_hoa_don);

	@Override
	protected hoa_don convertData(ResultSet rs) throws SQLException {
		hoa_don r = new hoa_don();
		r.setMa_hoa_don(rs.getLong(ma_hoa_don));
		r.setNgay_lap(rs.getDate(ngay_lap));
		r.setTen_khach_hang(rs.getString(ten_khach_hang));
		r.setId_nv(rs.getInt(id_nv));
		r.setGhi_chu(rs.getString(ghi_chu));
		r.setNgay_huy(rs.getDate(ngay_huy));
		return r;
	}

	@Override
	protected void addIDParmater(CallableStatement cstm, Long id)
			throws SQLException {
		cstm.setLong(ma_hoa_don, id);
	}

	@Override
	protected void addAllParmaterWithoutID(CallableStatement cstm, hoa_don data)
			throws SQLException {
		cstm.setDate(ngay_lap, data.getNgay_lap());
		cstm.setString(ten_khach_hang, data.getTen_khach_hang());
		cstm.setInt(id_nv, data.getId_nv());
		cstm.setString(ghi_chu, data.getGhi_chu());
		cstm.setDate(ngay_huy, data.getNgay_huy());

	}

	@Override
	protected void addAllParmater(CallableStatement cstm, hoa_don data)
			throws SQLException {
		addIDParmater(cstm, data.getMa_hoa_don());
		addAllParmaterWithoutID(cstm, data);
	}

	public ArrayList<hoa_don> getDS() {
		CallableStatement cstm = null;
		try {
			cstm = getCallableStatement(procGetAll);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getDS(cstm);
	}

	public ArrayList<hoa_don> getDS(int id_nv) {
		CallableStatement cstm = null;
		try {
			cstm = getCallableStatement(procGetAllNV);
			cstm.setInt(this.id_nv, id_nv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getDS(cstm);
	}
}
