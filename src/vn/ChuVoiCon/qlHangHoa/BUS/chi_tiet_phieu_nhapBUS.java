package vn.ChuVoiCon.qlHangHoa.BUS;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DAO.Connect;
import vn.ChuVoiCon.qlHangHoa.DAO.chi_tiet_phieu_nhapDAO;
import vn.ChuVoiCon.qlHangHoa.DAO.phieu_nhapDAO;
import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_san_pham;
import vn.ChuVoiCon.qlHangHoa.DLL.phieu_nhap;

public class chi_tiet_phieu_nhapBUS extends Connect {
	
	private chi_tiet_phieu_nhapDAO ctpn=new chi_tiet_phieu_nhapDAO();
	public ArrayList<chi_tiet_san_pham> getDSSP(){
		ArrayList<chi_tiet_san_pham> arr = new ArrayList<chi_tiet_san_pham>();
		arr = ctpn.getDSSP();		
		return arr;
	}

}
