package vn.ChuVoiCon.qlHangHoa.BUS;

import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DAO.ChiTietSanPhamDAO;
import vn.ChuVoiCon.qlHangHoa.DAO.Connect;
import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_san_pham;
import vn.ChuVoiCon.qlHangHoa.DLL.loai_san_pham;

public class ChiTietSanPhamBUS extends Connect{
	ChiTietSanPhamDAO ctspd=new ChiTietSanPhamDAO();	
	
	public ArrayList<chi_tiet_san_pham> getDSCTSP() {
		ArrayList<chi_tiet_san_pham> arrCTSP = new ArrayList<chi_tiet_san_pham>();
		arrCTSP=ctspd.getDSCTSP();
		return arrCTSP;
	}	
}
