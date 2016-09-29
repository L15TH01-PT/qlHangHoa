package vn.ChuVoiCon.qlHangHoa.BUS;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DAO.Connect;
import vn.ChuVoiCon.qlHangHoa.DAO.phieu_nhapDAO;
import vn.ChuVoiCon.qlHangHoa.DLL.phieu_nhap;


public class nhap_khoBUS extends Connect {
	private phieu_nhapDAO pnd=new phieu_nhapDAO();
	
	public ArrayList<phieu_nhap> getDSPhieu(int act){
		ArrayList<phieu_nhap> arrPhieuNhap = new ArrayList<phieu_nhap>();
		arrPhieuNhap = pnd.getDSPhieu(act);		
		return arrPhieuNhap;
	}
	
	public boolean addPhieu(int ma_nv){
		if(pnd.insertPhieuNhap(ma_nv)==1){
			return true;
		}
		return false;
	}
	
	public boolean delPhieu(int maphieu){
		if(pnd.deletePhieuNhap(maphieu)==1){
			return true;
		}
		return false;
	}
}
