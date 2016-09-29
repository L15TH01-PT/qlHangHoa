package vn.ChuVoiCon.qlHangHoa.BUS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DAO.Connect;
import vn.ChuVoiCon.qlHangHoa.DAO.Nhan_VienDAO;
import vn.ChuVoiCon.qlHangHoa.DLL.NhanVien;

public class NhanVienBUS extends Connect{
	Nhan_VienDAO nvd = new Nhan_VienDAO();
	
	public ArrayList<NhanVien> getDSNV(){
		
		ArrayList<NhanVien> arrNhanVien= new ArrayList<NhanVien>();
		arrNhanVien = nvd.getDSNV();
		
		return arrNhanVien;
	}
	
	public NhanVien getNV(int id){
		NhanVien nv = nvd.getNV(id);
		return nv;			
	}
	
	public int login(String manv, String pass){
		try {
			return nvd.checklogin(manv, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
}
