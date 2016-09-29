package vn.ChuVoiCon.qlHangHoa.BUS;

import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DAO.Connect;
import vn.ChuVoiCon.qlHangHoa.DAO.LoaiSanPhamDAO;
import vn.ChuVoiCon.qlHangHoa.DAO.NhaCungCapDAO;
import vn.ChuVoiCon.qlHangHoa.DLL.loai_san_pham;
import vn.ChuVoiCon.qlHangHoa.DLL.nha_cung_cap;

public class NhaCungCapBUS extends Connect{
	NhaCungCapDAO nccd=new NhaCungCapDAO();
	
	public ArrayList<nha_cung_cap> getDSNCC() {
		ArrayList<nha_cung_cap> arrNCC = new ArrayList<nha_cung_cap>();
		arrNCC=nccd.getDSNCC();
		return arrNCC;
	}
	
	public int addNCC(String mancc,String tenncc, String nglh, String dienthoai, String diachi){
		return nccd.add(mancc, tenncc, nglh, dienthoai, diachi);		
	}
	
	public int deleteNCC(String mancc){
		return nccd.delete(mancc);
	}
	
	public int editNCC(String mancc,String tenncc, String nglh, String dienthoai, String diachi){
		return nccd.edit(mancc, tenncc, nglh, dienthoai, diachi);
	}
}
