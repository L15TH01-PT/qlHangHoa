package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DLL.loai_san_pham;
import vn.ChuVoiCon.qlHangHoa.DLL.nha_cung_cap;

public class NhaCungCapDAO extends Connect{
	public ArrayList<nha_cung_cap> getDSNCC(){
		ArrayList<nha_cung_cap> arrNCC = new ArrayList<nha_cung_cap>();
		try {
			PreparedStatement ps=getPreparedStatement("select * from nha_cung_cap");
			ResultSet rs=executeQuery(ps);
			while(rs.next()) {
				nha_cung_cap ncc=new nha_cung_cap();
				ncc.setId_ncc(rs.getString("id_ncc"));
				ncc.setTen_ncc(rs.getString("ten_ncc"));
				ncc.setNguoi_lien_he(rs.getString("nguoi_lien_he"));
				ncc.setDien_thoai(rs.getString("dien_thoai"));
				ncc.setDia_chi(rs.getString("dia_chi"));
				arrNCC.add(ncc);
			}
			rs.close();
			ps.close();
			return arrNCC;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int add(String mancc, String tenncc, String nglh, String dienthoai, String diachi) {		
		try {
			PreparedStatement ps = getPreparedStatement("INSERT INTO nha_cung_cap VALUE (?,?,?,?,?)");
			ps.setString(1, mancc);
			ps.setString(2, tenncc);
			ps.setString(3, nglh);
			ps.setString(4, dienthoai);
			ps.setString(5, diachi);
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int delete(String mancc) {
		try {
			PreparedStatement ps = getPreparedStatement("DELETE FROM nha_cung_cap WHERE id_ncc = ?");
			ps.setString(1, mancc);
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int edit(String mancc,String tenncc, String nglh, String dienthoai, String diachi) {
		try {
			PreparedStatement ps = getPreparedStatement("UPDATE nha_cung_cap SET ten_ncc = ?,nguoi_lien_he = ?,dien_thoai = ?,dia_chi=? WHERE id_ncc = ?");
			ps.setString(1, tenncc);
			ps.setString(2, nglh);
			ps.setString(3, dienthoai);
			ps.setString(4, diachi);
			ps.setString(5, mancc);
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
