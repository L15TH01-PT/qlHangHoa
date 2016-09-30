package vn.ChuVoiCon.qlHangHoa.BUS;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DAO.Connect;
import vn.ChuVoiCon.qlHangHoa.DAO.phieu_nhapDAO;
import vn.ChuVoiCon.qlHangHoa.DLL.phieu_nhap;


public class nhap_khoBUS {
	private phieu_nhapDAO pnd=new phieu_nhapDAO();
	
	public nhap_khoBUS() {
		pnd = new phieu_nhapDAO();
	}
	
	public ArrayList<phieu_nhap> getDSEX(int s) {
		try {
			return pnd.getDS(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public ArrayList<phieu_nhap> getDS(int id_nv) {
		try {
			return pnd.getDS(id_nv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public phieu_nhap getData(int ma_phieu_nhap) throws SQLException {
		try {
			return pnd.getData(ma_phieu_nhap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int Add(phieu_nhap pn) {
		try {
			return pnd.Insert(pn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public int Del(int ma_phieu_nhap) {
		try {
			if(pnd.deletePhieuNhap(ma_phieu_nhap)==1){
				return 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
