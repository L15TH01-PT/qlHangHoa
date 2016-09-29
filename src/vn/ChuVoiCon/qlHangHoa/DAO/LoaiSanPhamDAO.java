package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DLL.loai_san_pham;

public class LoaiSanPhamDAO extends Connect{
	public ArrayList<loai_san_pham> getDSLSP() {
		ArrayList<loai_san_pham> arrLSP = new ArrayList<loai_san_pham>();
		try {
			PreparedStatement ps=getPreparedStatement("select * from loai_san_pham");
			ResultSet rs=executeQuery(ps);
			while(rs.next()) {
				loai_san_pham lsp=new loai_san_pham();
				lsp.setId_loai(rs.getString("id_loai"));
				lsp.setTen_loai(rs.getString("ten_loai"));
				arrLSP.add(lsp);
			}
			rs.close();
			ps.close();
			return arrLSP;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int add(String maloai, String tenloai) {		
		try {
			PreparedStatement ps = getPreparedStatement("INSERT INTO loai_san_pham VALUE (?,?)");
			ps.setString(1, maloai);
			ps.setString(2, tenloai);
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int delete(String maloai) {
		try {
			PreparedStatement ps = getPreparedStatement("DELETE FROM loai_san_pham WHERE id_loai = ?");
			ps.setString(1, maloai);
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int edit(String maloai,String tenloai) {
		try {
			PreparedStatement ps = getPreparedStatement("UPDATE loai_san_pham SET ten_loai = ? WHERE id_loai = ?");
			ps.setString(1, tenloai);
			ps.setString(2, maloai);
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
