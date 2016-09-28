package vn.ChuVoiCon.qlHangHoa.BUS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DAO.Connect;
import vn.ChuVoiCon.qlHangHoa.DLL.LoaiSanPham;

public class LoaiSanPhamBUS extends Connect{
	public ArrayList<LoaiSanPham> getDSLSP() {
		ArrayList<LoaiSanPham> arrLSP = new ArrayList<LoaiSanPham>();
		try {
			PreparedStatement ps=getPreparedStatement("select * from loai_san_pham");
			ResultSet rs=executeQuery(ps);
			while(rs.next()) {
				LoaiSanPham lsp=new LoaiSanPham();
				lsp.setTen_loai(rs.getString("ten_loai"));
				arrLSP.add(lsp);
			}
			return arrLSP;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
