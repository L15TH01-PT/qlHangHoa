package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DLL.hoa_don;

public class hoa_donDAO extends Connect {
	// Collum sql
	private final String ma_hoa_don = "ma_hoa_don";
	private final String ngay_lap = "ngay_lap";
	private final String ten_khach_hang = "ten_khach_hang";
	private final String id_nv = "id_nv";
	private final String ghi_chu = "ghi_chu";
	private final String ngay_huy = "ngay_huy";
	// Proc
	private final String procGetAll = "hoa_donGetALL()";
	private final String procGetAllNV = "hoa_donGetALLNV(?)";
	private final String procGetData = "hoa_donGetData(?)";
	private final String procInsert = "hoa_donInsert(?,?,?,?,?,?)";
	private final String procSetHuy = "hoa_donSetHuy(?)";

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

	protected void addIDParmater(CallableStatement cstm, Long id)
			throws SQLException {
		cstm.setLong(1, id);
	}

	protected void addAllParmater(CallableStatement cstm, hoa_don data)
			throws SQLException {
		cstm.setLong(1, data.getMa_hoa_don());
		cstm.setDate(2, data.getNgay_lap());
		cstm.setString(3, data.getTen_khach_hang());
		cstm.setInt(4, data.getId_nv());
		cstm.setString(5, data.getGhi_chu());
		cstm.setDate(6, data.getNgay_huy());
	}
	protected ArrayList<hoa_don> getDS(CallableStatement cstm) throws SQLException {
		ResultSet rs = cstm.executeQuery();
		ArrayList<hoa_don> r = new ArrayList<hoa_don>();
		while (rs.next()) {
			r.add(convertData(rs));
		}
		rs.close();
		cstm.close();
		return r;
	}
	
	protected hoa_don getData(CallableStatement cstm) throws SQLException {
		ResultSet rs = cstm.executeQuery();
		hoa_don r = null;
		if (rs.next()) {
			r = convertData(rs);
		}
		rs.close();
		cstm.close();
		return r;
	}
	
	protected int callProcWithData(String procedure, hoa_don data) throws SQLException {
		CallableStatement cstm = getCallableStatement(procedure);
		addAllParmater(cstm, data);
		int r = 0;
		r = cstm.executeUpdate();
		cstm.close();
		return r;
	}

	public ArrayList<hoa_don> getDS() throws SQLException {
		CallableStatement cstm = getCallableStatement(procGetAll);
		return getDS(cstm);
	}

	public ArrayList<hoa_don> getDS(int id_nv) throws SQLException {
		CallableStatement cstm = getCallableStatement(procGetAllNV);
		cstm.setInt(1, id_nv);
		return getDS(cstm);
	}

	public hoa_don getData(long ma_hoa_don) throws SQLException {
		CallableStatement cstm = null;
		cstm = getCallableStatement(procGetData);
		cstm.setLong(1, ma_hoa_don);
		return getData(cstm);
	}

	public int Insert(hoa_don hd) throws SQLException {
		CallableStatement cstm = getCallableStatement(procInsert);
		cstm.registerOutParameter(1, java.sql.Types.BIGINT);
		cstm.registerOutParameter(2,  java.sql.Types.DATE);
		cstm.setString(3, hd.getTen_khach_hang());
		cstm.setInt(4, hd.getId_nv());
		cstm.setString(5, hd.getGhi_chu());
		cstm.setDate(6, null);
		int r = cstm.executeUpdate();
		hd.setMa_hoa_don(cstm.getLong(1));
		cstm.close();
		return r;
	}

	public int Delete(hoa_don hd) throws SQLException {
		CallableStatement cstm = getCallableStatement(procSetHuy);
		addIDParmater(cstm, hd.getMa_hoa_don());
		//cstm.setDate(2, hd.getNgay_huy());
		return executeUpdate(cstm);
	}
}
