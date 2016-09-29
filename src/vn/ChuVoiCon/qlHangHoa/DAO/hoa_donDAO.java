package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DLL.NhanVien;
import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_hoa_don;
import vn.ChuVoiCon.qlHangHoa.DLL.hoa_don;

public class hoa_donDAO extends Connect {

	private chi_tiet_hoa_donDAO cthd;

	public hoa_donDAO() {
		super();
		cthd = new chi_tiet_hoa_donDAO();
	}

	protected hoa_don convertData(ResultSet rs) throws SQLException {
		hoa_don r = new hoa_don();
		r.setMa_hoa_don(rs.getInt("ma_hoa_don"));
		r.setNgay_lap(rs.getDate("ngay_lap"));
		r.setTen_khach_hang(rs.getString("ten_khach_hang"));
		r.setId_nv(rs.getInt("id_nv"));
		r.setGhi_chu(rs.getString("ghi_chu"));
		r.setNgay_huy(rs.getDate("ngay_huy"));
		return r;
	}

	protected ArrayList<hoa_don> getDS(CallableStatement cstm)
			throws SQLException {
		ResultSet rs = cstm.executeQuery();
		ArrayList<hoa_don> r = new ArrayList<hoa_don>();
		while (rs.next()) {
			r.add(convertData(rs));
		}
		rs.close();
		cstm.close();
		return r;
	}

	protected ArrayList<hoa_don> getDS(PreparedStatement pstm)
			throws SQLException {
		ResultSet rs = executeQuery(pstm);
		ArrayList<hoa_don> r = new ArrayList<hoa_don>();
		while (rs.next()) {
			hoa_don t = convertData(rs);
			t.setNv(new NhanVien());
			t.getNv().setId(t.getId_nv());
			t.getNv().setTen_nhan_vien(rs.getString("ten_nhan_vien"));
			r.add(t);
		}
		rs.close();
		pstm.close();
		return r;
	}

	public ArrayList<hoa_don> getDS() throws SQLException {
		String sqlQuery = "SELECT hd.*,nv.ten_nhan_vien "
				+ "FROM hoa_don hd INNER JOIN nhan_vien nv on hd.id_nv = nv.id";
		PreparedStatement pstm = getPreparedStatement(sqlQuery);
		return getDS(pstm);
	}

	public ArrayList<hoa_don> getDS(int id_nv) throws SQLException {
		String sqlQuery = "SELECT hd.*,nv.ten_nhan_vien "
				+ "FROM hoa_don hd INNER JOIN nhan_vien nv on hd.id_nv = nv.id "
				+ "WHERE hd.id_nv = ?";
		PreparedStatement pstm = getPreparedStatement(sqlQuery);
		pstm.setInt(1, id_nv);
		return getDS(pstm);
	}

	public hoa_don getData(int ma_hoa_don) throws SQLException {
		String sqlQuery = "SELECT hd.*,nv.ten_nhan_vien "
				+ "FROM hoa_don hd INNER JOIN nhan_vien nv on hd.id_nv = nv.id "
				+ "WHERE hd.ma_hoa_don = ?";
		PreparedStatement pstm = getPreparedStatement(sqlQuery);
		pstm.setInt(1, ma_hoa_don);

		ResultSet rs = pstm.executeQuery();
		hoa_don r = null;
		if (rs.next()) {
			r = convertData(rs);
			r.setChi_tiet_hoa_dons(cthd.getHD(r));
		}
		rs.close();
		pstm.close();

		return r;
	}

	public int Insert(hoa_don hd) throws SQLException {
		String sqlQuery = "INSERT INTO hoa_don(ten_khach_hang,id_nv,ghi_chu) "
				+ "VALUES(?,?,?)";

		PreparedStatement pstm = getPreparedStatementWithGenKey(sqlQuery);
		pstm.setString(1, hd.getTen_khach_hang());
		pstm.setInt(2, hd.getId_nv());
		pstm.setString(3, hd.getGhi_chu());

		setAutoCommit(false);
		try {
			int r = executeUpdateWithGenKey(pstm);
			if (r == 0)
				throw new SQLException();

			// for (chi_tiet_hoa_don item : hd.getChi_tiet_hoa_dons()) {
			// if (cthd.Insert(item) == 0)
			// throw new SQLException();
			// }
			// hd.setMa_hoa_don(cstm.getInt(arg0)(1));
			getConnection().commit();
		} catch (SQLException e) {
			getConnection().rollback();
		}
		setAutoCommit(true);
		return 0;
	}

	public int Delete(int ma_hoa_don) throws SQLException {
		String sqlQuery = "UPDATE FROM hoa_don SET ngay_huy = NOW() "
				+ "WHERE ma_hoa_don = ?";
		PreparedStatement pstm = getPreparedStatementWithGenKey(sqlQuery);
		pstm.setInt(1, ma_hoa_don);
		return executeUpdate(pstm);
	}
}
