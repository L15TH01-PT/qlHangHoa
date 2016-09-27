package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DLL.NhanVien;

public class Nhan_VienDAO extends Connect{
	
	public ArrayList<NhanVien> getDSNV(){
		ArrayList<NhanVien> arrNhanVien = new ArrayList<NhanVien>();
			try {
	//			ResultSet rs = executeQuery("select * from nhan_vien where id ="+1);
	//			PreparedStatement ps = getPreparedStatement("select * from nhan_vien where id =?");
	//			ps.setInt(1, 1);
				PreparedStatement ps = getPreparedStatement("select * from nhan_vien");	
				ResultSet rs = executeQuery(ps);
				while (rs.next()) {
					NhanVien nv = new NhanVien();
					nv.setTen_nhan_vien(rs.getString("ten_nhan_vien"));
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
			while(rs.next()){
				nv.setId(rs.getInt("id"));
				nv.setMa_nhan_vien(rs.getString("ma_nhan_vien"));
				nv.setTen_nhan_vien(rs.getString("ho_nhan_vien"));
				nv.setHo_nhan_vien(rs.getString("ten_nhan_vien"));
				nv.setPhai(rs.getBoolean("phai"));
				nv.setNgay_sinh(rs.getDate("ngay_sinh"));
				nv.setLuong(rs.getInt("luong"));
				nv.setDia_chi(rs.getString("dia_chi"));
				nv.setMa_phong_ban(rs.getInt("ma_phong_ban"));
				nv.setMa_chuc_vu(rs.getInt("ma_chuc_vu"));
				nv.setTrang_thai(rs.getByte("trang_thai"));
				nv.setDien_thoai(rs.getString("dien_thoai"));
				nv.setMat_khau(rs.getString("mat_khau"));
				return nv;
			}
			rs.close();
			ps.close();
			return nv;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
				
	}
}

