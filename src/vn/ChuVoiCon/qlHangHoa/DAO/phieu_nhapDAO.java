package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DLL.phieu_nhap;

public class phieu_nhapDAO extends Connect {
	
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
	
	public ArrayList<phieu_nhap> getDSPhieu(int act) {
		ArrayList<phieu_nhap> arrPhieuNhap = new ArrayList<phieu_nhap>();
		String sql = "select * from phieu_nhap";
		if(act == 1)
			sql+=" WHERE ngay_huy is null";
		else if(act==-1)
			sql+=" WHERE ngay_huy is not null";
		try {
			PreparedStatement ps = getPreparedStatement(sql);
			ResultSet rs = executeQuery(ps);
			while (rs.next()) {
				phieu_nhap nk = new phieu_nhap();
				nk.setMa_phieu_nhap(rs.getInt(1));
				nk.setNgay_lap(rs.getDate(2));
				nk.setId_nv(rs.getInt(3));
				nk.setNgay_huy(rs.getDate(4));
				arrPhieuNhap.add(nk);
			}
			rs.close();
			ps.close();
			return arrPhieuNhap;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertPhieuNhap(int ma_nv) {
		try {
			PreparedStatement ps = getPreparedStatement("INSERT INTO phieu_nhap(ngay_lap,id_nv,ngay_huy) VALUE (NOW(),?,?)");
			ps.setInt(1, ma_nv);
			ps.setDate(2, null);
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deletePhieuNhap(int ma_phieu_nhap){
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
