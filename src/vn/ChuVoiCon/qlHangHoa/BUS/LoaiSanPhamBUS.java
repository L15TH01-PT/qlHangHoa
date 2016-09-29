package vn.ChuVoiCon.qlHangHoa.BUS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DAO.Connect;
import vn.ChuVoiCon.qlHangHoa.DAO.LoaiSanPhamDAO;
import vn.ChuVoiCon.qlHangHoa.DLL.loai_san_pham;

public class LoaiSanPhamBUS extends Connect{
	LoaiSanPhamDAO lspd=new LoaiSanPhamDAO();
	
	public ArrayList<loai_san_pham> getDSLSP() {
		ArrayList<loai_san_pham> arrLSP = new ArrayList<loai_san_pham>();
		arrLSP=lspd.getDSLSP();
		return arrLSP;
	}
	
	public int addLSP(String maloai, String tenloai){
		return lspd.add(maloai, tenloai);		
	}
	
	public int deleteLSP(String maloai){
		return lspd.delete(maloai);
	}
	
	public int editLSP(String maloai, String tenloai){
		return lspd.edit(maloai, tenloai);
	}
}
