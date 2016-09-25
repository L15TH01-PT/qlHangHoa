package vn.ChuVoiCon.qlHangHoa.BUS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DAO.Connect;
import vn.ChuVoiCon.qlHangHoa.DLL.NhanVien;

public class NhanVienBUS extends Connect{
	
	public ArrayList<NhanVien> getDSNV(){
		
		ArrayList<NhanVien> arrNhanVien= new ArrayList<NhanVien>();
		try {
			PreparedStatement ps = getPreparedStatement("select * from nhan_vien");			
			ResultSet rs = executeQuery(ps);
			while (rs.next()) {
				NhanVien nv = new NhanVien();
				nv.setMa_nhan_vien(rs.getString("ma_nhan_vien"));
				nv.setLuong(rs.getInt("luong"));
				nv.setMat_khau(rs.getString("mat_khau"));
				arrNhanVien.add(nv);
			}
			rs.close();
			ps.close();
			return arrNhanVien;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public NhanVien getNV(String manv){
		NhanVien nv = new NhanVien();
		try {
			PreparedStatement ps = getPreparedStatement("select * from nhan_vien where ma_nhan_vien = ?");
			ps.setString(1, manv);
			ResultSet rs = executeQuery(ps);
			while (rs.next()) {			
				nv.setMa_nhan_vien(rs.getString("ma_nhan_vien"));
				nv.setLuong(rs.getInt("luong"));
				nv.setMat_khau(rs.getString("mat_khau"));		
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nv;
				
	}
}
