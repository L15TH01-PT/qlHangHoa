package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.BUS.nhap_khoBUS;
import vn.ChuVoiCon.qlHangHoa.DLL.NhanVien;
import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_phieu_nhap;
import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_san_pham;
import vn.ChuVoiCon.qlHangHoa.DLL.phieu_nhap;

public class phieu_nhapDAO extends Connect {
	
	private chi_tiet_phieu_nhapDAO ctd=new chi_tiet_phieu_nhapDAO();
	
	public phieu_nhap getPhieuNhap(int ma_phieu_nhap) {
		phieu_nhap nk = null;
		try {
			PreparedStatement ps = getPreparedStatement("select * from phieu_nhap where ma_phieu_nhap = ?");
			ps.setInt(1, ma_phieu_nhap);
			ResultSet rs = executeQuery(ps);
			if (rs.next()) {
				nk = new phieu_nhap();
				nk.setMa_phieu_nhap(rs.getInt(1));
				nk.setNgay_lap(rs.getDate(2));
				nk.setId_nv(rs.getInt(3));
				nk.setNgay_huy(rs.getDate(4));
			}
			rs.close();
			ps.close();
			return nk;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected phieu_nhap convertData(ResultSet rs) throws SQLException {
		phieu_nhap r = new phieu_nhap();
		r.setMa_phieu_nhap(rs.getInt("ma_phieu_nhap"));
		r.setNgay_lap(rs.getDate("ngay_nhap"));
		r.setId_nv(rs.getInt("id_nv"));
		r.setNgay_huy(rs.getDate("ngay_huy"));
		return r;
	}
	
	public ArrayList<phieu_nhap> getDSPhieu(int act) throws SQLException {
		String sqlQuery = "SELECT pn.*,nv.ten_nhan_vien "
				+ "FROM phieu_nhap pn INNER JOIN nhan_vien nv on pn.id_nv = nv.id";
		switch (act) {
		case -1:
			sqlQuery += " WHERE ngay_huy is not null";
			break;
		case 1:
			sqlQuery += " WHERE ngay_huy is null";
			break;
		}
		sqlQuery+= " ORDER BY pn.ma_phieu_nhap desc";
		PreparedStatement pstm = getPreparedStatement(sqlQuery);
		return getDS(pstm);
	}
	
	protected ArrayList<phieu_nhap> getDS(PreparedStatement pstm)
			throws SQLException {
		ResultSet rs = executeQuery(pstm);
		ArrayList<phieu_nhap> r = new ArrayList<phieu_nhap>();
		while (rs.next()) {
			phieu_nhap t = convertData(rs);
			t.setNv(new NhanVien());
			t.getNv().setId(t.getId_nv());
			t.getNv().setTen_nhan_vien(rs.getString("ten_nhan_vien"));
			r.add(t);
		}
		rs.close();
		pstm.close();
		return r;
	}
	
	public ArrayList<phieu_nhap> getDS() throws SQLException {
		String sqlQuery = "SELECT pn.*,nv.ten_nhan_vien "
				+ "FROM phieu_nhap pn INNER JOIN nhan_vien nv on pn.id_nv = nv.id";
		PreparedStatement pstm = getPreparedStatement(sqlQuery);
		return getDS(pstm);
	}

	
	public ArrayList<phieu_nhap> getDS(int id_nv) throws SQLException {
		String sqlQuery = "SELECT pn.*,nv.ten_nhan_vien "
				+ "FROM phieu_nhap pn INNER JOIN nhan_vien nv on pn.id_nv = nv.id "
				+ "WHERE pn.id_nv = ?";
		PreparedStatement pstm = getPreparedStatement(sqlQuery);
		pstm.setInt(1, id_nv);
		return getDS(pstm);
	}
	
	public phieu_nhap getData(int ma_phieu_nhap) throws SQLException {
		String sqlQuery = "SELECT hd.*,nv.ten_nhan_vien "
				+ "FROM phieu_nhap pn INNER JOIN nhan_vien nv on pn.id_nv = nv.id "
				+ "WHERE pn.ma_phieu_nhap = ?";
		PreparedStatement pstm = getPreparedStatement(sqlQuery);
		pstm.setInt(1, ma_phieu_nhap);

		ResultSet rs = pstm.executeQuery();
		phieu_nhap r = null;
		if (rs.next()) {
			r = convertData(rs);
			r.setNv(new NhanVien());
			r.getNv().setId(r.getId_nv());
			r.getNv().setTen_nhan_vien(rs.getString("ten_nhan_vien"));
			r.setCt_nhap_kho(ctd.getHD(r));
		}
		rs.close();
		pstm.close();

		return r;
	}
	
	public int Insert(phieu_nhap pn) throws SQLException {
		String sqlQuery = "INSERT INTO phieu_nhap(ngay_nhap,id_nv) "
				+ "VALUES(NOW(),?)";

		PreparedStatement pstm = getPreparedStatement(sqlQuery);
		pstm.setInt(1, pn.getId_nv());
		
		int r=0;
		setAutoCommit(false);
		try {
			r = executeUpdateWithGenKey(pstm);
			if (r == 0)
				throw new SQLException();

			 for (chi_tiet_phieu_nhap item : pn.getCt_nhap_kho()) {
				 item.setMa_phieu_nhap(r);
				 if (ctd.Insert(item) == 0)
					 throw new SQLException();
			 }
			 pn.setMa_phieu_nhap(r);
			getConnection().commit();
		} catch (SQLException e) {
			getConnection().rollback();
		}
		setAutoCommit(true);
		return r;
	}
	
	
	public int deletePhieuNhap(int ma_phieu_nhap) throws SQLException{
		try{
			PreparedStatement ps = getPreparedStatement("UPDATE phieu_nhap SET ngay_huy=NOW() WHERE ma_phieu_nhap=?");
			ps.setInt(1, ma_phieu_nhap );
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
